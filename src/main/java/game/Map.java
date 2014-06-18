package game;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import math.Circle;
import math.Vector2D;

/**
 * Osztály egy játékbeli pálya (játékállapot) reprezentálásához.
 */
public class Map {
	/**
	 * Az osztály loggere.
	 */
	private static Logger	logger = LoggerFactory.getLogger(Map.class);
	
	/**
	 * Az ehhez a pályához tartozó {@link Snake} objektumok.
	 */
	private List<Snake> snakes;
	
	/**
	 * A pálya szélessége pixelben.
	 */
	private int width;
	
	/**
	 * A pálya magassága pixelben.
	 */
	private int height;
	
	/**
	 * A pálya összes pixelének tartalmát leíró kép.
	 */
	private BufferedImage image;
	
	/**
	 * Létrehoz egy {@code Map} objektumot teljesen fekete pixelekkel.
	 * 
	 * @param width a pálya szélessége
	 * @param height a pálya magassága
	 */
	public Map(int width, int height) {
		super();
		snakes=new ArrayList<Snake>();
		this.width = width;
		this.height = height;
		image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		
		Graphics2D graphics = image.createGraphics();

		graphics.setPaint ( new Color ( 0, 0, 0 ) );
		graphics.fillRect ( 0, 0, image.getWidth(), image.getHeight() );
	
		logger.info("Létrejött egy új Map.");
	}
	
    /**
     * Visszaadja az aktuális pálya szélességét.
     * @return az aktuális pálya szélessége
     */
	public int getWidth() {
		return width;
	}
	
	/**
     * Visszaadja az aktuális pálya magasságát.
     * @return az aktuális pálya magassága
     */
	public int getHeight() {
		return height;
	}

	/**
     * Visszaadja az aktuális pályát leíró képet.
     * @return az aktuális pályát leíró kép
     */
	public BufferedImage getImage() {
		return image;
	}

	/**
     * Visszadja az aktuális pályához tartozó {@link Snake} objektumokat.
     * @return lista az aktuális pályához tartozó {@link Snake} objektumokról.
     */
	public List<Snake> getSnakes() {
		return snakes;
	}
	
	/**
	 * A játék állapotát lépteti előre.
	 * @param time az idő, mellyel előrelépteti a játékot ezredmásodpercben
	 */
	public void update(int time){
		for(Snake s:snakes){
			if(s.isLive()){
				Vector2D oldPosition=new Vector2D(s.getPos());
				s.turnAndMove(time);
				if(collision(s,oldPosition)){
					s.setLive(false);
					logger.info("Egy kígyó kiesett.");
				}
				else{
					fill(s);
				}
			}
		}
	}
	
	/**
	 * Egy {@link Snake} objektum aktuális poziciójának lenyomatát helyezi el a képre.
	 * @param s a {@link Snake} objektum, melynek el kell helyezni a lenyomatát a képre
	 */
	private void fill(Snake s){
		Vector2D center = s.getPos();
		double r=s.getThickness();
		//(x - center_x)^2 + (y - center_y)^2 < radius^2
		for(int y=(int) (center.getY()-r);y<=center.getY()+r;y++)
			for(int x=(int) (center.getX()-r);x<=center.getX()+r;x++)
				if(Circle.isInnerPoint(r, center, x, y))
					image.setRGB(x, y, s.getColor().getRGB());
	}
	
	/**
	 * Megvizsgálja, hogy egy {@link Snake} objektum aktuális poziciója érvényes-e(nem ütközik sem a fallal sem más {@link Snake} objektumokkal).
	 * 
	 * @param s az a {@link Snake} objektum melynek az érvényességét vizsgáljuk
	 * @param previousPosition a {@link Snake} objektum előző poziciója
	 * @return az ütközés igazságértéke
	 */
	private boolean collision(Snake s,Vector2D previousPosition){
		Vector2D center = s.getPos();
		double r=s.getThickness();
		if(center.getX()<=r || center.getX()+r>=width || center.getY()<=r || center.getY()+r>=height)
			return true;
		
		
		
		for(int y=(int) (center.getY()-r);y<=center.getY()+r;y++)
			for(int x=(int) (center.getX()-r);x<=center.getX()+r;x++)
				if(Circle.isInnerPoint(r, center, x, y) && !Circle.isInnerPoint(r,previousPosition,x,y))
					if(image.getRGB(x, y)!=Color.BLACK.getRGB())
						return true;
		
		return false;
		
	}
	
	/**
	 * Az ezen a pályán lévő élő {@link Snake} objektumok számát határozza meg.
	 * @return az élő {@link Snake} objektumok száma
	 */
	public int numberOfLiveSnake(){
		int count=0;
		for(Snake s : snakes){
			if(s.isLive())
				count++;
		}
		return count;
	}
	
	/**
	 * Meghatározza, hogy vége van-e a játéknak.
	 * @return true, ha a játéknak vége, false, ha nincs.
	 */
	public boolean isEnd(){
		if (numberOfLiveSnake()<2)
			return true;
		else
			return false;
	}
	
	
}
