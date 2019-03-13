package Model;

public interface EmployeePortfolioInterface {

	EmployeeInterface getHead();

	void setHead(EmployeeInterface head);

	void addEmployee(EmployeeInterface newEmployee);

	void updatePortfolio();

	void loadPortfolio();

}