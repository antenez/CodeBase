package ba.enox.codebase.algorithms.string;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
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
		assertTrue("String is not palindrom ",
				so.canSourceBeConvertedToDestinationWithDeleteAndAppendNumberOfSteps("asd", "asd", 7));

	}

	@Test
	public void testBracketsValidator() {
		assertTrue("Brackets are not paired  ", so.BracketsValidator("{{[[[{}{}{((()()()))}]]]}}"));
		assertFalse("Brackets are paired  ", so.BracketsValidator("{{[[[{}{}{(((()()()))}]]]}}"));

	}

	@Test
	public void testIsRotationStringOfAnother() {
		// TODO
	}

	@Test
	public void testReturnShortestDistanceBetweenWordsInList() {
		//mixed case
		String[] book = new String[] { "sad", "eno", "asd","asd", "asd", "ahmed", "asd", "ahmed", "asd", "eno", "asd" };
		Assert.assertEquals(2,so.returnShortestDistanceBetweenWordsInList(book, "eno", "ahmed"));
		
		//begin and end case
		book = new String[] { "eno", "asd","asd", "ahmed" };
		Assert.assertEquals(3,so.returnShortestDistanceBetweenWordsInList(book, "eno", "ahmed"));
		
		//reversed word count
		book = new String[] { "eno", "ahmed","eno", "ahmed" };
		Assert.assertEquals(1,so.returnShortestDistanceBetweenWordsInList(book, "eno", "ahmed"));
		
		//not found case
		book = new String[] { "eno", "ahmed","eno", "ahmed" };
		Assert.assertEquals(-1,so.returnShortestDistanceBetweenWordsInList(book, "aa", "bb"));

	}
	
	@Test
	public void testFindLongestWordWhichContainsOtherTwo(){
		List<String> list = new ArrayList<>();
		list.add("haho");
		list.add("kjshdlkahfl");
		list.add("abalaba");
		list.add("kokolo");
		list.add("abal");
		list.add(	 "aba"); 
		list.add("ha");
		
		Assert.assertEquals("abalaba",so.findLongestWordWhichContainsOtherTwo(list));
	}
	

}
