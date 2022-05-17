package com.ua.jxlea;

import java.util.Objects;

public class Node<T> {

    T element;
    Node<T> next;

    public Node(T element) {
        this.element = element;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node<?> node = (Node<?>) o;
        return Objects.equals(element, node.element) && Objects.equals(next, node.next);
    }

    @Override
    public int hashCode() {
        return Objects.hash(element, next);
    }
}
