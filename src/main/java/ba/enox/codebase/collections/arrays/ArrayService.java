package ba.enox.codebase.collections.arrays;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class ArrayService {

  /**
   * It will return all distinct but without order.
   *
   * @param arr
   * @return
   */
  public int[] removeDuplicateIntegersFromArray(int[] arr) {

    int index = 0;
    int arraySize = arr.length;
    for (index = 0; index < arraySize; index++) {
      for (int compareInd = index + 1; compareInd < arraySize; compareInd++) {
        if (arr[index] == arr[compareInd]) {
          int temp = arr[compareInd];
          arr[compareInd] = arr[arraySize - 1];
          arr[arraySize - 1] = temp;
          compareInd--;
          arraySize--;
        }
      }
    }

    int[] newArray = new int[arraySize];
    System.arraycopy(arr, 0, newArray, 0, arraySize);
    return newArray;
  }

  /**
   * It will return all distinct but without order.
   *
   * @param arr
   * @return
   */
  public List removeDuplicateIntegersFromArrayByUsingSets(List<Integer> primes) {

    // let's print arraylist with duplicate
    System.out.println("list of prime numbers : " + primes);

    // Now let's remove duplicate element without affecting order
    // LinkedHashSet will guaranteed the order and since it's set
    // it will not allow us to insert duplicates.
    // repeated elements will automatically filtered.
    Set<Integer> primesWithoutDuplicates = new LinkedHashSet<Integer>(primes);

    // now let's clear the ArrayList so that we can copy all elements from
    // LinkedHashSet
    primes.clear();
    // copying elements but without any duplicates
    primes.addAll(primesWithoutDuplicates);
    System.out.println("list of primes without duplicates : " + primes);
    return primes;
  }
}
