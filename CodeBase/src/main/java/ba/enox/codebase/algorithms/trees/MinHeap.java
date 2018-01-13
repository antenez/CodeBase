package ba.enox.codebase.algorithms.trees;

import java.util.Arrays;

/*
 * https://www.youtube.com/watch?v=t0Cq6tVNRBA&t=8s 
 * Tree structure with minimum element at the top and maximum at last bottom right node.
 * For implementation ussualy we use array, Can be also implemented as tree with left and right nodes.
 * Accesing elements in array formulas:
 * 	parent = (index-2/2)
 * 	left = (index*2+1)
 * 	right = (index*2 +2 )
 */
		
public class MinHeap {
	
	private int size=0;
	private int capacity=10;
	int[] items = new int[capacity];
	
	private int getLeftChildIndex(int elementIndex){ return (2*elementIndex)+1;}
	private int getRightChildIndex(int elementIndex){ return (2*elementIndex)+2;}
	private int getParentIndex(int elementIndex){ return (elementIndex-1)/2;}
	
	//private boolean hasLeftChild(int index){ return getLeftChi)}
	private boolean hasLeftChild(int elementIndex){return getLeftChildIndex(elementIndex)<size;}
	private boolean hasRightChild(int elementIndex){return getRightChildIndex(elementIndex)<size;}
	private boolean hasParent(int elementIndex){return getParentIndex(elementIndex)>=0;}
	
	
	
	private int leftChild(int index ){ return items[getLeftChildIndex(index)]; }
	private int rightChild(int index ){ return items[getRightChildIndex(index)]; }
	private int parentOfChild(int index ){ return items[getParentIndex(index)]; }
	
	private void swapElements (int indexOne, int indexTwo){
		int tmp = items[indexOne];
		items[indexOne] = items[indexTwo];
		items[indexTwo] =tmp;
		
	}
	
	private void ensureExtraCappacity(){
		if(size == capacity){
			capacity *=2;
			items = Arrays.copyOf(items,capacity);
		}
	}
	
	/*
	 * selectMin 
	 * @return
	 */
	public int peek(){
		if (size==0){throw new IllegalStateException();}
		return items[0];
	}
	
	/*
	 * takeMin and remove 
	 * @return
	 */
	public int pool(){
		if (size==0){throw new IllegalStateException();}
		int responseValue = items[0];
		size--;
		reheapifyDown();
		return responseValue;
	}
	
	/**
	 * Add item at the end and then heapify rebalance upword.
	 * @param item
	 */
	public void add(int item){
		ensureExtraCappacity();
		items[size]=item;
		size++;
		reheapifyUp();
	}
	
	public void reheapifyUp(){
		int currentElementIndex = size-1;
		while (currentElementIndex >= 0 &&  items[currentElementIndex]> items[getParentIndex(currentElementIndex)]){
			swapElements(currentElementIndex, getParentIndex(currentElementIndex));
			currentElementIndex=getParentIndex(currentElementIndex);
		}
	}
	
	public void reheapifyDown(){
		int currentElementIndex = 0;
		while (hasLeftChild(currentElementIndex)){
			int smallerChildInd = getLeftChildIndex(currentElementIndex);
			if(hasRightChild(currentElementIndex) && rightChild(currentElementIndex)<leftChild(currentElementIndex)){
				smallerChildInd=getRightChildIndex(currentElementIndex);
			}
			
			swapElements(currentElementIndex, smallerChildInd);
			currentElementIndex=smallerChildInd;
			
			if(items[smallerChildInd]< items[currentElementIndex]){
				break;
			}else{
				swapElements(currentElementIndex, getParentIndex(currentElementIndex));
			}
			currentElementIndex=getParentIndex(currentElementIndex);
		}
	}
	
	
	
	
	
	
	
	/*
	 * Insert operation is going to latest empty right spot. Then we need to booble it up to the top in tree to find right spot
	 */
	
	/*
	 * Removing min element
	 * 	Remove root element
	 * 	Replace it with lates added element
	 * 	Swap elements down trough the tree till right spot
	 */
	
	/*
	 * Removing min element
	 * 	Remove root element
	 * 	Replace it with lates added element
	 * 	Swap elements down trough the tree till right spot
	 */
	
	
	/*
	 * 
	 */
	
}
