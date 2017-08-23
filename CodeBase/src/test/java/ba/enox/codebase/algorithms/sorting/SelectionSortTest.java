package ba.enox.codebase.algorithms.sorting;

import static org.junit.Assert.*;

import org.junit.Test;

import junit.framework.TestCase;

public class SelectionSortTest extends TestCase {

	@Test
	public void test() {
		int[] array = new int[]{64 ,25, 12, 22, 11};
		SelectionSort ss = new SelectionSort();
		array=ss.doSelectionSort(array);
		int tmp=0;
		for(int i=0; i< array.length; i++){
			assertTrue(array[tmp]<=array[i]);
			tmp=i;			
		}
		
	}

}
