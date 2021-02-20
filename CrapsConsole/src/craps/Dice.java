/**
 * @file Dice.java
 * @author Ingrid Echeverri Montoya 1943542
 * @brief Class that controls the basics of the game.
 * @version 0.1
 * @date 2020-02-20
 */

package craps;
import java.util.Random;

public class Dice {
	private int sideValue;
	/** @brief Class constructor */
	public Dice() {
		this.setSideValue(1);
	}
	/**
	 * @brief Gets dice value number
	 * @return int
	 */
	public int getSideValue() {
		return sideValue;
	}
	/**
	 * @brief Sets the dice value number
	 * @param sideValue
	 */
	public void setSideValue(int sideValue) {
		this.sideValue = sideValue;
	};
	/**
	 * @brief Rolls the dice and picks a random value to asign to sideValue.
	 * @see setSideValue(int);
	 */
	public void rollDice() {
		Random diceRollValue = new Random();
		int newSideValue = diceRollValue.nextInt(6)+1;
		this.setSideValue(newSideValue);
	}
	
	
	
}
