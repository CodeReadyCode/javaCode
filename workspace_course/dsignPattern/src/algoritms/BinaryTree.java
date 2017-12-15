package algoritms;

import java.util.Stack;

/* * Java Program to print all leaf nodes of binary tree * using recursion * input : 
 * a * / \ * b f * / \ / \ * c e g h * / \ * d k * * output: d e g k */
public class BinaryTree {
	// http://www.java67.com/2016/10/how-to-print-leaf-nodes-of-binary-tree-without-recursion-in-java.html
	public static void main(String[] args) throws Exception { // let's create a
																// binary tree
		TreeNode d = new TreeNode("d");
		TreeNode e = new TreeNode("e");
		TreeNode g = new TreeNode("g");
		TreeNode k = new TreeNode("k");
		TreeNode c = new TreeNode("c", d, null);
		TreeNode h = new TreeNode("h", k, null);
		TreeNode b = new TreeNode("b", c, e);
		TreeNode f = new TreeNode("f", g, h);
		TreeNode root = new TreeNode("a", b, f);
		// print all leaf nodes of binary tree using recursion
		System.out.println("Printing all leaf nodes of binary tree in Java (recursively)");
		printLeaves(root);
		
		
		
	}

	/**
	 * A class to represent a node in binary tree
	 */
	private static class TreeNode {
		String value;
		TreeNode left;
		TreeNode right;

		TreeNode(String value) {
			this.value = value;
		}

		TreeNode(String data, TreeNode left, TreeNode right) {
			this.value = data;
			this.left = left;
			this.right = right;
		}

		boolean isLeaf() {
			return left == null ? right == null : false;
		}
	}

	public static void printLeaves(TreeNode node) {
		if (node == null) {
			return;
		}
		System.out.println(node.value);
		if (node.isLeaf()) {
			// System.out.printf("%s ", node.value);
		}
		printLeaves(node.left);
		printLeaves(node.right);
	}

	public static void printLeaf(TreeNode root) {
		if (root == null) {
			return;
		}
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		while (!stack.isEmpty()) {
			TreeNode node = stack.pop();
			if (node.left != null) {
				stack.add(node.left);
			}
			if (node.right != null) {
				stack.add(node.right);
			}
			if (node.isLeaf()) {
				System.out.printf("%s ", node.value);
			}
		}
	}
}
