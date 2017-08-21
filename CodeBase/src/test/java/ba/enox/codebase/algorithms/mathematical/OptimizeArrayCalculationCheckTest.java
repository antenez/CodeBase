package ba.enox.codebase.algorithms.mathematical;

import static org.junit.Assert.*;

import org.junit.Test;
import org.omg.PortableInterceptor.SUCCESSFUL;

public class OptimizeArrayCalculationCheckTest {

	@Test
	public void test() {
		int[] initialArray = new int[7];
		initialArray[0] = 4;
		initialArray[1] = 6;
		initialArray[2] = 2;
		initialArray[3] = 2;
		initialArray[4] = 6;
		initialArray[5] =6;
		initialArray[6] =1;
		
		OptimizeArrayCalculationCheck oacc = new OptimizeArrayCalculationCheck();
		assertTrue(oacc.solution(initialArray) == 4);		
		
		assertTrue(oacc.slutionOptimized(initialArray) == 4);
	}

}
