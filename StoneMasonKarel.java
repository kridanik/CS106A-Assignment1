/*
 * File: StoneMasonKarel.java
 * --------------------------
 * Karel repairs each column that has stones missing. It starts at 1,1 facing
 * east. Columns are always four units apart, with first column being at 1,1.
 * The last column is followed by a wall.
 */

import stanford.karel.*;

public class StoneMasonKarel extends SuperKarel {

	/* Fixes one column at a time, until it hits the wall. */
	public void run() {
		while (frontIsClear()) {
			fixColumn();
			findColumn();
		}
		fixColumn();
	}
	
	/*
	 * Fixes one column.
	 * 
	 * Pre-condition: Facing east at the bottom of a column.
	 * Post-condition: Facing east at the bottom of the same column.
	 */
	private void fixColumn() {
		turnLeft();
		repairDamage();
		descendColumn();
	}
	
	/*
	 * Ascends and repairs each damaged spot of a column.
	 * 
	 * Pre-condition: Facing north at the bottom of a column.
	 * Post-condition: Facing north at the top of the same column.
	 */
	private void repairDamage() {
		while (frontIsClear()) {
			if (noBeepersPresent()) {
				putBeeper();
			}
			move();
		}
		if (noBeepersPresent()) {
			putBeeper();
		}
	}
	
	/*
	 * Descends a column.
	 * 
	 * Pre-condition: Facing north at the top of a column.
	 * Post-condition: Facing east at the bottom of the same column.
	 */
	private void descendColumn() {
		turnAround();
		while (frontIsClear()) {
			move();
		}
		turnLeft();
	}
	
	/*
	 * Moves to the next column.
	 * 
	 * Pre-condition: Facing east at the bottom of a column.
	 * Post-condition: Facing east at the bottom of the next column.
	 */
	private void findColumn() {
		for (int i = 0; i < 4; i++) {
			move();
		}
	}
}
