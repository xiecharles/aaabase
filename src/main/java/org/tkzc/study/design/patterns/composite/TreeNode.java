package org.tkzc.study.design.patterns.composite;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TreeNode {

	private String name;
	
	private TreeNode parent;
	
	private List<TreeNode> children = new ArrayList<TreeNode>();

	public TreeNode(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public TreeNode getParent() {
		return parent;
	}

	public void setParent(TreeNode parent) {
		this.parent = parent;
	}
	
	/**
	 * 添加孩子节点
	 * @param node
	 */
	public void add(TreeNode node) {
		children.add(node);
	}
	
	/**
	 * 删除孩子节点
	 * @param node
	 */
	public void remove(TreeNode node) {
		children.remove(node);
	}
	
	/**
	 * 获得孩子节点
	 * @return
	 */
	public Iterator<TreeNode> getChildren() {
		return children.iterator();
	}
}
