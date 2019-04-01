package Model;

public class Employee implements EmployeeInterface {
    private int ssn;
    private String name;
    private int bookedDates;
    private EmployeeInterface next;

    public Employee(int ssn, String name, int bookedDates) {
        this.ssn = ssn;
        this.name = name;
        this.bookedDates = bookedDates;
        this.next = null;
    }

    public Employee(int ssn) {
        this.ssn = ssn;
        this.name = "N/A";
        this.bookedDates = 1;
        this.next = null;
    }

    public Employee() {
        this.ssn = 0;
        this.name = "N/A";
        this.bookedDates = 0;
        this.next = null;
    }

    @Override
    public int getSsn() {
        return ssn;
    }

    @Override
    public void setSsn(int ssn) {
        this.ssn = ssn;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int getBookedDates() {
        return bookedDates;
    }

    @Override
    public void setBookedDates(int bookedDates) {
        this.bookedDates = bookedDates;
    }

    @Override
    public EmployeeInterface getNext() {
        return next;
    }

    @Override
    public void setNext(EmployeeInterface next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Model.Employee{" +
                "ssn=" + ssn +
                ", name='" + name + '\'' +
                ", bookedDates=" + bookedDates +
                '}';
    }
}
