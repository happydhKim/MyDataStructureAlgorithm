package JavaDataStructure;

public class MyArrayQueue {
	private int front;
	private int rear;
	private int queueSize;
	private char itemArray[];

	// 생성자(큐 생성)
	public MyArrayQueue(int queueSize) {
		front = -1;
		rear = -1;
		this.queueSize = queueSize;
		itemArray = new char[this.queueSize];
	}

	// 큐가 비어있는지 확인
	public boolean isEmpty() {
		return (front == rear);
	}

	// 큐가 가득 차있는지 확인
	public boolean isFull() {
		return (rear == queueSize - 1);
	}

	// 큐의 삽입 연산
	public void enQueue(char item) {
		if (isFull()) {
			System.out.println("Queue is full.");
		} else {
			itemArray[++rear] = item;
		}
	}

	// 큐의 삭제 및 반환 연산
	public char deQueue() {
		if (isEmpty()) {
			System.out.println("Queue is empty.");
			return 0;
		} else {
			return itemArray[++front];
		}
	}

	// 큐 삭제
	public void delete() {
		if (isEmpty()) {
			System.out.println("Queue is empty.");
		} else {
			++front;
		}

	}

	// 현재 큐의 맨 앞의 값
	public char peek() {
		if (isEmpty()) {
			System.out.println("Queue is empty.");
			return 0;
		} else {
			return itemArray[front + 1];
		}
	}

	// 전체 큐 출력
	public void printQueue() {
		if (isEmpty()) {
			System.out.println("Queue is empty.");
		} else {
			for (int i = front + 1; i <= rear; i++) {
				System.out.print(itemArray[i] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String args[]) {
		int queueSize = 3;
		char deletedItem;
		MyArrayQueue queue = new MyArrayQueue(queueSize);

		queue.enQueue('A');
		queue.printQueue();

		queue.enQueue('B');
		queue.printQueue();

		deletedItem = queue.deQueue();
		if (deletedItem != 0) {
			System.out.println("deleted Item : " + deletedItem);
		}
		queue.printQueue();
	}
}