package MyStackWithArray;

public class TestClass {

	public static void main(String[] args) throws CloneNotSupportedException {
		MyStackWithArray stack = new MyStackWithArray(5);

		stack.push(3);
		stack.push(5);
		stack.push(6);
		stack.push(5);
		stack.push(3);
		
		System.out.println(stack.printStack());
		System.out.println(stack.isPalindrome());


	}
}
