

public class ValueNode extends Node{
	private Node parent;
	private Node right;
	private Node left;
	private double value;

	ValueNode(double value){
		super();
		this.parent = null;
		this.right = null;
		this.left = null;
		this.value = value;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
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
