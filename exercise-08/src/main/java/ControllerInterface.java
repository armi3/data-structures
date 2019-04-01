import Model.Container;
import Model.EmployeePortfolioInterface;

public interface ControllerInterface {
    int assignToRandom();

    int assignToSpecific();

    int printPortfolio();

    int updatePortfolio();

    Container getSchedule();

    void setSchedule(Container schedule);

    EmployeePortfolioInterface getPortfolio();

    void setPortfolio(EmployeePortfolioInterface portfolio);

    ViewInterface getView();

    void setView(ViewInterface view);
}
