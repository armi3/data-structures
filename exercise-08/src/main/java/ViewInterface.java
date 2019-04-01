import Model.EmployeePortfolioInterface;

public interface ViewInterface {
    String getMenu();

    int promptActionWithMenu();

    int promptAction();

    String promptClient();

    String promptSpecificSsn();

    void printPortfolio(EmployeePortfolioInterface portfolio);
}
