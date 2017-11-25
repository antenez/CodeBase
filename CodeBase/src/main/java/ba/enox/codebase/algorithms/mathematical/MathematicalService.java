package ba.enox.codebase.algorithms.mathematical;

import java.math.BigInteger;

public class MathematicalService {

	/*
	 * Really large facoriel
	 * 
	 * test for number 25
	 * 
	 * We recommend solving this challenge using BigIntegers.
	 */

	public BigInteger factorielWithLargeResult(int n) {
		if (n == 1) {
			return BigInteger.valueOf(1);
		} else {
			return BigInteger.valueOf(n).multiply(factorielWithLargeResult(n - 1));
		}
	}

	int consecutiveCounter;
	int numberOfCounts;

	/**
	 * @param number
	 * @return for 15 retrn 3 because 3ree combinations (1+2+3+4+5) (4+5+6)
	 *         (7+8)
	 */
	public int getConsecutiveSumCombinationForNumber(int number) {
		int counter = 0;
		for (int i = (number / 2) + 1; i > 0; i--) {
			int tmpSum = 0;
			for (int j = i; j > 0 && tmpSum < number; j--) {
				tmpSum += j;
				if (tmpSum == number) {
					counter++;
					break;
				}
			}
		}
		return counter;
	}

	/*
	 * Find the number of ways that a given integer, , can be expressed as the
	 * sum of the power of unique, natural numbers. Input Format
	 * 
	 * The first line contains an integer X. The second line contains an integer
	 * N.
	 * 
	 * If X=10 and N =2 we need to find the number of ways that can be
	 * represented as the sum of squares of unique numbers. 10 = 1pow2 +3pow2 =>
	 * 1+9 only combination.
	 * 
	 */

	public int countPowerSum(int total, int power, int number) {
		int value = (int) (total - Math.pow(number, power));
		if (value < 0) {
			return 0;
		} else if (value == 0) {
			return 1;
		} else {
			return countPowerSum(value, power, number + 1) + countPowerSum(total, power, number + 1);
		}

	}

}
