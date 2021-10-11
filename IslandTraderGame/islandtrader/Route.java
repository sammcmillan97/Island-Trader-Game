package islandtrader;


/**
 * Class for holding all information about routes used for when sailing between islands
 *
 */

public class Route {
    private String name;
    private int distance;
    private Island destination;
    private int pirateRisk; // Out of 10,1 very low - 10 very high
    private int weatherRisk;// Out of 10, 1 very low - 10 very high
    private int sailorRisk;// Out of 10, 1 very low - 10 very high
    
    
    public Route(String name, int distance, Island destination, int pirateRisk,
    		int weatherRisk, int sailorRisk) {
    	this.name = name;
    	this.distance = distance;
    	this.destination = destination;
    	this.pirateRisk = pirateRisk;
    	this.weatherRisk = weatherRisk;
    	this.sailorRisk = sailorRisk;
	}
    
    public String toString() {
    	String returnString = ("The name of the route is " + this.name + " with a distance of " +
    this.distance + " taking you to " + this.destination.getName() + "\nPirate Risk: " + this.pirateRisk +
    "\nWeather Risk: " + this.weatherRisk + "\nChance of Sailors: " + this.sailorRisk);
    	return returnString;
    }
    
    public String getName() {
    	return this.name;
    }
    
    public Island getDestination() {
    	return this.destination;
    }
    
    public int getDistance() {
    	return this.distance;
    }
    
    public int getPirate() {
    	return this.pirateRisk;
    }
    
    public int getWeather() {
    	return this.weatherRisk;
    }
    
    public int getSailor() {
    	return this.sailorRisk;
    }
    
    public int getDay(Ship playerShip) {
    	return (int) (Math.ceil(distance / playerShip.getSpeed()));
    }
    
    public int getCost(Ship playerShip) {
    	int day = getDay(playerShip);
    	return (day * playerShip.getSize()); 
    }
   
}
