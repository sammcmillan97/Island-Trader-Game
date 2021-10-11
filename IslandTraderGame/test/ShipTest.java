package test;


import static org.junit.jupiter.api.Assertions.*; 
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import islandtrader.*;

class ShipTest {
	private Ship testShip;
	private Ship testShip2;
	
	//Name - Health - Durability - size - cargoCapacity - Speed - attackPower
	
	@BeforeEach
	public void init() {
		testShip = new Ship("Tester", 100, 20, 8, 100, 100, 90, "");
		testShip2 = new Ship("Tester", 80, 30, 6, 70, 70, 70, "");
	}
	
	
	@Test
	public void getDamagetest() {
		assertEquals(80, testShip.getDamage(100));
		assertEquals(14, testShip2.getDamage(20));
	}
	
	@Test
	public void getRepairCostTest() {
		assertEquals(40, testShip2.getRepairCost());
		assertEquals(0, testShip.getRepairCost());
	}
	
	

}
