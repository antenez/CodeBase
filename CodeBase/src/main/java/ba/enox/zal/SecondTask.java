package ba.enox.zal;


	
	/*
Running solution...
Compilation successful.

Example test:    ([60, 80, 40], [2, 3, 5], 5, 2, 200) 
OK 

Example test:    ([40, 40, 100, 80, 20], [3, 3, 2, 2, 3], 3, 5, 200) 
OK 
	 */
public class SecondTask{
    public static void main(String[] args) {
        final SecondTask solution = new SecondTask();
        System.out.println(solution.solution(new int[]{60, 80, 40}, new int[]{2, 3, 5}, 5, 2, 200));
        System.out.println(solution.solution(new int[]{40, 40, 100, 80, 20}, new int[]{3, 3, 2, 2, 3}, 3, 5, 200));
    }

    public int solution(int A[], int B[], int M, int X, int Y) {

        int stops = 0;
        int nextPerson = 0;
        while (nextPerson < A.length) {
            final FloorWeightCount floorWeightCount = lift(A, B, nextPerson, M, X, Y);
            nextPerson = floorWeightCount.getNextPerson();
            stops += floorWeightCount.getNumberOfStops() + 1;
        }

        return stops;
    }

    private FloorWeightCount lift(int A[], int B[], int currentPerson, int M, int X, int Y) {

        boolean visitedFloors[] = new boolean[M];
        int nextPerson = currentPerson;
        int numberOfFloorsVisited = 0;

        int leftWeight = Y;
        int leftCount = X;
        for (int i = currentPerson; i < A.length; i++) {
            final int currentWeight = A[i];
            final int currentFloor = B[i];
            //If there is space in elevator and weight is smaller , decrease left weight and left count, also mark visited floors in current session
            //othervise take last values and return in object
            if (currentWeight <= leftWeight && leftCount > 0) {
                leftWeight -= currentWeight;
                leftCount--;
                if (!visitedFloors[currentFloor - 1]) {
                    numberOfFloorsVisited++;
                }

                visitedFloors[currentFloor - 1] = true;
                nextPerson++;
            } else {
                break;
            }
        }

        return new FloorWeightCount(nextPerson, numberOfFloorsVisited);
    }

    /*
     * HElper class used to hold data about next person and number of steps till next person.
     */
    private static class FloorWeightCount {

        private final int nextPerson;
        private final int numberOfStops;

        private FloorWeightCount(int nextPerson, int numberOfStops) {
            this.nextPerson = nextPerson;
            this.numberOfStops = numberOfStops;
        }

        public int getNextPerson() {
            return nextPerson;
        }

        public int getNumberOfStops() {
            return numberOfStops;
        }
    }
    
    
    
}