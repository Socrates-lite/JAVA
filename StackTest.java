import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class StackTest {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new File("C:\\Users\\sunda\\eclipse-workspace\\Assignment4\\src\\test_file.docx"));

		Stack<Character> stack = new Stack<Character>();

		while (sc.hasNextLine()) {
			String str = sc.nextLine();
			for (int i = 0; i < str.length(); i++) {
				char current = str.charAt(i);
				if (current == '{' || current == '(' || current == '[') {
					stack.push(current);
				}

				else if (current == '}' || current == ')' || current == ']') // one to enter and down to really need
																				// another // constraint
				{
					if (current == '}' && stack.peek() == '{' || current == ')' && stack.peek() == '('
							|| current == ']' && stack.peek() == '[')
						stack.pop();

				}

			}

			if (stack.isEmpty())
				System.out.println("Valid Expression");
			else
				System.out.println("InValid Expression");

		}
	}

}
