package ba.enox.codebase.algorithms.mathematical;

import static org.junit.Assert.*;

import java.math.BigInteger;

import org.junit.Test;

import junit.framework.TestCase;

public class MathematicalServiceTest extends TestCase{
	
	MathematicalService ms = new MathematicalService();

	@Test
	public void test() {
		assertEquals("Factoriel not correct",ms.factorielWithLargeResult(25)+"","15511210043330985984000000");
	}
	
	
	@Test
	public void getConsecutiveSumCombinationForNumber() {
		assertEquals("Factoriel not correct",ms.getConsecutiveSumCombinationForNumber(15),3);
		assertEquals("Factoriel not correct",ms.getConsecutiveSumCombinationForNumber(6),1);
	}
	
	

}
