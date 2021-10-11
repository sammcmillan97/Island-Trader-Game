package islandtrader;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 *
 * Class for the pirate encounter GUI.
 * Player clicks Roll and based on a number will get feedback on the encounter
 * 
 */

public class PirateScreen {

	private JFrame window;
	private GameManager gameManager;
	private int prirateRoll;
	private int playerRoll = -1;
	private int outcome;
	
	public PirateScreen(GameManager gameManager ) {
		this.gameManager = gameManager;
		this.prirateRoll = RandomEvent.getPirateRoll();
		this.outcome = 0;
		initialize();
		window.setVisible(true);
	}
	
	public void closeWindow() {
		window.dispose();
	}
	
	public void finishedWindow(int selection) {
		gameManager.closePirateScreen(this, selection);
	}
	
	public void exitToMain() {
		finishedWindow(0);
	}
	
	public void exitToEnd() {
		finishedWindow(1);
	}
	

	
	public void playerRoll(JTextPane txtpnFeedback, JLabel lblPlayerRollDisplay) {
		boolean haveEnoughMoney;
		if(playerRoll != -1) {
			txtpnFeedback.setText("You have already rolled");
		} else {
			this.playerRoll = RandomEvent.getPlayerRoll(this.gameManager.playerShip.getAttackPower());
			lblPlayerRollDisplay.setText(String.valueOf(playerRoll));
			if (this.playerRoll > this.prirateRoll) {
				//handle Win
				txtpnFeedback.setText("You roll a " + String.valueOf(this.playerRoll) + " and fend off the pirates");
				this.outcome = 1;
			} if (this.playerRoll == this.prirateRoll) {
				//handle draw
				this.outcome = 1;
				txtpnFeedback.setText("You roll a " + String.valueOf(this.playerRoll) + " and fend off the pirates but at a cost parts of your ship has been destroyed");
				this.gameManager.playerShip.changeHealth(-20);
				if(this.gameManager.playerShip.getHealth() < 0) {
					this.outcome = 2; //Ship sunk due pirate Encounter
					this.gameManager.player.setOutcome(2);
				}
			} if (this.playerRoll < this.prirateRoll) {
				//handle loss
				txtpnFeedback.setText("You roll a " + String.valueOf(this.playerRoll) + " and the pirates has overrun your ship they demand 200 gold!");
				//call to see if cargo has not enough gold worth  if not then player gold if not enough outcome = 2 and player.outcome = 2	

				haveEnoughMoney = gameManager.playerShip.pirateAttack(gameManager);
				if(!haveEnoughMoney) {
					this.outcome = 2;
					this.gameManager.player.setOutcome(1);
					txtpnFeedback.setText("You roll a " + String.valueOf(this.playerRoll) + " and the pirates has overrun your ship they demand 200 gold! "
							+ "You dont have enough gold or items on board to statisfy there greed you must now walk the plank!");
				} else {
					this.outcome = 1;
					txtpnFeedback.setText("You roll a " + String.valueOf(this.playerRoll) + " and the pirates has overrun your ship they demand 200 gold!"
							+ " Lucky you have enough on board to statisfy there greed and they take off with there bounty!");
				
				}
			}
		}

	}

	public void exit(JTextPane txtpnFeedback) {
		if(this.outcome == 0) {
			txtpnFeedback.setText("You cant leave now pirates are attacking your ship!");
		} if (this.outcome == 1) { // survive encounter
			exitToMain();
		} if(this.outcome == 2) {
			exitToEnd();
		}
	}

	private void initialize() {
		window = new JFrame();
		window.getContentPane().setBackground(Color.DARK_GRAY);
		window.setTitle("Pirates!");
		window.setBounds(100, 100, 1000, 600);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setLayout(null);
		
		JTextPane txtpnFeedback = new JTextPane();
		txtpnFeedback.setFont(new Font("FreeMono", Font.PLAIN, 16));
		txtpnFeedback.setBackground(Color.LIGHT_GRAY);
		txtpnFeedback.setText("As you sail towards your journey  a cannon ball flys past your head. Pirates are attacking your ship!" + "Pirate roll a "
								+ String.valueOf(this.prirateRoll));
		txtpnFeedback.setBounds(310, 12, 366, 88);
		window.getContentPane().add(txtpnFeedback);
		txtpnFeedback.setEditable(false);
		
		JLabel lblPlayerShipImage = new JLabel("PlayerShipImage");
		lblPlayerShipImage.setBounds(0, 112, 550, 322);
		window.getContentPane().add(lblPlayerShipImage);
		lblPlayerShipImage.setIcon(new ImageIcon(PirateScreen.class.getResource(this.gameManager.playerShip.getImage())));
		
		JLabel lblPirateShipImage = new JLabel("Pirate Ship Image");
		lblPirateShipImage.setBounds(544, 112, 550, 322);
		window.getContentPane().add(lblPirateShipImage);
		lblPirateShipImage.setIcon(new ImageIcon(PirateScreen.class.getResource("/Images/pirateShip.png")));
		
		JLabel lblPirateRollDisplay = new JLabel(String.valueOf(this.prirateRoll));
		lblPirateRollDisplay.setForeground(Color.WHITE);
		lblPirateRollDisplay.setBounds(693, 485, 70, 15);
		window.getContentPane().add(lblPirateRollDisplay);
		
		JLabel lblPlayerRollDisplay = new JLabel("");
		lblPlayerRollDisplay.setForeground(Color.WHITE);
		lblPlayerRollDisplay.setBounds(264, 485, 70, 15);
		window.getContentPane().add(lblPlayerRollDisplay);
		
		JButton btnRoll = new JButton("Roll");
		btnRoll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				playerRoll(txtpnFeedback, lblPlayerRollDisplay);
			}
		});
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				exit(txtpnFeedback);
			}
		});
		btnExit.setBounds(12, 539, 117, 25);
		window.getContentPane().add(btnExit);
		btnRoll.setBounds(458, 480, 117, 25);
		window.getContentPane().add(btnRoll);
	}
}
