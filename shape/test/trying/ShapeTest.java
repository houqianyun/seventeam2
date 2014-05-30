package trying;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;


public class ShapeTest {
	@Test
	public void isValidShape() {
		assertTrue(new Shape(new double[]{1,1,1,1,1}).isValidShape());
		assertFalse(new Shape(new double[]{0,1,1,1,1}).isValidShape());
		assertFalse(new Shape(new double[]{1,0,1,1,1}).isValidShape());
		assertFalse(new Shape(new double[]{1,1,0,1}).isValidShape());
		assertFalse(new Shape(new double[]{1,1,1,0,1,1}).isValidShape());
	}
	@Test
	public void moreTestMethods() {
		assertTrue(new Shape(new double[]{1,1,1,1,1}).hasNEqualSides(5));
		assertTrue(new Shape(new double[]{1,6,4,1,1}).hasNEqualSides(3));
		assertFalse(new Shape(new double[]{1,1,3,1}).hasNEqualSides(3));
		assertFalse(new Shape(new double[]{1,3,4,2,5,6}).hasNEqualSides(6));
	}

	@Test
	public void test() {
	}

}
