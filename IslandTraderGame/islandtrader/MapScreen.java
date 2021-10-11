package islandtrader;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Class for map GUI
 * 
 * Player chooses from the five islands which they would like to view.
 * 
 * 
 *
 */

public class MapScreen {

	private JFrame window;
	private GameManager gameManager;
	
	public MapScreen(GameManager gameManager) {
		this.gameManager = gameManager;
		initialize();
		window.setVisible(true);
	}
	
	public void closeWindow() {
		window.dispose();
	}
	
	public void finishedWindow(int selection) {
		gameManager.closeMapScreen(this, selection);
	}
	
	public void exitMap() {
		finishedWindow(0);
	}
	
	public void openIslandView(int selection) {
		finishedWindow(selection); //selection = island 1 - 5
	}
	
	
	
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		window = new JFrame();
		window.setTitle("Map");
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
		
	
		
		JButton btnExitMap = new JButton("Exit");
		btnExitMap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				exitMap();
			}
		});
		btnExitMap.setBackground(Color.WHITE);
		btnExitMap.setBounds(24, 539, 117, 25);
		window.getContentPane().add(btnExitMap);
		
		JLabel lblMapName = new JLabel("Procrastination Isles");
		lblMapName.setForeground(Color.WHITE);
		lblMapName.setFont(new Font("FoulisGreek", Font.BOLD, 50));
		lblMapName.setBackground(Color.BLACK);
		lblMapName.setBounds(308, 42, 442, 75);
		window.getContentPane().add(lblMapName);
		
		JButton btnIslandOne = new JButton("Island 1");
		btnIslandOne.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				openIslandView(1);
			}
		});
		btnIslandOne.setFont(new Font("Go Mono", Font.BOLD, 12));
		btnIslandOne.setBackground(Color.LIGHT_GRAY);
		btnIslandOne.setBounds(77, 107, 117, 25);
		window.getContentPane().add(btnIslandOne);
		
		JButton btnIsland2 = new JButton("Island 2");
		btnIsland2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				openIslandView(2);
			}
		});
		btnIsland2.setBackground(Color.WHITE);
		btnIsland2.setBounds(100, 413, 117, 25);
		window.getContentPane().add(btnIsland2);
		
		JButton btnIsland3 = new JButton("Island 3");
		btnIsland3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				openIslandView(3);
			}
		});
		btnIsland3.setBackground(Color.WHITE);
		btnIsland3.setBounds(392, 282, 117, 25);
		window.getContentPane().add(btnIsland3);
		
		JButton btnIsland4 = new JButton("Island 4");
		btnIsland4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				openIslandView(4);
			}
		});
		btnIsland4.setBackground(Color.WHITE);
		btnIsland4.setBounds(774, 216, 117, 25);
		window.getContentPane().add(btnIsland4);
		
		JButton btnIsland5 = new JButton("Island 5");
		btnIsland5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				openIslandView(5);
			}
		});
		btnIsland5.setBackground(Color.WHITE);
		btnIsland5.setBounds(801, 479, 117, 25);
		window.getContentPane().add(btnIsland5);
		
		JLabel lblMap = new JLabel("");
		lblMap.setIcon(new ImageIcon(MapScreen.class.getResource("/Images/map.png")));
		lblMap.setBounds(12, -11, 1155, 597);
		window.getContentPane().add(lblMap);
	}
}
