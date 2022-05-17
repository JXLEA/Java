package com.ua.jxlea;

import lombok.Builder;
import lombok.Data;

public class Node<T> {

    T element;
    Node<T> next;

    Node(T element) {
        this.element = element;
    }
}
