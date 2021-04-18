package ba.enox.codebase.collections.linkedlists;

public class BowlingGame {
	private static final int NUMBER_OF_FRAMES = 10;
	private Frame firstFrame;
	private Frame currentFrame;

	/**
	 * Constructor to start playing game
	 */
	public BowlingGame() {
		resetGame();
	}
	/**
	 * Reset bowling
	 */
	public void resetGame() {
		firstFrame = new Frame(2);
		Frame tmp = firstFrame;
		for (int i = 2; i <= NUMBER_OF_FRAMES; i++) {
			tmp = tmp.addNextFrame(new Frame(i != NUMBER_OF_FRAMES ? 2 : 3));// for last  one set 3i nodes
		}
		currentFrame = firstFrame;// initialize position for scores
	}

	/**
	 * Add result of shoot
	 */
	public void addShootScore(int numberOfPins) throws IllegalStateException {
		if (currentFrame.isFrameDone()) {
			if (currentFrame.nextFrame == null) {
				throw new IllegalStateException("+++BowlingGame is Over you sould reset game!");
			}
			System.out.println("+++Frame is done, take next one.");
			currentFrame = currentFrame.nextFrame;
		}
		currentFrame.addScore(numberOfPins);
		System.out.println(this);
	}

	/**
	 * Return score of game
	 * @return total score sum for all frames.
	 */
	public int getTotalScore() {
		Frame tmpNextFrame = firstFrame;
		int response = 0;
		while (tmpNextFrame != null) {
			if (tmpNextFrame.isLastFrame()) {
				response = tmpNextFrame.frameScore();
			}
			tmpNextFrame = tmpNextFrame.nextFrame;
		}
		return response;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String response = "";
		Frame tmpNext = firstFrame;
		int counter = 1;
		while (tmpNext != null) {
			response += "(" + (counter++) + ")" + tmpNext.frameScore() + "\t";
			tmpNext = tmpNext.nextFrame;
		}
		return response.substring(0, response.length() - 1);
	}

	/**
	 * @author eno.ahmedspahic
	 *
	 */
	private class Frame {
		private static final int MAX_FRAME_SCORE = 10;
		private int availableNumberOfPins = 10;
		private Frame previousFrame;
		private Frame nextFrame;

		int[] shoots;

		public Frame(int numberOfShoots) {
			initializeShoots(numberOfShoots);

		}

		private int[] initializeShoots(int numberOfShoots) {
			this.shoots = new int[numberOfShoots];
			for (int i = 0; i < numberOfShoots; i++)
				this.shoots[i] = -1;
			return this.shoots;
		}


		/**
		 * @param score to dd to current frame
		 * @return true false if score placed
		 * @throws IllegalAccessError when score is added to closed frame
		 */
		public boolean addScore(int score) throws IllegalAccessError {
			if (isFrameDone()) {
				throw new IllegalAccessError("Frame is closed and add score can not be done");
			}

			if (score > availableNumberOfPins) {
				throw new IllegalArgumentException(
						"Not enough available pins! Available:" + availableNumberOfPins + ", score: " + score);
			}
			for (int i = 0; i < shoots.length; i++) {
				if (shoots[i] == -1) {
					shoots[i] = score;
					availableNumberOfPins -= score;
					if (availableNumberOfPins == 0) {
						availableNumberOfPins = 10;
					}
					return true;
				}
			}
			return false;
		}

		/**
		 * Method calculate current score according to current values in corresponding frames
		 * @return score for current frame
		 */
		public int frameScore() {
			int score = 0;
			// in last frame strikes are scored as 10 already
			for (int i = 0; i < shoots.length; i++) {
				if (shoots[i] != -1) {
					score += shoots[i];
				} else {
					break;
				}
			}
			// Take previous score
			if (previousFrame != null) {
				score += previousFrame.frameScore();
			}

			int toCalculateShots = isStrike() ? 2 : (isSpare() ? 1 : 0);

			if (nextFrame != null && toCalculateShots != 0) {
				for (int i = 0; i < 2 && toCalculateShots != 0; i++) {
					if (nextFrame.shoots[i] != -1) {
						score += nextFrame.shoots[i];
						toCalculateShots--;
					}
				}

				for (int i = 0; i < 2 && toCalculateShots != 0 && nextFrame.nextFrame != null; i++) {
					if (nextFrame.nextFrame.shoots[i] != -1) {
						score += nextFrame.nextFrame.shoots[i];
						toCalculateShots--;
					}
				}
			}
			return score;
		}

		/**
		 * 
		 * @param nextFrame frame to add in list
		 * @return added frame
		 */
		public Frame addNextFrame(Frame nextFrame) {
			this.nextFrame = nextFrame;
			nextFrame.previousFrame = this;
			return nextFrame;
		}
		/**
		 * Check if frame is done
		 * @return
		 */
		public boolean isFrameDone() {
			if ((isStrike() || isSpare()) && !isLastFrame()) {
				return true;
			} else {
				for (int i = 0; i < shoots.length; i++) {
					if (shoots[i] == -1) {
						System.out.println("+++Frame is not done!");
						return false;
					}
				}
				return true;
			}
		}

		/**
		 * Check is frame strike
		 * @return
		 */
		boolean isStrike() {
			return shoots[0] == MAX_FRAME_SCORE ? true : false;
		}
		/**
		 * Check is frame spare
		 * @return
		 */
		boolean isSpare() {
			int shootsSum = 0;
			for (int i = 0; i < shoots.length; i++) {
				if (shoots[i] != -1) {
					shootsSum += shoots[i];
				}
			}
			return shootsSum == MAX_FRAME_SCORE ? true : false;
		}
		/**
		 * Check is frame last in list
		 * @return
		 */
		public boolean isLastFrame() {
			return shoots.length == 3 ? true : false;
		}

	}
}
