package islandtrader;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

/** 
 * Main menu Screen is the GUI screen for when the player first opens the game
 * Only choice is play which opens game setup screen 
 * Save - not implemented
 * Instructions - not implemented
 *
 */


public class MainMenuScreen {

	private JFrame window;
	private GameManager gameManager;
	
	public MainMenuScreen(GameManager gameManager ) {
		this.gameManager = gameManager;
		initialize();
		window.setVisible(true);
	}
	
	public void closeWindow() {
		window.dispose();
	}
	
	public void finishedWindow() {
		gameManager.closeMainMenuScreen(this);
	}
	


	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		window = new JFrame();
		window.setTitle("Main Menu");
		window.setBounds(100, 100, 700, 500);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setLayout(null);
		
		JLabel lblIslandTraderAdventure = new JLabel("Terrible Island Trader Adventure");
		lblIslandTraderAdventure.setFont(new Font("Nimbus Sans Narrow", Font.BOLD, 16));
		lblIslandTraderAdventure.setHorizontalAlignment(SwingConstants.CENTER);
		lblIslandTraderAdventure.setBounds(183, 12, 349, 43);
		window.getContentPane().add(lblIslandTraderAdventure);
		
		JButton btnPlay = new JButton("Play");
		btnPlay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				finishedWindow();
			}
		});
		btnPlay.setBounds(289, 104, 129, 25);
		window.getContentPane().add(btnPlay);
		
		JButton btnLoadGame = new JButton("Load Game");
		btnLoadGame.setBounds(289, 144, 129, 25);
		window.getContentPane().add(btnLoadGame);
		
		JButton btnInstructions = new JButton("Instructions");
		btnInstructions.setBounds(289, 183, 129, 25);
		window.getContentPane().add(btnInstructions);
		
		JLabel lblNewLabel = new JLabel("Rory Holmes Sam McMillan");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 8));
		lblNewLabel.setBounds(544, 439, 144, 25);
		window.getContentPane().add(lblNewLabel);
	}
}
