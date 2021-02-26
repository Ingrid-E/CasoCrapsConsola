package craps;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Interface extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	private JLabel dice1, dice2;
	private JButton roll;
	private ImageIcon image;
	private Lisent lisent;
	private Controler gameControl;
	private Dice diceOne, diceTwo;

	/**
	 * @about Default constructor
	 */
	public Interface() {
		//Window that contains game
		Container container = this.getContentPane();
		container.setLayout(new FlowLayout());
		//Create an object that lisents
		lisent = new Lisent();
		//Add graphic components 
		image = new ImageIcon("src/images/dado.png");
		dice1 = new JLabel(image);
		dice2 = new JLabel(image);
		
		roll = new JButton("Roll Dice");
		roll.addActionListener(lisent);
		
		container.add(dice1);
		container.add(dice2);
		container.add(roll);
		
		this.setTitle("Craps Game");
		this.setSize(350,210);
		//What does this do?
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Working");
	}
	
	private class Lisent implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent event) {
			// TODO Auto-generated method stub
			if(event.getSource() == roll) {
				viewDice();
			}
		}
	}
	private void viewDice() {
		diceOne.rollDice();
		diceTwo.rollDice();
		int firstDice = diceOne.getSideValue();
		int secondDice = diceTwo.getSideValue();
		int rollValue = firstDice+secondDice;
		image = new ImageIcon("src/images/"+firstDice+".png");
		dice1.setIcon(image);
		image = new ImageIcon("src/images/"+secondDice+".png");
		dice2.setIcon(image);
	}


}

//Me quedan 20 min para terminar el primer video
