package Model;

public class Stack implements Container {
	
	public String[] objects; 
	public boolean isEmpty;

	public boolean isEmpty() {
		return isEmpty;
	}

	public void setEmpty(boolean isEmpty) {
		this.isEmpty = isEmpty;
	}

	@Override
	public void in(String object) {
		// TODO Auto-generated method stub
		objects[objects.length] = object;
	}

	@Override
	public String out() {
		// TODO Auto-generated method stub
		String popped ="";
		if (isEmpty=false) {
			popped = objects[objects.length-1];
			for (int i=objects.length; i>1; i++) {
				
			}
		}
		return popped;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		objects = null;
		isEmpty = true;
	}

	@Override
	public String look() {
		// TODO Auto-generated method stub
		return null;
	}

}
