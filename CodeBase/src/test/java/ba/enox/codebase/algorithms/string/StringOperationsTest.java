package ba.enox.codebase.algorithms.string;

import static org.junit.Assert.*;

import org.junit.Test;

import junit.framework.TestCase;

public class StringOperationsTest extends TestCase {
	private StringOperations so = new StringOperations();

	@Test
	public void test() {
		assertTrue("String is not palindrom ", so.isStringPalindrome("anavolimilovana"));
		assertFalse("String should not be palindrom ", so.isStringPalindrome("ana1volimilovana"));
		assertFalse("String should not be palindrom ", so.isStringPalindrome("anavolimilov1ana"));
		
		
		
		
		
	}
	@Test
	public void testChangesInString() {
		assertTrue("String is not palindrom ", so.canSourceBeConvertedToDestinationWithDeleteAndAppendNumberOfSteps("asd","asd",7));

	}
	
	@Test
	public void testBracketsValidator() {
		assertTrue("Brackets are not paired  ", so.BracketsValidator("{{[[[{}{}{((()()()))}]]]}}"));
		assertFalse("Brackets are paired  ", so.BracketsValidator("{{[[[{}{}{(((()()()))}]]]}}"));

	}



}
