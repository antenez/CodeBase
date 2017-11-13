package ba.enox.codebase.collections.linkedlists;

import org.w3c.dom.ls.LSSerializer;

public class LinkedListMain {
	static LinkedListService lss = new LinkedListService();
	public static void main(String[] args){
		System.out.println("test");
		
		
		LinkedList list = new LinkedList();
		list.insertNewLink("Nasko");
		list.displayItems();
		list.removeFirstLink();
		
		list.insertNewLink("Nasko");
		list.insertNewLink("Enko");
		list.insertNewLink("Elma");
		list.insertNewLink("Emir");
		list.insertNewLink("Emin");
		list.displayItems();
		
		System.out.println("----remove first start");
		
		list.removeFirstLink();
		list.displayItems();
		
		System.out.println(list.findingItemOnTheList("Enko").nameOfItem+" was found!");
		
		list.removeLink("Enko");
		
		System.out.println("----Remove Enko After");
		list.displayItems();
		
		
		
		Node head = new Node("1");
		head.addNext("2");
		Node current = head.next;
		current.addNext("3");
		current=current.next;
		current.addNext("4");
		current=current.next;
		current.addNext("5");
		current=current.next;
		
		lss.display(head);
		head = lss.reverseLinkedList(head);
		lss.display(head);
	}

}
