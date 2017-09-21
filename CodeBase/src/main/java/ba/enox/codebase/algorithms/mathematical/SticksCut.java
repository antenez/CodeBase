package ba.enox.codebase.algorithms.mathematical;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SticksCut {

	/*
You are given  sticks, where the length of each stick is a positive integer. A cut operation is performed on the sticks such that all of them are reduced by the length of the smallest stick.

Suppose we have six sticks of the following lengths:

5 4 4 2 2 8
Then, in one cut operation we make a cut of length 2 from each of the six sticks. For the next cut operation four sticks are left (of non-zero length), whose lengths are the following: 

3 2 2 6
	 * 
	 */
	public static void main(String[] args) {
//	        Scanner in = new Scanner(System.in);
//	        int n = in.nextInt();
//	        int arr[] = new int[n];
//	        for(int arr_i=0; arr_i < n; arr_i++){
//	            arr[arr_i] = in.nextInt();
//	        }
//	       
	       
	        int n = 6;
	        int[]arr = new int[]{5, 4, 4 ,2, 2, 8};
	        
	        boolean hasCut=true;
	        int min=-1;
	       
	        int countCuts=0;
	        while(hasCut){
	        	hasCut = false;
	        	countCuts = 0;
	        	
	        	int currentInd=0;
	        	for(int i =1;i<n;i++){
	 	        	if(arr[i]<=arr[currentInd] && arr[i]!=0 || arr[currentInd]==0){
	 	        		currentInd = i;
	 	        		
	 	        	}
	 	        }
	        	min=arr[currentInd];
	        	//System.out.println("NextMin "+min);
	        	
	        	for(int i =0;i<n;i++ ){
	        		if(arr[i]>=min && arr[i]!=0 && min!=0){
	        			arr[i]=arr[i]-min;
	        			countCuts++;
	        			hasCut=true;
	        		}
	        	}
	        	
	        	if(countCuts!=0){
	        		System.out.println(countCuts);
	        	}
	        }	
	        
	}

}
