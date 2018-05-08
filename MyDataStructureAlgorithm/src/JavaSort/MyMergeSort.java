package JavaSort;

import java.util.Arrays;

public class MyMergeSort {

	public static void mergeSort(int data[], int left, int right) {
		if (left < right) {
			int mid = (left + right) / 2;

			mergeSort(data, left, mid);
			mergeSort(data, mid + 1, right);
			merge(data, left, mid, right);
		}
	}

	public static void merge(int data[], int left, int mid, int right) {
		int i = left, j = mid + 1, k = left;
		int tmp[] = new int[data.length];

		while (i <= mid && j <= right) {
			if (data[i] <= data[j]) {
				tmp[k++] = data[i++];
			} else {
				tmp[k++] = data[j++];
			}
		}
		while (i <= mid) {
			tmp[k++] = data[i++];
		}
		while (j <= right) {
			tmp[k++] = data[j++];
		}
		for (i = left; i <= right; i++) {
			data[i] = tmp[i];
		}
	}

	public static void main(String args[]) {

		int[] data = { 4, 2, 3, 1, 5, 6, 7 };

		mergeSort(data, 0, data.length - 1);

		System.out.println(Arrays.toString(data));
	}
}