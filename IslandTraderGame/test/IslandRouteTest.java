package test;

import static org.junit.jupiter.api.Assertions.*; 
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import islandtrader.*;

class IslandRouteTest {
	
	private Island testIsland;
	private Island testIsland2;
	private Route testRoute;
	
	@BeforeEach
	public void init() {
		testIsland = new Island("Test Island");
		testIsland2 = new Island("Test Island2");
		testRoute = new Route("Test route", 100, testIsland2, 10, 10, 10);
	}
	
	@Test
	public void testRoute() {
		testIsland.addRoute(testRoute);
		assertEquals(1, testIsland.getRoutes(testIsland2).size());
		assertEquals(testRoute, testIsland.getRoute(testIsland2, 0));
	}

}


