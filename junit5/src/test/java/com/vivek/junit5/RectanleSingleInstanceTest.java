package com.vivek.junit5;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.EnabledIf;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
@TestInstance(Lifecycle.PER_CLASS)
public class RectanleSingleInstanceTest {
	
	Rectangle r;
	@BeforeAll
	public void begin() {
		System.out.println("Before anything");
	}
	
	@BeforeEach
	public void init() {
		r=new Rectangle();
		System.out.println("Before Each testcase");
	}
	
	@Test
	//@EnabledOnOs(OS.LINUX)
	@DisabledOnOs({OS.LINUX,OS.MAC})
	@DisplayName("testing rectangle area")
	void testCalArea() {
		double l=10,w=5,a=50;
		Assertions.assertEquals(a, r.calArea(l, w));
	}
	
	@Test
	@Disabled
	public void testRectPerimeter() {
		Assertions.fail("This method is not implemented");
	}
	
	@Test
	public void divideByZero() {
		int a=5,b=5;
		Assumptions.assumeTrue(b==0);
		Assertions.assertThrows(ArithmeticException.class, ()->{int r=a/b;});
	}
	
	@Test
	public void testMultipleAssertion() {
		Assertions.assertAll(
				()->Assertions.assertEquals(25, r.calArea(5, 5)),
				()->Assertions.assertEquals(75, r.calArea(15, 5)),
				()->Assertions.assertEquals(50, r.calArea(10, 5)),
				()->Assertions.assertEquals(100, r.calArea(20, 5)),
				()->Assertions.assertEquals(125, r.calArea(25, 5))
				
				);
	}
	
	@AfterEach
	public void cleanup() {
		System.out.println("After Each Testcase");
		
	}
	
	@AfterAll
	public void end() {
		System.out.println("After everything");
	}

}
