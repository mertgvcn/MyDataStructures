package MyQueueWithArray;

public class MyQueueWithArray {
	private int[] queue;
	private int first;
	private int last;
	private int size;
	private int currentSize;
	
	public MyQueueWithArray(int size) {
		this.size = size;
		queue = new int[size];
		first = 0;
		last = -1;
		currentSize = 0;
	}
	
	//enqueue & dequeue
	public void enqueue(int data) {
		if(isFull()) {
			System.out.println("List is full");
		}else {
			last = (last+1) % size;
			queue[last] = data;
			currentSize++;
		}	
	}
	
	public void dequeue() {
		if(isEmpty()) {
			System.out.println("List is empty");
		}else {
			queue[first] = 0;
			first = (first+1) % size;
			currentSize--;
		}
	}
	
	//SUPPORT
	public boolean isEmpty() {
		if(currentSize == 0) {
			return true;
		}
		
		return false;
	}
	
	public boolean isFull() {
		if(currentSize == size) { 
			return true;
		}
		
		return false;
	}
	
	public String toString() {
		StringBuilder msg = new StringBuilder();
		int i;
			
		if(currentSize == 1) {
			msg.append(queue[first]);
		}
		else if(last > first) { //circular yaptýðýmýz için else fronttan küçük olmýþ olabilir.
			for (i = first; i <= last; i++) {			
				msg.append(queue[i]);
				msg.append(" ");
			}
		}
		else if(last < first) {
			for (i = first; i<= last+size; i++) {
				msg.append(queue[i%size]);
				msg.append(" ");
			}
		}
		
		return msg.toString();
	}
}
