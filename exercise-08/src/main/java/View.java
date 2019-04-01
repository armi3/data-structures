import Model.EmployeeInterface;
import Model.EmployeePortfolioInterface;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Pattern;


public class View implements ViewInterface {

    private String menu = "\n" +
            "------------- Main menu ------------- \n" +
            "0. Repeat menu \n" +
            "1. Assign job to random employee \n" +
            "2. Assign job to an specific employee \n" +
            "3. Print employee portfolio\n" +
            "4. Update employee portfolio\n" +
            "5. Exit\n" +
            "\nInput action (0-5): ";

    @Override
    public String getMenu() {
        return menu;
    }

    @Override
    public int promptActionWithMenu() {
        int menuChoice =6;
        Scanner sc = new Scanner(System.in);
        System.out.print(getMenu());
        try {
            menuChoice = Integer.parseInt(sc.next(Pattern.compile("^([0-5])$")));
        }
        catch (InputMismatchException e) {
            System.out.print("\nInvalid input.");
        }
        return menuChoice;
    }

    @Override
    public int promptAction() {
        int menuChoice;
        Scanner sc = new Scanner(System.in);
        System.out.print("\nInput action (1-5) or 0 for menu: ");
        try {
            menuChoice = Integer.parseInt(sc.next(Pattern.compile("^([0-5])$")));
        }
        catch (InputMismatchException e) {
            menuChoice = 6;
        }
        return menuChoice;
    }

    @Override
    public String promptClient(){
        Scanner sc = new Scanner(System.in);
        System.out.print("\nInput client: ");
        return sc.nextLine();
    }

    @Override
    public String promptSpecificSsn(){
        Scanner sc = new Scanner(System.in);
        String ssn;
        System.out.print("\nInput employee's SSN (XXX-XX-XXXX): ");
        try {
            ssn = sc.next(Pattern.compile("(?:\\d{3})-(?:\\d{2})-(\\d{4})"));
        }
        catch (InputMismatchException e) {
            System.out.print("\nInvalid SSN format.");
            ssn = "";
        }
        return ssn;
    }

    @Override
    public void printPortfolio(EmployeePortfolioInterface portfolio){
        System.out.println("\nModel.Employee portfolio: ");
        EmployeeInterface employeeToPrint = portfolio.getHead();
        while(employeeToPrint!=null){
            System.out.println(employeeToPrint.toString());
            employeeToPrint = employeeToPrint.getNext();
        }
    }
}
