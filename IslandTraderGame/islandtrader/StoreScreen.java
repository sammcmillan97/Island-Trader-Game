package islandtrader;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JList;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StoreScreen {

	private JFrame frame;
	private GameManager gameManager;
	private Store currentStore;
	private Player player;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	
	public StoreScreen(GameManager gameManager) {
		this.gameManager = gameManager;
		this.currentStore = gameManager.currentStore;
		this.player = gameManager.player;
		initialize();
		frame.setVisible(true);
	}
	public void done() {
		gameManager.closeStoreScreen(this);
	}
	
	public void closeWindow() {
		frame.dispose();
	}
	public void updateSelling(JTextPane textPane, JLabel goldLabel) {
		textPane.setText(currentStore.sellingStringGUI(currentStore));
		goldLabel.setText("Current Money: " + player.getGold() + " gold!");
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1000, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Store");
		frame.getContentPane().setLayout(null);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(98, 79, 225, 355);
		textPane.setText(currentStore.sellingStringGUI(currentStore));
		textPane.setEditable(false);
		frame.getContentPane().add(textPane);
		
		JTextPane textPane_1 = new JTextPane();
		textPane_1.setBounds(645, 79, 225, 355);
		textPane_1.setEditable(false);
		textPane_1.setText(currentStore.buyingStringGUI(currentStore));
		frame.getContentPane().add(textPane_1);
		
		JButton btnNewButton = new JButton("Exit Store");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				done();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton.setBounds(0, 530, 105, 33);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Buy from Store:\r\n");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(645, 54, 165, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Sell from cargo:\r\n");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(98, 54, 150, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel(currentStore.getName()+"\r\n");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_2.setBounds(425, 54, 136, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(98, 470, 60, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		
		JLabel lblNewLabel_3 = new JLabel("Item Number:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_3.setBounds(98, 445, 80, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Quantity:\r\n");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_4.setBounds(225, 446, 49, 14);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("\r\n");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel_5.setBounds(333, 414, 302, 20);
		frame.getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Current Money: " + player.getGold() + " gold!\r\n");
		lblNewLabel_6.setBounds(415, 252, 158, 20);
		frame.getContentPane().add(lblNewLabel_6);
		
		textField_1 = new JTextField();
		textField_1.setBounds(225, 470, 60, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Sell!\r\n");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String tempsellNum = textField.getText();
					String tempsellQuantity = textField_1.getText();
					int sellNum = Integer.parseInt(tempsellNum);
					int sellQuantity = Integer.parseInt(tempsellQuantity);
					currentStore.sellingGUI(gameManager, sellNum, sellQuantity);
					//lblNewLabel_5.setText("");
				} catch (NumberFormatException e1) {
					//System.out.println("Please enter a number");
					lblNewLabel_5.setText("Input only accepts numbers");
				} catch (Exception e2) {
					lblNewLabel_5.setText(e2.getMessage());
					//System.out.println(e2.getMessage());
				} finally {
					updateSelling(textPane, lblNewLabel_6);
					textField.setText("");
					textField_1.setText("");
				}
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton_1.setBounds(328, 469, 89, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel_3_1 = new JLabel("Item Number:");
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_3_1.setBounds(645, 445, 80, 14);
		frame.getContentPane().add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_4_1 = new JLabel("Quantity:\r\n");
		lblNewLabel_4_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_4_1.setBounds(786, 446, 49, 14);
		frame.getContentPane().add(lblNewLabel_4_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(645, 470, 60, 20);
		frame.getContentPane().add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(786, 470, 60, 20);
		frame.getContentPane().add(textField_3);
		
		JButton btnNewButton_1_1 = new JButton("Buy!");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				try {
					String tempbuyNum = textField_2.getText();
					String tempbuyQuantity = textField_3.getText();
					int buyNum = Integer.parseInt(tempbuyNum);
					int buyQuantity = Integer.parseInt(tempbuyQuantity);
					currentStore.buyingGUI(gameManager,  buyNum, buyQuantity);
					
					//lblNewLabel_5.setText("");
				} catch (NumberFormatException e1) {
					//System.out.println("Please enter a number");
					lblNewLabel_5.setText("Input only accepts numbers");
				} catch (Exception e2) {
					//System.out.println(e2.getMessage());
					lblNewLabel_5.setText(e2.getMessage());
				} finally {
					updateSelling(textPane, lblNewLabel_6);
					textField_2.setText("");
					textField_3.setText("");
				}
			}
			
		});
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton_1_1.setBounds(887, 469, 89, 23);
		frame.getContentPane().add(btnNewButton_1_1);

	}
}
