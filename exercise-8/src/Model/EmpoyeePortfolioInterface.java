package Model;

public interface EmpoyeePortfolioInterface {

	EmployeeInterface getHead();

	void setHead(EmployeeInterface head);

	void addEmployee(EmployeeInterface newEmployee);

	void updatePortfolio();

	void loadPortfolio();

}