package ba.enox.codebase.algorithms.string;

import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;

public class StringOperations {

	public boolean isStringPalindrome(String s) {
		// end casses
		if (s.length() == 0 || s.length() == 1) {
			return true;
		}
		// compare ends
		if (s.charAt(0) == s.charAt(s.length() - 1)) {
			// check one char insede form ends
			return isStringPalindrome(s.substring(1, s.length() - 1));
		}
		return false;
	}

	// check can we transform source string to destinaton in limited number of
	// changes with only delete last and append last are permitted
	public boolean canSourceBeConvertedToDestinationWithDeleteAndAppendNumberOfSteps(String src, String dest, int k) {
		char[] s = src.toCharArray();
		char[] t = dest.toCharArray();
		// We have more operations than we need to delete and rewrite the string
		if (s.length + t.length < k) {
			return true;
		}
		// Iterate through string matching characters
		int i = -1;
		while (i++ < Math.min(s.length, t.length) - 1) {
			if (s[i] != t[i]) {
				break;
			}
		}
		// The strings are the same
		if (i == s.length && s.length == t.length) {
			// if k is odd, there will always be 1 operation left over
			// else, you can delete and re-append last character to use up k
			// operations
			return ((k & 1) == 1) ? false : true;
		}
		// Else
		// Reduce k by number of necessary deletions and insertions
		k = k - (s.length - i) - (t.length - i);

		// If k < 0 or there is an odd number of operations left over, false
		// else we need exactly k operations or the number of extra ops is even,
		// true
		return (k < 0 || (k & 1) == 1) ? false : true;

	}

	public boolean BracketsValidator(String str) {
		Stack<String> openingBrackets = new Stack<String>();
		for (char s : str.toCharArray()) {
			if (s == '{' || s == '[' || s == '(') {
				openingBrackets.push(String.valueOf(s));
			} else {
				String c = openingBrackets.pop();
				if ((c == "(" && s != ')') || (c == "{" && s != '}') || (c == "[" && s != ']')) {
					return false;
				}
			}
		}
		return openingBrackets.isEmpty();
	}
	
	//one more way to solve it with map and stack.
	public  boolean bracketsValidator2(String expression) {
	    Map<Character, Character> openClosePair = new HashMap<Character, Character>();
	    openClosePair.put(')', '(');
	    openClosePair.put('}', '{');
	    openClosePair.put(']', '[');        
	    Stack<Character> stack = new Stack<Character>();
	    for(char ch : expression.toCharArray()) {
	        if(openClosePair.containsKey(ch)) {
	            if(stack.pop() != openClosePair.get(ch)) {
	                return false;
	            }
	        } else if(openClosePair.values().contains(ch)) {
	            stack.push(ch); 
	        }
	    }
	    return stack.isEmpty();
	}
	
	
	
	/*
	 * Implement a function that checks if two strings are circularly identical e.g. "aabbb" "bbaab" 
	 */
	boolean isRotation(String s1,String s2) {
	    return (s1.length() == s2.length()) && ((s1+s1).indexOf(s2) != -1);
	}
	/*
	 * Recursive reverse of string
	 */
	public static String reverseStringRecursively(String s) {
		if (s.length() < 1) {
			return s;
		}
		return reverseStringRecursively(s.substring(1)) + s.charAt(0);
	}
	
	
	/*
	 * You have a large text file containing words.
	 * Given any two words, find the shortest distance (in terms of number of words) between them in the file.
	 * Can you make the searching operation in O(1) time? 
	 * What about the space complexity for your solution?
	 *
	 * We will assume for this question that the word order does not matter. This is a question you should ask your interviewer. If the word order does matter, we can make the small modification shown in the code below.
	 * To solve this problem, simply traverse the file and for every occurrence of word1 and word2, compare difference of positions and update the current minimum.
	 *
	 * To solve this problem in less time (but more space), we can create a hash table with each word and the locations where it occurs. We then just need to find the minimum (arithmetic) difference in the locations (e.g., abs(word0.loc[1] - word1.loc[5])).
	 * To find the minimum arithmetic difference, we take each location for word1 (e.g.: 0, 3} and do a modified binary search for it in word2’s location list, returning the closest number. Our search for 3, for example, in {2, 7, 9} would return 1. The minimum of all these binary searches is the shortest distance.
	 */
	
	public int returnShortestDistanceBetweenWordsInList(String[] words, String word1, String word2) {
		int minDistance= Integer.MAX_VALUE;
		int w1position = -1, w2position = -1;
		int positionCounter=0;
		
		for(String currentWord : words){
			if(currentWord==word1){
				w1position = positionCounter; 
				
				if(w2position!=-1 && minDistance>Math.abs(w1position-w2position)){
					minDistance =Math.abs(w1position-w2position); 
				}
			}
			if(currentWord==word2){
				w2position=positionCounter;
				if(w1position!=-1 && minDistance>Math.abs(w1position-w2position)){
					minDistance =Math.abs(w1position-w2position); 
				}
			}
			positionCounter++;
		}
		return minDistance==Integer.MAX_VALUE? -1: minDistance;
	}
	
	
//	Write a program to find the longest word made of other words.
	public String findLongestWordWhichContainsOtherTwo(List<String> listOfStrings){
		if(null==listOfStrings){
			return "List is null";
		}
		String returnString="";
		
		Comparator<String> comparator = new Comparator<String>() {
			
			@Override
			public int compare(String o1, String o2) {
				if(o1.length()>o2.length()){
					return -1;
				}else if(o1.length()<o2.length()){
					return 1;
				}
				
				return o1.compareTo(o2);
			}
		};
		Set<String> treeSetOfStrings = new TreeSet<>(comparator);
		treeSetOfStrings.addAll(listOfStrings);
		
		Iterator<String> iterator = treeSetOfStrings.iterator();
		while(iterator.hasNext() && returnString==""){
			String current = iterator.next();
			for(int i =1; i< current.length();i++){
				String part1, part2;
				part1= current.substring(0,i);
				part2= current.substring(i);
//				System.out.println("Check contains part1 "+ part1+" "+treeSetOfStrings.contains(part1));
//				System.out.println("Check contains part2 "+ part2+" "+treeSetOfStrings.contains(part2));
				if(treeSetOfStrings.contains(part1) && treeSetOfStrings.contains(part2)){
					returnString = current;
					break;
				}
			}			
		}
		
		return returnString;
	}
	
	
	

}
