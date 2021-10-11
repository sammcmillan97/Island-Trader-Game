package islandtrader;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;

/** 
 * A GUI for the player when they select an island off the Map Gui
 * displays information about the island store
 * displays information about the routes the player can travel
 * Calls the island set sail method if the player decides to travel to another island
 *
 */

public class IslandScreen {

	private JFrame window;
	private GameManager gameManager;
	private Island selectedIsland;
	private Route selectedRoute;
	private Store selectedStore;

	public IslandScreen(GameManager gameManager, Island selectedIsland, Store selectedStore) {
		this.gameManager = gameManager;
		this.selectedIsland = selectedIsland;
		this.selectedStore = selectedStore;
		initialize();
		window.setVisible(true);
	}
	
	public void closeWindow() {
		window.dispose();
	}
	
	public void finishedWindow(int selection) {
		gameManager.closeIslandScreen(this, selection);
	}
	
	public void exitToMap() {
		finishedWindow(0);
	}
	
	public void exitToMain() {
		finishedWindow(1);
	}
	
	public void exitToPirates() {
		finishedWindow(2);
	}
	
	public void exitToWeather() {
		finishedWindow(3);
	}
	
	public void exitToSailors() {
		finishedWindow(4);
	}
	
	public void displayRoute(int routeSelection, JLabel routeName, JLabel days, JLabel distance , JLabel pirate, JLabel cost, JTextPane feedback) {
		if(selectedIsland != this.gameManager.currentLocation) {
			Route route = this.gameManager.currentLocation.getRoute(selectedIsland, routeSelection);
			this.selectedRoute = route;
			routeName.setText(route.getName());
			days.setText(String.valueOf(route.getDay(this.gameManager.playerShip)));
			distance.setText(String.valueOf(route.getDistance()));
			pirate.setText(String.valueOf(route.getPirate()));
			cost.setText(String.valueOf(route.getCost(this.gameManager.playerShip)));
		} else {
			feedback.setText("You are currently docked at this Island");
		}
	}
	
	public void attemptSetSail(JTextPane feedback) {
		if(this.selectedIsland == gameManager.currentLocation) {
			feedback.setText("You are already on this Island");
		} else if(selectedRoute == null) {
			feedback.setText("Please select a route");
		} else if (selectedRoute.getCost(this.gameManager.playerShip) > gameManager.player.getGold()) {
			feedback.setText("Your crew refuse to set sail as you dont have enough gold to pay them!");
		} else if(selectedRoute.getDay(this.gameManager.playerShip) > this.gameManager.player.getDaysLeft()) {
			feedback.setText("You dont have enough time left for the journey");
		} else if(this.gameManager.playerShip.getHealth() < 50) {
			feedback.setText("Your ship is too damaged to travel, you need to repair your ship");
		} else {
			int outcome = this.gameManager.currentLocation.setSail(this.gameManager, this.selectedRoute);
			setSailOutcome(outcome);
		}
	}
	
	public void setSailOutcome(int outcome) {
		this.gameManager.currentLocation = this.selectedIsland;
		if (outcome == 0) {
			exitToMain();
		} else if(outcome == 1) {
			exitToPirates();
		} else if(outcome == 2) {
			exitToWeather();
		} else if(outcome == 3) {
			exitToSailors();
		}
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		window = new JFrame();
		window.getContentPane().setBackground(UIManager.getColor("Button.focus"));
		window.setTitle("Island");
		window.setBounds(100, 100, 1000, 600);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 1000, 30);
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
		
		JLabel lblDaysDisplay = new JLabel(String.valueOf(this.gameManager.player.getDaysLeft()));
		lblDaysDisplay.setBounds(233, 12, 70, 15);
		panel.add(lblDaysDisplay);
		
		JLabel lblCurrentLocation = new JLabel("Docked: ");
		lblCurrentLocation.setBounds(293, 12, 70, 15);
		panel.add(lblCurrentLocation);
		
		JLabel lblCurrentLocationDisplay = new JLabel(this.gameManager.currentLocation.getName());
		lblCurrentLocationDisplay.setBounds(375, 12, 92, 15);
		panel.add(lblCurrentLocationDisplay);
		
		JTextPane txtpnFeedback = new JTextPane();
		txtpnFeedback.setBackground(UIManager.getColor("Button.focus"));
		txtpnFeedback.setBounds(246, 451, 488, 49);
		window.getContentPane().add(txtpnFeedback);
		
		JPanel RouteInfoPanel = new JPanel();
		RouteInfoPanel.setBackground(new Color(222, 184, 135));
		RouteInfoPanel.setBounds(763, 113, 217, 284);
		window.getContentPane().add(RouteInfoPanel);
		RouteInfoPanel.setLayout(null);
		
