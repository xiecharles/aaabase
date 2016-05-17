package org.tkzc.study.design.patterns.composite;

import org.junit.Test;

public class TreeTest {

	@Test
	public void testTree() {
		Tree tree = new Tree("root");
		TreeNode node1 = new TreeNode("A");
		TreeNode node2 = new TreeNode("B");
		// 组合节点
		node1.add(node2);
		tree.root.add(node1);
		System.out.println("builder the tree finished!");
	}
}
