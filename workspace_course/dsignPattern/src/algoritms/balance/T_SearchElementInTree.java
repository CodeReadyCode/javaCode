package algoritms.balance;

//Approach will be very simple, do any of the tree traversal and check if given element is present.
public class T_SearchElementInTree {

	public static boolean isPresent(Node root, int x) {
		if (root != null) {

			// check if current node has the element we are looking for
			if (root.data == x) {
				return true;
			} else {
				// check if the sub trees
				return isPresent(root.left, x) || isPresent(root.right, x);
			}
		}
		return false;
	}

	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);

		System.out.println("Does 4 exist in the tree: " + isPresent(root, 4));
		System.out.println("Does 7 exist in the tree: " + isPresent(root, 7));

	}
}

class Node {
	int data;
	Node left;
	Node right;

	public Node(int data) {
		this.data = data;
	}
}