package islandtrader;

public class TankShip extends Ship{
	
	public TankShip() {
		super("The Destroyer", 150, 80, 9, 85, 35, 80, "/Images/tankShip.png");
	}
	
	@Override
	public int getRepairCost() {
		int repairCost = (150 - this.getHealth()) * 2;
		return repairCost;
	}
	
	@Override
	public void setHealth(int health) {
		super.setHealth(health + 50);
	}
}