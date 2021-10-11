package islandtrader;

/**
 * Cargo Ship a subclass of ship
 * 
 * Contains a constructor called during variable initialization. Provides a choice for the 
 * player when choosing there ship in game setup.
 * 
 * Contains the cargo capacity of all the ships.
 * 
 *
 */



public class CargoShip extends Ship {
	
	public CargoShip() {
		super("Betty", 100, 50, 8, 100, 40, 40, "/Images/cargoShip.png");
	}
}
