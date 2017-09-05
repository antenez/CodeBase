package ba.enox.codebase.collections.linkedlists;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

//you can also use imports, for example:
//import java.util.*;

//you can write to stdout for debugging purposes, e.g.
//System.out.println("this is a debug message");

class Solution1 {
	 public int solution(int[] A, int[] B, int M, int X, int Y) {
	        // write your code in Java SE 8
	        PriorityQueue<Integer> elevatorStack = new PriorityQueue<Integer>(M, new Comparator<Integer>() {
				public int compare(Integer o1, Integer o2) {
					return o1.compareTo(o2);
				};
			});

			if (A.length == 0) {
				return 0;
			}

			int weightCount = 0;
			int exitCounts = 0;
			int indexCounter=0;
			
			elevatorStack.add(B[indexCounter]);
			weightCount=A[indexCounter];
			indexCounter=1;//start from first now because we add one
			
			
			while (!elevatorStack.isEmpty() && indexCounter<A.length){
			
				if (weightCount + A[indexCounter] > X)  {
					while (elevatorStack.poll() != null) {
						exitCounts++;
					}
					weightCount = 0;
					//exitCounts+=1;//return to ground flor
				}
				//System.out.println(indexCounter);
			
			    elevatorStack.add(B[indexCounter++]);
		    }
		    //clean last element
		    if (elevatorStack.poll()!=null) {
					exitCounts+=2;//add one stop and return to ground
			}
		    
		    System.out.println(exitCounts);
		
			return exitCounts;    
	        
	    } 

	private class PersonInElevator {

	}

}