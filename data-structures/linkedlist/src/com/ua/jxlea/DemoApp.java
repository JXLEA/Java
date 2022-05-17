package com.ua.jxlea;

import java.util.Stack;

public class DemoApp {

  public static void main(String[] args) {
    var head = createLinkedList(4, 3, 9, 1);
    printReversed(head);
  }

  /**
   * Creates a list of linked {@link Node} objects based on the given array of elements and returns
   * a head of the list.
   *
   * @param elements an array of elements that should be added to the list
   * @param <T> elements type
   * @return head of the list
   */
  public static <T> Node<T> createLinkedList(T... elements) {
    Node<T> head = new Node<>(elements[0]);
    Node<T> current = head;
    for(var i = 0; i < elements.length; i++) {
      Node<T> element = new Node<>(elements[i]);
      current.next = element;
    }
    return head;
  }

  /**
   * Prints a list in a reserved order using a recursion technique. Please note that it should not
   * change the list, just print its elements.
   *
   * <p>Imagine you have a list of elements 4,3,9,1 and the current head is 4. Then the outcome
   * should be the following: 1 -> 9 -> 3 -> 4
   *
   * @param head the first node of the list
   * @param <T> elements type
   */
  public static <T> void printReversed(Node<T> head) {
    printRecursively(head.next);
    System.out.println();
  }

  public static <T> void printReversedUsingStack(Node<T> head) {
    var stack = new Stack<>();

  }

  private static void printRecursively(Node<?> node) {
    if (node != null) {
      printRecursively(node.next);
      System.out.print(" -> " + node.element);
    }
  }
}
