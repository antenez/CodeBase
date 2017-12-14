package ba.enox.codebase.algorithms.mathematical;

import java.util.Random;
import java.util.Scanner;

public class RandomNumberGenerator {

	private static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		System.out.println("Enter start number and range:");
		int startNum = sc.nextInt();
		int range = sc.nextInt();
		
		System.out.println("Random number is : "+getRandomIntInRange(startNum, range));
	}

	public static int getRandomIntInRange(int startNum, int range) {
		Random ran = new Random();
		return ran.nextInt(range) + startNum;
	}

}
