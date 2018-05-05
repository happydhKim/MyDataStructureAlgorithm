package JavaSort;

public class MyInsertionSort {
	public void sort(int data[]) {
		int size = data.length;
		int temp = 0;
		int j = 0;
		for (int i = 1; i < size; i++) {
			temp = data[i];
			for (j = i - 1; j >= 0 && temp < data[j]; j--) {
				data[j + 1] = data[j];
			}
			data[j + 1] = temp;
		}
	}

	public static void main(String[] args) {

		MyInsertionSort insertion = new MyInsertionSort();

		int data[] = { 66, 10, 1, 34, 5 };

		insertion.sort(data);

		for (int i = 0; i < data.length; i++) {
			System.out.println("data[" + i + "] : " + data[i]);
		}
	}
}
