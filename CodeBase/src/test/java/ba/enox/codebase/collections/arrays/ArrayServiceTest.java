package ba.enox.codebase.collections.arrays;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class ArrayServiceTest {

	ArrayService arrayService = new ArrayService();

	@Test
	public void testRemoveDuplicateIntegersFromArray() {

		int[] array = new int[] { 1, 2, 1, 3, 2, 4, 1, 5, 3, 5, 6, 7, 8, 1, 9, 10 };
		int[] result = arrayService.removeDuplicateIntegersFromArray(array);

		assertTrue("Size is not 10 ", result.length == 10);
		boolean[] checkerArray = new boolean[result.length + 1];
		for (int i = 0; i < result.length; i++) {
			if (checkerArray[result[i]] == true) {
				fail();
			} else {
				checkerArray[result[i]] = true;
			}
		}
	}

	@Test
	public void testRemoveDuplicateIntegersFromArrayBySet() {

		// creating ArrayList with duplicate elements
		List<Integer> primes = new ArrayList<Integer>();
		primes.add(1);
		primes.add(2);
		primes.add(2);
		primes.add(3);
		primes.add(4);
		primes.add(5);
		primes.add(6);
		primes.add(7);
		primes.add(8);
		primes.add(8); // duplicate
		primes.add(9);
		primes.add(10);
		
		List<Integer> result = arrayService.removeDuplicateIntegersFromArrayByUsingSets(primes);

		assertTrue("Size is not 10 ", result.size() == 10);
		boolean[] checkerArray = new boolean[result.size() + 1];
		for (int i : result) {
			if (checkerArray[i] == true) {
				fail();
			} else {
				checkerArray[i] = true;
			}
		}
	}

}
