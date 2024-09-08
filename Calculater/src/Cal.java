import java.util.Stack;

public class Cal {

	public static double calInput(String input) {
		
		StringBuilder numberBuffer = new StringBuilder();
		Stack<Double> numbers = new Stack<>();
		Stack<Character> operators = new Stack<>();
		
		for(int i=0; i<input.length(); i++) {
			
			char c = input.charAt(i);
			
			if(Character.isDigit(c) || c == '.') {
				numberBuffer.append(c);
			}else {
				if(numberBuffer.length() > 0) {	//演算子、括弧の時点で、numberBufferに格納していた数値をnumbersスタックに格納する
					double doubleNumber = Convert.toDouble(numberBuffer);
					numbers.push(doubleNumber);
					numberBuffer.setLength(0);
				}
				if(c == '(') {
					operators.push(c);
				}
				else if(c == ')') {
					while(operators.peek() != '(') {
						double subResult = Operator.applyOperator(operators.pop(), numbers.pop(), numbers.pop());
						numbers.push(subResult);
					}
					operators.pop();
				}
				else if(c == '+' || c == '-' || c == '×' || c == '*' || c == '÷' || c == '/') {
					if(!operators.isEmpty() && Operator.precedure(c) <= Operator.precedure(operators.peek())) {
						double subResult = Operator.applyOperator(operators.pop(), numbers.pop(), numbers.pop());
						numbers.push(subResult);
					}
					operators.push(c);
				}
			}
		}
		if(numberBuffer.length() > 0) {
			double doubleNumber = Convert.toDouble(numberBuffer);
			numbers.push(doubleNumber);
			numberBuffer.setLength(0);
		}
		while(!operators.isEmpty()) {
			double subResult = Operator.applyOperator(operators.pop(), numbers.pop(), numbers.pop());
			numbers.push(subResult);
		}
		return numbers.pop();
	}
}
