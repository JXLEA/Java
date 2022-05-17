package com.ua.jxlea;

import java.util.Objects;

public class Node<T> {

    T element;
    Node<T> next;

    public Node(T element) {
        this.element = element;
    }
}
