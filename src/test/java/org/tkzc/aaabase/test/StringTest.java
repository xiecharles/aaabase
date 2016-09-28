package org.tkzc.aaabase.test;

import org.junit.Test;

public class StringTest {

	@Test
	public void testEqualsNullParam() {
		if("a".equals(null)) {
			System.out.println("a equals null");
		} else {
			System.out.println("a not equals null");
		}
	}
}
