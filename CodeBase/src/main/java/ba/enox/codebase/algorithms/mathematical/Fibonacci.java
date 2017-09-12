package ba.enox.codebase.algorithms.mathematical;
/*
In mathematics, the Fibonacci numbers are the numbers in the following integer sequence, called the Fibonacci sequence, and characterized by the fact that every number after the first two is the sum of the two preceding ones:[1][2]

{\displaystyle 1,\;1,\;2,\;3,\;5,\;8,\;13,\;21,\;34,\;55,\;89,\;144,\;\ldots } {\displaystyle 1,\;1,\;2,\;3,\;5,\;8,\;13,\;21,\;34,\;55,\;89,\;144,\;\ldots }
Often, especially in modern usage, the sequence is extended by one more initial term:

{\displaystyle 0,\;1,\;1,\;2,\;3,\;5,\;8,\;13,\;21,\;34,\;55,\;89,\;144,\;\ldots } {\displaystyle 0,\;1,\;1,\;2,\;3,\;5,\;8,\;13,\;21,\;34,\;55,\;89,\;144,\;\ldots }.[3]

The Fibonacci spiral: an approximation of the golden spiral created by drawing circular arcs connecting the opposite corners of squares in the Fibonacci tiling;[4] this one uses squares of sizes 1, 1, 2, 3, 5, 8, 13 and 21.
By definition, the first two numbers in the Fibonacci sequence are either 1 and 1, or 0 and 1, depending on the chosen starting point of the sequence, and each subsequent number is the sum of the previous two.

The sequence Fn of Fibonacci numbers is defined by the recurrence relation:

{\displaystyle F_{n}=F_{n-1}+F_{n-2},} {\displaystyle F_{n}=F_{n-1}+F_{n-2},}
with seed values[1][2]

{\displaystyle F_{1}=1,\;F_{2}=1} {\displaystyle F_{1}=1,\;F_{2}=1}
or[5]

{\displaystyle F_{0}=0,\;F_{1}=1.} {\displaystyle F_{0}=0,\;F_{1}=1.}
 */
public class Fibonacci {
	
	/*
	 * This can be optimized with memorization of repeated calculations.
	 */
	public int fibonnacy(int i){
		if(i==0) return 0;
		if(i==1)return 1;
		return fibonnacy(i-1)+fibonnacy(i-2);
	}
	
	public int fibonnacy(int i, int[] array){
		if(i==0) return 0;
		if(i==1)return 1;
		if(0==array[i]){
			return array[i]=fibonnacy(i-1, array)+fibonnacy(i-2, array);
		}
		
		return array[i];
	}

}
