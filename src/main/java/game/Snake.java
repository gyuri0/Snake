package game;

import java.awt.Color;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import math.Vector2D;


/**
 * Osztály egy játékbeli kígyó reprezentálásához
 */
public class Snake {
	private static Logger logger = LoggerFactory.getLogger(Snake.class);
	
	/**
	 * A kígyó aktuális poziciója.
	 */
	private Vector2D pos;
	
	/**
	 * A kígyó aktuális sebessége.
	 */
	private Vector2D velocity;
	
	/**
	 * A kígyó szélessége.
	 */
	private int thickness;
	
	/**
	 * A kígyó fordulási sebessége.
	 */
	private double turnSpeed;
	
	/**
	 * A kígyó fordulási szándéka.
	 */
    private Move move;
    
    /**
     * A kígyó állapota. Ha false, akkor a kígyó már kiesett a játékból.
     */
	private boolean live;
	
	/**
	 * A kígyó színe.
	 */
	private Color color;
	
	/**
	 * Létrehoz egy {@code Snake} objektumot.
	 * @param pos a kígyó kezdeti poziciója
	 * @param velocity a kígyó sebessége
	 * @param thickness a kígyó vastagsága
	 * @param turnSpeed a kígyó fordulási sebessége fok/másodpercben megadva
	 * @param color a kígyó színe
	 */
	public Snake(Vector2D pos, Vector2D velocity, int thickness, double turnSpeed,Color color) {
		super();
		this.pos = pos;
		this.velocity = velocity;
		this.thickness = thickness;
		this.turnSpeed=turnSpeed;
		this.color=color;
		move=Move.FORWARD;
		live=true;
	}
	
	/**
	 * Visszaadja az aktuális kígyó vastagságát.
	 * @return az aktuális kígyó vastagsága
	 */
	public int getThickness() {
		return thickness;
	}
	
	/**
	 * Beállítja az aktuális kígyó vastagságát.
	 * @return az aktuális kígyó vastagsága
	 */
	public void setThickness(int thickness) {
		this.thickness=thickness;
	}
	
	/**
	 * Visszaadja az aktuális kígyó pozicióját.
	 * @return az aktuális kígyó poziciója
	 */
	public Vector2D getPos() {
		return pos;
	}
	
	/**
	 * Beállítja az aktuális kígyó a pozicióját.
	 * @param pos az aktuális kígyó poziciója
	 */
	public void setPos(Vector2D pos) {
		this.pos = pos;
	}

	/**
	 * Visszaadja az aktuális kígyó sebességét.
	 * @return az aktuális kígyó sebessége
	 */
	public Vector2D getVelocity() {
		return velocity;
	}

	/**
	 * Beállítja az aktuális kígyó sebességét.
	 * @param velocity az aktuális kígyó sebessége. 
	 */
	public void setVelocity(Vector2D velocity) {
		this.velocity = velocity;
		logger.warn("Megváltoztatták egy Snake sebességét.");
	}
	
	/**
	 * Visszaadja az aktuális kígyó fordulási sebességét fok/másodpercben.
	 * @return az aktuális kígyó fordulási sebessége
	 */
	public double getTurnSpeed() {
		return turnSpeed;
	}

	/**
	 * Beállítja az aktuális kígyó fordulási sebességét fok/másodpercben.
	 * @param turnSpeed az aktuális kígyó fordulási sebessége fok/másodpercben
	 */
	public void setTurnSpeed(double turnSpeed) {
		this.turnSpeed = turnSpeed;
	}

	/**
	 * Visszaadja az aktuális kígyó fordulási szándékát.
	 * @return az aktuális kígyó fordulási szándéka
	 */
	public Move getMove() {
		return move;
	}

	/**
	 * Beállítja az aktuális kígyó fordulási szándékát.
	 * @return az aktuális kígyó fordulási szándéka
	 */
	public void setMove(Move move) {
		this.move = move;
	}
	
	/**
	 * Visszaadja az aktuális kígyó színét.
	 * @return az aktuális kígyó színe
	 */
	public Color getColor() {
		return color;
	}

	/**
	 * Beállítja az aktuális kígyó színét.
	 * @return az aktuális kígyó színe
	 */
	public void setColor(Color color) {
		this.color = color;
		logger.warn("Megváltoztatták egy Snake színét.");
	}
	
	/**
	 * Visszaadja, hogy a kígyó játékban van-e még.
	 * @return true, ha a kígyó még nem esett ki, false, ha igen.
	 */
	public boolean isLive() {
		return live;
	}

	/**
	 * Beállítja, azt, hogy a kígyó játékban van-e még.
	 * @param live a kígyó állapota
	 */
	public void setLive(boolean live) {
		this.live = live;
	}
	/**
	 * Elfordítja a kígyót a fordulási szándéknak megfelőlen.
	 * @param time a fordulás ideje ezredmásodpercben
	 */
	private void turn(int time){
		double realDegree=turnSpeed*(time/1000.0);
		if(move==Move.RIGHT){
			velocity=velocity.rotate(realDegree);
		}
		else if(move==Move.LEFT){
			velocity=velocity.rotate(-realDegree);
		}
	}
	
	/**
	 * Mozgatja a kígyót a sebességnek megfelelően.
	 * @param time a mozgatás ideje ezredmásodpercben.
	 */
	private void move(int time){
		pos=pos.add(velocity.multiply(time/1000.0));
	}
	
	/**
	 * Fordítja és mozgatja a kígyót.
	 * @param time a forgatás és mozgatás ideje ezredmásodpercben.
	 */
	public void turnAndMove(int time){
		turn(time);
		move(time);
	}
	
}
