package algoritms.queue;

import java.util.Stack;

public class QueueByTwoStacks {
	
	private Stack<Integer> stack1 = new Stack<Integer>();
	private Stack<Integer> stack2 = new Stack<Integer>();


	
	public void enQueue(int data){
		
		while(!stack1.isEmpty()){
			stack2.push(stack1.pop());
		}
		
		stack1.push(data);
		
		while(!stack2.isEmpty()){
			stack1.push(stack2.pop());
		}
	}

	
	public Integer deQueue(){
		
		if(stack1.isEmpty()){
			System.out.println("Error, no element in Q");
		}
		
		return stack1.pop();
		
	}
	
	public void printQueue(){
		
		while(!stack1.isEmpty()){
			System.out.println(stack1.pop());
		}
	}
	public static void main(String[] args) {
		
		QueueByTwoStacks  q = new QueueByTwoStacks();
		q.enQueue(5);
		q.enQueue(9);
		q.enQueue(8);
		q.enQueue(10);
	//	q.printQueue();
		System.out.println("*******");
		q.enQueue(9);
		q.deQueue();
		System.out.println("*******");
		q.printQueue();
		
		
		
	}
}
