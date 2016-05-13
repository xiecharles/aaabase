package org.tkzc.study.design.patterns.singleton.staticc;

import org.junit.Test;

public class SingletonTest {

	@Test
	public void testSingletonStatic() {
		for(int i=0; i<5; i++) {
			Singleton instance = Singleton.getInstance();
			System.out.println(instance);
		}
	}
	
	@Test
	public void testSingletonStaticMultiThread() {
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
