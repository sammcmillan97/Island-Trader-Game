package islandtrader;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Scanner;


import java.util.Map.Entry;

public class Store{
        private String name;
        private Island location;
        private ArrayList<Item> buyable = new ArrayList<Item>();
    	private static HashMap<Integer, Item> sellable = new HashMap<>();
        //Item favour is a % of how much they want it
        private double metalFavour;
        private double luxuryFavour;
        private double foodFavour;
        private double spiceFavour;
        
    	private Item steel = new Item("Steel", 60, 4, "Metal");
    	private Item iron = new Item("Iron", 70, 4, "Metal");
    	private Item silver = new Item("Silver", 80, 5, "Metal");
    	private Item platinum = new Item("Platinum", 90, 5, "Metal");
    	private Item osmium = new Item("Osmium", 70, 4, "Metal");
        
    	private Item ring = new Item("Ring", 25, 2, "Luxury");
    	private Item heirloom = new Item("Old Heirloom", 30, 3, "Luxury");
    	private Item diamond = new Item("Diamond", 40, 2, "Luxury");
    	private Item crown = new Item("Crown", 35, 3, "Luxury");
    	private Item necklace = new Item("Necklace", 30, 3, "Luxury");
        
    	private Item duck = new Item("Duck", 15, 1,  "Food");
    	private Item chicken = new Item("Chicken", 20, 1, "Food");
    	private Item lamb = new Item("Lamb", 15, 1, "Food");
    	private Item steak = new Item("Steak", 2, 1, "Food");
    	private Item bread = new Item ("Bread", 18, 1, "Food");
        
    	private Item cinnamon = new Item("Cinnamon", 15, 1, "Spice");
    	private Item coriander = new Item("Coriander", 18, 1, "Spice");
    	private Item cumin = new Item("Cumin", 15, 1, "Spice");
    	private Item sugar = new Item("Sugar", 22, 1, "Spice");
    	private Item cloves = new Item("Cloves", 15, 1, "Spice");
        
    public Store(Island tempIsland, String name, double mFavour, double lFavour, double fFavour, double sFavour) {
    	   this.location = tempIsland;
    	   this.name = name;
    	   this.metalFavour = mFavour;
    	   this.luxuryFavour = lFavour;
    	   this.foodFavour = fFavour;
    	   this.spiceFavour = sFavour;
    	   initializeItems(tempIsland);
       }
    
    //Returns store name
    public String getName() {
    	return this.name;
    }
    public Island getLocation() {
    	return this.location;
    }
    
    public void sellAllItems(GameManager gameManager) {
    	for (Entry<Item, Integer> set : Ship.sellingCargo().entrySet()) {
    		gameManager.player.changeGold(set.getKey().getValue(set.getKey(), gameManager.currentStore) * set.getValue()); //Changes players gold
			Ship.changeCargo(set.getKey(), (-1 * set.getValue()));
    	}
    }
    
    public String getPreview(Store currentStore, Island tempIsland) {
    	//initializeItems(tempIsland);
    	String previewString = (this.name + "'s Prices!\n\n");
    	int count = 0;
    	for (Item i: buyable) { 	//Loops through buyable items
    		previewString += (++count + ". " + i.getName() +"\nAt the price: " + 
    						i.getValue(i, currentStore) 
    						+ "\nWeight: " + (i.getWeight()) + "\n\n");
   		    count = count++;
   	   }
    	return previewString;
    }
    
