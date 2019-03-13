package Model;

public class StackContainer implements Container {
	
	private String[] containedObjects; 
	private int dynamicSize;

	public StackContainer(String[] containedObjects, int dynamicSize) {
		super();
		this.containedObjects = containedObjects;
		this.dynamicSize = dynamicSize;
	}
	
	public StackContainer() {
		super();
		this.dynamicSize = 0;
		this.containedObjects = new String[dynamicSize];	
	}

	public String[] getContainedObjects() {
		String[] copy = new String[this.containedObjects.length];
		System.arraycopy(this.containedObjects, 0, copy, 0, copy.length);
		return copy;
	}

	public void setContainedObjects(String[] containedObjects) {
		this.containedObjects = new String[containedObjects.length];
		System.arraycopy(containedObjects, 0, this.containedObjects, 0, containedObjects.length);
	}

	public int getDynamicSize() {
		return dynamicSize;
	}

	public void setDynamicSize(int dynamicSize) {
		this.dynamicSize = dynamicSize;
	}

	@Override
	public void in(String object) {
		setDynamicSize(getContainedObjects().length + 1);
		String[] updatedStack = new String[getDynamicSize()];
		System.arraycopy(getContainedObjects(), 0, updatedStack, 0, getContainedObjects().length);
		updatedStack[getDynamicSize()-1] = object;
		setContainedObjects(updatedStack);
	}

	@Override
	public String out() {
		String popped ="";
		if (getDynamicSize() > 0) {
			setDynamicSize(getContainedObjects().length - 1);
			popped = getContainedObjects()[getDynamicSize()];
			
			String[] updatedStack = new String[getDynamicSize()];
			System.arraycopy(getContainedObjects(), 0, updatedStack, 0, getDynamicSize());
			setContainedObjects(updatedStack);
		}
		return popped;
	}

	@Override
	public void clear() {
		setDynamicSize(0);
		setContainedObjects(new String[0]);
	}

	@Override
	public String look() {
		String lifo = "";
		if (getDynamicSize() > 0) {
			lifo = getContainedObjects()[getDynamicSize() - 1];
		}
		return lifo;
	}
	
}