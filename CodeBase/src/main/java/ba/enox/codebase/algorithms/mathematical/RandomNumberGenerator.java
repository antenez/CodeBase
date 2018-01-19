package ba.enox.codebase.algorithms.mathematical;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class RandomNumberGenerator {

	private static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
//		System.out.println("Enter start number and range:");
//		int startNum = sc.nextInt();
//		int range = sc.nextInt();
//		
//		System.out.println("Random number is : "+getRandomIntInRange(startNum, range));
//		
		Integer[] myArray = new Integer[]{1,2,3,8,9};		
		Set<Integer>realNumbersToMatch = new HashSet<>(Arrays.asList(myArray));
		
		System.out.println("+++generated number"+getRandomIntInRangeInSet(1,10,realNumbersToMatch));
		
		
	}

	public static int getRandomIntInRange(int startNum, int range) {
		Random ran = new Random();
		return ran.nextInt(range) + startNum;
	}
	
	public static int getRandomIntInRangeInSet(int startNum, int range, Set<Integer>realNumbersToMatch) {
		Random ran = new Random();
		Integer tmp=-1;
		do{
			tmp = ran.nextInt(range) + startNum;
		}while(!realNumbersToMatch.contains(tmp));
		
		return tmp;
	}

}
