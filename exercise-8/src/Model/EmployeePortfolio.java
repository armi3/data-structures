package Model;

public class EmployeePortfolio implements EmployeePortfolioInterface {
	
	private EmployeeInterface head;

	public EmployeePortfolio() {
		super();
		this.head = null;
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
	public void addEmployee(EmployeeInterface newEmployee) {

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
				while(employeeToCompare.getNext()!=null && !ordered){
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
			}
			
		}
	}

	@Override
	public void updatePortfolio() {

	}

	@Override
	public void loadPortfolio(){

	}

}
