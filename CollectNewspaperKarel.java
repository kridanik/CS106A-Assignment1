/*
 * File: CollectNewspaperKarel.java
 * --------------------------------
 * At present, the CollectNewspaperKarel subclass does nothing.
 * Your job in the assignment is to add the necessary code to
 * instruct Karel to walk to the door of its house, pick up the
 * newspaper (represented by a beeper, of course), and then return
 * to its initial position in the upper left corner of the house.
 */

import stanford.karel.*;

public class CollectNewspaperKarel extends SuperKarel {
	
	/*
	 * Picks up newspaper and returns back to the starting position 
	 */
	public void run() {
		moveToNewspaper();
		pickNewspaper();
		returnToStart();
	}
	
	/* 
	 * Moves to newspaper
	 * 
	 * Pre-condition: Facing east at northwest corner of the house
	 * Post-condition: Facing east standing on newspaper
	 */
	private void moveToNewspaper() {
		move();
		move();
		turnRight();
		move();
		turnLeft();
		move();
	}
	
	/*
	 * Picks up newspaper
	 * 
	 * Pre-condition: Facing east at newspaper
	 * Post-condition: Facing east at the same spot (outside doorway)
	 */
	private void pickNewspaper() {
		pickBeeper();
	}
	
	/*
	 * Returns to initial position
	 * 
	 * Pre-condition: Facing east outside doorway
	 * Post-condition: Facing east at northwest corner of the house
	 */
	private void returnToStart() {
		turnAround();
		move();
		move();
		move();
		turnRight();
		move();
		turnRight();
	}

}
