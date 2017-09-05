package ba.enox.codebase.algorithms.thinkingtasks;

import org.junit.Test;

import junit.framework.TestCase;

public class MinimiseTicketCostsTest extends TestCase {

	private MinimiseTicketCosts mtc = new MinimiseTicketCosts();

	@Test
    public void testMinTicketPrice() throws Exception {
    	int[] array = new int[]{	/* 2x one day */1,2,   /*7days*/15,16,17,     /*7days*/ 28,29,30}; /*total 2+2+7+7 = 18*/
    	mtc.minimiseTicketCosts(array);
    }
}
