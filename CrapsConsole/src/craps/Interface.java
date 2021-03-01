package craps;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.sun.media.sound.Toolkit;

public class Interface extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	private JLabel dice1, dice2, background;
	private ImageIcon imgBackground;
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
		JLabel contentPane = new JLabel();
		contentPane.setIcon(new ImageIcon("src/images/GameBoard.png"));
		contentPane.setLayout( new BorderLayout() );
		this.setContentPane( contentPane );
		
		Container container = this.getContentPane();
		//Create an object that lisents
		lisent = new Lisent();
		gameControl = new Controler();
		//Add graphic components 
		image = new ImageIcon("src/images/dado.png");
		dice1 = new JLabel(image);
		dice2 = new JLabel(image);
		
		roll = new JButton("Roll Dice");
		roll.addActionListener(lisent);
		
		contentPane.add(dice2);
		container.add(roll);
		
		this.setTitle("Craps Game");
		this.setSize(600,500);
		//What does this do?
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//Add Craps custom background
		
		//imgBackground = new ImageIcon("src/images/GameBoard.png");
		//background = new JLabel(imgBackground, JLabel.CENTER);
		//background.setBounds(0,0,600,500);
		//add(background);
		
		
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
				rollDices();
				String rollResult = gameControl.getPoint();
				Icon icon;
				switch(gameControl.getGameState()) {
				case 0:
					icon = new ImageIcon("src/images/perdiste.png");
					JOptionPane.showMessageDialog(roll, rollResult, "RESULT", 
												  JOptionPane.DEFAULT_OPTION,icon);
					break;
				case 1:
					icon = new ImageIcon("src/images/ganaste.png");
					JOptionPane.showMessageDialog(roll, rollResult, "RESULT", 
												  JOptionPane.DEFAULT_OPTION,icon);
					break;
				case 2:
					String point = " You established a base " + rollResult + "\n"+
					"Get the same number to win, but if you get 7 first you lose!";
					icon = new ImageIcon("src/images/punto.png");
					JOptionPane.showMessageDialog(roll, rollResult + point, "RESULT", 
												  JOptionPane.DEFAULT_OPTION,icon);
					break;
				}
			}
		}
	}
	
	private void rollDices() {
		gameControl = new Controler();
		gameControl.rollDices();
		int firstDice = gameControl.diceOnePoint;
		int secondDice = gameControl.diceTwoPoint;
		int rollValue = firstDice+secondDice;
		image = new ImageIcon("src/images/"+firstDice+".png");
		dice1.setIcon(image);
		image = new ImageIcon("src/images/"+secondDice+".png");
		dice2.setIcon(image);
	}


}

//Me quedan 20 min para terminar el primer video
