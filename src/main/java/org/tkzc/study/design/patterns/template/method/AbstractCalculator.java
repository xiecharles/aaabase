package org.tkzc.study.design.patterns.template.method;

public abstract class AbstractCalculator {

	/**
	 * 主方法, 实现对本类其他方法的调用
	 * @param exp
	 * @param opt
	 * @return
	 */
	public final int calculate(String exp, String opt) {
		int[] arrayInt = split(exp, opt);
		return calculate(arrayInt[0], arrayInt[1]);
	}
	
	/**
	 * 需被子类重写的方法, 子类实现实际的功能(此处只当提供一个方法的模板)
	 * @param num1
	 * @param num2
	 * @return
	 */
	abstract public int calculate(int num1, int num2);
	
	public int[] split(String exp, String opt) {
		String[] array = exp.split(opt);
		int[] arrayInt = new int[2];
		arrayInt[0] = Integer.parseInt(array[0]);
		arrayInt[1] = Integer.parseInt(array[1]);
		return arrayInt;
	}
}
