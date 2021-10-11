package islandtrader;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import java.awt.event.ActionListener;



/**
 * 
 * Screen for showing the player what items they currently hold
 *
 */
public class InventoryScreen {
	private JFrame frame;

	private Ship currentShip;
	private GameManager gameManager;
	
	public InventoryScreen(GameManager gameManager) {
		this.gameManager = gameManager;
		this.currentShip = gameManager.playerShip;
		initialize();
		frame.setVisible(true);
		
	}
	public void done() {
		gameManager.closeInventoryScreen(this);
	}
	public void closeWindow() {
		frame.dispose();
	}
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 452, 544);
		frame.setTitle("Inventory");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblInventory = new JLabel("Inventory:\r\n");
		lblInventory.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblInventory.setBounds(163, 0, 112, 59);
		frame.getContentPane().add(lblInventory);
		
		JTextPane cargoHolder = new JTextPane();
		cargoHolder.setBounds(121, 79, 195, 398);
		frame.getContentPane().add(cargoHolder);
		cargoHolder.setText(Ship.showGUICargo());
		cargoHolder.setEditable(false);
		
		JButton exitInventory = new JButton("Exit Inventory\r\n");
		exitInventory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				done();
				
			}
		});
		exitInventory.setBounds(0, 484, 122, 23);
		frame.getContentPane().add(exitInventory);
		
		JLabel cargoSpace = new JLabel("Cargo space left:");
		cargoSpace.setBounds(10, 55, 112, 23);
		frame.getContentPane().add(cargoSpace);
		
		JLabel cargoSpaceHolder = new JLabel(Integer.toString(gameManager.playerShip.remainingSpace()));
		cargoSpaceHolder.setBounds(10, 79, 49, 14);
		frame.getContentPane().add(cargoSpaceHolder);
	}
}
