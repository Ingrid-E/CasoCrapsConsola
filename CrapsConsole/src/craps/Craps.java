/**
 * @file Craps.java
 * @author Ingrid Echeverri Montoya 1943542
 * @brief Main class that controls the console.
 * @version 0.1
 * @date 2020-02-20
 */

package craps;

public class Craps {
	/**
	 * @brief Main class, contains a controler object that starts the game in the console.
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Controler player = new Controler();
		player.startGame();
	}

}
