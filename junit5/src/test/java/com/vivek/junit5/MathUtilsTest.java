package com.vivek.junit5;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
	public void sumTest() {
		// MathUtils mu = new MathUtils();
		int x = 3, y = 4, expected = 7;
		Assertions.assertTrue(mu.sum(x, y) == expected);
	}

	@Test
	public void calCircleArea() {
		// MathUtils mu = new MathUtils();
		int radius = 10;
		double expected = 314.1592653589793;

		Assertions.assertEquals(expected, mu.calCircleArea(radius), "The calculated circle area is not correct");

	}

	@Test
	public void testDivide() {
		int f = 6, s = 0;
		// MathUtils mu = new MathUtils();
		Assertions.assertThrows(ArithmeticException.class, () -> mu.divide(f, s));
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
