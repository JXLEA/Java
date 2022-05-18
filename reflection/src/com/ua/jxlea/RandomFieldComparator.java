package com.ua.jxlea;

import lombok.SneakyThrows;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * A generic comparator that is comparing a random field of the given class. The field is either
 * primitive or {@link Comparable}. It is chosen during comparator instance creation and is used for
 * all comparisons.
 *
 * <p>By default it compares only accessible fields, but this can be configured via a constructor
 * property. If no field is available to compare, the constructor throws {@link
 * IllegalArgumentException}
 *
 * @param <T> the type of the objects that may be compared by this comparator
 */
public class RandomFieldComparator<T> implements Comparator<T> {

  private final Class<?> classType;
  private final Field randomField;

  public RandomFieldComparator(Class<T> targetType) {
    this(targetType, false);
  }

  /**
   * A constructor that accepts a class and a property indicating which fields can be used for
   * comparison. If property value is true, then only public fields or fields with public getters
   * can be used.
   *
   * @param targetType a type of objects that may be compared
   * @param compareOnlyAccessibleFields config property indicating if only publicly accessible
   *     fields can be used
   */
  public RandomFieldComparator(Class<T> targetType, boolean compareOnlyAccessibleFields) {
    this.classType = targetType;
    randomField = getRandomField(targetType, compareOnlyAccessibleFields);
  }

  public Field getRandomField(Class<T> targetType, boolean compareOnlyAccessibleFields) {
    List<Field> accessedFields =
        Arrays.stream(targetType.getDeclaredFields())
            .filter(
                field ->
                    compareOnlyAccessibleFields
                        ? (Modifier.isPublic(field.getModifiers())
                            || isPublicMethod(field.getName(), targetType))
                        : Boolean.TRUE)
            .filter(
                field ->
                    Comparable.class.isAssignableFrom(field.getType())
                        || field.getType().isPrimitive())
            .toList();

    if (accessedFields.isEmpty()) {
      throw new IllegalArgumentException();
    }
    return accessedFields.get(ThreadLocalRandom.current().nextInt(accessedFields.size()));
  }

  public Boolean isPublicMethod(String fieldName, Class<T> targetType) {
    return Modifier.isPublic(
        Arrays.stream(targetType.getDeclaredMethods())
            .filter(method -> method.getName().equalsIgnoreCase(("set" + fieldName)))
            .findAny()
            .get()
            .getModifiers());
  }

  /**
   * Compares two objects of the class T by the value of the field that was randomly chosen. It
   * allows null values for the fields, and it treats null value grater than a non-null value (nulls
   * last).
   */
  @Override
  @SneakyThrows
  public int compare(T o1, T o2) {
    randomField.setAccessible(true);
    Comparable o1f = (Comparable) randomField.get(o1);
    Comparable o2f = (Comparable) randomField.get(o2);

    if (o1f == null) {
      return (o2f == null) ? 0 : 1;
    } else if (o2f == null) {
      return -1;
    } else {
      return o1f.compareTo(o2f);
    }
  }

  /**
   * Returns a statement "Random field comparator of class '%s' is comparing '%s'" where the first
   * param is the name of the type T, and the second parameter is the comparing field name.
   *
   * @return a predefined statement
   */
  @Override
  public String toString() {
    return String.format(
        "Random field comparator of class '%s' is comparing '%s'",
        classType.getTypeName(), randomField.getName());
  }
}
