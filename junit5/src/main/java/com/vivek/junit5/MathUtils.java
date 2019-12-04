package com.vivek.junit5;

public class MathUtils {

	public static void main(String[] args) {

		// without test framework
		MathUtils mu = new MathUtils();
		int i1 = 5, i2 = 7, expected = 12;
		int result = mu.sum(i1, i2);
		if (result != expected) {
			System.out.println("Test Cases Failed");
		} else {
			System.out.println("Test Cases Passed");
		}
	}

	public int sum(int x, int y) {
		return x + y;

	}

	public double calCircleArea(int radius) {
		return Math.PI * (radius * radius);
	}
	
	public int divide(int f,int s) {
		return f/s;
	}

}
