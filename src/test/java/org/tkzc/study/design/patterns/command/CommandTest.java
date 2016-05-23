package org.tkzc.study.design.patterns.command;

import org.junit.Test;

public class CommandTest {

	@Test
	public void testCommand() {
		Receiver receiver  = new Receiver();
		Command command = new MyCommand(receiver);
		Invoker invoker = new Invoker(command);
		invoker.action();
	}
}
