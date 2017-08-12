package ba.enox.codebase.collections.linkedlists;

/**
 * @author ea
 * 
 * Link is an object
 * Each link has reference to next object
 * Linked list has reference only to last object added to the list
 *
 */
public class SimpleLink {
	String nameOfItem;
	SimpleLink next;
	
	public SimpleLink(String nameOfItem){
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
