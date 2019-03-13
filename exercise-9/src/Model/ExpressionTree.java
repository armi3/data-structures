package Model;

public interface ExpressionTree {
	static Node build(char[] postfix, Container stack) {
		
		for (int i = 0; i < postfix.length; i++) {
			
			Node node = new Node(postfix[i]);
			
			switch (postfix[i]) {
			
			case '0':case '1':case '2':case '3':case '4':
			case '5':case '6':case '7':case '8':case '9':
				stack.push(node);
				System.out.println("Pushed");
				break;
			
			case '+':case '-':case '/':case '*':
				System.out.println("Pushed");
				node.right = stack.pop();
				node.left = stack.pop();
				stack.push(node);
				break;
			default:
			}
		}

		Node root = stack.out();
		return root;
	}

}
