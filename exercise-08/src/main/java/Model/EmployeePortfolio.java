package Model;

public class EmployeePortfolio implements EmployeePortfolioInterface {

    private EmployeeInterface head;
    private int length;

    public EmployeePortfolio() {
        super();
        this.head = null;
        this.length = 0;
    }

    @Override
    public EmployeeInterface getHead() {
        return head;
    }

    @Override
    public void setHead(EmployeeInterface head) {
        this.head = head;
    }

    @Override
    public int getLength() {
        return length;
    }

    @Override
    public void setLength(int length) {
        this.length = length;
    }

    @Override
    public void addEmployee(EmployeeInterface newEmployee) {
        setLength(getLength()+1);

        // case a: empty portfolio
        if (this.getHead()==null) {
            this.setHead(newEmployee);

        } else {
            boolean ordered = false;
            EmployeeInterface employeeToCompare = this.getHead();
            EmployeeInterface employeePreviouslyCompared = null;
            // case b: 1 employee
            if (this.getHead().getNext()==null){

                // case b1: smaller ssn
                if (newEmployee.getSsn() < employeeToCompare.getSsn()) {
                    newEmployee.setNext(employeeToCompare);
                    this.setHead(newEmployee);

                }
                // case b2: same ssn
                else if (newEmployee.getSsn()==employeeToCompare.getSsn()) {
                    employeeToCompare=newEmployee;

                }
                // case b3: bigger ssn
                else {
                    employeeToCompare.setNext(newEmployee);

                }
            }
            // case c: 2 or more employees
            else {
                while(employeeToCompare!=null && !ordered){
                    // case c1: smaller ssn
                    if(newEmployee.getSsn() < employeeToCompare.getSsn()) {
                        newEmployee.setNext(employeeToCompare);
                        if (employeeToCompare==this.getHead()) {
                            this.setHead(newEmployee);
                        } else {
                            employeePreviouslyCompared.setNext(newEmployee);
                        }
                        ordered = true;
                    }
                    // case 2: same ssn
                    else if (newEmployee.getSsn()==employeeToCompare.getSsn()) {
                        employeeToCompare = employeeToCompare.getNext();
                    }
                    // case 3: bigger ssn
                    else {
                        employeePreviouslyCompared = employeeToCompare;
                        employeeToCompare = employeeToCompare.getNext();
                    }
                }
                if(employeeToCompare==null){
                    employeePreviouslyCompared.setNext(newEmployee);
                }
            }

        }

    }

    @Override
    public void updatePortfolio(String[] job) {
        EmployeeInterface employeeToCompare = getHead();
        int ssn = Integer.valueOf(job[1].replaceAll("-", ""));
        boolean isNew = true;
        for(int i=0; i<length; i++){
            if(employeeToCompare.getSsn()==ssn){
                i=length;
                employeeToCompare.setBookedDates(employeeToCompare.getBookedDates()+1);
                isNew = false;
            }
            employeeToCompare = employeeToCompare.getNext();
        }
        if(isNew){
            EmployeeInterface newEmployee = new Employee(ssn);
            addEmployee(newEmployee);
        }
    }

    @Override
    public void loadPortfolio(String[] database){
        for(String line: database){
            String ssn = line.substring(0, 9);
            line = line.substring(10);
            String bookedDates = line.replaceAll("[^0-9]", "");
            String name = line.replaceAll("\\d","");
            Employee newEmployee = new Employee(Integer.valueOf(ssn), name, Integer.valueOf(bookedDates));
            addEmployee(newEmployee);
        }

    }

}
