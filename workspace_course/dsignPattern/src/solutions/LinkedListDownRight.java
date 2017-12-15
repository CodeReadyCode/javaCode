package solutions;

public class LinkedListDownRight {

	static class Node{
		Node right;
		Node down;
		int data;
		
		public Node(int data) {
			this.data = data;
		}
	}
	
	
	public static void main(String[] args) {
		
		int[][] array = {{1,2,3},{4,5,6},{7,8,9}};

		downRightLinkedList(array);
	}


	private static void downRightLinkedList(int[][] array) {
		
		Node current = new Node(array[0][0]);
		Node head = current;
		Node rowDown =  null;
		boolean flag = true;
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length; j++) {
				if(i == array.length - 1 || j == array.length - 1){
					current.right = new Node(array[i][j]);
					continue;
				}
				Node down = new Node(array[i+1][j]);
				if(flag == true){
					rowDown = down;
					flag = false;
				}
				Node right = new Node(array[i][j+1]);
				current.right = right;
				current.down = down;
				current = current.right;
			}
			flag = true;
			current = rowDown;
			
		}
		
		Node down = head;
		Node right = head;
		while (down != null) {
			while (right != null) {
				System.out.println(right.data);
				right = right.right;
			}
			down = down.down;
			right = down;
		}
		
	}

}
