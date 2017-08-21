package ba.enox.codebase.algorithms.string;

public class PasswordValidator {
	
	/**
	 * @return true if password contain small and capital letter and number also and length >7
	 * Unicod ascII is standar java unicode presentation. Where each character has corresponding int value.
	 * 
	 */
	public boolean isPaswordValid(String password){
		if(password.length()<7){
			return false;			
		}
		
		boolean containCapital=false;
		boolean containSmall=false;
		boolean containNumeric=false;
		
		for (char c: password.toCharArray()){
			printOutCharValues(c);
			if(!containCapital){
				containCapital =  ((int)c >=(int)'A' && (int)c <=(int)'Z')?true:false;
			}
			if(!containSmall){
				containSmall =  ((int)c >=(int)'a' && (int)c <=(int)'z')?true:false;
			}
			if(!containNumeric){
				containNumeric =  ((int)c >=(int)'0' && (int)c <=(int)'9')?true:false;
			}
		}
		//alternative Character.isxxx
		return containCapital && containSmall && containNumeric;
			
	}
	
	public void printOutCharValues(char c){
		System.out.printf("Char is : %c number presentation is : %d%n", c , (int)c);
	}

}
