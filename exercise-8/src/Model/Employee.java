package Model;

public class Employee implements EmployeeInterface {
	private int ssn;
	private String name;
	private String[] bookedDates;
	private EmployeeInterface next;
	
	@Override
	public int getSsn() {
		return ssn;
	}
	@Override
	public String getName() {
		return name;
	}
	@Override
	public String[] getBookedDates() {
		return bookedDates;
	}
	@Override
	public EmployeeInterface getNext() {
		return next;
	}
	@Override
	public void setSsn(int ssn) {
		this.ssn = ssn;
	}
	@Override
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public void setBookedDates(String[] bookedDates) {
		this.bookedDates = bookedDates;
	}
	@Override
	public void setNext(EmployeeInterface next) {
		this.next = next;
	}
	
	@Override
	public int getBookedDatesSum() {
		return this.getBookedDates().length;
	}
	
	@Override
	public int getBookedOnSpecificDateSum(String specificDate) {
		int bookedOnDate =0;
		for (int i =0; i < this.getBookedDatesSum(); i++) {
			if (this.getBookedDates()[i].equals(specificDate)) {
				bookedOnDate++;
			}
		}
		return bookedOnDate;
	}
	

}
