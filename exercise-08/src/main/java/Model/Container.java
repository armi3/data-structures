package Model;

public interface Container {
    String[][] getJobs();

    void setJobs(String[][] jobs);

    int getDynamicSize();

    void setDynamicSize(int dynamicSize);

    void in(String[] job);

    String[] out();

    void clear();

    String[] look();
}
