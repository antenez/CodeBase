package ba.enox.codebase.algorithms.string;

public class IsStringWithAllUniqueChars {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String tstCase="Anes";
		System.out.println("Test Uniqueue letters "+isStringWthAllUniqueueChars(tstCase));

	}
	
	public static boolean isStringWthAllUniqueueChars(String s){
		boolean[] tmpHolder = new boolean[256];
		int strValue;
		for(int i=0;i<s.length();i++){
			
			strValue=s.charAt(i);
			System.out.println("Char at value "+s.charAt(i)+(s.charAt(i)+1-1));
			if(tmpHolder[s.charAt(i)]){
				return false;
			}
			tmpHolder[s.charAt(i)]=true;	
		}
		return true;
	}
	

}
