package Model;

public abstract class OperationNode implements Node {
	private Node parent;
	private Node rightChild;
	private Node leftChild; 
	private char operator;
	
	public Node getParent() {
		return parent;
	}
	public Node getRightChild() {
		return rightChild;
	}
	public Node getLeftChild() {
		return leftChild;
	}
	public char getOperator() {
		return operator;
	}
	public void setParent(Node parent) {
		this.parent = parent;
	}
	public void setRightChild(Node rightChild) {
		this.rightChild = rightChild;
	}
	public void setLeftChild(Node leftChild) {
		this.leftChild = leftChild;
	}
	public void setOperator(char operator) {
		this.operator = operator;
	}
	
}
