package ba.enox.codebase.algorithms.mathematical;

import java.util.HashMap;
import java.util.Map;

import javax.print.attribute.HashAttributeSet;

public class OptimizeArrayCalculationCheck {
	
	public int solution(int[]A){
		int N =A.length;
		int result=1;
		for(int i = 0; i<N ; i++){
			for(int j = 0; j<N ; j++){
				if(A[i]==A[j]){
					result =Math.max(result, Math.abs(i-j));
				}
			}
		}
		return result;
	}
	
	public int slutionOptimized(int[] A){
		int N =A.length;
		int result=1;
		Map<Integer,Integer> mapOfKeys = new HashMap<Integer, Integer>();
		
		for(int i = 0; i<N ; i++){
			
			if(!mapOfKeys.containsKey(A[i])){
				mapOfKeys.put(A[i], i);
			}else{
				result = Math.max(result, Math.abs(mapOfKeys.get(A[i]) -i));
			}
		}
		return result;
	}

}
