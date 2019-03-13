package Model;

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
	public void in(String[] job) {
		setDynamicSize(getJobs().length + 1);
		String[][] updatedSchedule = new String[getDynamicSize()][3];
		
		for (int i = 0; i < getJobs().length; i++) {
			System.arraycopy(getJobs()[i], 0, updatedSchedule, 0, 3);
		}
		updatedSchedule[getDynamicSize()-1] = job;
		setJobs(updatedSchedule);
	}

	@Override
	public String[] out() {
		String[] popped = {""};
		if (getDynamicSize() > 0) {
			setDynamicSize(getJobs().length - 1);
			popped = getJobs()[0]; // FIFO

			String[][] updatedSchedule = new String[getDynamicSize()][3];
			for (int i = 1; i < getDynamicSize(); i++) {
				System.arraycopy(getJobs()[i], 0, updatedSchedule, 0, 3);
			}
			setJobs(updatedSchedule);
		}
		return popped;
	}

	@Override
	public void clear() {
		setDynamicSize(0);
		setJobs(new String[0][3]);
	}

	@Override
	public String[] look() {
		String[] fifo = {""};
		if (getDynamicSize() > 0) {
			fifo = getJobs()[0];
		}
		return fifo;
	}

}