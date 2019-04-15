
/*
 * File: CheckerboardKarel.java
 * ----------------------------
 * When you finish writing it, the CheckerboardKarel class should draw
 * a checkerboard using beepers, as described in Assignment 1.  You
 * should make sure that your program works for all of the sample
 * worlds supplied in the starter folder.
 */

import stanford.karel.*;

public class CheckerboardKarel extends SuperKarel {

	public void run() {
		drawCheckerboard();
	}

	private void drawCheckerboard() {
		putBeeper();
		drawOneRow();
		while ((facingEast() && (frontIsClear() || leftIsClear()))
				|| (facingWest() && (frontIsClear() || rightIsClear()))) {
			if (beepersPresent()) {
				if (facingEast()) {
					turnLeft();
					move();
					turnLeft();
					drawOneRow();
				} else {
					turnRight();
					move();
					turnRight();
					drawOneRow();
				}
			} else {
				if (facingEast()) {
					turnLeft();
					move();
					turnLeft();
					putBeeper();
					drawOneRow();
				} else {
					turnRight();
					move();
					turnRight();
					putBeeper();
					drawOneRow();
				}
			}
		}
	}

	private void drawOneRow() {
		if (beepersPresent()) {
			drawBlackRow();
		} else {
			drawWhiteRow();
		}
	}

	private void drawBlackRow() {
		while (frontIsClear()) {
			move();
			if (frontIsClear()) {
				move();
				putBeeper();
			}
		}
	}

	private void drawWhiteRow() {
		while (frontIsClear()) {
			move();
			putBeeper();
			move();
		}
	}
}
