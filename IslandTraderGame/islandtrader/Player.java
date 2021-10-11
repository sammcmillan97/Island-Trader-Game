package islandtrader;

/**
 * 
 * Player class used to hold useful game details.
 * 
 * @param outcome determines how the game ended. 
 *
 */


public class Player {

	private String name;
	private int gold = 500;
	private int gameDuration = 0; //set between 20 - 50 by player and decreases as game progresses 
	private int daysUsed = 0; //The actual days used by the play increases and used for calculating end score
	private int outcome = 0; //Used for end game to see how player ends the game 0 = Retired, 1 = Walk the plank, 2 = sunk during pirate battle, 3 = Sunk due to a storm. 
	
	public Player() {
	}
	
	public String getName() {
		return this.name;
	}
	public int getGold() {
		return this.gold;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setDuration(int tempInt) {
		this.gameDuration = tempInt;
	}
	
	public void changeDaysUsed(int days) {
		this.daysUsed += days;
	}
	
	public int getDaysLeft() {
		return (this.gameDuration - this.daysUsed);
	}
	
	public void changeGold(int ammount) {
		this.gold = this.gold += ammount; 
	}
	
	public int getDuration() {
		return this.gameDuration;
	}
	
	/**
	 * Used for setting the outcome on how the game ended
	 * @param outcome 0: Retired 1: walked the plank 2: Sunk during battle 3: sunk during storm.
	 */
	public void setOutcome(int outcome) {
		this.outcome = outcome;
	}
	
	public int getOutcome() {
		return this.outcome;
	}
	
	public int getProfit() {
		return( this.getGold() - 500);
	}
	
	public String getScore() {
		int value;
		String score;
		value = (this.getProfit() - (this.gameDuration * 10));
		if (value < 0) {
			score = "D";
		} else if (value < 1000 ) {
			score =  "C";
		} else if(value  < 2000) {
			score = "B";
		} else {
			score = "A";
		}
		return score;
	}
	
	/**
	 * 
	 * Checks the input String from game setup screen and provides feedback on if it is acceptable or not
	 * @param name Is the input string that the method recieves. 
	 */
	public int checkName(String name) {
		if(!name.matches("^[a-zA-Z]*$")) {
			//System.out.println(" Try again, trader name must contain no special characters or numbers!");
			return 1; //Name contains special Characters
		} else if(name.length() < 3) {
			//System.out.println("Try again, trader name is too short");
			return 2; //Name is too short
		} else if (name.length() > 15) {
			//System.out.println("Try again ! trader name too long");
			return 3; //Name is too long
		}
		return 0; //Name passes all checks checks
	}
	
}
