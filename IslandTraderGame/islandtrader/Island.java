package islandtrader;
import java.util.*;

/**
 * 
 * Class wish holds all Island variables and methods
 * 
 * Holds all the routes to get to other islands in the form of an array list routes
 *
 */


public class Island {
    private String name;
    private ArrayList<Route> routes;
    
    public Island(String tempName) {
    	this.name = tempName;
    	this.routes = new ArrayList<Route>();
    }
    
    public String getName() {
    	return this.name;
    }

	public void addRoute(Route route) {
    	routes.add(route);
    }
    
    /**
     * 
     * @param destination - the destination is the island in which the player would like to travel too
     * 
     * @return returns potential routes an array list of all the routes from the current location to the selected island.
     */
    public ArrayList<Route> getRoutes(Island destination) {
    	ArrayList<Route> potenialRoutes = new ArrayList<Route>();
    	for (Route route: this.routes) {
    		if (route.getDestination() == destination) {
    			potenialRoutes.add(route);
    		}
    	}
    	return potenialRoutes;
    }
    
    /**
     * Uses the function getRoutes then returns a single route from the array to display in island screen for the player.
     * The route is of there choice either index o or 1 , higher risk or lower risk
     * 
     */
    public Route getRoute(Island destination, int RouteSelection) {
    	Route route = getRoutes(destination).get(RouteSelection);
    	return route;
    }
    
   /**
    * 
    * @param route - The route in which the player choose to travel on
    * @return an integer which determines the fate of the route 0 if the player arrives without random encounter or
    * 1: Pirates!
    * 2: Bad Weather
    * 3: Sailors
    * 
    * Unfortunately if pirate is triggered the other two random encounters are unable to be triggered
    * could be changed in the future
    */
   public int setSail(GameManager gameManager, Route route) {
	   System.out.println("Set Sail!");
	   gameManager.player.changeGold(-1* route.getCost(gameManager.playerShip));
	   
	   int travelDays = route.getDay(gameManager.playerShip);
	   int pirateRisk = route.getPirate();
	   int weatherRisk = route.getWeather();
	   int sailorRisk = route.getSailor();
	   int returnValue = 0;
	   
	   while(true) {
		   travelDays -= 1;
		   gameManager.player.changeDaysUsed(1);
		   
		   if(travelDays == 0) {
		   		System.out.println("You have reached your destination");
			   returnValue = 0; //Returns 0 arrived at destination
			   break;
		   }
	   }
	   gameManager.player.changeDaysUsed(travelDays);
	   if( RandomEvent.eventRoll(pirateRisk)) {
		   return 1;
	   }
	   if(RandomEvent.eventRoll(weatherRisk)) {
		   return 2;
	   }
	   if(RandomEvent.eventRoll(sailorRisk)) {
		  return 3;

	   	}
	   return returnValue;
   }
    
}

