package math;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestCircle {

	@Test
	public void isInnerPointxy() {
		assertTrue(Circle.isInnerPoint(10, new Vector2D(0, 0), new Vector2D(9.9,0)));
		assertTrue(Circle.isInnerPoint(10, new Vector2D(0, 0), new Vector2D(7,7)));
		assertFalse(Circle.isInnerPoint(10, new Vector2D(0, 0), new Vector2D(10.1,0)));
		assertFalse(Circle.isInnerPoint(10, new Vector2D(0, 0), new Vector2D(8,7)));
	}
	
	@Test
	public void isInnerPointVector2D() {
		assertTrue(Circle.isInnerPoint(10, new Vector2D(0, 0), 9.9,0));
		assertTrue(Circle.isInnerPoint(10, new Vector2D(0, 0), 7,7));
		assertFalse(Circle.isInnerPoint(10, new Vector2D(0, 0), 10.1,0));
		assertFalse(Circle.isInnerPoint(10, new Vector2D(0, 0), 8,7));
	}

}
