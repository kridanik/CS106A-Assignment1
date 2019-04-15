
/*
 * File: MidpointFindingKarel.java
 * -------------------------------
 * When you finish writing it, the MidpointFindingKarel class should
 * leave a beeper on the corner closest to the center of 1st Street
 * (or either of the two central corners if 1st Street has an even
 * number of corners).  Karel can put down additional beepers as it
 * looks for the midpoint, but must pick them up again before it
 * stops.  The world may be of any size, but you are allowed to
 * assume that it is at least as tall as it is wide.
 */

import stanford.karel.*;

public class MidpointFindingKarel extends SuperKarel {

	public void run() {
		findMidpoint();
	}

	private void findMidpoint() {
		fillRow();
		removeEnds();
		putBeeper();
	}

	private void fillRow() {
		move();
		while (frontIsClear()) {
			putBeeper();
			move();
		}
		turnAround();
		move();
	}

	private void removeEnds() {
		while (beepersPresent()) {
			checkIfLast();
		}
	}

	private void checkIfLast() {
		move();
		if (noBeepersPresent()) {
			turnAround();
			move();
			move();
			if (noBeepersPresent()) {
				lastBeeper();
			} else {
				pickEnd();
			}
		}
	}

	private void pickEnd() {
		turnAround();
		move();
		pickBeeper();
		turnAround();
		move();
	}

	private void lastBeeper() {
		turnAround();
		move();
		pickBeeper();
	}
}
