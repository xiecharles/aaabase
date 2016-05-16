package org.tkzc.study.design.patterns.prototype;

import java.io.IOException;

import org.junit.Test;

public class PrototypeTest {

	@Test
	public void testPrototype() {
		Prototype pro0 = new Prototype();
		pro0.setStr("test");
		pro0.setObj(new AnyObject());
		System.out.println(pro0.getStr());
		System.out.println(pro0.getObj());
		// 复制pro0
		// 1.浅复制
		try {
			Prototype pro1 = (Prototype) pro0.clone();
			System.out.println(pro1.getStr());
			System.out.println(pro1.getObj());
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		// 2.深复制
		try {
			Prototype pro2 = (Prototype) pro0.deepClone();
			System.out.println(pro2.getStr());
			System.out.println(pro2.getObj());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
