package ca.ubc.cpsc210.paddleball.test;

import ca.ubc.cpsc210.paddleball.model.PBG;
import ca.ubc.cpsc210.paddleball.model.Paddle;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
 * Unit tests for the Paddle class.
 */
class TestPaddle {
	private static final int XLOC = PBG.DIMENSION1 / 2;
	private Paddle p;
	
	@BeforeEach
	void runBefore() {
		p = new Paddle(XLOC);
	}
	
	@Test
	void testGetX() {
		assertEquals(XLOC, p.getXway());
	}
	
	@Test
	void testUpdate() {
		final int NUM_UPDATES = 8;
		
		p.move();
		assertEquals(XLOC + Paddle.DX, p.getXway());
		
		for(int count = 1; count < NUM_UPDATES; count++) {
			p.move();
		}
		
		assertEquals(XLOC + NUM_UPDATES * Paddle.DX, p.getXway());
	}
	
	@Test
	void testFlipDirection() {
		p.move();
		assertEquals(XLOC + Paddle.DX, p.getXway());
		p.left();
		p.move();
		assertEquals(XLOC, p.getXway());
		p.right();
		p.move();
		assertEquals(XLOC + Paddle.DX, p.getXway());
	}
	
	@Test 
	void testLeftBoundary() {
		p.left();
		for(int count = 0; count < (PBG.DIMENSION1 / 2 - Paddle.DIMENSION1 / 2) / Paddle.DX + 1; count++)
			p.move();
		assertEquals(Paddle.DIMENSION1 / 2, p.getXway());
		p.move();
		assertEquals(Paddle.DIMENSION1 / 2, p.getXway());
	}
	
	@Test
	void testRightBoundary() {
		p.right();
		for(int count = 0; count < (PBG.DIMENSION1 / 2 - Paddle.DIMENSION1 / 2) / Paddle.DX + 1; count++)
			p.move();
		assertEquals(PBG.DIMENSION1 - Paddle.DIMENSION1 / 2, p.getXway());
		p.move();
		assertEquals(PBG.DIMENSION1 - Paddle.DIMENSION1 / 2, p.getXway());
	}
}
