package ba.enox.codebase.algorithms.string;

import org.junit.Test;

import junit.framework.TestCase;

public class PasswordValidationTest extends TestCase {


	@Test
    public void testSeriousness() throws Exception {
    	PasswordValidator passwordValidator = new PasswordValidator();
    	
    	//Invalid pass
    	assertFalse(passwordValidator.isPaswordValid("smallletters"));
    	assertFalse(passwordValidator.isPaswordValid("BIGLETTERS"));
    	assertFalse(passwordValidator.isPaswordValid("sh0RT"));
    	assertFalse(passwordValidator.isPaswordValid("1234"));
    	
    	//Valid test
    	assertTrue(passwordValidator.isPaswordValid("ValidPass01"));
    	
    	

    }
}