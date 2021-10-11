package islandtrader;
import java.util.*;

/**
 * The main class of Island Trader
 * 
 * Holds the game variables and opens and closes the GUI classes when needed.
 * 
 *
 */

public class GameManager {

	Island islandOne;
	Island islandTwo;
	Island islandThree;
	Island islandFour;
	Island islandFive;
	Island currentLocation;
	ArrayList<Ship> shipList = new ArrayList<Ship>();
	Player player = new Player();
	Ship playerShip;
	Store currentStore;
	Store storeOne;
	Store storeTwo;
	Store storeThree;
	Store storeFour;
	Store storeFive;
	
/**
 * Initializes all game variables called from main when the game is started.
 * 
 * All five Islands
 * All the routes
 * All five Ships
 * All five Stores
 * 
 */
	public void initializeVariables() {
		initializeShips(); 
		initializeIslands();
		initializeRoutes();
		initializeStores();
		
		
	}

//Ships
	public void initializeShips() {
		AverageShip averageShip = new AverageShip();
		CargoShip cargoShip = new CargoShip();
		FastShip fastShip = new FastShip();
		TankShip tankShip = new TankShip();
		shipList.add(averageShip);
		shipList.add(cargoShip);
		shipList.add(fastShip);
		shipList.add(tankShip);
		
	}
	
//Islands //
	public void initializeIslands() {
		this.islandOne = new Island("Island One (Home)");
		this.islandTwo = new Island("Island Two (poor)");
		this.islandThree = new Island("Island Three (Mining)");
		this.islandFour = new Island("Island Four(Rich)");
		this.islandFive = new Island("Island Five (scary)");
	}
	
//Routes //
	public void initializeRoutes() {
		
		
//Name, Distance, destination, Pirate, weather, Sailor //
// Creates a two routes to each island from one island in the order high risk low risk //
		
		//Name, Distance, destination, Pirate, weather, Sailor
		Route oneToTwo1 = new Route("One to Two 1", 100, this.islandTwo, 6, 6, 3); // Higher Risk 
		Route oneToTwo2 = new Route("One to Two 2", 130, this.islandTwo, 1, 1, 3); // Lower Risk
		Route oneToThree1 = new Route("One to Three 1", 120, this.islandThree, 3, 4, 3); //Higher Risk
		Route oneToThree2 = new Route("One to Three 2", 150, this.islandThree, 2, 3, 3); //Lower Risk
		Route oneToFour1 = new Route("One to Four 1", 140, this.islandFour, 4, 6, 4); //Higher Risk
		Route oneToFour2 = new Route("One to Four 2", 170, this.islandFour, 3, 4, 4); //Lower Risk
		Route oneToFive1 = new Route("One to Five 1", 190, this.islandFive, 9, 7, 5); // Higher Risk //High PirateRisk
		Route oneToFive2 = new Route("One to Five 2", 210, this.islandFive, 6, 6, 5); //Lower Risk

		islandOne.addRoute(oneToTwo1);
		islandOne.addRoute(oneToTwo2);
		islandOne.addRoute(oneToThree1);
		islandOne.addRoute(oneToThree2);
		islandOne.addRoute(oneToFour1);
		islandOne.addRoute(oneToFour2);
		islandOne.addRoute(oneToFive1);
		islandOne.addRoute(oneToFive2);
		
//Island Two routes //
		Route twoToOne1 = new Route("Two to One 1", 100, this.islandOne, 4, 4, 4);
		Route twoToOne2 = new Route("Two to One 2", 130, this.islandOne, 3, 3, 4);
		Route twoToThree1 = new Route("Two to Three 1", 110, this.islandThree, 3, 4, 3);
		Route twoToThree2 = new Route("Two to Three 2", 140, this.islandThree, 2, 3, 3);
		Route twoToFour1 = new Route("Two to Four 1", 130, this.islandFour, 5, 6, 3);
		Route twoToFour2 = new Route("Two to four 2", 180, this.islandFour, 3, 4, 3);
		Route twoToFive1 = new Route("Two to Five 1", 200, this.islandFive, 8, 7, 3);
		Route twoToFive2 = new Route("Two to Five 2", 240, this.islandFive, 6, 6, 3);
		islandTwo.addRoute(twoToOne1);
		islandTwo.addRoute(twoToOne2);
		islandTwo.addRoute(twoToThree1);
		islandTwo.addRoute(twoToThree2);		
		islandTwo.addRoute(twoToFour1);		
		islandTwo.addRoute(twoToFour2);
		islandTwo.addRoute(twoToFive1);
		islandTwo.addRoute(twoToFive2);
		
//Island Three routes //
		Route threeToOne1 = new Route("Three to One 1", 80, this.islandOne, 4, 4, 4);
		Route threeToOne2 = new Route("Three to One 2", 130, this.islandOne, 3, 3, 4);
		Route threeToTwo1 = new Route("Three to Two 1", 110, this.islandTwo, 3, 4, 3);
		Route threeToTwo2 = new Route("Three to Two 2", 140, this.islandTwo, 2, 3, 3);
		Route threeToFour1 = new Route("Three to Four 1", 90, this.islandFour, 5, 6, 3);
		Route threeToFour2 = new Route("Three to four 2", 120, this.islandFour, 3, 4, 3);
		Route threeToFive1 = new Route("Three to Five 1", 100, this.islandFive, 8, 7, 3);
		Route threeToFive2 = new Route("Three to Five 2", 150, this.islandFive, 4, 6, 3);
		islandThree.addRoute(threeToOne1);
		islandThree.addRoute(threeToOne2);
		islandThree.addRoute(threeToTwo1);
		islandThree.addRoute(threeToTwo2);		
		islandThree.addRoute(threeToFour1);		
		islandThree.addRoute(threeToFour2);
		islandThree.addRoute(threeToFive1);
		islandThree.addRoute(threeToFive2);

//Island four routes //
		Route fourToOne1 = new Route("four to One 1", 80, this.islandOne, 4, 4, 4);
		Route fourToOne2 = new Route("four to One 2", 130, this.islandOne, 3, 3, 4);
		Route fourToTwo1 = new Route("four to two 1", 110, this.islandTwo, 3, 4, 3);
		Route fourToTwo2 = new Route("four to two 2", 140, this.islandTwo, 2, 3, 3);
		Route fourToThree1 = new Route("four to three 1", 90, this.islandThree, 5, 6, 3);
		Route fourToThree2 = new Route("four to three 2", 120, this.islandThree, 3, 4, 3);
		Route fourToFive1 = new Route("four to Five 1", 100, this.islandFive, 8, 7, 3);
		Route fourToFive2 = new Route("four to Five 2", 150, this.islandFive, 4, 6, 3);
		islandFour.addRoute(fourToOne1);
		islandFour.addRoute(fourToOne2);
		islandFour.addRoute(fourToTwo1);
		islandFour.addRoute(fourToTwo2);		
		islandFour.addRoute(fourToThree1);		
		islandFour.addRoute(fourToThree2);
		islandFour.addRoute(fourToFive1);
		islandFour.addRoute(fourToFive2);
		
//Island five routes //
		Route fiveToOne1 = new Route("five to One 1", 80, this.islandOne, 4, 4, 9); //High Sailor Chance
		Route fiveToOne2 = new Route("five to One 2", 130, this.islandOne, 3, 3, 4);
		Route fiveToTwo1 = new Route("five to two 1", 110, this.islandTwo, 3, 4, 3);
		Route fiveToTwo2 = new Route("five to two 2", 140, this.islandTwo, 2, 3, 3);
		Route fiveToThree1 = new Route("five to three 1", 90, this.islandThree, 5, 6, 3);
		Route fiveToThree2 = new Route("five to three 2", 120, this.islandThree, 3, 4, 3);
		Route fiveToFour1 = new Route("five to four 1", 100, this.islandFour, 8, 7, 3);
		Route fiveToFour2 = new Route("five to four 2", 150, this.islandFour, 4, 6, 3);
		islandFive.addRoute(fiveToOne1);
		islandFive.addRoute(fiveToOne2);
		islandFive.addRoute(fiveToTwo1);
		islandFive.addRoute(fiveToTwo2);		
		islandFive.addRoute(fiveToThree1);		
		islandFive.addRoute(fiveToThree2);
		islandFive.addRoute(fiveToFour1);
		islandFive.addRoute(fiveToFour2);
	}
	
//Stores //
	public void initializeStores() {
		// Island, store, Metal, Luxury, Food, Spice
		this.storeOne = new Store(this.islandOne, "StoreOne", 50, 50, 50, 50);
		this.storeTwo = new Store(this.islandTwo, "StoreTwo", 70, 10, 50, 70);
		this.storeThree = new Store(this.islandThree, "StoreThree", 20, 50, 70, 60);
		this.storeFour = new Store(this.islandFour, "StoreFour", 70, 70, 20, 40);
		this.storeFive = new Store(this.islandFive, "StoreFive", 60, 10, 80, 50);
		this.currentStore = storeOne;
	}
			
	
	
	
	
	
//Interface //
	
//Main Menu window //
	public void launchMainMenuScreen() {
		MainMenuScreen mainMenuScreen = new MainMenuScreen(this);
		}
	
