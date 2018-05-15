package JavaSort;

public class MyHeapSort {

	int data[];

	public MyHeapSort(int data[]) {
		this.data = data;
	}

	public void max_Heapify(int i) {

		if (data == null || data.length < 1)
			return;

		int leftChild = i * 2;
		int rightChild = leftChild + 1;
		int largest;

		if (leftChild < data.length && data[leftChild] > data[i])
			largest = leftChild;
		else
			largest = i;

		if (rightChild < data.length && data[rightChild] > data[largest])
			largest = rightChild;

		if (largest != i) {
			swap(i, largest);
			max_Heapify(largest);
		}
	}

	public void buildMaxHeap() {

		if (data == null || data.length < 1)
			return;

		for (int i = data.length / 2; i > 0; i--) {
			max_Heapify(i);
		}
	}

	private void swap(int i, int j) {
		int tmp = data[i];
		data[i] = data[j];
		data[j] = tmp;
	}

	public void printdata() {
		for (int i = 0; i < data.length; i++) {
			System.out.print(" " + data[i]);
			if (i == 0 || i == 1 || i == 3 || i == 7) {
				System.out.println();
			}
		}
	}

	public static void main(String args[]) {

		int data[] = { 0, 16, 42, 15, 14, 67, 39, 13, 92, 18 };

		MyHeapSort heap = new MyHeapSort(data);

		heap.buildMaxHeap();
		heap.printdata();

		System.out.println();
		System.out.println();

	}
}