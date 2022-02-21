package com.ua.education.compare;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CompareAndComparable {

    public static void main(String[] args) {
        printInNaturalOrder();
    }

    public static void printInNaturalOrder() {
        List<String> list = new ArrayList(List.of(
                new CustomComparableEntity("Will", "Smith"),
                new CustomComparableEntity("John", "Doe"),
                new CustomComparableEntity("Chuck", "Norris"))
        );

        Collections.sort(list);
        System.out.println(list);
    }
}
