/**
 * @file Controler.java
 * @author Ingrid Echeverri Montoya 1943542
 * @brief Class that controls the basics of the game.
 * @version 0.1
 * @date 2020-02-20
 */

package craps;
import java.util.Scanner;
import java.lang.String;

public class Controler {
	private int point, gameState, pivot;
	private Dice dice1, dice2;
	
	/** @brief Constructor of Class*/
	public Controler() {
		this.setGameState(0);
		this.setPoint(1);
		this.dice1 = new Dice();
		this.dice2 = new Dice();
	};
	/**
	 * @brief Method that starts the game, checks game state to see if the player 
	 * has already won or lost, and interacts with the player to roll the dices.
	 */
	public void startGame(){
		//Scanner class to read console input
		Scanner console =  new Scanner(System.in);
		
		//Check if they are still rolling dices
		if(this.gameState != 2) {
			System.out.println("Welcome to Craps!");
		}
		
		//Start game from 0
		System.out.println("Roll Dices? y/n");
		//Get Console response to roll dices.
		String question = console.nextLine();
		if(question.equals("y")) {
			//Roll Dices
			this.rollDices();
		}
		else if(question.equals("n")) {
			System.out.println("See you later!");
			System.exit(0);
		}
		else {
			System.out.println("Error wrong letter");
			System.exit(0);
		}

		//Print out points.
		System.out.println("Dado 1 = " + dice1.getSideValue() + ", Dado 2 = " + dice2.getSideValue() + ", Base Point = " + this.point);
		System.out.println(this.getPoint());

		/* Get game status
		 * 0 =  Lost Game
		 * 1 = Won Game
		 * 2 = Still in game, keep rolling.
		 */
		if(this.getGameState() == 0) {
			System.out.println("You Lost! Try Again?");
			this.restart();
			
		}
		else if(this.getGameState() == 1) {
			System.out.println("You Won! Play again?");
			this.restart();
		}
		else {
			this.startGame();
		}
		
		
		
	};
	/**
	 * @brief Method that rolls both dices.
	 */
	public void rollDices(){
		dice1.rollDice();
		dice2.rollDice();
		//Add dice values
		this.pivot = dice1.getSideValue() + dice2.getSideValue();
		//Change base point value if it is not rolling again in state 2
		if(this.getGameState() != 2) {
			this.setPoint(pivot);
		}
	}
	
	/**
	 * @brief Checks point value and changed game state.
	 * @return string Game point and point name.
	 */
	public String getPoint() {
		//Game State 2 rolling again dices
		if(this.getGameState() == 2) {
			//If new number matches base number player wins
			if(this.pivot == this.point) {
				this.setGameState(1);
				return "New Point: " + this.pivot;
			}
			//If new number is 7, game lost.
			else if(this.pivot == 7) {
				this.setGameState(0);
				return "New Point: 7";
			}
			//Random number, keep rolling to win.
			else {
				this.setGameState(2);
				return "New Point: " + this.pivot;
			}
		}
		//If number is 2,3,or 12 player looses
		if(this.point == 2 || this.point == 3 || this.point == 12) {
			this.setGameState(0);
			return "CRAPS: " + this.point;
		}
		//If number is 7,11 player wins
		else if(this.point == 7 || this.point == 11 ) {
			this.setGameState(1);
			return "Natural " + this.point;
		}
		//If number is 4,5,6,8,9 or 10 keep rolling to win. 
		else {
			this.setGameState(2);
			return "Point " + this.point;
		}
	}
	
	/**
	 * @brief restarts the game if the player hasn't won or lost yet.
	 */
	public void restart() {
		//Make player choose to keep playing or not
		System.out.println("Yes: 1    No: 0");
		System.out.print("-> ");
		//Console input option
		Scanner anotherTry = new Scanner(System.in);
		int tryAgain = anotherTry.nextInt();
		//If player inputs 1 then the games restarts
		if(tryAgain == 1) {
			this.startGame();
		}
		//If player inputs 0 then game ends
		else {
			System.out.println("See you later!");
			System.exit(0);
		}
	}

	/**
	 * Set point value
	 * @param point
	 */
	public void setPoint(int point) {
		this.point = point;
	}
	/**
	 * @brief returns game state value
	 * @return int
	 */
	public int getGameState() {
		return gameState;
	}
	 
	/**
	 * @brief Set game state.
	 * @param gameState
	 */
	public void setGameState(int gameState) {
		this.gameState = gameState;
	};

}
