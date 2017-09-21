package ba.enox.zal;

public class ThirdTask {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int A=123778910, B=45678910;
		
		String aS=String.valueOf(A);
		String bS=String.valueOf(B);
		String resultS="";
		int i=0;
		for(i=0; i<aS.length() && i<bS.length(); i ++){
			resultS+=aS.charAt(i);
			resultS+=bS.charAt(i);
			System.out.println(resultS);
			if(Integer.valueOf(resultS)>100000000){
				System.out.println("vece od 100xxx");
				//return -1;
			}
		}
		System.out.println(resultS);
		if(i<aS.length()-1){
			resultS+=aS.substring(i);
		}else if(i<bS.length()-1){
			resultS+=bS.substring(i);
		}
		System.out.println(resultS);
		

	}

}
