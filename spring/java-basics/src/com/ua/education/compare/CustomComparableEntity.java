package com.ua.education.compare;

import java.util.Objects;

public class CustomComparableEntity implements Comparable<CustomComparableEntity>{

    private String name;
    private String surname;

    public CustomComparableEntity(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    @Override
    public int compareTo(CustomComparableEntity another) {
        int res = this.name.compareTo(another.name);
        if (res == 0) {
            return this.surname.compareTo(another.surname);
        }
        return res;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomComparableEntity that = (CustomComparableEntity) o;
        return Objects.equals(name, that.name) && Objects.equals(surname, that.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname);
    }

    @Override
    public String toString() {
        return "CustomComparableEntity{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}
