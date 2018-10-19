package JavaSort;
/*
 * 퀵 정렬은 n개의 데이터를 정렬할 때, 최악의 경우에는 O(n2)번의 비교를 수행하고, 평균적으로 O(n log n)번의 비교를 수행한다.
 * 
 * 리스트 가운데서 하나의 원소를 고른다. 이렇게 고른 원소를 피벗이라고 한다.
 * 피벗 앞에는 피벗보다 값이 작은 모든 원소들이 오고, 피벗 뒤에는 피벗보다 값이 큰 모든 원소들이 오도록 피벗을 기준으로 리스트를 둘로 나눈다. 이렇게 리스트를 둘로 나누는 것을 분할이라고 한다. 분할을 마친 뒤에 피벗은 더 이상 움직이지 않는다.
 * 분할된 두 개의 작은 리스트에 대해 재귀(Recursion)적으로 이 과정을 반복한다. 재귀는 리스트의 크기가 0이나 1이 될 때까지 반복된다.
 */
public class MyQuickSort {
	public void sort(int data[], int l, int r) {
		int left = l;
		int right = r;
		int pivot = data[(l + r) / 2];

		do {
			while (data[left] < pivot) {
				left++;
			}
			while (data[right] > pivot) {
				right--;
			}
			if (left <= right) {
				int temp = data[left];
				data[left] = data[right];
				data[right] = temp;
				left++;
				right--;
			}
		} while (left <= right);

		if (l < right) {
			sort(data, l, right);
		}
		if (r > left) {
			sort(data, left, r);
		}
	}

	public static void main(String args[]) {

		int data[] = { 66, 10, 1, 34, 5, -10 };

		MyQuickSort quick = new MyQuickSort();

		quick.sort(data, 0, data.length - 1);
		for (int i = 0; i < data.length; i++) {
			System.out.println("data[" + i + "] : " + data[i]);
		}
	}
}
