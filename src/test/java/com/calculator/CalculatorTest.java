package com.calculator;

import org.junit.Test;
import static org.junit.Assert.*;

public class CalculatorTest{

	Calculator calc = new Calculator();

	@Test
	public void testSqrt() {
		assertEquals(3.0, calc.sqrt(9), 0);
	}

	@Test
	public void testFactorial() {
		assertEquals(120, calc.factorial(5));
	}

	@Test
	public void testPower() {
		assertEquals(8, calc.power(2, 3), 0);
	}
}
