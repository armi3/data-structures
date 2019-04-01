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

    public ViewInterface createView(){
        return new View();
    }

    public ControllerInterface createController(Container schedule, EmployeePortfolioInterface portfolio, ViewInterface view){
        return new Controller(schedule, portfolio, view);
    }

}
