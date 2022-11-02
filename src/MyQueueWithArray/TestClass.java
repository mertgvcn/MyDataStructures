package MyQueueWithArray;

public class TestClass {

	public static void main(String[] args) {
		MyQueueWithArray q = new MyQueueWithArray(5);
		q.enqueue(5);
		q.enqueue(8);
		q.enqueue(9);
		q.enqueue(12);
		q.enqueue(15);
		q.dequeue();
		q.dequeue();
		q.dequeue();
		q.enqueue(13);
		q.enqueue(21);
		q.enqueue(11);
		
		System.out.println(q);
		
	}

}
