/**
 * @author Fernanda González
 *
 */

package Model;
import java.util.Arrays;

public class Stack implements Container {
	
	private String[] containedObjects; 
	private int dynamicSize;

	/**
	 * @param containedObjects
	 * @param dynamicSize
	 */
	public Stack(String[] containedObjects, int dynamicSize) {
		super();
		this.containedObjects = containedObjects;
		this.dynamicSize = dynamicSize;
	}
	
	public Stack() {
		super();
		this.dynamicSize = 0;
		this.containedObjects = new String[dynamicSize];	
	}

	@Override
	public String toString() {
		return "Stack [containedObjects=" + Arrays.toString(containedObjects) + ", dynamicSize=" + dynamicSize + "]";
	}

	/**
	 * @return the containedObjects
	 */
	public String[] getContainedObjects() {
		String[] copy = new String[this.containedObjects.length];
		System.arraycopy(this.containedObjects, 0, copy, 0, copy.length);
		return copy;
	}

	/**
	 * @param containedObjects the containedObjects to set
	 */
	public void setContainedObjects(String[] containedObjects) {
		this.containedObjects = new String[containedObjects.length];
		System.arraycopy(containedObjects, 0, this.containedObjects, 0, containedObjects.length);
	}

	/**
	 * @return the dynamicSize
	 */
	public int getDynamicSize() {
		return dynamicSize;
	}

	/**
	 * @param dynamicSize the dynamicSize to set
	 */
	public void setDynamicSize(int dynamicSize) {
		this.dynamicSize = dynamicSize;
	}

	@Override
	public void in(String object) {
		// TODO Auto-generated method stub
		setDynamicSize(getContainedObjects().length + 1);
		String[] updatedStack = new String[getDynamicSize()];
		System.arraycopy(getContainedObjects(), 0, updatedStack, 0, getContainedObjects().length);
		updatedStack[getDynamicSize()-1] = object;
		setContainedObjects(updatedStack);
	}

	@Override
	public String out() {
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub
		setDynamicSize(0);
		setContainedObjects(new String[0]);
	}

	@Override
	public String look() {
		// TODO Auto-generated method stub
		String lifo = "";
		if (getDynamicSize() > 0) {
			lifo = getContainedObjects()[getDynamicSize() - 1];
		}
		return lifo;
	}
	
}