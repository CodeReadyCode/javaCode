package solutions;

class BSTCloseToK {
	// A binary tree node
	static class Node {
		int data;
		Node left, right;

		Node(int item) {
			data = item;
			left = right = null;
		}
	}

	Node root;

	/* Driver program to test above functions */
	public static void main(String[] args) {
		BSTCloseToK tree = new BSTCloseToK();
		
		tree.root = new Node(2);
		tree.root.left = new Node(1);
		tree.root.right = new Node(3);
		tree.root.right.right = new Node(25);
		tree.root.right.right.right = new Node(31);
		tree.root.right.right.left = new Node(10);

		System.out.println("Height of tree is : " + tree.closeToK(tree.root, 24));
	}

	int closeToK(Node node, int k) {
		if (node == null)
			return 0;
		//if(k > node.data)
		closeToK(node.left, k);
		closeToK(node.right, k);
		
		System.out.println(node.data);
		
		int result =node.data - k;
		
		if(node.left !=null){
			if(result > node.left.data){
				result =  node.left.data - k ;
			}
		}
		
		if(node.right !=null){
			if(result > node.right.data){
				result =   node.right.data - k ;
			}
		}
		
		return result;
		
	}

}

// This code has been cpontributed by Mayank Jaiswal(mayank_24)
