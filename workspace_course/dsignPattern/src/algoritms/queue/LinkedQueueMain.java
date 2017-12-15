package algoritms.queue;

public class LinkedQueueMain {

	public static void main(String[] args) {
		
		LinkedQueue q = new LinkedQueue();
		q.enqueue(new Integer(5));
		q.enqueue(new Integer(6));
		q.enqueue(new Integer(7));
		q.dequeue();
		q.enqueue(new Integer(8));
		
		q.printQ();
	}

}

