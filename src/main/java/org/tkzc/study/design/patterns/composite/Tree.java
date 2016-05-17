package org.tkzc.study.design.patterns.composite;

public class Tree {

	TreeNode root;
	
	public Tree(String name) {
		root = new TreeNode(name);
	}
}
