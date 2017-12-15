package algoritms;

public class LinkedList {

	private  Node head;

	  class Node {
		private int data;
		private Node next;

		public Node(int data) {
			this.data = data;
			next = null;
		}

	}

	public void addNodeToHead(int data) {

		Node newNode = new Node(data);
		if (head == null) {
			head = newNode;
			return;
		}

		newNode.next = head;
		head = newNode;

	}

	public void addNodeToTail(int data) {
		Node newNode = new Node(data);
		newNode.next = null;
		if (head == null) {
			head = newNode;
			return;
		}

		Node tail = head;

		while (tail.next != null) {
			tail = tail.next;
		}

		tail.next = newNode;

	}

	public Node searchNodeByData(int data) {
		// list is empty
		if (head == null) {
			return null;
		}

		Node temp = head;
		while (temp != null && temp.data != data) {
			temp = temp.next;
		}
		// was not fine the key
		if (temp == null) {
			return null;
		}

		return temp;

	}

	public void printNodes() {

		if (head == null) {
			System.out.println("List is empty");
		}

		Node node = head;
		while (node != null) {

			System.out.println(node.data);
			node = node.next;

		}
	}

	public Node removeNodeByKey(int data) {
		// list is empty
		if (head == null) {
			System.out.println("list is empty");
			return null;
		}

		Node temp = head;
		Node prev = null;
		while (temp != null && temp.data != data) {
			prev = temp;
			temp = temp.next;
		}
		// was not fine the key
		if (temp == null) {
			return null;
		}

		prev.next = temp.next;

		return prev;

	}

	public void removeFirstElent() {
		// list is empty
		if (head == null) {
			System.out.println("list is empty");
			return;
		}

		Node temp = head;
		temp = temp.next;
		head = temp;

	}

	public void insertAfter(int afterNode, int data) {
		// list is empty
		if (head == null) {
			System.out.println("list is empty");
			return;
		}
		Node nodeAfter = new Node(afterNode);
		Node newNode = new Node(data);
		Node temp = head;
		Node prev = null;

		// head element is key
		if (temp.data == newNode.data) {
			newNode.next = head;
			head = newNode;

		}

		boolean flag = false;
		while (temp.next != null && !flag) {
			prev = temp;
			temp = temp.next;
			if (nodeAfter.data == temp.data) {
				flag = true;
			}
			

		}

		// if key on the end of th list
		if (temp.next == null && flag) {

			temp.next = newNode;
			newNode.next = null;
			return;
		}

		newNode.next = prev.next;
		prev.next = newNode;

	}

	public void removeLastElent() {
		// list is empty
		if (head == null) {
			System.out.println("list is empty");
			return;
		}

		Node temp = head;
		Node prev = null;
		while (temp.next != null) {
			prev = temp;
			temp = temp.next;
		}

		temp = null;
		prev.next = null;

	}

	public static void main(String[] args) {

		LinkedList list = new LinkedList();
		list.addNodeToHead(4);
		list.addNodeToHead(5);
		list.addNodeToHead(6);
		list.addNodeToTail(7);

		if (list.searchNodeByData(7) == null) {
			System.out.println("no sucg element");
		} else {
			System.out.println(list.searchNodeByData(7).data);
		}
		list.printNodes();
		System.out.println("After remove element");
		list.removeNodeByKey(5);
		list.printNodes();
		System.out.println("remove first element");
		list.removeFirstElent();
		list.printNodes();

		System.out.println("return last element");
		list.removeLastElent();
		list.printNodes();
		System.out.println("*****");
		list.addNodeToHead(6);
		list.addNodeToHead(77);
		list.addNodeToHead(84);
		
		list.printNodes();
		System.out.println("**********8");
		list.insertAfter(654, 88);
		list.printNodes();

	}

}
