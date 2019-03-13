package Model;

public class ValueNode implements Node {
	private Node parent;
	private double value;
	
	public Node getParent() {
		return parent;
	}
	public double getValue() {
		return value;
	}
	public void setParent(Node parent) {
		this.parent = parent;
	}
	public void setValue(double value) {
		this.value = value;
	}

	
}
