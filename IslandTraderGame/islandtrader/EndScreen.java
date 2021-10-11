package islandtrader;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EndScreen {

	private JFrame window;
	private GameManager gameManager;
	
/**
 * End Screen is the GUI for the end of the game. Takes a variable player.outcome to provide feedback on how the game ended
 * Calls methods from the player class to provide feedback on the game.
 * 
 * 
 */
	
	
	public EndScreen(GameManager gameManager) {
		this.gameManager = gameManager;
		
		initialize();
		window.setVisible(true);
	}
	
	public void closeWindow() {
		window.dispose();
	}
	
	public void finishedWindow() {
		gameManager.closeEndScreen(this);
	}
	
	public void setScore(JLabel score) {
		
		
	}
	
	public void exit() {
		finishedWindow();
	}
	
	public void setEnd(JLabel image, JTextPane text) {
		// based on player. outcome will set image and give description of what happened
		if (this.gameManager.player.getOutcome() == 0) {
			text.setText("You retire");
			//set retire image
		}
		if (this.gameManager.player.getOutcome() == 1) {
			text.setText("You didnt have a enough gold to statisfy the greed of the pirates so they made you walk the plank");
		}
		if (this.gameManager.player.getOutcome() == 2) {
			text.setText("During your defense against the pirates your ship was sunk");
		}
		if (this.gameManager.player.getOutcome()== 3) {
			text.setText("The damage from the storm was too great and your ship sunk into the abyss");
		}
	}
	
	private void initialize() {
		window = new JFrame();
		window.getContentPane().setBackground(Color.WHITE);
		window.setTitle("The End ");
		window.setBounds(100, 100, 461, 602);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(28, 30, 403, 515);
		window.getContentPane().add(panel);
		panel.setLayout(null);
		
		JTextPane gameWrapUp = new JTextPane();
		gameWrapUp.setBounds(45, 32, 307, 62);
		gameWrapUp.setEditable(false);
		panel.add(gameWrapUp);
		
		JLabel gameDuration = new JLabel(String.valueOf(this.gameManager.player.getDuration()));
		gameDuration.setBounds(247, 150, 105, 15);
		panel.add(gameDuration);
		
		JLabel lblScore = new JLabel("Score:");
		lblScore.setBounds(78, 231, 45, 15);
		panel.add(lblScore);
		
		JLabel lblGameDuration = new JLabel("Game Duration:");
		lblGameDuration.setBounds(79, 150, 111, 15);
		panel.add(lblGameDuration);
		
		JLabel lblProfit = new JLabel("Profit:");
		lblProfit.setBounds(78, 204, 44, 15);
		panel.add(lblProfit);
		
		JLabel lblDaysPlayed = new JLabel("Days played:");
		lblDaysPlayed.setBounds(78, 177, 92, 15);
		panel.add(lblDaysPlayed);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(79, 123, 45, 15);
		panel.add(lblName);
		
		JLabel name = new JLabel(this.gameManager.player.getName());
		name.setBounds(247, 123, 120, 15);
		panel.add(name);
		
		JLabel profit = new JLabel(String.valueOf(this.gameManager.player.getProfit()));
		profit.setBounds(247, 204, 120, 15);
		panel.add(profit);
		
		JLabel daysPlayed = new JLabel(String.valueOf(this.gameManager.player.getDuration() - this.gameManager.player.getDaysLeft()));
		daysPlayed.setBounds(247, 177, 120, 15);
		panel.add(daysPlayed);
		
		JLabel score = new JLabel(this.gameManager.player.getScore());
		score.setBounds(247, 231, 120, 15);
		panel.add(score);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				exit();
			}
		});
		btnExit.setBounds(145, 478, 117, 25);
		panel.add(btnExit);
		
		JLabel endImage = new JLabel("image");
		endImage.setBounds(35, 283, 332, 162);
		panel.add(endImage);
		endImage.setBackground(Color.WHITE);
		endImage.setForeground(Color.BLACK);
	
		setScore(score);
		setEnd(endImage, gameWrapUp);
	}
}

