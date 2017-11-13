package ba.enox.codebase.collections.linkedlists;
//https://www.youtube.com/watch?v=195KUinjBpU

public class LinkedList {
	Node firstLink;
	
	//To show that at every beginning first link is nulls
	public LinkedList() {
		firstLink=null;
	}
	
	//To check is list empty, we check is first link empty
	public boolean isEmpty(){
		return (firstLink==null);
	}
	
	/*
	 * New link is created
	 * Next of new link, points to previous first link
	 * Newest item becomes fistLink
	 */
			
	public void insertNewLink(String nameOfLink){
		Node newLink = new Node(nameOfLink);
		newLink.next=firstLink;
		firstLink=newLink;
	}
	
	//Remove item work like changing first linkt o be value of firstLink next element.
	public Node removeFirstLink(){
		Node linkReference = firstLink;
		if (!isEmpty()){
			firstLink=firstLink.next;
		}else{
			System.out.println("+++itIs empty list");
		}
		return linkReference;
		
	}
	
	//looptrough list
	//display from first link until there is no next
	public void displayItems(){
		Node theLink = firstLink;
		
		while(theLink!=null){
			theLink.display();
			System.out.println("NextLink: "+theLink.next);
			System.out.println();
			theLink= theLink.next;
		}
	}
	
	public Node findingItemOnTheList(String name){
		Node theLink = firstLink;
		
		if(!isEmpty()){
			while(theLink.nameOfItem!=name){
				
				if (theLink.next == null){
					return null;
				}else{
					theLink=theLink.next;
				}
			}
		}else{
			System.out.println("It is empty");
		}
		return theLink;
	}
	
	
	//Remove item from inked list
	/*
	 * Go trough list till match
	 * when foun...
	 * 	if frst take his next and mark it as first
	 * 	if occurs elswhere ... find the link which nest is our target
	 * 	take next of the next founded before and assign it to link before
	 */
	public Node removeLink(String nameOfItem){
		Node currentLik = firstLink;
		Node previousLink = firstLink;//To have it initialized
		
		while (nameOfItem!=currentLik.nameOfItem){
			if(currentLik.next==null){
				return null;
			}else{
				previousLink =currentLik;
				currentLik=currentLik.next;
				
			}
		}
		
		if(currentLik==firstLink){
			firstLink=firstLink.next;
		}else{
			previousLink.next=currentLik.next;
		}
		
		return currentLik;
	}
	
	
	
	
}
