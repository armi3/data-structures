

public class VariableNode extends Node{
	private Node parent;
	private Node right;
	private Node left;
	private char variable;
	private boolean negative;

	VariableNode(char variable){
		super();
		this.parent = null;
		this.right = null;
		this.left = null;
		this.variable = variable;
		this.negative = false;
	}

	public char getVariable() {
		return variable;
	}

	public boolean isNegative() {
		return negative;
	}

	public void setVariable(char variable) {
		this.variable = variable;
	}

	public void setNegative(boolean negative) {
		this.negative = negative;
	}

	@Override
	public Node getParent() {
		// TODO Auto-generated method stub
		return super.getParent();
	}

	@Override
	public Node getRight() {
		// TODO Auto-generated method stub
		return super.getRight();
	}

	@Override
	public Node getLeft() {
		// TODO Auto-generated method stub
		return super.getLeft();
	}

	@Override
	public void setParent(Node parent) {
		// TODO Auto-generated method stub
		super.setParent(parent);
	}

	@Override
	public void setRight(Node right) {
		// TODO Auto-generated method stub
		super.setRight(right);
	}

	@Override
	public void setLeft(Node left) {
		// TODO Auto-generated method stub
		super.setLeft(left);
	}
	
	

}
