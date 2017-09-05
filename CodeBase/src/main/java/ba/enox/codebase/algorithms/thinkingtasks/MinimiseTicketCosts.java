package ba.enox.codebase.algorithms.thinkingtasks;

/*
 * I recently came across an interview question, asking to minimize cost of ticket purchasing.
 *  The question goes like this:
 * You've to travel on specific days in a month (given as boolean array of 30 elements). 
 * On the transport system you can buy tickets of either: 
 * 	1-day ticket that costs 2,
 * 	7-day ticket that costs 7,
 * 	or a full-month ticket that costs 30.
 * Find minimal cost of travel for the month so that you travel with a valid ticket on the said days;
 * also what ticket would you purchase on what day. 
 * I'd like to ask for a systematic way of solving this,
 * and family of such problems. Dynamic Programming?
 */
public class MinimiseTicketCosts {

	public int minimiseTicketCosts(int [] arrayDays){
		return getOptimalPrice(arrayDays, arrayDays.length-1);
	}
	
	public int getOptimalPrice(int[] array, int currentTicketDay){
		int amount=0;
		
		
		for (int i=array.length-1; i>-1; i--){
			
			System.out.println("day "+array[i]);					
		}
		
		if (amount > 30){
			return 30;
		}
		return 0;
			
		
	}
}
