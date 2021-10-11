package islandtrader;

import java.awt.EventQueue ;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import javax.swing.JTextField;

import javax.swing.JSlider;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Game Set up screen called by game manager after main menu play is selected on the main menu
 * Takes an input string for the name and provides feedback if it is too long short or contains correct characters.
 * Takes a ship section and displays its stats.
 * Takes an integer input from game duration Slider.
 * If all variables are correctly selected it will allow the player to move to main game screen.
 * Otherwise it will provide feedback.
 * 
 *
 */


public class GameSetupScreen {

	private JFrame window;
	private JTextField nameInput;
	private GameManager gameManager;
	private Ship selectedShip = null;
	
	public GameSetupScreen(GameManager incomningGameManager) {
		this.gameManager = incomningGameManager;
		initialize();
		window.setVisible(true);
	}
	
	public void closeWindow() {
		window.dispose();
	}
	
	public void finishedWindow() {
		gameManager.closeGameSetupScreen(this);
	}
	
	public void displayShip(JLabel healthLabel, JLabel attackPowerLabel, JLabel cargoLabel, 
			JLabel sizeLabel, JLabel speedLabel, JLabel shipImage, JLabel shipName, int shipNum) {
		Ship ship = this.gameManager.shipList.get(shipNum);
		this.selectedShip = ship;
		String health = String.valueOf(ship.getHealth());
		String attackPower = String.valueOf(ship.getAttackPower());
		String cargoCapacity = String.valueOf(ship.getCargoCapacity());
		String size = String.valueOf(ship.getSize());
		String speed = String.valueOf(ship.getSpeed());
		String name = ship.getName();
		healthLabel.setText(health);
		attackPowerLabel.setText(attackPower);
		cargoLabel.setText(cargoCapacity);
		sizeLabel.setText(size);
		speedLabel.setText(speed);
		shipName.setText(name);
		shipImage.setIcon(new ImageIcon(GameSetupScreen.class.getResource(ship.getImage())));
}
	
	
	public void finishSetup(JLabel feedback, JSlider gameDuration) {
		int nameCheck = this.gameManager.player.checkName(nameInput.getText());
		if ( selectedShip == null) {
			feedback.setText("Select a ship!");
		} else if (nameCheck == 1) {
			feedback.setText("Name can't contain special characters");
		} else if (nameCheck == 2) {
			feedback.setText("Name is too short!");
		} else if (nameCheck == 3) {
			feedback.setText("Name is too long!");
		} else {
			feedback.setText("NICE");
			this.gameManager.player.setDuration(gameDuration.getValue());
			this.gameManager.playerShip = selectedShip;
			this.gameManager.player.setName(nameInput.getText());
			finishedWindow();
		}
	}
	

	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		window = new JFrame();
		window.setTitle("Game Setup");
		window.setBounds(100, 100, 899, 680);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setLayout(null);
		
		JLabel lblChooseYourTrader = new JLabel("Choose your trader name");
		lblChooseYourTrader.setBounds(12, 11, 212, 32);
		window.getContentPane().add(lblChooseYourTrader);
		
		nameInput = new JTextField();
		nameInput.setBounds(218, 12, 220, 32);
		window.getContentPane().add(nameInput);
		nameInput.setColumns(10);
		
		JLabel lblGameDuration = new JLabel("Select game duration:");
		lblGameDuration.setBounds(12, 70, 197, 22);
		window.getContentPane().add(lblGameDuration);
		
		JSlider durationSlider = new JSlider();
		durationSlider.setBackground(Color.WHITE);
		durationSlider.setMaximum(50);
		durationSlider.setMinimum(20);
		durationSlider.setBounds(227, 70, 211, 22);
		window.getContentPane().add(durationSlider);
		
		JLabel lblSelectShip = new JLabel("Select Ship:");
		lblSelectShip.setBounds(12, 104, 90, 22);
		window.getContentPane().add(lblSelectShip);
		
		JLabel lblStats = new JLabel("Stats:");
		lblStats.setBounds(501, 120, 70, 15);
		window.getContentPane().add(lblStats);
		
		JLabel lblHealth = new JLabel("Health:");
		lblHealth.setBounds(403, 147, 98, 15);
		window.getContentPane().add(lblHealth);
		
