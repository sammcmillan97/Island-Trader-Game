package islandtrader;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import javax.swing.JTextPane;

public class ShipScreen {

	private JFrame window;
	private GameManager gameManager;
	
	public ShipScreen(GameManager gameManager) {
		this.gameManager = gameManager;
		initialize();
		window.setVisible(true);
	}
	
	public void closeWindow() {
		window.dispose();
	}
	
	public void finishedWindow() {
		gameManager.closeShipScreen(this);
	}
	
	public void repair(JTextPane feedback) {
		if(this.gameManager.playerShip.getRepairCost() != 0) {
			if(this.gameManager.player.getGold() >= this.gameManager.playerShip.getRepairCost()) {
				this.gameManager.playerShip.setHealth(100);
				feedback.setText("Your ship has been fully repaired");
			} else {
				feedback.setText("You can't afford these repairs go sell some of your items or retire");
			}
		} else {
			feedback.setText("Your ship is already full health");
		}
		
	}
	
	public void upgrade(JTextPane feedback) {
		feedback.setText("You can't get any upgrades around these parts");
	}
	
	private void initialize() {
		window = new JFrame();
		window.getContentPane().setBackground(UIManager.getColor("CheckBoxMenuItem.acceleratorForeground"));
		window.setBackground(Color.DARK_GRAY);
		window.setTitle("Ship");
		window.setBounds(100, 100, 1000, 600);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1000, 30);
		panel.setBackground(Color.WHITE);
		window.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblGold = new JLabel("Gold");
		lblGold.setBounds(12, 12, 70, 15);
		panel.add(lblGold);
		
		JLabel lblGoldDisplay = new JLabel(String.valueOf(this.gameManager.player.getGold()));
		lblGoldDisplay.setBounds(62, 12, 70, 15);
		panel.add(lblGoldDisplay);
		
		JLabel lblDaysRemaing = new JLabel("Days remaing:");
		lblDaysRemaing.setBounds(123, 12, 128, 15);
		panel.add(lblDaysRemaing);
		
		JLabel lblDaysDisplay = new JLabel(String.valueOf(this.gameManager.player.getDuration()));
		lblDaysDisplay.setBounds(233, 12, 70, 15);
		panel.add(lblDaysDisplay);
		
		JLabel lblCurrentLocation = new JLabel("Docked: ");
		lblCurrentLocation.setBounds(293, 12, 70, 15);
		panel.add(lblCurrentLocation);
		
		JLabel lblCurrentLocationDisplay = new JLabel(this.gameManager.currentLocation.getName());
		lblCurrentLocationDisplay.setBounds(375, 12, 92, 15);
		panel.add(lblCurrentLocationDisplay);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(63, 100, 276, 320);
		window.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblShipName = new JLabel("Ship Name:");
		lblShipName.setBounds(12, 12, 87, 15);
		panel_1.add(lblShipName);
		
		JLabel shipName = new JLabel(this.gameManager.playerShip.getName());
		shipName.setBounds(157, 12, 88, 15);
		panel_1.add(shipName);
		
		JLabel lblTotalCrew = new JLabel("Total Crew:");
		lblTotalCrew.setBounds(12, 39, 101, 15);
		panel_1.add(lblTotalCrew);
		
		JLabel lblNewLabel = new JLabel("Remaing space:");
		lblNewLabel.setBounds(12, 66, 112, 15);
		panel_1.add(lblNewLabel);
		
		JLabel lblUpgrades = new JLabel("Upgrades:");
		lblUpgrades.setBounds(12, 93, 87, 15);
		panel_1.add(lblUpgrades);
		
		JLabel lblShipDamage = new JLabel("health:");
		lblShipDamage.setBounds(11, 120, 102, 15);
		panel_1.add(lblShipDamage);
		
		JLabel lblNewLabel_1 = new JLabel("Cost to repair:");
		lblNewLabel_1.setBounds(12, 147, 112, 15);
		panel_1.add(lblNewLabel_1);
		
		JLabel totalCrew = new JLabel(String.valueOf(this.gameManager.playerShip.getSize()));
		totalCrew.setBounds(157, 39, 70, 15);
		panel_1.add(totalCrew);
		
		JLabel remainingSpace = new JLabel(String.valueOf(this.gameManager.playerShip.remainingSpace()));
		remainingSpace.setBounds(157, 66, 70, 15);
		panel_1.add(remainingSpace);
		
		JLabel upgrades = new JLabel("NA");
		upgrades.setBounds(157, 93, 70, 15);
		panel_1.add(upgrades);
		
		JLabel health = new JLabel(String.valueOf(this.gameManager.playerShip.getHealth()));
		health.setBounds(157, 120, 70, 15);
		panel_1.add(health);
		
		JLabel costToRepair = new JLabel(String.valueOf(gameManager.playerShip.getRepairCost()));
		costToRepair.setBounds(157, 147, 70, 15);
		panel_1.add(costToRepair);
		
		JTextPane feedback = new JTextPane();
		feedback.setBounds(346, 465, 600, 40);
		window.getContentPane().add(feedback);
		feedback.setEditable(false);
		
		JLabel lblImageOfShip = new JLabel("Image of ship");
		lblImageOfShip.setBounds(382, 100, 550, 322);
		window.getContentPane().add(lblImageOfShip);
		lblImageOfShip.setIcon(new ImageIcon(ShipScreen.class.getResource(this.gameManager.playerShip.getImage())));
		
		JButton btnRepair = new JButton("Repair");
		btnRepair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				repair(feedback);
			}
		});
		btnRepair.setBounds(73, 432, 117, 25);
		window.getContentPane().add(btnRepair);
		
		JButton btnUpgrade = new JButton("Upgrade");
		btnUpgrade.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				upgrade(feedback);
			}
		});
		btnUpgrade.setBounds(202, 432, 117, 25);
		window.getContentPane().add(btnUpgrade);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setBounds(12, 539, 117, 25);
		window.getContentPane().add(btnExit);
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				finishedWindow();
			}
		});
		
	}
}
