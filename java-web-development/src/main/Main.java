package main;

import java.util.List;

import entity.Park;
import entity.Plant;
import logic.ParkLogic;
import logic.ParserXML;

public class Main {
	

	public static void main(String[] args) {
		ParserXML px = new ParserXML();
		List<Plant> plants = px.readPlantsXML();
		Park park = new Park("My park", plants);
		ParkLogic parkLogic = new ParkLogic(park);
		int platingsNumber = parkLogic.countThePlantingsNumber();
		double totalHeight = parkLogic.countTheTotalHeight();
		px.writePlantsXML("My park", platingsNumber, totalHeight );

	}

}
