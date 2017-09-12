package ba.enox.codebase.algorithms.trees;

/**
 * @author eno.ahmedspahic
 * This is example of balanced tree implementation
 * Cover also InOrder L-Root-R traversal (others are PostOrder -R-L-root and preorder Root-L-R )
 */
public class Node {
	private int data;
	private Node left,right;
	
	public Node(int data){
		super();
		this.data = data;
	}
	
	public void insert(int value){
		if(value <= data){
			if(left == null){
				left = new Node(value);
			}else{
				left.insert(value);
			}
		}else{
			if(right == null){
				right = new Node(value);
			}else{
				this.right.insert(value);
			}
		}
	}
	
	public boolean contains(int value){
		if(this. data == value){
			return true;
		}
		else if(value < data){
			if(left==null){
				return false;
			}else{
				return this.left.contains(value);
			}
		}else{
			if(right==null){
				return false;
			}else{
				return this.right.contains(value);
			}
		}
		//return false;
	}
	
	public void printInOrder(){
		if(left!=null){
			left.printInOrder();			
		}
		System.out.println(data+" ");
		if(right!=null){
			right.printInOrder();
		}
	}
	
	

}
