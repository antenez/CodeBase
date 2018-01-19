package ba.enox.codebase.collections.linkedlists;

public class LinkedListService {
	
	public Node reverseLinkedList(Node node){
		 Node prev = null;
	        Node current = node;
	        Node next = null;
	        while (current != null) {
	            next = current.next;
	            current.next = prev;
	            prev = current;
	            current = next;
	        }
	        node = prev;
	        return node;
	}
	
	public void  display(Node head){
		System.out.println("===Printout list from head===");
		Node current = head;
		while (current!=null){
			System.out.println("current: "+current+" next: "+current.next);
			current=current.next;
		}
		
	}

}