		JLabel lblDayDisplay = new JLabel("");
		lblDayDisplay.setBounds(135, 64, 70, 15);
		RouteInfoPanel.add(lblDayDisplay);
		
		JLabel lblNewLabel_1 = new JLabel("Days            :");
		lblNewLabel_1.setBounds(12, 67, 90, 15);
		RouteInfoPanel.add(lblNewLabel_1);
		
		JLabel lblDistance = new JLabel("Distance     :");
		lblDistance.setBounds(12, 104, 90, 15);
		RouteInfoPanel.add(lblDistance);
		
		JLabel lblNewLabel_3 = new JLabel("Pirate Risk  :");
		lblNewLabel_3.setBounds(12, 145, 90, 15);
		RouteInfoPanel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_2 = new JLabel("Cost             :");
		lblNewLabel_2.setBounds(12, 188, 90, 15);
		RouteInfoPanel.add(lblNewLabel_2);
		
		JLabel lblDistanceDisplay = new JLabel("");
		lblDistanceDisplay.setBounds(135, 105, 70, 15);
		RouteInfoPanel.add(lblDistanceDisplay);
		
		JLabel lblPirateRiskDisplay = new JLabel("");
		lblPirateRiskDisplay.setBounds(135, 145, 70, 15);
		RouteInfoPanel.add(lblPirateRiskDisplay);
		
		JLabel lblCostDisplay = new JLabel("");
		lblCostDisplay.setBounds(135, 184, 70, 15);
		RouteInfoPanel.add(lblCostDisplay);
		
		JLabel lblRouteNameDisplay = new JLabel("");
		lblRouteNameDisplay.setHorizontalAlignment(SwingConstants.CENTER);
		lblRouteNameDisplay.setBounds(27, 12, 158, 40);
		RouteInfoPanel.add(lblRouteNameDisplay);
		
		JLabel lblIslandPhoto = new JLabel("contains Island photo");
		lblIslandPhoto.setBackground(Color.WHITE);
		lblIslandPhoto.setBounds(257, 158, 476, 241);
		window.getContentPane().add(lblIslandPhoto);
		
		JButton btnSetSail = new JButton("Set Sail");
		btnSetSail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				attemptSetSail(txtpnFeedback);
			}
		});
		btnSetSail.setBounds(863, 539, 117, 25);
		window.getContentPane().add(btnSetSail);
		
		JButton btnRiskyRoute = new JButton("Risk it!");
		btnRiskyRoute.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				displayRoute(0, lblRouteNameDisplay, lblDayDisplay, lblDistanceDisplay, lblPirateRiskDisplay, lblCostDisplay, txtpnFeedback);
			}
		});
		btnRiskyRoute.setBounds(362, 539, 117, 25);
		window.getContentPane().add(btnRiskyRoute);
		
		JButton btnSafeRoute = new JButton("Play it safe");
		btnSafeRoute.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				displayRoute(1, lblRouteNameDisplay, lblDayDisplay, lblDistanceDisplay, lblPirateRiskDisplay, lblCostDisplay, txtpnFeedback);
			}
		});
		btnSafeRoute.setBounds(491, 539, 117, 25);
		window.getContentPane().add(btnSafeRoute);
		
		JLabel lblRoute = new JLabel("Route:");
		lblRoute.setBounds(838, 56, 111, 33);
		window.getContentPane().add(lblRoute);
		
		JLabel lblIslandName = new JLabel(this.selectedIsland.getName());
		lblIslandName.setHorizontalAlignment(SwingConstants.CENTER);
		lblIslandName.setBounds(328, 97, 323, 49);
		window.getContentPane().add(lblIslandName);
		
		JLabel lblStore = new JLabel(this.selectedStore.getName());
		lblStore.setBounds(89, 65, 70, 15);
		window.getContentPane().add(lblStore);
		
		JTextPane txtpnStoreDetails = new JTextPane();
		txtpnStoreDetails.setBackground(new Color(222, 184, 135));
		txtpnStoreDetails.setText(selectedStore.getPreview(selectedStore, selectedIsland));
		txtpnStoreDetails.setEditable(false);
		txtpnStoreDetails.setBounds(12, 113, 217, 284);
		window.getContentPane().add(txtpnStoreDetails);
		
		JLabel lblSelectRoute = new JLabel("Select Route");
		lblSelectRoute.setBounds(434, 512, 104, 15);
		window.getContentPane().add(lblSelectRoute);
		
		JButton btnExitToMap = new JButton("Exit");
		btnExitToMap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				exitToMap();
			}
		});
		btnExitToMap.setBounds(12, 539, 117, 25);
		window.getContentPane().add(btnExitToMap);
	}
}
