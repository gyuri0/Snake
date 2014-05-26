package xml;

import java.awt.Color;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import math.Vector2D;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import game.Map;
import game.Snake;

public class XmlParser {
	private static Map map;
	private static Snake snake;
	private static Vector2D vector;
	private static Color color;
	private static String chars;
	public static Map mapFromXmlFile(String filename) throws ParserConfigurationException, SAXException, IOException{
		SAXParserFactory factory = SAXParserFactory.newInstance();
		SAXParser saxParser = factory.newSAXParser();
		
		DefaultHandler handler = new DefaultHandler() {
			public void startElement(String uri, String localName,String qName, 
	                Attributes attributes) throws SAXException {
				if("Map".equalsIgnoreCase(qName)){
					map=new Map(Integer.valueOf(attributes.getValue("width")),Integer.valueOf(attributes.getValue("height")));
				}
				if("Snake".equalsIgnoreCase(qName)){
					snake=new Snake(null, null, 0, 0, null);
				}
				if("Position".equalsIgnoreCase(qName)){
					vector=new Vector2D(0,0);
				}
				if("Velocity".equalsIgnoreCase(qName)){
					vector=new Vector2D(0,0);
				}
				if("Color".equalsIgnoreCase(qName)){
					color=new Color(0,0,0);
				}
			}
			public void characters(char ch[], int start, int length) throws SAXException {
				chars=new String(ch,start,length);
			}
			public void endElement(String uri, String localName,
					String qName) throws SAXException {
				
				if("Snake".equalsIgnoreCase(qName))
					map.getSnakes().add(snake);
				if("Position".equalsIgnoreCase(qName))
					snake.setPos(vector);
				if("Velocity".equalsIgnoreCase(qName))
					snake.setVelocity(vector);
				if("Color".equalsIgnoreCase(qName))
					snake.setColor(color);
				if("Thickness".equalsIgnoreCase(qName))
					snake.setThickness(Integer.valueOf(chars));
				if("Red".equalsIgnoreCase(qName))
					color=new Color(Integer.valueOf(chars),color.getGreen(),color.getBlue());
				if("Green".equalsIgnoreCase(qName))
					color=new Color(color.getRed(),Integer.valueOf(chars),color.getBlue());
				if("Blue".equalsIgnoreCase(qName))
					color=new Color(color.getRed(),color.getGreen(),Integer.valueOf(chars));
				if("TurnSpeed".equalsIgnoreCase(qName))
					snake.setTurnSpeed(Double.valueOf(chars));
				if("X".equalsIgnoreCase(qName)){
					vector.setX(Double.valueOf(chars));
				}
				if("Y".equalsIgnoreCase(qName)){
					vector.setY(Double.valueOf(chars));
				}
			}
		};
		saxParser.parse(filename, handler);
		return map;
	}
}
