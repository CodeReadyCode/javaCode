package algoritms.queue;

import java.util.Stack;

public class QueueByOneStack {

	private Stack<Integer> stack = new Stack<Integer>();

	public void enQueue(int data) {
		stack.push(data);
	}

	public Integer deQueue() {
		int temp = stack.pop();
		if (stack.isEmpty()) {
			return temp;
		}
		int result = deQueue();
		stack.push(temp);
		return result;

		// Integer top = stack.pop();
		// System.out.println(top+"??");
		// if (stack.isEmpty())
		// return top;
		// else {
		// Integer result = deQueue();
		// System.out.println(top+"!!");
		// stack.push(top);
		// return result;
		// }

	}

	public void printQueue() {

		while (!stack.isEmpty()) {
			System.out.println(stack.pop());
		}
	}

	public static void main(String[] args) {

		QueueByOneStack q = new QueueByOneStack();
		q.enQueue(5);
		q.enQueue(9);
		q.enQueue(8);
		q.enQueue(10);
		// q.printQueue();
		System.out.println("*******");
		q.enQueue(99);
		q.deQueue();
		System.out.println("*******");
		q.printQueue();

	}
}
