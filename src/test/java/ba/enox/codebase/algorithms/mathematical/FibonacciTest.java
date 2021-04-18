package ba.enox.codebase.algorithms.mathematical;

import static org.junit.Assert.*;

import org.junit.Test;

public class FibonacciTest {
	
	Fibonacci fib= new Fibonacci();

	@Test
	public void test() {

		assertTrue("Fib of 20 must be 6765 ",fib.fibonnacy(20)==6765);
		assertTrue("Fib of 16 must be 987 ",fib.fibonnacy(16)==987);
		
		
		assertTrue("Fib of 20 must be 6765 ",fib.fibonnacy(20,new int[20+1])==6765);
		assertTrue("Fib of 16 must be 987 ",fib.fibonnacy(16, new int[16+1])==987);
		
	}

}
