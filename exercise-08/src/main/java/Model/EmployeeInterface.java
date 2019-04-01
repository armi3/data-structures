package Model;

public interface EmployeeInterface {
    int getSsn();

    void setSsn(int ssn);

    String getName();

    void setName(String name);

    int getBookedDates();

    void setBookedDates(int bookedDates);

    EmployeeInterface getNext();

    void setNext(EmployeeInterface next);

    @Override
    String toString();
}
