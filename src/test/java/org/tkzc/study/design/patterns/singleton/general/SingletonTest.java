package org.tkzc.study.design.patterns.singleton.general;

import org.junit.Test;

public class SingletonTest {

	@Test
	public void testSingletonGeneral() {
		for(int i=0; i<5; i++) {
			Singleton instance = Singleton.getInstance();
			System.out.println(instance);
		}
	}
	
	@Test
	public void testSingletonGeneralMultiThread() {
		// 多执行几次单元测试就会发现有不同的实例出现
		for(int i=0; i<5; i++) {
			new Thread() {
				@Override
				public void run() {
					Singleton instance0 = Singleton.getInstance();
					System.out.println(instance0);
				}
			}.start();
		}
	}
}
