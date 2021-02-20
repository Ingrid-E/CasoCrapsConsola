package craps;
import java.util.Random;

public class Dice {
	private int sideValue;
	
	public Dice() {
		this.setSideValue(1);
	}
	
	public int getSideValue() {
		return sideValue;
	}
	public void setSideValue(int sideValue) {
		this.sideValue = sideValue;
	};
	
	public void rollDice() {
		Random diceRollValue = new Random();
		int newSideValue = diceRollValue.nextInt(6)+1;
		this.setSideValue(newSideValue);
	}
	
	
	
}
