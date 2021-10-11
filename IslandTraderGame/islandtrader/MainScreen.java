package islandtrader;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * The main GUI of the game.
 * Player can choose to select:
 * 
 * 1: View ship which launches view ship screen
 * 2: View player inventory which  launches inventory screen.
 * 3: View Map which launches view map screen
 * 4: Visit store which launches the island store screen
 * 5: Retire which launches end game screen
 * 
 * The GUI also provides the player with there current gold and how many days they have left.
 * 
 */


public class MainScreen {

	private JFrame window;
	private GameManager gameManager;
	
	public MainScreen(GameManager gameManager) {
		this.gameManager = gameManager;
		initialize();
		window.setVisible(true);
	}
	
	public void closeWindow() {
		window.dispose();
	}
	
	public void finishedWindow(int selection) {
		gameManager.closeMainScreen(this, selection);
	}
	
	public void openMap() {
		finishedWindow(2);
	}
	
	public void openInventory() {
		finishedWindow(1);
	}
	
	public void openShip() {
		finishedWindow(0);
	}
	
	public void retire() {
		finishedWindow(4);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		window = new JFrame();
		window.getContentPane().setBackground(new Color(163, 184, 204));
		window.setTitle("Main ");
		window.setBounds(100, 100, 1000, 600);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setLayout(null);
		
		JPanel topPanel = new JPanel();
		topPanel.setBackground(Color.WHITE);
		topPanel.setBounds(0, 0, 1000, 30);
		window.getContentPane().add(topPanel);
		topPanel.setLayout(null);
		
		JLabel lblGold = new JLabel("Gold");
		lblGold.setBounds(12, 12, 70, 15);
		topPanel.add(lblGold);
		
		JLabel gold = new JLabel(String.valueOf(this.gameManager.player.getGold()));
		gold.setBounds(62, 12, 70, 15);
		topPanel.add(gold);
		
		JLabel lblDaysRemaing = new JLabel("Days remaing:");
		lblDaysRemaing.setBounds(123, 12, 128, 15);
		topPanel.add(lblDaysRemaing);
		
		JLabel daysDisplay = new JLabel(String.valueOf(this.gameManager.player.getDaysLeft()));
		daysDisplay.setBounds(233, 12, 70, 15);
		topPanel.add(daysDisplay);
		
		JLabel lblCurrent = new JLabel("Docked: ");
		lblCurrent.setBounds(293, 12, 70, 15);
		topPanel.add(lblCurrent);
		
		JLabel CurrentLocationDisplay = new JLabel(this.gameManager.currentLocation.getName());
		CurrentLocationDisplay.setBounds(375, 12, 157, 15);
		topPanel.add(CurrentLocationDisplay);
		
		JButton btnViewShip = new JButton("View Ship");
		btnViewShip.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				openShip();
			}
		});
		btnViewShip.setBounds(22, 83, 143, 25);
		window.getContentPane().add(btnViewShip);
		
		JButton btnViewInventory = new JButton("View Inventory");
		btnViewInventory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				openInventory();
			}
		});
		btnViewInventory.setBounds(22, 120, 143, 25);
		window.getContentPane().add(btnViewInventory);
		
		JButton btnViewMap = new JButton("View Map");
		btnViewMap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				openMap();

			}
		});
		btnViewMap.setBounds(22, 157, 143, 25);
		window.getContentPane().add(btnViewMap);
		
		JButton btnVisitStore = new JButton("Visit Store");
		btnVisitStore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finishedWindow(3);
			}
		});
		btnVisitStore.setBounds(22, 195, 143, 25);
		window.getContentPane().add(btnVisitStore);
		
		JLabel lblIslandImage = new JLabel("image of current island Not implemented");
		lblIslandImage.setBounds(183, 73, 805, 491);
		window.getContentPane().add(lblIslandImage);
		
		JButton btnRetire = new JButton("Retire!");
		btnRetire.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				retire();
			}
		});
		btnRetire.setBounds(12, 539, 117, 25);
		window.getContentPane().add(btnRetire);
	}
}
