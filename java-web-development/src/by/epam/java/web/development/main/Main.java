package by.epam.java.web.development.main;

import java.util.List;

import by.epam.java.web.development.entity.Park;
import by.epam.java.web.development.entity.Plant;
import by.epam.java.web.development.logic.ParkLogic;
import by.epam.java.web.development.logic.ParserXML;

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
