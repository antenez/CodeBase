package ba.enox.codebase.algorithms.mathematical;

public class CountPrimeNumbers {
	
	/*
	 * A prime number (or a prime) is a natural number greater than 1 
	 * that has no positive divisors other than 1 and itself. 
	 * A natural number greater than 1 that is not a prime number
	 *  is called a composite number. For example, 
	 *  5 is prime because 1 and 5 are its only positive integer factors, 
	 *  whereas 6 is composite because it has the divisors 2 and 3 in addition to 1 and 6. 
	 */

	public static void main(String[] args) {
		for (int i = 1; i < 1000; i++) {
			System.out.println("Is prime "+i+" = "+isPrimeNumber(i));
		}
	}
	
	public static boolean isPrimeNumber(int number){
		if(number==1){
			return false;
		}
		//simple i<=(number/2)
		//improved i<=Math.sqrt(number)
		//without function is final
		for(int i=2; i*i<=number ;i++){
			if (number%i == 0 ){
				return false;
			}
		}
		return true;
	}

}
