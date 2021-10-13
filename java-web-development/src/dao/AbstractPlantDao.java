package dao;

import java.util.List;

import entity.Plant;

public abstract class AbstractPlantDao {
	public abstract  List<Plant> loadPlants();
	
	public abstract void saveResults();
}
