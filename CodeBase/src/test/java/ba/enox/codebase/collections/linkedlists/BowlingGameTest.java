package ba.enox.codebase.collections.linkedlists;

import static org.junit.Assert.fail;

import org.junit.Assert;
import org.junit.Test;

public class BowlingGameTest {

	private BowlingGame bowlingGame = new BowlingGame();

	/*
	 * Test from requirements
	 */
	@Test
	public void combinedScores() {
		System.out.println("=======================");
		System.out.println("++++combinedScores test");
		int[] scores = new int[] { 1, 4, 4, 5, 6, 4, 5, 5, 10, 0, 1, 7, 3, 6, 4, 10, 2, 8, 6 };
		for (int i : scores) {
			bowlingGame.addShootScore(i);
		}
		int total = bowlingGame.getTotalScore();
		Assert.assertTrue("Full strike count is not 133", 133 == total);
		System.out.println("");
	}

	/*
	 * Test from pdf specification Test Full strikes calculation
	 */
	@Test
	public void testFullStrikes() {
		System.out.println("=======================");
		System.out.println("++++testFullStrikes test");
		int[] scores = new int[] { 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10 };
		for (int i : scores) {
			bowlingGame.addShootScore(i);
		}
		int total = bowlingGame.getTotalScore();
		Assert.assertTrue("Full strike count is not 300", 300 == total);
	}

	/*
	 * Test all spares calculation
	 */
	@Test
	public void testFullSpares() {
		System.out.println("=======================");
		System.out.println("++++testFullSpares test");
		int[] scores = new int[] { 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5 };
		for (int i : scores) {
			bowlingGame.addShootScore(i);
		}
		int total = bowlingGame.getTotalScore();
		Assert.assertTrue("Full spare count is not 150", 150 == total);
	}

	/*
	 * Test Throw exception for unexpected throw
	 */
	@Test
	public void testExtraThrowExceptionHandling() {
		System.out.println("=======================");
		System.out.println("++++testExtraThrowExceptionHandling test");
		// last 1 is extra
		int[] scores = new int[] { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 };

		try {
			for (int i : scores) {
				bowlingGame.addShootScore(i);
			}
			fail("IllegalArgumentException is required!");
		} catch (IllegalStateException expectedException) {
			Assert.assertEquals("+++BowlingGame is Over you sould reset game!", expectedException.getMessage());
		} catch (Exception e) {
			fail("Unexpected exception occured!");
		}
	}

	/*
	 * Test Throw more then available pins
	 */
	@Test
	public void testThrowMoreThenAvailablePinsScoreInput() {
		System.out.println("=======================");
		System.out.println("++++testThrowMoreThenAvailablePinsScoreInput test");
		int[] scores = new int[] { 0, 0, 8, 6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		try {
			for (int i : scores) {
				bowlingGame.addShootScore(i);
			}
			fail("IllegalArgumentException is required!");
		} catch (IllegalArgumentException expectedException) {
			Assert.assertEquals("Not enough available pins! Available:2, score: 6", expectedException.getMessage());
		} catch (Exception e) {
			fail("Unexpected exception occured!");
		}
	}

	/*
	 * Test last frame specific calculation
	 */
	@Test
	public void testLastFrameCalculation() {
		System.out.println("=======================");
		System.out.println("++++testLastFrameCalculation test");
		int[] scores = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 10, 10, 4 };
		for (int i : scores) {
			bowlingGame.addShootScore(i);
		}
		int total = bowlingGame.getTotalScore();
		Assert.assertTrue("Full spare count is not 24", 24 == total);
	}

	/*
	 * Test spare strike spare combination calculation
	 */
	@Test
	public void testSpareStrikeSpare() {
		System.out.println("=======================");
		System.out.println("++++testSpareStrikeSpare test");
		int[] scores = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 5, 10, 5, 5, 10, 10, 10 };
		for (int i : scores) {
			bowlingGame.addShootScore(i);
		}
		int total = bowlingGame.getTotalScore();
		Assert.assertTrue("Full spare count is not 90", 90 == total);
	}

	/*
	 * Test strike spare strike combination calculation
	 */
	@Test
	public void testStrikeSpareStrike() {
		System.out.println("=======================");
		System.out.println("++++testStrikeSpareStrike test");
		int[] scores = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 10, 5, 5, 10, 10, 10, 10 };
		for (int i : scores) {
			bowlingGame.addShootScore(i);
		}
		int total = bowlingGame.getTotalScore();
		Assert.assertTrue("Full spare count is not 103", 103 == total);
	}

}
