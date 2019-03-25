
public interface LinkedList {
	
	static Node build(String inputInfix, Container stack) {
		char[] inputInfixArray = inputInfix.toCharArray();
		Node headInputPostfix = new OperationNode(inputInfixArray[0]);
		return headInputPostfix;
	}

}
