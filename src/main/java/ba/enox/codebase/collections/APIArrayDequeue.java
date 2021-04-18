package ba.enox.codebase.collections;

import java.util.ArrayDeque;

public class APIArrayDequeue {
  public static void main(String[] args) {

    // ArrayDeque same as Linked list but bit faster with some operations
    // Doubly linked list
    // Not Synchronised
    ArrayDeque<String> dequeue = new ArrayDeque<>();

    dequeue.addFirst("1");
    dequeue.addLast("2");
    dequeue.addFirst("3");
    dequeue.addLast("4");

    while (!dequeue.isEmpty()) {
      System.out.println(dequeue.peek());
      System.out.println(dequeue.peekFirst());

      // Same as pollFirst
      System.out.println(dequeue.poll());
    }
  }
}
