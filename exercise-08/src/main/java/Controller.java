import Model.Container;
import Model.EmployeeInterface;
import Model.EmployeePortfolioInterface;

import java.util.concurrent.ThreadLocalRandom;

public class Controller implements ControllerInterface {

    private Container schedule;
    private EmployeePortfolioInterface portfolio;
    private ViewInterface view;

    public Controller(Container schedule, EmployeePortfolioInterface portfolio, ViewInterface view) {
        this.schedule = schedule;
        this.portfolio = portfolio;
        this.view = view;
    }

    @Override
    public int assignToRandom(){
        String[] job = new String[2];
        // prompt client
        job[0] = getView().promptClient();
        // get random index and get ssn
        int randomNum = ThreadLocalRandom.current().nextInt(0, getPortfolio().getLength());
        EmployeeInterface employeeRandomlyChosen = getPortfolio().getHead();
        for(int i = 0; i < randomNum; i++){
            employeeRandomlyChosen = employeeRandomlyChosen.getNext();
        }
        job[1] = String.valueOf(employeeRandomlyChosen.getSsn());
        // push to queue
        schedule.in(job);
        return getView().promptAction();
    }

    @Override
    public int assignToSpecific(){
        String[] job = new String[2];
        // prompt client
        job[0] = getView().promptClient();
        // prompt ssn
        String ssn = getView().promptSpecificSsn();
        if(ssn.equals("")){
            return 6;
        }
        job[1] = ssn;
        // push to queue
        schedule.in(job);
        return getView().promptAction();
    }

    @Override
    public int printPortfolio(){
        getView().printPortfolio(getPortfolio());
        return getView().promptAction();
    }

    @Override
    public int updatePortfolio(){
        // pop each in queue
        for(int i=0; i < getSchedule().getDynamicSize(); i++){
            getPortfolio().updatePortfolio(getSchedule().out());
        }
        return getView().promptAction();
    }



    @Override
    public Container getSchedule() {
        return schedule;
    }

    @Override
    public void setSchedule(Container schedule) {
        this.schedule = schedule;
    }

    @Override
    public EmployeePortfolioInterface getPortfolio() {
        return portfolio;
    }

    @Override
    public void setPortfolio(EmployeePortfolioInterface portfolio) {
        this.portfolio = portfolio;
    }

    @Override
    public ViewInterface getView() {
        return view;
    }

    @Override
    public void setView(ViewInterface view) {
        this.view = view;
    }
}
