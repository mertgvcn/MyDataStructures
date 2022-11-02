package MyQueueWithLL;

public class TestClass {

	public static void main(String[] args) {
		MyQueueWithLL<Integer> queue = new MyQueueWithLL<Integer>();
		queue.enqueue(4);
		queue.enqueue(8);
		queue.enqueue(13);
		queue.enqueue(9);
		System.out.println(queue);

		queue.dequeue();
		System.out.println(queue);
	}

}
