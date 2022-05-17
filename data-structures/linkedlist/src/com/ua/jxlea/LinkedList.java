package com.ua.jxlea;

import javax.swing.text.Element;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class  LinkedList {

  public static void main(String[] args) {
    var names =
        new String[] {
          "Andrii", "Serhii", "Nazar", "Taras", "Stas", "Yurii", "Tetiana", "Valerii", "Victoriai"
        };
    var head = createLinkedList(names);
    printLinkedList(head);
    System.out.println();
    var invHead = invertLinkedList(head);
    printLinkedList(invHead);
  }

  /** Creates a linked list based on the input array and returns a head */
  public static <T> Node<T> createLinkedList(T... element) {
    var head = new Node<T>(element[0]);
    var current = head;
    var counter = 1;
    while (counter < element.length) {
      current.next = new Node<>(element[counter++]);
      current = current.next;
    }
    return head;
  }

  /**
   * Prints a linked list with arrows like this head:5 -> 7 -> 1 -> 4
   *
   * @param head the first element of the list
   */
  public static void printLinkedList(Node<?> head) {
    System.out.print("head:" + head.element);
    while (head.next != null) {
      System.out.print(" -> " + head.next.element);
      head = head.next;
    }
  }
  //"Andrii", "Serhii", "Nazar", "Taras", "Stas", "Yurii", "Tetiana", "Valerii", "Victoriai"
  public static <T> Node<T> invertLinkedList(Node<T> head) {
    Node<T> current = head;
    Node<T> previous = null;
    while (head != null) {
      head = head.next;
      previous.next = previous;
      //previous =
    }
    return head;
  }
}
