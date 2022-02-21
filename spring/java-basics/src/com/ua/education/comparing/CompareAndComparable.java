package com.ua.education.comparing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CompareAndComparable {

    public static void main(String[] args) {
        printInNaturalOrder();
    }

    public static void printInNaturalOrder() {
        List<EntityComparable> list = new ArrayList(List.of(
                new EntityComparable("Will", "Smith"),
                new EntityComparable("John", "Doe"),
                new EntityComparable("Chuck", "Norris"))
        );

        // так сравнение происходит только при условии реализации
        // интерфейса Comparable иначе - ошибка компиляции
        Collections.sort(list);
        System.out.println(list);

        // таким образом сравнение происходит мы уже
        // можем докидывать в сортировку нужные нам "сравниватели" - Comparators
        Collections.sort(list, new EntitySurNameComparator());

        // либо так
        list.sort(new EntitySurNameComparator());
        System.out.println(list);
    }
}
