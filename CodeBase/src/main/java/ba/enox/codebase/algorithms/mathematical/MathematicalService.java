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
	
	 public static BigInteger factorielWithLargeResult(int n){
	        if(n==1){
	            return BigInteger.valueOf(1);
	        }
	        else{
	            return BigInteger.valueOf(n).multiply(factorielWithLargeResult(n-1));
	        }
	    }
	 
	 int consecutiveCounter;
	 int numberOfCounts;
	 /**
	 * @param number
	 * @return for 15 retrn 3 because 3ree combinations (1+2+3+4+5)   (4+5+6)   (7+8)
	 */
	public int getConsecutiveSumCombinationForNumber(int number){
		int counter=0;
		for(int i=(number/2)+1; i >0 ; i--){
			int tmpSum=0;
			for(int j = i ; j >0 && tmpSum<number ; j--){
				tmpSum+=j;
				if(tmpSum==number){
					counter++;
					break;
				}
			}
		}
		return counter;
	 }

}
