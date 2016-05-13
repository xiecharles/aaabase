package org.tkzc.study.design.patterns.singleton.sync.method;

import org.junit.Test;

public class SingletonTest {

	@Test
	public void testSingletonSyncMethod() {
		for(int i=0; i<5; i++) {
			Singleton instance = Singleton.getInstance();
			System.out.println(instance);
		}
	}
	
	@Test
	public void testSingletonSyncMethodMultiThread() {
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
