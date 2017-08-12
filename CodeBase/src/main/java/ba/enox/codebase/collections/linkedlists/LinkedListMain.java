package ba.enox.codebase.collections.linkedlists;

public class LinkedListMain {
	
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
	}

}
