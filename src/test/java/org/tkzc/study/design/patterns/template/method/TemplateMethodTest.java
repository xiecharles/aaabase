package org.tkzc.study.design.patterns.template.method;

import org.junit.Test;

public class TemplateMethodTest {

	@Test
	public void testPlus() {
		String exp = "8+2";
		AbstractCalculator calc = new Plus();
		int result = calc.calculate(exp, "\\+");
		System.out.println(result);
	}
}
