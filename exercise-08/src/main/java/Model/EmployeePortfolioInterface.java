package Model;

public interface EmployeePortfolioInterface {
    EmployeeInterface getHead();

    void setHead(EmployeeInterface head);

    int getLength();

    void setLength(int length);

    void addEmployee(EmployeeInterface newEmployee);

    void updatePortfolio(String[] job);

    void loadPortfolio(String[] database);
}
