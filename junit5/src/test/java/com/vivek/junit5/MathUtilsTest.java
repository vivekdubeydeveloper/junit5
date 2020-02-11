package com.vivek.junit5;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.TestReporter;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
// @TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MathUtilsTest {

	MathUtils mu;
	TestInfo ti;
	TestReporter tr;
	

	@BeforeAll
	public static void beforeInstance() {
		System.out.println("Run Before all method");
	}

	// This method will run before each test cases
	@BeforeEach
	public void init(TestInfo ti,TestReporter tr) {
		/*
		 * do not initialize object in each fuction do it in init method
		 */
		System.out.println("Run before each testcase");
		this.ti=ti;
		this.tr=tr;
		tr.publishEntry("This is "+ti.getTestMethod());
		mu = new MathUtils();
	}

	@Test
	// @Order(2)
	@DisplayName("Sum Test Function")
	public void sumTest() {
		
		System.out.println("This is "+ti.getDisplayName());
		// MathUtils mu = new MathUtils();
		int x = 3, y = 4, expected = 7;
		System.out.println("Sum test");
		Assertions.assertTrue(mu.sum(x, y) == expected);
	}

	//@Test
	// @Order(1)
	@RepeatedTest(4)
	@Tag("Circle")
	public void calCircleArea(RepetitionInfo rinfo) {
		System.out.println(rinfo.getCurrentRepetition());
		if(rinfo.getCurrentRepetition()==1) {
			//perform logic1
		}else if(rinfo.getCurrentRepetition()==2) {
			//perform logic 2
		}
		// MathUtils mu = new MathUtils();
		int radius = 10;
		double expected = 314.1592653589793;
		System.out.println("Cal circle area test");
		Assertions.assertEquals(expected, mu.calCircleArea(radius), "The calculated circle area is not correct");

	}

	@Test
	public void testDivide() {
		int f = 6, s = 0;
		// MathUtils mu = new MathUtils();
		Assertions.assertThrows(ArithmeticException.class, () -> mu.divide(f, s));
	}

	// if want to group some test cases

	@Nested
	@DisplayName("Test Sum of 2 numbers")
	class SumTest {

		@Test
		@DisplayName("Test + no sum")
		public void testPositiveNumber() {
           Assertions.assertEquals(12, mu.sum(5, 7));
		}

		@Test
		@DisplayName("Test - no sum")
		public void testNegativeNumber() {
			 Assertions.assertEquals(-12, mu.sum(-5, -7));
		}

		@Test
		@DisplayName("Test 0 no sum")
		public void testZeroNumber() {
			Assertions.assertEquals(5, mu.sum(5, 0),()->"expected is not actual");
		}
	}

	@AfterEach
	public void cleanUp() {
		System.out.println("Run after each testcase");
	}

	@AfterAll
	public static void afterInstance() {
		System.out.println("Run After all method");
	}

}