		JLabel lblAttackPower = new JLabel("AttackPower:");
		lblAttackPower.setBounds(403, 174, 98, 15);
		window.getContentPane().add(lblAttackPower);
		
		JLabel lblCargoCapacity = new JLabel("Cargo Capacity:");
		lblCargoCapacity.setBounds(403, 201, 121, 15);
		window.getContentPane().add(lblCargoCapacity);
		
		JLabel lblSize= new JLabel("Size:");
		lblSize.setBounds(403, 228, 70, 15);
		window.getContentPane().add(lblSize);
		
		JLabel lblSpeed = new JLabel("Speed:");
		lblSpeed.setBounds(403, 255, 70, 15);
		window.getContentPane().add(lblSpeed);
		
		JLabel health = new JLabel("health");
		health.setBounds(605, 147, 105, 15);
		window.getContentPane().add(health);
		
		JLabel attackPower = new JLabel("attackPower");
		attackPower.setBounds(605, 174, 105, 15);
		window.getContentPane().add(attackPower);
		
		JLabel cargoCapacity = new JLabel("cargoCapacity");
		cargoCapacity.setBounds(605, 199, 105, 15);
		window.getContentPane().add(cargoCapacity);
		
		JLabel size = new JLabel("size");
		size.setBounds(605, 226, 120, 15);
		window.getContentPane().add(size);
		
		JLabel speed = new JLabel("speed");
		speed.setBounds(605, 255, 120, 15);
		window.getContentPane().add(speed);
		
		JLabel lblShipImage = new JLabel("");
		lblShipImage.setForeground(Color.MAGENTA);
		lblShipImage.setBackground(Color.WHITE);
		lblShipImage.setBounds(175, 282, 550, 322);
		window.getContentPane().add(lblShipImage);
		
		JLabel lblShipNameDisplay = new JLabel("Ship Name");
		lblShipNameDisplay.setBounds(36, 270, 212, 31);
		window.getContentPane().add(lblShipNameDisplay);
		
		JButton btnSelectAverage = new JButton("Average Ship");
		btnSelectAverage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				displayShip(health, attackPower, cargoCapacity, 
						size, speed, lblShipImage, lblShipNameDisplay, 0);
			}
		});
		
		JLabel lblFeedback = new JLabel("");
		lblFeedback.setBounds(245, 616, 423, 22);
		window.getContentPane().add(lblFeedback);
		btnSelectAverage.setBounds(12, 138, 138, 32);
		window.getContentPane().add(btnSelectAverage);
		
		JButton btnSelectFast = new JButton("Fast Ship");
		btnSelectFast.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				displayShip(health, attackPower, cargoCapacity, 
						size, speed, lblShipImage, lblShipNameDisplay, 2);
			}
		});
		btnSelectFast.setBounds(12, 182, 138, 32);
		window.getContentPane().add(btnSelectFast);
		
		JButton btnSelectTank = new JButton("Tank Ship");
		btnSelectTank.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				displayShip(health, attackPower, cargoCapacity, 
						size, speed, lblShipImage, lblShipNameDisplay, 3);
			}
		});
		btnSelectTank.setBounds(162, 182, 138, 32);
		window.getContentPane().add(btnSelectTank);
		
		JButton btnSelectRandom = new JButton("Random Ship");
		btnSelectRandom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					int random = RandomEvent.getRandom();
				displayShip(health, attackPower, cargoCapacity, 
						size, speed, lblShipImage, lblShipNameDisplay, random);
			}
		});
		btnSelectRandom.setBounds(86, 226, 138, 32);
		window.getContentPane().add(btnSelectRandom);
		
		JButton btnSelectCargo = new JButton("Cargo Ship");
		btnSelectCargo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				displayShip(health, attackPower, cargoCapacity, 
						size, speed, lblShipImage, lblShipNameDisplay, 1);
			}
		});
		btnSelectCargo.setBounds(161, 138, 138, 32);
		window.getContentPane().add(btnSelectCargo);
		
		/**
		 * Player clicks when is happy with there game setup.
		 */
		JButton btnFinish = new JButton("Finish");
		btnFinish.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//complete setup
				finishSetup(lblFeedback, durationSlider);
			}
		});
		btnFinish.setBounds(770, 11, 117, 25);
		window.getContentPane().add(btnFinish);
		
	}
}
