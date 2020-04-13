/**
 * 
 */
package com.chenbitao.actioninjava.algorithm.structure.tree;

/**
 * @author peter
 * 树的节点
 */
public class TreeNode<T> {

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}

	public TreeNode<T> getLeft() {
		return left;
	}

	public void setLeft(TreeNode<T> node) {
		this.left = node;
	}

	public TreeNode<T> getRight() {
		return right;
	}

	public void setRight(TreeNode<T> right) {
		this.right = right;
	}

	public TreeNode(T value) {
		this.value = value;
	}
	private T value;

	private TreeNode<T> left;

	private TreeNode<T> right;
}
