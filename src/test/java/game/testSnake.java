package game;

import static org.junit.Assert.*;

import java.awt.Color;

import math.Vector2D;

import org.junit.Test;

public class testSnake {

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
	}

}
