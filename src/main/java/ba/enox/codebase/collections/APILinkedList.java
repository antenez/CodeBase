package ba.enox.codebase.collections;

import java.util.LinkedList;

public class APILinkedList {

  public static void main(String[] args) {
    // Deque
    // Doubly linked list
    // Not Synchronised
    LinkedList<String> list = new LinkedList<>();

    list.addFirst("1");
    list.addLast("2");
    list.addFirst("3");
    list.addLast("4");

    while (!list.isEmpty()) {
      System.out.println(list.peek());
      System.out.println(list.peekFirst());

      // Same as pollFirst
      System.out.println(list.poll());
    }
  }
}
