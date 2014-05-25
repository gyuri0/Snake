package game;

import static org.junit.Assert.*;

import java.awt.Color;

import math.Vector2D;

import org.junit.Test;

public class TestSnake {

	@Test
	public void testSettersAndGetters() {
		Snake s = new Snake(new Vector2D(0,0),new Vector2D(1,0),0,0,Color.black);
		s.setPos(new Vector2D(4,5));
		assertEquals(new Vector2D(4,5),s.getPos());
		
		s.setVelocity(new Vector2D(3,6));
		assertEquals(new Vector2D(3,6),s.getVelocity());
		
		s.setColor(new Color(1,2,3));
		assertEquals(new Color(1,2,3), s.getColor());
		
		s.setMove(Move.LEFT);
		assertEquals(Move.LEFT, s.getMove());
		
		s.setThickness(2);
		assertEquals(2, s.getThickness());
		
		s.setTurnSpeed(90.3);
		assertEquals(90.3, s.getTurnSpeed(),0.00001);
		
		s.setLive(false);
		assertEquals(false, s.isLive());
		
	}
	
	@Test
	public void testTurnAndMove() {
		Snake s = new Snake(new Vector2D(0,0),new Vector2D(1,0),0,0,Color.black);
		s.turnAndMove(1000);
		assertEquals(new Vector2D(1,0), s.getPos());
		
		s.setVelocity(new Vector2D(1,1));
		s.turnAndMove(2000);
		assertEquals(new Vector2D(3,2), s.getPos());
		
		s.setPos(new Vector2D(0,0));
		s.setTurnSpeed(90);
		s.setMove(Move.LEFT);
		s.setVelocity(new Vector2D(0,1));
		
		s.turnAndMove(1000);
		assertEquals(new Vector2D(1,0), s.getVelocity());
		assertEquals(new Vector2D(1,0), s.getPos());
		
		s.setMove(Move.RIGHT);
		s.turnAndMove(1000);
		
		assertEquals(new Vector2D(1,1),s.getPos());
	}

}
