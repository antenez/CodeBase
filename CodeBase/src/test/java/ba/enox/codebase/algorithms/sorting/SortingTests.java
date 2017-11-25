package ba.enox.codebase.algorithms.sorting;

import static org.junit.Assert.*;

import org.junit.Test;
import org.omg.CORBA.Current;

public class SortingTests {
	MergeSort ms = new MergeSort();
	QuickSort2 qs = new QuickSort2();
	SelectionSort ss = new SelectionSort();
	
	long start;
	long end;
	
	@Test
	public void test() {
		int[]array = new int[]{10,5,2,7,4,9,12,1,8,6,11,3,13,20,14,19,15,18,16,17};
//		start= System.currentTimeMillis();
//		array=ms.mergeSort(array);
//		end= System.currentTimeMillis();
//		System.out.println("+++sorting time merge sort ms"+(end-start));
//		for(int i=0;i<20;i++){
//			assertEquals("Elment on position is not equal to value "+i,array[i],i+1);
//		}
//		
//		
//		array =new int[]{10,5,2,7,4,9,12,1,8,6,11,3,13,20,14,19,15,18,16,17};
//		start= System.currentTimeMillis();
//		array=ss.doSelectionSort(array);
//		end= System.currentTimeMillis();
//		System.out.println("+++sorting time selectionsort ms"+(end-start));
//		for(int i=0;i<20;i++){
//			assertEquals("Elment on position is not equal to value "+i,array[i],i+1);
//		}
//		
		array =new int[]{10,5,2,7,4,9,12,1,8,6,11,3,13,20,14,19,15,18,16,17};
		start= System.currentTimeMillis();
		array=qs.quickSort(array);
		end= System.currentTimeMillis();
		System.out.println("+++sorting time quicksort ms"+(end-start));
		for(int i=0;i<20;i++){
			assertEquals("Elment on position is not equal to value "+i,array[i],i+1);
		}
	}

}
