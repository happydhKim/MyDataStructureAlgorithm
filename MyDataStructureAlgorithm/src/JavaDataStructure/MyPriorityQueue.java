package JavaDataStructure;

public class MyPriorityQueue {

	private int maxSize;
	private long queueArray[];
	private int count;

	// 큐 배열 생성
	public MyPriorityQueue(int maxSize) {

		this.maxSize = maxSize;
		this.queueArray = new long[maxSize];
		this.count = 0;

	}

	// 큐가 비어있는지 확인
	public boolean empty() {
		return (count == 0);
	}

	// 큐가 꽉 찼는지 확인
	public boolean full() {
		return (count == maxSize);
	}

	// 큐에 데이터 등록
	// 큐가 데이터가 큰 순서대로 배열의 앞에서부터 정렬되있기에
	// 배열의 뒤에서부터 탐색하며 item 보다 큰 값이 있는 index 뒤에 삽입한다.
	public void insert(long item) {

		if (full())
			throw new ArrayIndexOutOfBoundsException();

		if (empty()) {

			queueArray[count++] = item;

		} else {

			// 데이터의 뒤에서부터 앞으로 탐색한다.
			int i = 0;
			for (i = count - 1; i >= 0; i--) {

				// 현재 index의 데이터가 입력받은 데이터(item)보다 작으면 배열의 뒤로 밀어낸다.
				if (item > queueArray[i]) {

					queueArray[i + 1] = queueArray[i];

				} else {
					// item이 현재 index의 값보다 작으면 탐색을 멈춘다.
					// item 삽입 위치 확인
					break;
				}
			}

			// item 등록
			queueArray[i + 1] = item;
			count++;
		}
	}

	// 큐의 마지막 데이터 조회 (가장작은 데이터)
	public Object peek() {

		if (empty())
			throw new ArrayIndexOutOfBoundsException();

		return queueArray[count - 1];
	}

	// 큐에서 마지막 데이터 제거 (가장작은 데이터)
	public Object remove() {

		Object item = peek();
		count--;
		return item;
	}

}