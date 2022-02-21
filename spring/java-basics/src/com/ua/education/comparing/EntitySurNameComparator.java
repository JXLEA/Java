package com.ua.education.comparing;

import java.util.Comparator;

public class EntitySurNameComparator implements Comparator<EntityComparable> {

    @Override
    public int compare(EntityComparable o1, EntityComparable o2) {
        return o1.getSurname().compareTo(o2.getSurname());
    }
}
