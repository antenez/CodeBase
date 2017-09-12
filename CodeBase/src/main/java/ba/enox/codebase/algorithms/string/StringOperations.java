package ba.enox.codebase.algorithms.string;

import java.util.Stack;

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
	
	
	
	
	// check can we transform source string to destinaton in limited number of changes with only delete last and append last are permitted
	
	    
	    public  boolean canSourceBeConvertedToDestinationWithDeleteAndAppendNumberOfSteps(String src,String dest, int k) {
	    	char[] s=src.toCharArray() ;
	    	char[] t=dest.toCharArray();
	    	// We have more operations than we need to delete and rewrite the string
	        if (s.length + t.length < k) {
	            return true;
	        }
	        // Iterate through string matching characters
	        int i = -1;
	        while(i++ < Math.min(s.length, t.length) - 1) {
	            if (s[i] != t[i]) {
	                break;
	            }
	        }
	        
	        // The strings are the same
	        if (i == s.length && s.length == t.length) {
	            // if k is odd, there will always be 1 operation left over
	            // else, you can delete and re-append last character to use up k operations
	            return ((k & 1) == 1) ? false : true;
	        }

	        // Else
	        // Reduce k by number of necessary deletions and insertions
	        k = k - (s.length - i) - (t.length - i);

	        // If k < 0 or there is an odd number of operations left over, false
	        // else we need exactly k operations or the number of extra ops is even, true
	        return (k < 0 || (k & 1) == 1) ? false : true;
	        
	    }
	    
	    
	    
	    public boolean BracketsValidator(String str){
	    	Stack<String> openingBrackets = new Stack<String>();
	    	for(char s:str.toCharArray()){
	    		if(s=='{' || s=='[' || s=='('){
	    			openingBrackets.push(String.valueOf(s));	    			
	    		}else{
	    			String c = openingBrackets.pop();
	    			if((c=="(" && s!=')') || (c=="{" && s!='}' ) || (c=="[" && s!=']' ) ){
	    				return false;
	    			}
	    		}
	    	}
	    	return   openingBrackets.isEmpty();
	    }
	   
	

}
