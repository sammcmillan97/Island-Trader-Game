package islandtrader;

/**
 * Fast Ship a subclass of ship
 * 
 * Contains a constructor called during variable initialization. Provides a choose for the 
 * player when choosing there ship in game setup.
 * 
 * Contains the highest speed variable of all the Ships.
 * 
 *
 */

public class FastShip extends Ship {
	
	public FastShip() {
		super("Ricky", 100, 40, 6, 60, 80, 35, "/Images/fastShip.png");
	}
}