	public void closeMainMenuScreen(MainMenuScreen mainMenuWindow) {
		mainMenuWindow.closeWindow();
		launchGameSetupScreen();
	}
	
//Game setup window //
	public void launchGameSetupScreen() {
		GameSetupScreen gameSetupWindow = new GameSetupScreen(this);
	}
	
	public void closeGameSetupScreen(GameSetupScreen gameSetupWindow) {
		gameSetupWindow.closeWindow();
		currentLocation = islandOne;
		launchMainScreen();
	}
	
//Main game window //
	public void launchMainScreen() {
		MainScreen mainScreen = new MainScreen(this);
	}
	
	public void closeMainScreen(MainScreen mainWindow, int GUIselection) {
		mainWindow.closeWindow();
		if (GUIselection == 0) {
			//ship
			launchShipScreen();
		}
		if (GUIselection == 1) {
			// Inventory
			launchInventoryScreen();
		}
		if (GUIselection == 2) {
			launchMapScreen();
		}
		if(GUIselection == 3) {
			//store
			launchStore();
		}
		if (GUIselection == 4) {
			launchEndScreen();
		}
	}
	
// Map window //
	public void launchMapScreen() {
		MapScreen mapScreen = new MapScreen(this);
	}
	
	public void closeMapScreen(MapScreen mapWindow, int selection) {
		mapWindow.closeWindow();
		if (selection == 0) {
			launchMainScreen();
		}
		if(selection == 1) {
			//Exit to island one
			this.currentStore = this.storeOne;
			launchIslandScreen(this.islandOne, this.storeOne);
		}
		if(selection == 2) {
			//Exit to island two
			this.currentStore = this.storeTwo;
			launchIslandScreen(this.islandTwo, this.storeTwo);
		}
		if(selection == 3) {
			//Exit to island three
			this.currentStore = this.storeThree;
			launchIslandScreen(this.islandThree, this.storeThree);
		}
		if(selection == 4) {
			//Exit to island four
			this.currentStore = this.storeFour;
			launchIslandScreen(this.islandFour, this.storeFour);
		}
		if(selection == 5) {
			//Exit to island five
			this.currentStore = this.storeFive;
			launchIslandScreen(this.islandFive, this.storeFive);
		}
	}
	
	
// Island Screen //
	public void launchIslandScreen(Island selectedIsland, Store selectedStore) {
		IslandScreen islandScreen = new IslandScreen(this, selectedIsland, selectedStore);
	}
	
