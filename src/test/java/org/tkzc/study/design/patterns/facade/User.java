package org.tkzc.study.design.patterns.facade;

import org.junit.Test;

public class User {

	@Test
	public void testCompany() {
		Computer computer = new Computer();
		computer.startup();
		computer.shutdown();
	}
}
