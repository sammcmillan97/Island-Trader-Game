package islandtrader;

/**
 * Class for holding the variables of items.
 * Items can be brought and sold using the store class
 *
 */

public class Item {

	
	
	private String name;
	private double value;
	private int weight;
	private String type;

	
	public Item(String tempName, int value, int weight, String type){
		this.name = tempName;
		this.value = value;
		this.weight = weight;
		this.type = type;
	}
	
	public int getWeight() {
		return this.weight;
	}
	
	public int getValue(Item item, Store store) {
		//System.out.println("Favour: " + store.getFavour(item) + 
		//		"\nMultiplying by: " + (store.getFavour(item) / 100)
		//		+ "\n Value unmultiplied: " + this.value + 
		//		"\nPost: " + (this.value * (store.getFavour(item) / 100)));
		if (store != null) {
			return (int) Math.round(this.value * (store.getFavour(item) / 100));
		} else {
			return (int) Math.round(this.value);
		}
	}
	
	public String getType() {
		return this.type;
	}
	
	public String getName() {
		return this.name;
	}

	
}
