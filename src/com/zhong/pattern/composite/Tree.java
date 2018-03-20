package com.zhong.pattern.composite;
/**
 * 组合模式有时又叫部分-整体模式在处理类似树形结构的问题时比较方便.
 * 
 * 使用场景：将多个对象组合在一起进行操作，常用于表示树形结构中，例如二叉树，数等。
 * @author admin
 *
 */
public class Tree {

	TreeNode root = null;

	public Tree(String name, Object data) {
		root = new TreeNode(name, data);
	}

	public static void main(String[] args) {
		
		Tree tree = new Tree("A", "dataA");
		
		TreeNode nodeB = new TreeNode("B", "dataB");
		TreeNode nodeC = new TreeNode("C", "dataC");
		
		nodeB.add(nodeC);
		tree.root.add(nodeB);
		System.out.println("build the tree finished!");
	}
}
