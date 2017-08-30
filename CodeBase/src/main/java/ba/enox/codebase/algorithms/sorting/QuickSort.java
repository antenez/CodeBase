package ba.enox.codebase.algorithms.sorting;

public class QuickSort {
//TODO
	
	public int[] quickSort(int[] array){
		quickSort(array, 0, array.length-1);
		return array;
	}
	
	private int[] quickSort(int[] array,int left, int right){
		if(left>=right){
			return array;
		}
		
		int pivot=array[(left+right)/2];
		int index = partition(array, left,right,pivot);
		
		//quicksortleft
		quickSort(array, left, index-1);
		//quicksortright
		quickSort(array, index,right);
		
		
		
		return array;
	}
	
	private int partition(int[]array, int left,int right, int pivot){
		
		while(left<=right){
			
			while(array[left]<pivot ){
				left++;
			}
			while (array[right]>pivot){
				right--;
			}
			
			if(left<=right){
				//swap
				swapArrayElements(array, left, right);
				//break main while loop
				left++;
				right--;
			}
		}
		return left;
		
		
	}
	
	private void swapArrayElements(int []array, int left, int right){
		int i = array[left];
		array[left]=right;
		array[right]=i;
	}
	
}
