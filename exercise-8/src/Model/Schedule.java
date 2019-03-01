package Model;
import java.util.Arrays;

public class Schedule implements Container {

	private String[][] jobs; 
	private int dynamicSize;

	public Schedule(String[][] jobs, int dynamicSize) {
		super();
		this.jobs = jobs;
		this.dynamicSize = dynamicSize;
	}

	public Schedule() {
		super();
		this.dynamicSize = 0;
		this.jobs = new String[dynamicSize][3];	
	}

	public String[][] getJobs() {
		String[][] newMatrix = new String[this.jobs.length][3];
		for (int i = 0; i < this.jobs.length; i++) {
			String[] copy = new String[3];
			System.arraycopy(this.jobs[i], 0, copy, 0, 3);
			newMatrix[i]=copy;
		}
		return newMatrix;
	}

	public void setJobs(String[][] jobs) {
		this.jobs = new String[jobs.length][3];
		for (int i = 0; i < jobs.length; i++) {
			System.arraycopy(jobs[i], 0, this.jobs, 0, 3);
		}
	}

	public int getDynamicSize() {
		return dynamicSize;
	}

	public void setDynamicSize(int dynamicSize) {
		this.dynamicSize = dynamicSize;
	}

	@Override
	public void in(String object) {
		// TODO Auto-generated method stub
		setDynamicSize(getJobs().length + 1);
		String[] updatedSchedule = new String[getDynamicSize()];
		System.arraycopy(getJobs(), 0, updatedSchedule, 0, getJobs().length);
		updatedSchedule[getDynamicSize()-1] = object;
		setJobs(updatedSchedule);
	}

	@Override
	public String out() {
		// TODO Auto-generated method stub
		String popped ="";
		if (getDynamicSize() > 0) {
			setDynamicSize(getJobs().length - 1);
			popped = getJobs()[getDynamicSize()];

			String[] updatedSchedule = new String[getDynamicSize()];
			System.arraycopy(getJobs(), 0, updatedSchedule, 0, getDynamicSize());
			setJobs(updatedSchedule);
		}
		return popped;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		setDynamicSize(0);
		setJobs(new String[0]);
	}

	@Override
	public String look() {
		// TODO Auto-generated method stub
		String lifo = "";
		if (getDynamicSize() > 0) {
			lifo = getJobs()[getDynamicSize() - 1];
		}
		return lifo;
	}

}