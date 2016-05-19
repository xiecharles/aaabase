package org.tkzc.study.design.patterns.strategy;

import org.junit.Test;

public class StrategyTest {

	@Test
	public void testPlus() {
		String exp = "4+2";
		ICalculator cal = new Plus();
		int result = cal.calculate(exp);
		System.out.println(result);
	}
	
	@Test
	public void testMinus() {
		String exp = "4-2";
		ICalculator cal = new Minus();
		int result = cal.calculate(exp);
		System.out.println(result);
	}
	
	@Test
	public void testMultiply() {
		String exp = "8*2";
		ICalculator cal = new Multiply();
		int result = cal.calculate(exp);
		System.out.println(result);
	}
}
