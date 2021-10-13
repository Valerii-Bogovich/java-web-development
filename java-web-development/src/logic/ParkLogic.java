package logic;

import entity.Park;
import entity.Plant;

public class ParkLogic {
	private  Park park;
	
	
	
	public ParkLogic(Park park) {
		
		this.park = park;
	}

	public void plantThePark(Plant plant) {
		park.addPlant(plant);
	}
	
	public int countThePlantingsNumber() {
		return park.getPlants().size();
	}
	
	public double countTheTotalHeight() {
		double totalHeight = 0;
		for (Plant plant : park.getPlants()) {
			totalHeight += plant.getHeight();
		}
		
		return totalHeight;
	}
}
