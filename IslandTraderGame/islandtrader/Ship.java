package islandtrader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Class for holding all information about the ships used when traveling from islands, holding cargo, 
 * @author smc397
 *
 */

public class Ship {
	  
	private String name;
	private int health;
	private int durability;
	//Cargo list = [Steel, Meat, Jewelry]
	private static HashMap<Item, Integer> cargo = new HashMap<>();
	private int cargoCapacity;
	private int size;
	private int speed;
	private int attackPower;
	private int totalCost;
	private ArrayList<Item> upgrades = new ArrayList<Item>();
	private String image;
	
	public Ship(String name, int health, int durability, int size, int cargoCapacity, int speed, int attackPower, String image) {
			this.name = name;
			this.health = health;
			this.durability = durability;
			this.size = size;
			this.cargoCapacity = cargoCapacity;
			this.speed = speed;
			this.attackPower = attackPower;	
			this.totalCost = size / 2;
			this.image = image;
	}
	
	
	
	public int remainingSpace() {
		if (cargo.size() == 0) {
			return this.cargoCapacity;
		} else {
			int remainingSpace = this.cargoCapacity;
			for (Entry<Item, Integer> set : cargo.entrySet()) { //Loops through cargo
				remainingSpace -= (set.getKey().getWeight() * set.getValue());
			}
			return remainingSpace;
		}
	}
	
	public int getRepairCost() {
		int repairCost = (100 - this.health) * 2;
		return repairCost;
	}
	
	public int getHealth() {
		return this.health;
	}
	
	public int getSpeed() {
		return this.speed;
	}
	
	public int getSize() {
		return this.size;
	}
	
	public int getCargoCapacity() {
		return this.cargoCapacity;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setHealth(int health) {
		this.health = health;
	}
	
	public void changeHealth(int change) {
		this.health += change; 
	}
	
	public int getTotalCost() {
		return this.totalCost;
	}
	
	
	public int getAttackPower() {
		return this.attackPower;
	}
	
	public int getDurability() {
		return this.durability;
	}
	
	public String getImage() {
		return this.image;
	}
	
	public int getDamage(int damage) {
		double durability = this.getDurability();
		double damageReduced = damage - (damage * (durability / 100));
		return (int) damageReduced;
	}
	
	
	/**
	 * Changes the type and Quantity of cargo.
	 * 
	 *  @param item 
	 *  @param quanity of the specified item
	 */
	public static void changeCargo(Item item, int quantity) {
		
		if (cargo.containsKey(item)){
			int preQuantity = cargo.get(item);
			cargo.put(item, (preQuantity + quantity));
			if (cargo.get(item) == 0) {
				cargo.remove(item);
			}
		} else {
			cargo.put(item, quantity);
		}
		
	}
	
	public static HashMap<Item, Integer> sellingCargo() {
		return Ship.cargo;
	}
	
	public static String showGUICargo() {
		String cargoString = "";
		if (cargo.isEmpty()){
			cargoString = ("You have no cargo! Visit the store!");
		} else {
		for (Entry<Item, Integer> set : cargo.entrySet()) {
			cargoString += (set.getKey().getName() + ", quantity: " + set.getValue() + "\n");
		}
		}
		return cargoString;
	}
	public static void showCargo() {
		if (cargo.isEmpty()){
			System.out.println("You have no cargo! Visit the store!");
		} else {
		for (Entry<Item, Integer> set : cargo.entrySet()) {
			System.out.println(set.getKey().getName() + ", quantity: " + set.getValue());
		}
		}
		System.out.println();
	}
	
	public boolean pirateAttack(GameManager gameManager) {
		int goldTaken = 0;
		int playerGold;
		int itemQuantity;
		int itemValue;
		while (goldTaken < 200){ //Loops while player has not lost enough gold
			if (gameManager.player.getGold() > 200) { //If player has 200 gold, looses gold
				goldTaken += 200;
				gameManager.player.changeGold(-200);
				return true;
			} else { //Checks if player has gold in items
				playerGold = gameManager.player.getGold();
				goldTaken += playerGold;
				gameManager.player.changeGold(-1 * playerGold);
				for (Entry<Item, Integer> set : cargo.entrySet()) { //Loops through items
					itemValue = set.getKey().getValue(set.getKey(), null);
					itemQuantity = set.getValue();
					while (itemQuantity > 0) { //Takes away items until gold amount is met

						if (goldTaken < 200) {
							goldTaken += itemValue;
							changeCargo(set.getKey(), 1);
						} else { // Reached gold amount
							itemQuantity = 0;
							
							return true;
						}
						itemQuantity -= 1;
					}
				
				}
				if (goldTaken < 200) { //If player doesnt have the gold at all
					goldTaken = 200;
					return false;
				}
			}
		}
		return false;
	}
}
	
	
	

	
	

