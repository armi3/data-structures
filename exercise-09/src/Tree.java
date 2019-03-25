

public interface Tree {

	static Node build(Node headInputPostfix, Container stack) {
		String valueBeingCaptured = "";
		boolean nextIsSigned = false;

		for (int i = 0; i < postfix.length; i++) {

			if (Parser.isValue(postfix[i])) {
				valueBeingCaptured += postfix[i];
				while (Parser.isValue(postfix[i+1])) {
					valueBeingCaptured += postfix[i+1];
					i++;
				}
				ValueNode node = new ValueNode(Double.parseDouble(valueBeingCaptured));
				if (nextIsSigned) {
					node.setValue(node.getValue()*-1);
					nextIsSigned = false;
				}
				stack.in(node);
				valueBeingCaptured = "";
			}

			else if(postfix[i]=='x') {
				VariableNode node = new VariableNode(postfix[i]);
				if (nextIsSigned) {
					node.setNegative(!node.isNegative());
					nextIsSigned = false;
				}
				stack.in(node);
			}

			else if(postfix[i]=='+') {

			}

			else if(postfix[i]=='-') {

			}

			else if(postfix[i]=='*') {

			}

			else if(postfix[i]=='/') {

			}

			else if(postfix[i]=='^') {

			}

			else if(postfix[i]=='(') {

			}

			else if(postfix[i]==')') {

			}

		}

		Node root = stack.out();
		return root;
	}
	
	static Node buildDerivative(Node rootInput, Container stack) {
		return rootInput;
		//return rootOutput;
		
	}
	
	static String unbuild(Node rootOutput, Container stack){
		return null;
		
	}
}
