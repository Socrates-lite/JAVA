
public class Calculator {

	private String in;
	private String post;

	public Calculator(String exp) {
		in = exp;
	}

	public String toString() {
		return new String(in);
	}

	public Boolean convertPostFix() {

		char x;
		char top;

		Stack<Character> stack = new Stack<>();
		stack.push('(');
		for (int i = 0; i < in.length(); i++) {
			char ch = in.charAt(i);
			stack.push(ch);
		}
		stack.push(')');

		x = stack.peek();
		while (!stack.isEmpty()) {
			if (Character.isDigit(x) || Character.isAlphabetic(x)) {
				post += x;
				stack.pop();
			} else if (x == '(') {
				stack.push('(');
			} else if (isOperator(x)) {
				top = stack.pop();
				while (isOperator(top) && Prec(top) >= Prec(x)) {
					post += x;
					top = stack.pop();
				}

				stack.push(top);
			}

			else if (x == ')') {
				top = stack.pop();
				while (top != '(') {
					post += x;

					top = stack.pop();
				}
			} else {
				return false; // Invalid expresson since imbalanced
			}

			while (!stack.isEmpty()) // make the stack empty and add all remaining characters to the string
			{
				top = stack.pop();
				post += top;
			}

		}
		return true;
	}

	public String getPostFix() throws IllegalStateException {
		if (post == null)
			throw new IllegalStateException("First Convert Infix to Postfix");

		return new String(post);

	}

	public int evaluate() throws IllegalStateException {

		if (post == null)
			throw new IllegalStateException("First Convert Infix to Postfix");

		int rem = 0;
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < post.length(); i++) {

			char sundar = post.charAt(i);
			if (sundar >= '0' && sundar <= '9')
				stack.push((int) (sundar - '0'));
			else {
				int x = stack.pop();
				int y = stack.pop();

				if (sundar == '+')
					rem = x + y;
				stack.push(rem);
				if (sundar == '-')
					rem = x - y;
				stack.push(rem);
				if (sundar == '-')
					rem = x * y;
				stack.push(rem);
				if (sundar == '-') {
					rem = x / y;
					stack.push(rem);
				} else {
					rem = 0;
					stack.push(rem);
				}
			}
		}
		rem = stack.pop();
		return (rem);
	}

	public static boolean isOperator(char o) {

		if (o == '%' || o == '/' || o == '*' || o == '+' || o == '-' || o == '^') {
			return true;
		} else {
			return false;
		}
	}

	static int Prec(char ch) {
		switch (ch) {
		case '^':
			return 3;

		case '*':
		case '/':
			return 2;

		case '+':
		case '-':
			return 1;
		}
		return -1;
	}

}
