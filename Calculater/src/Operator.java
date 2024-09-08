
public class Operator {

	public static int precedure(char operator) {
		
		switch(operator){
			
			case '+':
			case '-':
				return 1;
				
			case '×':
			case '*':
			case '÷':
			case '/':
				return 2;
				
			case '(':
			case ')':
				return 0;
				
			default:
				throw new IllegalStateException("不適切な演算子：" + operator);
			
		}
	}
	
	public static double applyOperator(char operator, double b, double a) {
		
		switch(operator) {
		
			case '+':
				return a + b;
				
			case '-':
				return a - b;
				
			case '×':
			case '*':
				return a * b;
				
			case '÷':
			case '/':
				if(b == 0) {
					throw new ArithmeticException("0で割ることはできません。");
				}
				return a / b;
			
			default:
				throw new IllegalStateException("不適切な演算子：" + operator);
		}
	}
	
	public static String addMultiplication(String input) {
		
		StringBuilder preInput = new StringBuilder();
		
		for(int i=0; i<input.length(); i++) {
			
			char c = input.charAt(i);
			preInput.append(c);
			
			if(i<input.length()-1 && Character.isDigit(c) && input.charAt(i+1) =='(') {
				preInput.append('*');
			}
			
			if(i<input.length()-1 && c == ')' && input.charAt(i+1) =='(') {
				preInput.append('*');
			}
		}
		return preInput.toString();
	}
}
