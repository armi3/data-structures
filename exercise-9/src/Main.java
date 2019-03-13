
public class Main {

	public static void main(String[] args) {
		String inputInfix = "-x^2*3(22-2.5x)^2/0.1^-2+(x+2x)";
		Container stack = new StackContainer();
		
		Node headInputPostfix = LinkedList.build(inputInfix, stack);
		Node rootInput = Tree.build(headInputPostfix, stack);
		Node rootOutput = Tree.buildDerivative(rootInput, stack);
		String outputPostfix = Tree.unbuild(rootOutput, stack);
		System.out.print(outputPostfix);

	}

}
