package ba.enox.codebase.algorithms.string;

import java.util.Scanner;

public class SysOutInDemo {
	
	public static void main(String[] args) {
		
		 Scanner in = new Scanner(System.in);
	        int a;
	        System.out.println("Enter first number :");
	        a = in.nextInt();
	        int b;
	        System.out.println("Enter second number :");
	        b = in.nextInt();
	        int sum;
	        sum = a+b;
	        System.out.println(sum);
	        in.close();
		
	}

}
