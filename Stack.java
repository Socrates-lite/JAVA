public class Stack<T> {

	private class Node {
		T item;
		Node next;

		public Node(T item, Node next) {
			this.item = item;
			this.next = next;
		}
	}

	private Node head;

	public Stack() {
		head = null;
	}

	public boolean isEmpty() {

		return head == null;
	}

	public void push(T item) {

		head = new Node(item, head);

	}

	public T pop() throws StackException {

		if (isEmpty())
			throw new StackException("Stack is Empty");

		T item = head.item;
		head = head.next;

		return item;
	}

	public T peek() throws StackException {
		if (isEmpty())
			throw new StackException("Stack is Empty");

		return head.item;
	}

	public void popAll() {
		head = null;
	}

	public void print() {
		Node curr = head;

		System.out.println("----------STACK----------");
		while (curr != null) {
			System.out.println(head.item);
			head = head.next;
		}

		head = curr;
	}

}
