package Model;

public class VariableNode implements Node {
	private Node parent;
	private boolean negative;
	private char variable;
	
	public Node getParent() {
		return parent;
	}
	public boolean isNegative() {
		return negative;
	}
	public char getVariable() {
		return variable;
	}
	public void setParent(Node parent) {
		this.parent = parent;
	}
	public void setNegative(boolean negative) {
		this.negative = negative;
	}
	public void setVariable(char variable) {
		this.variable = variable;
	}
	
}
