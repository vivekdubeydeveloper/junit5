package com.vivek.junit5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MathUtilsTest {
	
	@Test
	public void sumTest() {
		MathUtils mu=new MathUtils();
		int x=3,y=4,expected=7;
		Assertions.assertTrue(mu.sum(x, y)==expected);
	}

}
