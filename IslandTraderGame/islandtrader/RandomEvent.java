package islandtrader;
import java.util.Random;

/**
 * Class for the GUi of bad weather and sailor event just provides feedback and image to the player based on the event then the player
 * Either exits to main screen or exit to the end if the ship sunk in the storm
 * 
 *
 */

public class RandomEvent {
	static Random rand = new Random();
	
	
	public static boolean eventRoll(int eventChance) {
		int playerRoll = rand.nextInt(51); //Increase/decrease odds of event happening
		int eventRoll = rand.nextInt(eventChance);
		if(playerRoll < eventRoll) {
			System.out.println("Returning true");
			return true;
		}
		return false;
	}
	
	public static int getPirateRoll() {
		return rand.nextInt(51);
	}
	
	public static int getWeatherRoll() {
		return rand.nextInt(101);
	}
	
	public static int getPlayerRoll(int chance) {
		return rand.nextInt(chance);
	}
	
	public static void sailors(int sailorChance) {
		if(eventRoll(sailorChance)) {
			System.out.println("You have come across some shipwrecked sailors!");
		}
	}
	
	public static int getRandom() {
		int random = rand.nextInt(4);
		if (random == 4) {
			return 0;
		}
		return random;
	}
	
	public static int getSailorRoll() {
		return rand.nextInt(200);
	}

}
