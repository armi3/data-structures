import Model.*;

public class Factory {
	public Container createSchedule() {
		return new Schedule();
	}
	public EmployeeInterface createEmployee() {
		return new Employee();
	}
	public EmployeePortfolioInterface createPortfolio() {
		return new EmployeePortfolio();
	}

}
