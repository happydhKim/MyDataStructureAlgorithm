package JavaSearch;

public class MyBinarySearch {

	public static void binarySearch(int index, int data[]) {
		int mid;
		int left = 0;
		int right = data.length - 1;

		while (right >= left) {
			mid = (right + left) / 2;

			if (index == data[mid]) {
				System.out.println(index + " is in the array with index value: " + mid);
				break;
			}

			if (index < data[mid]) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}

		}
	}

	public static void main(String args[]) {
		int data[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };

		binarySearch(2, data);
	}
}