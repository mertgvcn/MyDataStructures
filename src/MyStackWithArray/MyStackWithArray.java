package MyStackWithArray;

public class MyStackWithArray implements Cloneable{
	private int[] myStack;
	private int size;
	public int top;

	public MyStackWithArray(int size) {
		myStack = new int[size];
		this.size = size;
		top = -1;
	}
	
	public int peek() { //shows top value
		if(isEmpty()) {
			System.out.println("Stack is empty! Returning (-1) ...");
			return -1;
		}
		
		return myStack[top];
	}
	
	public void push(int data) {
		if(!isFull()) {
			top++;
			myStack[top] = data;
		}
	}
	
	public int pop() {		
		if(!isEmpty()) {
			int topValue = myStack[top];
			top--;
			return topValue;
		}
		
		return -1;
	}

	//SUPPORT
	public boolean isEmpty() {
		return (top == -1);
	}

	public boolean isFull() {
		return (top == (size - 1));
	}
	
	public Object copy() throws CloneNotSupportedException { //geçici stackler oluþturacaðýmýz zaman iþe yarayabilir.
		return this.clone();								 //this'in özelliklerine sahip yeni bir obje oluþturur.
	}
	
	//GETTER SETTER
	public void setSize(int size) {
		this.size = size;
	}
	
	public int getSize() {
		return size;
	}
	
}
