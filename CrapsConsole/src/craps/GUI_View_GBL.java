package craps;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import crapsComponents.Titles;

public class GUI_View_GBL extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel dicePanel, resultsPanel;
	private JLabel dice1, dice2,rollValue, pointValue;
	private JTextField rollText, pointText;
	private JButton rollButton, exitButton;
	private ImageIcon imageIcon;
	private JTextArea messages;
	private Controler controler;
	private Lisent lisent;
	private Titles title, results;
	private JFrame gameWindow;
	
	public GUI_View_GBL() {
		//Where the graphic content is located
		initGUI();
		//Default window configuration
		//this.setTitle("Craps");
		this.setUndecorated(true);
		this.setBackground(new Color(0,87,,250));
		//this.setSize(310, 180);
		this.pack();
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	private void initGUI() {
		//Set Layout
		this.getContentPane().setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		//Objects
		lisent = new Lisent();
		controler = new Controler();
		gameWindow = this;
		//GUIComponents
		
		//Main Title
		title =  new Titles("Game Craps", 30, new Color(192,187,41));
		title.addMouseListener(lisent);
		title.addMouseMotionListener(lisent);
		title.setCursor(new Cursor(Cursor.MOVE_CURSOR));
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 2;
		c.fill = GridBagConstraints.HORIZONTAL;
		add(title,c);
		//DicePanel
		dicePanel = new JPanel();
		imageIcon = new ImageIcon("src/images/dado.png");
		dice1 = new JLabel(imageIcon);
		dice2 = new JLabel(imageIcon);
		rollButton = new JButton("Roll");
		rollButton.addActionListener(lisent);
		dicePanel.add(dice1);
		dicePanel.add(dice2);
		dicePanel.add(rollButton);
		dicePanel.setPreferredSize(new Dimension(310,180));
		dicePanel.setBorder(new TitledBorder("Game Zone"));
		c.gridx = 0;
		c.gridy = 1;
		c.gridwidth = 1;
		c.gridheight = 3;
		c.fill = GridBagConstraints.NONE;	
		add(dicePanel,c);
		
		//exit
		exitButton = new JButton("exit");
		exitButton.addActionListener(lisent);
		exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		c.gridx = 0;
		c.gridy = 4;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.fill = GridBagConstraints.NONE;
		c.anchor = GridBagConstraints.LAST_LINE_END;
		add(exitButton,c);
		//result Title
		results = new Titles("Results", 24, new Color(177,41,192));
		c.gridx = 1;
		c.gridy = 1;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.anchor = GridBagConstraints.CENTER;
		add(results,c);
		//resultsPanel
		resultsPanel = new JPanel();
		resultsPanel.setLayout(new GridLayout(2,2));
		rollValue = new JLabel("Roll: ");
		pointValue =  new JLabel("Point: ");
		rollText = new JTextField(2);
		rollText.setEditable(false);
		pointText = new JTextField(2);
		pointText.setEditable(false);
		resultsPanel.add(rollValue);
		resultsPanel.add(rollText);
		resultsPanel.add(pointValue);
		resultsPanel.add(pointText);
		resultsPanel.setBackground(Color.WHITE);
		c.gridx = 1;
		c.gridy = 2;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.fill = GridBagConstraints.NONE;
		c.anchor = GridBagConstraints.CENTER;
		add(resultsPanel, c);
		//Messages 
 
		c.gridx = 1;
		c.gridy = 3;
		c.gridwidth = 1;
		c.gridheight = 2;
		c.fill = GridBagConstraints.VERTICAL;
		c.anchor = GridBagConstraints.CENTER;
		add(scroll, c);
	}
	//Java interface is a software that allows me to define a group of objects.
	//They can be implemented by classes a class can implement as much as it wants.
	
	private class Lisent implements ActionListener,MouseListener, MouseMotionListener{
		private int x,y;

		@Override
		public void actionPerformed(ActionEvent eventAction) {
			// TODO Auto-generated method stub
			if(eventAction.getSource() == exitButton) {
				System.exit(0);
			}else {
				controler.rollDices();
				//Show Dice Number
				imageIcon = new ImageIcon("src/images/"+controler.diceOnePoint+".png");
				dice1.setIcon(imageIcon);
				imageIcon = new ImageIcon("src/images/"+controler.diceTwoPoint+".png");
				dice2.setIcon(imageIcon);
				rollText.setText(String.valueOf(controler.pivot));
				//controler.getGameState();
				switch(controler.getGameState()) {
				case 0:
					messages.append("You Lost! \n");
					break;
				case 1:
					messages.append("You Won! \n");
					break;
				case 2:
					pointText.setText(String.valueOf(controler.pivot));
					String message = "You set a Base Point! \n "
							+ "You have to keep rolling the dices \n"
							+ "If you get the same number you win! ->" + String.valueOf(controler.pivot)
							+ "If You get 7 you loose \n";
					messages.append(message);
					break;
					
				}
			}
			
		}

		@Override
		public void mouseClicked(MouseEvent eventMouse) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent eventMouse) {
			// TODO Auto-generated method stub
			x = eventMouse.getX();
			y = eventMouse.getY();
		}

		@Override
		public void mouseReleased(MouseEvent eventMouse) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent eventMouse) {

			
		}

		@Override
		public void mouseExited(MouseEvent eventMouse) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseDragged(MouseEvent eventMouseMotion) {
			// TODO Auto-generated method stub
			setLocation(gameWindow.getLocation().x+eventMouseMotion.getX()-x, 
					    gameWindow.getLocation().y +eventMouseMotion.getY()-y);
		}

		@Override
		public void mouseMoved(MouseEvent eventMouseMotion) {
			// TODO Auto-generated method stub
			
		}
		
	}

}
