package ba.enox.codebase.algorithms.sorting;

public class SelectionSort {
//	Selection Sort
/*
 * 	Link http://www.geeksforgeeks.org/selection-sort/
	The selection sort algorithm sorts an array by repeatedly finding the minimum element (considering ascending order)
	from unsorted part and putting it at the beginning. The algorithm maintains two subarrays in a given array.

	1) The subarray which is already sorted.
	2) Remaining subarray which is unsorted.

	In every iteration of selection sort, the minimum element (considering ascending order) from the unsorted subarray is picked and moved to the sorted subarray.

	Following example explains the above steps:

	arr[] = 64 25 12 22 11

	// Find the minimum element in arr[0...4]
	// and place it at beginning
	11 25 12 22 64

	// Find the minimum element in arr[1...4]
	// and place it at beginning of arr[1...4]
	11 12 25 22 64

	// Find the minimum element in arr[2...4]
	// and place it at beginning of arr[2...4]
	11 12 22 25 64

	// Find the minimum element in arr[3...4]
	// and place it at beginning of arr[3...4]
	11 12 22 25 64 
 */
	public int[] doSelectionSort(int[] array){
		
		int minIndex = 0;
		for(int nextUnsortedIndex=0; nextUnsortedIndex<array.length;nextUnsortedIndex++ ){		
			minIndex=nextUnsortedIndex;
			for(int j=nextUnsortedIndex; j<array.length ; j++ ){
				if(array[j]<=array[minIndex]){
					minIndex=j;
				}
			}
			//swapValues(array[nextUnsortedIndex], array[minIndex]);
			int tmp=0;
			tmp=array[nextUnsortedIndex];
			array[nextUnsortedIndex]=array[minIndex];
			array[minIndex]=tmp;
		}
		return array;
	}
	
	public void swapValues(int a, int b){
		int tmp=0;
		tmp=a;
		a=b;
		b=tmp;
	}

}
