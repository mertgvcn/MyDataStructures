package MyStackWithArray;

public class MyStackWithArray implements Cloneable{
	private int[] myStack;
	public int size;
	public int top;

	public MyStackWithArray(int size) {
		myStack = new int[size];
		this.size = size;
		top = -1;
	}
	
	//Basic Operations
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
	
	//Other Functions
	public void deleteMiddle() {
		MyStackWithArray temp = new MyStackWithArray(this.size / 2);
		int poppedValue;
		
		if(this.size % 2 == 0) {
			System.out.println("Your stack has even size");
		}
		
		for (int i = 0; i < this.size/2; i++) {
			poppedValue = this.pop();
			temp.push(poppedValue);
		}
		
		this.pop();
		
		while(!temp.isEmpty()) {
			poppedValue = temp.pop();
			this.push(poppedValue);
		}
	}
	
	public String printStack() {
		MyStackWithArray tempStack = new MyStackWithArray(this.size);
		int poppedValue;
		StringBuilder msg = new StringBuilder();

		if (this.isEmpty()) {
			msg.append("Stack is empty");
			
		} else {

			while (!this.isEmpty()) {
				poppedValue = this.pop();
				tempStack.push(poppedValue);
			}

			while (!tempStack.isEmpty()) {
				poppedValue = tempStack.pop();
				msg.append(poppedValue);
				this.push(poppedValue);
			}
		}

		return msg.toString();
	}
	
	public boolean isPalindrome() throws CloneNotSupportedException {
		MyStackWithArray reverseStack = new MyStackWithArray(this.size);
		MyStackWithArray tempStack = (MyStackWithArray) this.copy();  //direkt tempStack = stack yapsayd�k;
		int poppedValue;

		if (this.isEmpty()) {
			System.out.println("Stack is empty");
		} else {

			while(!tempStack.isEmpty()) {
				poppedValue = tempStack.pop();  //bu sat�rda normal stack'ten de poplard� ��nk� ayn�
				reverseStack.push(poppedValue); //objeyi referans g�steriyolar. Klonlayarak stack objesinin
			}							  //ayn� �zelliklerini g�steren yeni bir obje yaratt�k ve tempStacke e�itledik.

		}
		
		return reverseStack.printStack().equals(this.printStack());
	}

	//SUPPORT
	public boolean isEmpty() {
		return (top == -1);
	}

	public boolean isFull() {
		return (top == (size - 1));
	}
	
	public Object copy() throws CloneNotSupportedException { //ge�ici stackler olu�turaca��m�z zaman i�e yarayabilir.
		return this.clone();								 //this'in �zelliklerine sahip yeni bir obje olu�turur.
	}
	
}
