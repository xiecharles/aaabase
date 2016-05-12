package org.tkzc.study.design.patterns.singleton.general;

import org.junit.Test;

public class SingletonTest {

	@Test
	public void testSingletonGeneral() {
		Singleton instance0 = Singleton.getInstance();
		System.out.println(instance0);
		Singleton instance1 = Singleton.getInstance();
		System.out.println(instance1);
	}
	
	@Test
	public void testSingletonGeneralMultiThread() {
		new Thread(new Runnable() {
			@Override
			public void run() {
				Singleton instance0 = Singleton.getInstance();
				System.out.println(instance0);
			}
		}).start();
	}
}
