package entity;

import java.util.ArrayList;
import java.util.List;

public class Park {
	private String name;
	private List<Plant> plants;
	
	public Park(String name, List<Plant> plants) {
		this.name = name;
		this.plants = plants;
	}
	
	public void addPlant(Plant plant) {
		plants.add(plant);
		
	}
	
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Plant> getPlants() {
		return plants;
	}

	public void setPlants(List<Plant> plants) {
		this.plants = plants;
	}

	@Override
	public String toString() {
		return "Park [name=" + name + ", plants=" + plants + "]";
	}
	
	
	
	
}
