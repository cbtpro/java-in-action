package com.chenbitao.actioninjava.algorithm.structure.tree;

import java.util.ArrayList;
import java.util.List;

public class TreeNodeTest {

	static List<String> list;
	static {
		String[] nodes = new String[] {"A", "B", "C", null, null,  "D", "E"};
		list = new ArrayList<>();
		for (int i = nodes.length - 1; i >= 0 ; i--) {
			list.add(nodes[i]);
		}
	}
	
	public static void main(String[] args) {
		// 得到了一个便于操作的倒叙数组
		TreeNode<String> root = new TreeNode<>(list.remove(list.size() - 1));
		while(list.size() > 0) {
			assembleNode(root);
		}
	}
	public static TreeNode<String> assembleNode(TreeNode<String> root) {
		String val = list.remove(list.size() - 1);
		if (val == null) {
			return new TreeNode<String>(val);
		} else {
			TreeNode<String> left = new TreeNode<String>(val);
			root.setLeft(left);
		}
		String val1 = list.remove(list.size() - 1);
		if (val1 == null) {
			return new TreeNode<String>(val1);
		} else {
			TreeNode<String> right = new TreeNode<String>(val1);
			root.setRight(right);
		}
		return root;
	}
}
