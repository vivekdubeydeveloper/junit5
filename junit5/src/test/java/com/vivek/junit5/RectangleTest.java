package com.vivek.junit5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
class RectangleTest {

	@Test
	void testCalArea() {
		Rectangle rect=new Rectangle();
		double expected=50;
		double l=10,w=5;
		assertEquals(expected, rect.calArea(l, w),"The area calculation of rectangle shuold be");
	}

}
