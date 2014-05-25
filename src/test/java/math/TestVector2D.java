package math;

import static org.junit.Assert.*;

import math.Vector2D;

import org.junit.Test;

public class TestVector2D {
	
	@Test
	public void testAdd(){
		Vector2D a;
		Vector2D b;
		
		a= new Vector2D(0.5,-6.135);
		b= new Vector2D(100,-100);
		assertEquals(new Vector2D(100.5,-106.135),a.add(b));
		
		a= new Vector2D(-5,5);
		b= new Vector2D(6,-3);
		assertEquals(new Vector2D(1,2),a.add(b));
		
		
	}
	
	@Test
	public void testMultiply(){
		Vector2D a;
		a=new Vector2D(-5,5);
		assertEquals(new Vector2D(-10,10), a.multiply(2));
		
		a=new Vector2D(-5,5);
		assertEquals(new Vector2D(0,0), a.multiply(0));
		
		a=new Vector2D(-5,5);
		assertEquals(new Vector2D(15,-15),a.multiply(-3));
		
		a=new Vector2D(-2,1);
		assertEquals(new Vector2D(-0.5,0.25),a.multiply(0.25));
		
		a=new Vector2D(-0.2,1.2);
		assertEquals(new Vector2D(-2,12),a.multiply(10));
	}
	
	@Test
	public void testRotate(){
		Vector2D a;
		
		a=new Vector2D(-5,5);
		assertEquals(new Vector2D(-5,5),a.rotate(0));
		
		a=new Vector2D(-5,5);
		assertEquals(new Vector2D(-5,5),a.rotate(360));
		
		a=new Vector2D(-5,5);
		assertEquals(new Vector2D(5,-5),a.rotate(180));
		
		a=new Vector2D(1,5);
		assertEquals(new Vector2D(-5,1),a.rotate(90));
		
		a=new Vector2D(0,1);
		assertEquals(new Vector2D(1,0),a.rotate(-90));
	}
}
