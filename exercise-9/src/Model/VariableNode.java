package Model;

public class VariableNode implements Node {
	private Node parent;
	private char variable;
	
	public Node getParent() {
		return parent;
	}
	public char getVariable() {
		return variable;
	}
	public void setParent(Node parent) {
		this.parent = parent;
	}
	public void setVariable(char variable) {
		this.variable = variable;
	}
	
}
