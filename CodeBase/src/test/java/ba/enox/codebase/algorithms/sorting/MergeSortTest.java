package ba.enox.codebase.algorithms.sorting;

import static org.junit.Assert.*;

import org.junit.Test;

public class MergeSortTest {

	@Test
	public void test() {
		int[]array = new int[]{10,5,2,7,4,9,12,1,8,6,11,3,13};
		MergeSort ms = new MergeSort();
		array=ms.mergeSort(array);
		for(int i=0;i<13;i++){
			assertEquals("Elment on position is not equal to value "+i,array[i],i+1);
		}
		
		
	}

}
