package ba.enox.codebase.collections.linkedlists;

/**
 * @author ea
 * 
 * Link is an object
 * Each link has reference to next object
 * Linked list has reference only to last object added to the list
 *
 */
public class Node {
	String nameOfItem;
	Node next;
	
	public Node(String nameOfItem){
		this.nameOfItem=nameOfItem;
		next = null;
	}
	
	
	public void display(){
		System.out.println("Name of object is "+nameOfItem);
	}
	
	
	public String toString(){
		return nameOfItem;
	}

}