	public void closeIslandScreen(IslandScreen islandWindow, int selection) {
		islandWindow.closeWindow();
		if (selection == 0) {
			//Exit to Map
			launchMapScreen();
		}
		if (selection == 1) {
			//Sailed to new Island with no random event
			launchMainScreen();
		}
		if (selection == 2) {
			//Random event pirates!
			launchPirateScreen();
		}
		if (selection == 3) {
			//Random event bad weather
			launchEventScreen(1);
		}
		if (selection == 4) {
			
			//Rescued Sailors
			launchEventScreen(2);
		}
	}
	
	
	// Ship Screen //
	public void launchShipScreen() {
		ShipScreen shipScreen = new ShipScreen(this);
	}
	
	public void closeShipScreen(ShipScreen shipWindow) {
		shipWindow.closeWindow();
		launchMainScreen();
	}
	
	
	// Pirate Screen //
	public void launchPirateScreen() {
		PirateScreen pirateScreen = new PirateScreen(this);
	}
	
	public void closePirateScreen(PirateScreen pirateWinodw, int selection) {
		pirateWinodw.closeWindow();
		if(selection == 0) {
			//Main Screen survived pirates
			launchMainScreen();
		} if(selection == 1) {
			//launch end game did not survive pirates;
			launchEndScreen();
		}
	}
	
	
	// Event Screen for handling Weather or sailors random events //
	public void launchEventScreen(int event) {
		EventScreen eventScreen = new EventScreen(this, event);
	}
	
	public void closeEventScreen(EventScreen eventWindow, int selection) {
		eventWindow.closeWindow();
		if(selection == 0) { //Survived event
			launchMainScreen();
		} if (selection == 1) {
			//Launch end game did not survive bad weather
			launchEndScreen();
		}
	}
	
	// Inventory Screen //
	public void launchInventoryScreen() {
		InventoryScreen inventoryScreen = new InventoryScreen(this);
	}
	
	public void closeInventoryScreen(InventoryScreen inventoryScreen) {
		inventoryScreen.closeWindow();
		launchMainScreen();
	}
	
	// Store Screen //
	public void launchStore() {
		StoreScreen storeScreen = new StoreScreen(this);
	}
	
	public void closeStoreScreen(StoreScreen storeScreen) {
		storeScreen.closeWindow();
		launchMainScreen();
	}
	
	
	
	// End Screen //
	public void launchEndScreen() {
		this.currentStore.sellAllItems(this);
		EndScreen endScreen = new EndScreen(this);
	}
	
	public void closeEndScreen(EndScreen endScreen) {
		endScreen.closeWindow();
	}
	
	
	
	// Main //
	public static void main(String[] args) {
		GameManager gameManager = new GameManager();
		gameManager.initializeVariables();
		gameManager.launchMainMenuScreen();
	}
	
	
}
