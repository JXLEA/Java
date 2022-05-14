package com.ua.jxlea;

public class HashTable<T> {

  @SuppressWarnings("unchecked")
  private Node<T>[] container = new Node[10];

  /**
   * Adds an element to the hash table. Does not support duplicate elements.
   *
   * @param element
   * @return true if it was added
   */
  public boolean add(T element) {
    int loadFactor = getLoadFactor();
    if (loadFactor % container.length > 6) {
      resize(((container.length * 3) / 2));
    }

    var hashOfCurrentCell = getHashCode(element, container.length);
    var current = container[hashOfCurrentCell];
    if (current == null) {
      container[hashOfCurrentCell] = new Node<>(element);
    } else {
      while (current.next != null) {
        if (current.element.equals(element)) {
          return false;
        }
        current = current.next;
      }
      current.next = new Node<>(element);
    }
    return true;
  }

  // the load factor an expected length of a chain.
  // to have search time in O(1) instead of O(n)
  private int getLoadFactor() {
    int n = 0;
    for (Node<T> node : container) {
      while (node != null) {
        n += 1;
        node = node.next;
      }
    }
    return n % (container.length - 1);
  }

  /**
   * Prints a hash table according to the following format 0: Andrii -> Taras 1: Start 2: Serhii ...
   */
  public void printTable() {
    for (Node<T> tNode : container) {
      var current = tNode;
      if (current != null) {
        System.out.print(getHashCode(current.element, container.length) + ": " + current.element);
        while (current.next != null) {
          current = current.next;
          System.out.print(" -> " + current.element);
        }
        System.out.println();
      }
    }
  }

  private int getHashCode(T element, int bound) {
    return new HashFunction<T>().getHashCode(element, bound);
  }

  /**
   * Creates a new underlying table with a given size and add all elements to the new table.
   *
   * @param newSize
   */
  public void resize(int newSize) {
    Node<T>[] resizedContainer = new Node[newSize];
    for (Node<T> node : container) {
      while (node != null) {
        resizedContainer[getHashCode(node.element, resizedContainer.length)] = node;
        node = node.next;
      }
    }
    container = resizedContainer;
  }

  class HashFunction<T> {

    // prehash checks is object hash returns nonegative.
    public int preHash(T element) {
      var elementHash = element.hashCode();
      if (elementHash < 0) {
        elementHash = elementHash * (-1);
      }
      return elementHash;
    }

    public int getHashCode(T element, int bound) {
      var elementHash = preHash(element);

      // replace hash to check the diff results
      return weakHash(elementHash, bound);
    }

    // reduce universe size of all keys(integers) down to reasonable size M(bound) for the table
    // to avoid the collisions
    public int weakHash(int preHash, int bound) {
      return preHash % bound;
    }
  }
}
