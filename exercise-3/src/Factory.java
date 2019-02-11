import Model.*;

public class Factory {
	public AccountInterface createModel() {
		return new Account();
	}
	public ViewInterface createView() {
		return new View();
	}
	public ControllerInterface createController() {
		return new Controller();
	}
}
