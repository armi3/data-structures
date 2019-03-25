package Model;

public interface Container {
	void in(String[] job);
	String[] out();
	void clear();
	String[] look();
}
