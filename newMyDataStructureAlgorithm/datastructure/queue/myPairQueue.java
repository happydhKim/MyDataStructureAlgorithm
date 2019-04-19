import java.util.Scanner;

class MyQueue {
	Node head;
	Node tail;
	int size;

	public class Node {
		int x;
		int y;
		Node next;
		Node prev;

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
			next = null;
			prev = null;
		}
	}

	Node node(int index) {
		Node node = null;
		if (index <= size / 2) {
			node = head;
			for (int i = 0; i < index; i++)
				node = node.next;
		} else {
			node = tail;
			for (int i = size - 1; i > index; i--) {
				node = node.prev;
			}
		}
		return node;
	}

	public void addFirst(int value, int cnt) {
		Node newNode = new Node(value, cnt);
		if (head == null) {
			head = newNode;
			tail = newNode;
		} else {
			newNode.next = head;
			head.prev = newNode;
			head = newNode;
		}
		size++;
	}

	public void addLast(int value, int cnt) {
		Node newNode = new Node(value, cnt);
		if (head == null)
			addFirst(value, cnt);
		else {
			tail.next = newNode;
			newNode.prev = tail;
			tail = newNode;
			size++;
		}
	}

	public Node removeFirst() {
		Node returnNode = null;
		if (head == null)
			return null;
		else {
			Node temp = head;
			head = head.next;
			returnNode = temp;
			temp = null;
			size--;
		}
		return returnNode;
	}

	public Node remove(int index) {
		Node returnNode = null;
		if (index == 0) {
			returnNode = removeFirst();
		} else {
			Node toDeleted = node(index);
			if (toDeleted == null) {
				return null;
			} else {
				Node temp = toDeleted.prev;
				if (toDeleted == tail) {
					tail = temp;
					tail.next = null;
				} else {
					toDeleted.next.prev = temp;
					temp.next = toDeleted.next;
				}
				returnNode = toDeleted;
				toDeleted = null;
				size--;
			}
		}
		return returnNode;
	}

	public Node removeLast() {
		return remove(size - 1);
	}

	public int size() {
		return size;
	}
}

public class test02 {

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		MyQueue q = new MyQueue();
		q.addFirst(5, 3);

		System.out.println();
		sc.close();
	}
}
