package Model;

public class StackContainer implements Container {
	
	private Node[] containedNodes; 
	private int dynamicSize;

//	public StackContainer(String[] containedNodes, int dynamicSize) {
//		super();
//		this.containedNodes = containedNodes;
//		this.dynamicSize = dynamicSize;
//	}
	
	public StackContainer() {
		super();
		this.dynamicSize = 0;
		this.containedNodes = new Node[dynamicSize];	
	}

	public Node[] getContainedNodes() {
		Node[] copy = new Node[this.containedNodes.length];
		System.arraycopy(this.containedNodes, 0, copy, 0, copy.length);
		return copy;
	}

	public void setContainedNodes(Node[] containedNodes) {
		this.containedNodes = new Node[containedNodes.length];
		System.arraycopy(containedNodes, 0, this.containedNodes, 0, containedNodes.length);
	}

	public int getDynamicSize() {
		return dynamicSize;
	}

	public void setDynamicSize(int dynamicSize) {
		this.dynamicSize = dynamicSize;
	}

	@Override
	public void in(Node node) {
		setDynamicSize(getContainedNodes().length + 1);
		Node[] updatedStack = new Node[getDynamicSize()];
		System.arraycopy(getContainedNodes(), 0, updatedStack, 0, getContainedNodes().length);
		updatedStack[getDynamicSize()-1] = node;
		setContainedNodes(updatedStack);
	}

	@Override
	public Node out() {
		Node popped = null;
		if (getDynamicSize() > 0) {
			setDynamicSize(getContainedNodes().length - 1);
			popped = getContainedNodes()[getDynamicSize()];
			
			Node[] updatedStack = new Node[getDynamicSize()];
			System.arraycopy(getContainedNodes(), 0, updatedStack, 0, getDynamicSize());
			setContainedNodes(updatedStack);
		}
		return popped;
	}

	@Override
	public void clear() {
		setDynamicSize(0);
		setContainedNodes(new Node[0]);
	}

	@Override
	public Node look() {
		Node lifo = null;
		if (getDynamicSize() > 0) {
			lifo = getContainedNodes()[getDynamicSize() - 1];
		}
		return lifo;
	}
	
}