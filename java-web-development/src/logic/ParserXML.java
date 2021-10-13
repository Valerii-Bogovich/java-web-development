package logic;

import java.io.File;

import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;


import entity.Birch;
import entity.Blueberry;
import entity.Bush;
import entity.Cowberry;
import entity.Oak;
import entity.Park;
import entity.Plant;
import entity.Poplar;
import entity.Raspberry;
import entity.Tree;

public class ParserXML {
	private String PATH = "data\\plants.xml";
	private String PATH2 = "data\\result.xml";
	private final String BIRCH = "birch";
	private final String OAK = "oak";
	private final String POPLAR = "poplar";
	private final String BLUEBERRY = "blueberry";
	private final String COWBERRY = "cowberry";
	private final String RASPBERRY = "raspberry";
	
	
			
					
    private  List<Plant> plantList = new ArrayList<Plant>();
    
	
	public  List readPlantsXML(){
        File xmlFile = new File(PATH);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        
        try {
        	DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(xmlFile);
            collectInformation(document, BIRCH);
            collectInformation(document, OAK);
            collectInformation(document, POPLAR);
            collectInformation(document, BLUEBERRY);
            collectInformation(document, COWBERRY);
            collectInformation(document, RASPBERRY);
            
        } catch (Exception exc) {
            exc.printStackTrace();
        }
        return plantList;
    }
	
	private  void collectInformation(Document document, String element) {
       NodeList elements = document.getElementsByTagName(element);
       
       for (int i = 0; i < elements.getLength(); i++) {
            NamedNodeMap attributes = elements.item(i).getAttributes();
            int id = Integer.valueOf(attributes.getNamedItem("id").getNodeValue());
            double height = Double.valueOf(attributes.getNamedItem("height").getNodeValue());
            
            switch (element) {
                case BIRCH: {
                   plantList.add(new Birch(id, height));
                } break;
                case OAK: {
                    plantList.add(new Oak(id, height));
                } break;
                case POPLAR: {
                	plantList.add(new Poplar(id, height));
                } break;
                case BLUEBERRY: {
                	plantList.add(new Blueberry(id, height));
                } break;
                case COWBERRY: {
                	plantList.add(new Cowberry(id, height));
                } break;
                case RASPBERRY: {
                	plantList.add(new Raspberry(id, height));
                } break;
            }
        }
	}
	
	
	
	public  void writePlantsXML(String parkName, int platingsNumber, double totalHeight){
		 DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	   
	        try {
	            DocumentBuilder builder = factory.newDocumentBuilder();
	            Document doc = builder.newDocument();
	//            Element rootElement = doc.createElement("Park");
	            doc.appendChild(getPark(doc, parkName,Integer.toString(platingsNumber), Double.toString(totalHeight)));
	            TransformerFactory transformerFactory = TransformerFactory.newInstance();
	            Transformer transformer = transformerFactory.newTransformer();
	            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
	            DOMSource source = new DOMSource(doc);
	            StreamResult file = new StreamResult(new File(PATH2));
	            transformer.transform(source, file);
	            
	            
	        } catch (Exception e) {
	                e.printStackTrace();
	            }
    }
	
	
	        private  Node getPark(Document doc, String name, String platingsNumber, String totalHeight) {
	            Element park = doc.createElement("Park");
	            park.setAttribute("name", name);
	            park.appendChild(getParkElements(doc, park, "platingsNumber", platingsNumber));
	            park.appendChild(getParkElements(doc, park, "totalHeight", totalHeight)); 
	            return park;
	        }
	        
	        private  Node getParkElements(Document doc, Element element, String name, String value) {
	            Element node = doc.createElement(name);
	            node.appendChild(doc.createTextNode(value));
	            return node;
	        }
	     


}
	