package Model;

public interface EmployeeInterface {

	int getSsn();

	String getName();

	String[] getBookedDates();
	
	EmployeeInterface getNext();

	void setSsn(int ssn);

	void setName(String name);

	void setBookedDates(String[] bookedDates);
	
	void setNext(EmployeeInterface next);

	int getBookedDatesSum();

	int getBookedOnSpecificDateSum(String specificDate);

}