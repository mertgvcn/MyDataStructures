package MyStackWithArray;

public class TestClass {

	public static void main(String[] args) {
		MyStackWithArray stack = new MyStackWithArray(5);

		stack.push(3);
		stack.push(5);
		stack.push(6);
		stack.push(5);
		stack.push(3);
		
		System.out.println(printStack(stack));
		deleteMiddle(stack);
		System.out.println(printStack(stack));

	}

	// because user can reach only top of the stack, i am writing functional methods on here

	public static String printStack(MyStackWithArray stack) {
		MyStackWithArray tempStack = new MyStackWithArray(stack.getSize());
		int poppedValue;
		StringBuilder msg = new StringBuilder();

		if (stack.isEmpty()) {
			msg.append("Stack is empty");
			
		} else {

			while (!stack.isEmpty()) {
				poppedValue = stack.pop();
				tempStack.push(poppedValue);
			}

			while (!tempStack.isEmpty()) {
				poppedValue = tempStack.pop();
				msg.append(poppedValue);
				stack.push(poppedValue);
			}
		}

		return msg.toString();
	}

	public static boolean isPalindrome(MyStackWithArray stack) {
		MyStackWithArray reverseStack = new MyStackWithArray(stack.getSize());
		MyStackWithArray tempStack = stack;
		int poppedValue;

		if (stack.isEmpty()) {
			System.out.println("Stack is empty");
		} else {

			while(!tempStack.isEmpty()) {
				poppedValue = tempStack.pop();  //normal stack'ten de poplanýyor, hata burda?
				reverseStack.push(poppedValue);
			}

		}
		
		if(printStack(reverseStack).equals(printStack(stack))) {
			return true;
		}
		
		return false;
	}
	
	public static void deleteMiddle(MyStackWithArray stack) {
		MyStackWithArray temp = new MyStackWithArray(stack.getSize() / 2);
		int poppedValue;
		
		if(stack.getSize() % 2 == 0) {
			System.out.println("Your stack has even size");
		}
		
		for (int i = 0; i < stack.getSize()/2; i++) {
			poppedValue = stack.pop();
			temp.push(poppedValue);
		}
		
		stack.pop();
		
		while(!temp.isEmpty()) {
			poppedValue = temp.pop();
			stack.push(poppedValue);
		}
	}

}
