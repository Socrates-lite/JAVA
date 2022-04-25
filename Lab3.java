
public class Lab3 {

	private class Node {

		Integer item;
		Node left, right;

		public Node(Integer item) {
			this.item = item;
		}

		public Node(Integer item, Node left, Node right) {
			this.item = item;
			this.left = left;
			this.right = right;
		}

	}

	private Node root;

	// just letting a standard No-arg constructor be created so the class name can
	// be changed without issue

	public void makeTestTree1() {
		root = new Node(30, new Node(20, new Node(10), null),
				new Node(70, new Node(50, new Node(40), new Node(60)), new Node(90)));
	}

	public void makeTestTree2() {
		root = new Node(10,
				new Node(8, new Node(2, new Node(1), new Node(6, new Node(4, new Node(3), new Node(5)), null)), null),
				new Node(11, null, new Node(14, new Node(13), new Node(16))));

	}

	// METHODS TO BE ADDED

	// 1) PRINTING
	// a) In-order
	public void printInOrder() {
		printInOrder(root);
	}

	private void printInOrder(Node r) {
		if (r == null)
			return;
		printInOrder(r.left);

		System.out.print(r.item + " ");
		printInOrder(r.right);
	}

	public void printPreOrder() {
		printPreOrder(root);
	}
	
	private void printPreOrder(Node r) {
		if (r == null) return;
		
		System.out.print(r.item + " ");
		printPreOrder(r.left);
	
		printPreOrder(r.right);
	}
	
	public void printPostOrder() {
		printPostOrder(root);
	}

	private void printPostOrder(Node r) {
		if (r == null) return;
		
		printPostOrder(r.left);
	
		printPostOrder(r.right);

		System.out.print(r.item + " ");
	}


	// 2) INFORMATION METHODS
	// a) Count the number of nodes in the tree.
	
	// b) Compute the height of the tree.
	// c) Find the maximum element.
	// d) Find the sum of the elements
	// e) Find the average of the elements
	// f) Find a specific element
	// g) Determine whether one item is an ancestor or another
	// h) Determine the highest level that is full

	public static void main(String[] args) {
		Lab3 tree = new Lab3();
		tree.makeTestTree1();

		tree.printInOrder();
		System.out.println();

		tree.printPreOrder();
		System.out.println();

		tree.printPostOrder();
		System.out.println();

	}

}
