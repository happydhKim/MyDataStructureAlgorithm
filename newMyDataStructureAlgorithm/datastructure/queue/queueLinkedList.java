class LinkedListQueue {
	private class Node {
		private Object data;
		private Node nextNode;

		Node(Object data) {
			this.data = data;
			this.nextNode = null;
		}
	}

	private Node front;
	private Node rear;

	public LinkedListQueue() {
		this.front = null;
		this.rear = null;
	}

	public boolean empty() {
		return (front == null);
	}

	public void add(Object item) {
		Node node = new Node(item);
		node.nextNode = null;
		if (empty()) {
			rear = node;
			front = node;
		} else {
			rear.nextNode = node;
			rear = node;
		}
	}

	public Object peek() {
		if (empty())
			throw new ArrayIndexOutOfBoundsException();
		return front.data;
	}

	public Object remove() {
		Object item = peek();
		front = front.nextNode;
		if (front == null) {
			rear = null;
		}
		return item;
	}
}
