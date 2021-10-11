package islandtrader;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * 
 * Event Screen for handling sailor and weather random events.
 * Based on what event is passed in through the parameter event will display
 * an image and provide the player feedback on what happened.
 *
 */


public class EventScreen {

	private JFrame window;
	private GameManager gameManager;
	private int event; // 1 for Weather , 2 for sailors
	private int outcome = 0; // 0 = Survived storm or sailor 1 = Ship sunk in storm

	/**
	 * 
	 *
	 * @param event Either 1 or 2 and will either provide the GUI for the weather event or the sailor event.
	 */
	public EventScreen(GameManager gameManager, int event) {
		this.gameManager = gameManager;
		this.event = event;
		initialize();
		window.setVisible(true);
	}
	
	public void closeWindow() {
		window.dispose();
	}
	
	public void finishedWindow(int selection) {
		gameManager.closeEventScreen(this, selection);
	}
	
	public void exit() {
		finishedWindow(outcome);
	}
	/**
	 * Initialize the contents of the frame.
	 */
	
	
	
	private void initialize() {
		window = new JFrame();
		window.setBounds(100, 100, 1000, 600);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setLayout(null);
		
		JLabel lblEventTitle = new JLabel("");
		lblEventTitle.setBounds(491, 12, 70, 15);
		window.getContentPane().add(lblEventTitle);
		
		JLabel lblEventImage = new JLabel("image of event");
		lblEventImage.setBounds(262, 83, 500, 300);
		window.getContentPane().add(lblEventImage);
		
		JTextPane textPaneEventInfo = new JTextPane();
		textPaneEventInfo.setBounds(262, 403, 506, 86);
		window.getContentPane().add(textPaneEventInfo);
		
		
		if(event == 1) {
			//Weather
			int weatherRoll = RandomEvent.getWeatherRoll();
			int damage = this.gameManager.playerShip.getDamage(weatherRoll);
			lblEventTitle.setText("Unfortunate Weater");
			textPaneEventInfo.setText("You have been caught in a terrible storm and your ship has taken " + String.valueOf(damage));
			this.gameManager.playerShip.changeHealth(-1*weatherRoll);
			lblEventImage.setIcon(new ImageIcon(EventScreen.class.getResource("/Images/Storm.png")));
			if(gameManager.playerShip.getHealth() < 0) {
				this.outcome = 1; // Ship sunk in storm when exit will take to end game screen
				gameManager.player.setOutcome(3); 
			}
		}
		if (event == 2) {
			//Sailor
			int sailorRoll = RandomEvent.getSailorRoll();
			this.gameManager.player.changeGold(sailorRoll);
			lblEventTitle.setText("Rescued Sailors");
			textPaneEventInfo.setText("You have come across some shipwrecked sailors, upon resucing them they give you "
					+ String.valueOf(sailorRoll) + " gold pieces");
			lblEventImage.setIcon(new ImageIcon(EventScreen.class.getResource("/Images/sailor.png")));
		}
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				exit();
			}
		});
		btnExit.setBounds(12, 539, 117, 25);
		window.getContentPane().add(btnExit);
	}

}
