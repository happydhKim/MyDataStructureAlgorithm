선택 정렬
선택 정렬은 매 차례마다 정렬되지 않은 원소들을 모두 확인하여 각 인덱스에 맞는 원소를 선택하여 해당 인덱스의 원소와 교환해주는 정렬이다.
매 차례마다 남은 원소들을 모두 확인하기 때문에 시간 복잡도는 최악의 연산 횟수나 평균 연산 횟수나 O(N^2)이다.
공간복잡도는 O(1)

(1) 먼저 가장 작은 값을 첫 번째 값인 15로 지정하고, minimum index를 0으로 놓습니다.
(2) 그 수의 뒤에 있는 모든 수와 비교하면서, minimum index에 있는 수보다 작은 수일 경우 minimum index를 해당 수의 인덱스로 바꿔줍니다.
(3) 연산이 끝나면 마지막 수인 1이 minimum index가 되고 해당 수와 처음 인덱스를 바꿔줍니다.
(4) 첫 번째 수는 제대로 정렬된 수이므로 다음 수인 4를 가장 작은 값으로 지정하고 minimum index를 1로 놓습니다.
(5) (2),(3)의 과정을 실행합니다. 그러면 가장 작은 수는 3이므로 해당 수와 1번 인덱스의 수를 바꿔줍니다.

import java.util.*;

public class selectionSort {

	static void selectionSort(int arr[], int size) {
		for (int i = 0; i < size; i++) {
			int minIdx = i;
			for (int j = i + 1; j < size; j++) {
				if (arr[minIdx] > arr[j]) {
					minIdx = j;
				}
			}
			int temp = arr[minIdx];
			arr[minIdx] = arr[i];
			arr[i] = temp;
		}
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		selectionSort(arr, n);
		for (int i = 0; i < n; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println("");
		sc.close();
	}
}
