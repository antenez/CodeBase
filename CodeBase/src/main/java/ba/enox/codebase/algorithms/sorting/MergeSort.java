package ba.enox.codebase.algorithms.sorting;
/*
 * This sorting use divide and conquer approach.
 * Split array on left and right half till final arrey with one element, which is counted as sorted.
 * This is processed recursively.
 * Magic is happening in merge procedure which erge two arrays in ordered one.
 * Recursion do this till final array which is ordered.
 * 
 * Specific for particular implementation is that it use temp array tostore processed items and return them back to original.
 * This is improvement for space optimization.
 * Processing is logn.
 * 
 */
public class MergeSort {
	
	
	public int[] mergeSort(int[]array){
		return mergeSort(array,new int[array.length], 0,array.length-1);
	}
	
	public int[] mergeSort(int[]array,int[]tmpArray, int leftStart,int rightEnd){
		
		//If we reach end of splitting, if there is only one item in array
		if(leftStart>=rightEnd){
			return array;
		}else{
			printArray(array);
			int middleOfArray = (leftStart+rightEnd)/2;//because we use one array and pay with indexes//array.length/2;//(6)=3 (5)=2 (4)=2
 			//split more left part
				mergeSort(array,tmpArray, leftStart, middleOfArray);
			//split more right part
				mergeSort(array,tmpArray, middleOfArray+1, rightEnd);
			//do sorted merge
				mergeArray(array, tmpArray, leftStart, rightEnd);
				
			
		}
		return array;
	}
	
	public void printArray(int[]array){
		for(int i:array){
			System.out.print(i+" ,");
		}
		System.out.println("");
	}
	
	private int[] mergeArray(int[]array,int[]tmpArray, int leftStart, int rightEnd){
		
		int leftEnd= (leftStart+rightEnd)/2;
		int rightStart =leftEnd+1;
		int totalLength=rightEnd-leftStart+1;
		
		
		int leftInd=leftStart;
		int rightInd=rightStart;
		int index=leftStart;
		
		
		while(leftInd<=leftEnd && rightInd<=rightEnd){
			if(array[leftInd]<=array[rightInd]){
				tmpArray[index]=array[leftInd];
				leftInd++;
			}
			else{
				tmpArray[index]=array[rightInd];
				rightInd++;
			}
			//index in sorted array, tmp, later it will be copied to original.
			index++;
		}
		System.arraycopy(array, leftInd, tmpArray, index, leftEnd-leftInd+1);
		System.arraycopy(array, rightInd, tmpArray, index, rightEnd-rightInd+1);
		System.arraycopy(tmpArray, leftStart, array,leftStart, totalLength);
		return array;
				
	}

}
