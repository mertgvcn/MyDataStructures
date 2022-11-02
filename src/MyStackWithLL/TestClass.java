package MyStackWithLL;

public class TestClass {

	public static void main(String[] args) {
		
		String str = " (1+((2+3)*(4*5)))";
		System.out.println(DijkstrasExpressionEvaluation(str));
		
		String str2 = "((4+5) * (4/2))";
		System.out.println(DijkstrasExpressionEvaluation(str2));
		
	}

	public static int DijkstrasExpressionEvaluation(String str) {
		MyStackWithLL<Integer> valueStack = new MyStackWithLL<Integer>();
		MyStackWithLL<Character> operatorStack = new MyStackWithLL<Character>();
		int result;
		
		for (int i = 0; i < str.length(); i++) {
			if(str.charAt(i) == '(' || str.charAt(i) == ' ') {
				continue;
			}			
			else if(str.charAt(i) == '+' || str.charAt(i) == '-' || str.charAt(i) == '/' || str.charAt(i) == '*' ) {
				operatorStack.push(str.charAt(i));
			}
			else if(str.charAt(i) == ')') {
				
				char c = operatorStack.pop().data;
				int num1 = valueStack.pop().data;
				int num2 = valueStack.pop().data;
				
				switch(c) {
					case '+' : 
						result = (num2 + num1);
						valueStack.push(result);
						break;
					case '-' :
						result = (num2 - num1);
						valueStack.push(result);
						break;
					case '/' : 
						result = (num2 / num1);
						valueStack.push(result);
						break;
					case '*' :
						result = (num2 * num1);
						valueStack.push(result);
						break;
				}
				
			}else {
				int data = Character.getNumericValue(str.charAt(i));
				valueStack.push(data);
			}
		}
		
		
		int total = (int) valueStack.top.data;
		return total;
	}
}
