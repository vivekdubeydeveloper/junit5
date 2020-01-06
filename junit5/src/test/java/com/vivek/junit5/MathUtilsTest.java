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
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
// @TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MathUtilsTest {

	MathUtils mu;

	@BeforeAll
	public static void beforeInstance() {
		System.out.println("Run Before all method");
	}

	// This method will run before each test cases
	@BeforeEach
	public void init() {
		/*
		 * do not initialize object in each fuction do it in init method
		 */
		System.out.println("Run before each testcase");
		mu = new MathUtils();
	}

	@Test
	// @Order(2)
	public void sumTest() {
		// MathUtils mu = new MathUtils();
		int x = 3, y = 4, expected = 7;
		System.out.println("Sum test");
		Assertions.assertTrue(mu.sum(x, y) == expected);
	}

	//@Test
	// @Order(1)
	@RepeatedTest(4)
	public void calCircleArea() {
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