    //Returns Stores favour to item type for price calculation
    public double getFavour(Item tempItem) {	
    	
    	if (tempItem.getType() == "Metal") {
    		return this.metalFavour;
    	} else if (tempItem.getType() == "Luxury") {
    		return this.luxuryFavour;
    	}else if (tempItem.getType() == "Spice") {
    		return this.spiceFavour;
    	} else {
    		return this.foodFavour;
    	}
    }
    //Adds items into different islands Stores
    public void initializeItems(Island loaction) {
    	
    	String templocation = location.getName();
    	if (templocation == "Island One (Home)") {
    		buyable.add(steel);
        	buyable.add(ring);
        	buyable.add(duck);
        	buyable.add(cinnamon);
        	
    	} else if (templocation == "Island Two (poor)") {
    		buyable.add(iron);
    		buyable.add(heirloom);
    		buyable.add(chicken);
    		buyable.add(coriander);
    		
    	} else if (templocation == "Island Three (Mining)") {
    		buyable.add(silver);
    		buyable.add(diamond);
    		buyable.add(lamb);
    		buyable.add(cumin);
    		
    	} else if (templocation == "Island Four(Rich)") {
    		buyable.add(platinum);
    		buyable.add(steak);
    		buyable.add(crown);
    		buyable.add(sugar);
    		
    	} else {
    		buyable.add(osmium);
    		buyable.add(bread);
    		buyable.add(necklace);
    		buyable.add(cloves);
    	}
    	
    	
		
    }
	//Computes buying 
    public void buyingGUI(GameManager gameManager, int numItem, int quantity) throws Exception {
    	Item selectedItem;
    	
    	if (numItem >= 1 && numItem <= buyable.size()) { // If an item is selected
    		selectedItem = buyable.get(numItem - 1); //Stores item selection
    		if ((selectedItem.getValue(selectedItem, this) * quantity) <= gameManager.player.getGold()) {
    			if ((selectedItem.getWeight()* quantity) <= gameManager.playerShip.remainingSpace()) {
					gameManager.player.changeGold(selectedItem.getValue(selectedItem, this) * quantity * -1); //Changes players gold
					Ship.changeCargo(selectedItem, quantity);
					throw new Exception("Bought " + quantity + " piece(s) of " + selectedItem.getName() + "!" +
							" Deducting " + selectedItem.getValue(selectedItem, this) * quantity + " coins!");
    			} else {
  
    				throw new Exception("Not enough cargo space! Remaining: " + gameManager.playerShip.remainingSpace());
    			}
			} else {
				throw new Exception("Sorry you cant afford a price of " + 
						selectedItem.getValue(selectedItem, this) * quantity + "!");

			}
    	} else if (numItem != 0) {
    		throw new Exception("Please enter a number corresponding to an item");
    	}
    }
    public String buyingStringGUI(Store currentStore) {
    	int count = 0;
    	String buyingString = "";
    	for (Item i: buyable) { 	//Loops through buyable items
    		buyingString += (++count + ". " + i.getName() + 
    				"\nPrice: " + i.getValue(i, currentStore) 
    				+ "\nWeight: " + (i.getWeight()) + "\n\n");
   		    count = count++;
   	   }
       return buyingString;
    }
    // Computes selling
    public String sellingStringGUI(Store currentStore) {
    	int count = 1;
    	String sellingString = "";
    	if (Ship.sellingCargo().isEmpty()){ //If they have no cargo
    		sellingString += "You have no Cargo to sell!";
    	} else { //They have cargo
	    	for (Entry<Item, Integer> set : Ship.sellingCargo().entrySet()) {
				sellable.put(count, set.getKey());
				sellingString += (count + ". " + set.getKey().getName() + ", quantity: " + set.getValue() + 
						"\nPrice: $" + set.getKey().getValue(set.getKey(), currentStore) + " per item"
						+"\nTotal Weight: " + (set.getKey().getWeight() * set.getValue()) + "\n\n");
	   		    count++;
	   	    }
    	}
    	return sellingString;
    }
    public void sellingGUI(GameManager gameManager, int numItem, int quantity) throws Exception {
    	Item selectedItem;
    	
    	if (numItem > 0 && numItem <= Ship.sellingCargo().size()) { // If an item is selected
       		selectedItem = sellable.get(numItem); //Assigns selected Item
			
			if (Ship.sellingCargo().get(selectedItem) >= quantity) {
				gameManager.player.changeGold(selectedItem.getValue(selectedItem, this) * quantity); //Changes players gold
				Ship.changeCargo(selectedItem, (-1 * quantity));
				throw new Exception("Selling " + quantity + " piece(s) of " + selectedItem.getName() + "!" + 
						" Adding " + selectedItem.getValue(selectedItem, this) * quantity + " coins!");
			} else {
				throw new Exception("Sorry you dont have that much of " + selectedItem.getName() + "!");
			}
			
    	} else if (numItem != 0) {
    		throw new Exception("Please enter a correct number");
    	}
    }


	

}