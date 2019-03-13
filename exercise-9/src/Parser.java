

public interface Parser {
	static boolean isOperator(char charToEvaluate) {
		if (charToEvaluate == '+' || charToEvaluate == '-' || charToEvaluate == '*' || charToEvaluate == '/' || charToEvaluate == '^') {
			return true;
		} else {
			return false;
		}
	}
	
	static boolean isValue(char charToEvaluate) {
		if (charToEvaluate == '0' || charToEvaluate == '1' || charToEvaluate == '2' || charToEvaluate == '3' || charToEvaluate == '4' || charToEvaluate == '5' || charToEvaluate == '6' || charToEvaluate == '7' || charToEvaluate == '8' || charToEvaluate == '9' || charToEvaluate == '.') {
			return true;
		} else {
			return false;
		}
	}

	static boolean isUnary(char[] postfix, int i) {
		if((!isOperator(postfix[i-1]) && !isOperator(postfix[i+1]))
				|| (!isOperator(postfix[i-1]) && postfix[i+1]=='(')
				|| (postfix[i-1]==')' && !isOperator(postfix[i+1]))
				|| (postfix[i-1]==')' && postfix[i-1]=='(')) {
			return false;
		} else {
			return true;
		} 
	}

}
