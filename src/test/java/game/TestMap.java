package game;

import static org.junit.Assert.*;

import java.awt.Color;
import java.awt.image.BufferedImage;

import math.Vector2D;

import org.junit.Test;

public class TestMap {

	public Map getDefaultMap(){
		Map map = new Map(600, 600);
    	map.getSnakes().add(new Snake(new Vector2D(100,200), new Vector2D(100,0),5,90,Color.WHITE));
        map.getSnakes().add(new Snake(new Vector2D(500,400), new Vector2D(-100,0),5,90,Color.GREEN));
		return map;
	}
	
	@Test
	public void testGetters() {
		Map map= new Map(600,700);
		assertEquals(600,map.getWidth());
		assertEquals(700,map.getHeight());
		assertEquals(0,map.getSnakes().size());
		BufferedImage img = map.getImage();
		assertEquals(600,img.getWidth());
		assertEquals(700,img.getHeight());
	}

	@Test
	public void testNumberOfLiveSnakes() {
		Map map=new Map(1,1);
		assertEquals(0, map.numberOfLiveSnake());
		map.getSnakes().add(new Snake(new Vector2D(0,0), new Vector2D(0,0), 0, 0, Color.WHITE));
		assertEquals(1, map.numberOfLiveSnake());
		map.getSnakes().add(new Snake(new Vector2D(0,0), new Vector2D(0,0), 0, 0, Color.WHITE));
		assertEquals(2,map.numberOfLiveSnake());
		map.getSnakes().get(0).setLive(false);
		assertEquals(1,map.numberOfLiveSnake());
	}
	
	@Test
	public void testIsEnd() {
		Map map=getDefaultMap();
		assertFalse(map.isEnd());
		map.getSnakes().get(0).setLive(false);
		assertTrue(map.isEnd());
	}
	
	@Test
	public void testUpdate() {
		Map map=getDefaultMap();
		map.getSnakes().get(1).setLive(false);
		map.update(1000);
		Snake s1=map.getSnakes().get(0);
		Snake s2=map.getSnakes().get(1);
		map=getDefaultMap();
		Snake s3=map.getSnakes().get(0);
		Snake s4=map.getSnakes().get(1);
		s3.turnAndMove(1000);
		
		assertEquals(s1.getPos(),s3.getPos());
		assertEquals(s2.getPos(),s4.getPos());
		
		map=getDefaultMap();
		s1=map.getSnakes().get(0);
		
		s1.setPos(new Vector2D(800,500));
		map.update(10);
		assertFalse(s1.isLive());
		
		s1.setLive(true);
		s1.setPos(new Vector2D(-1,500));
		map.update(10);
		assertFalse(s1.isLive());
		
		s1.setLive(true);
		s1.setPos(new Vector2D(300,-1));
		map.update(10);
		assertFalse(s1.isLive());
		
		s1.setLive(true);
		s1.setPos(new Vector2D(300,9000));
		map.update(10);
		assertFalse(s1.isLive());
	}

}
