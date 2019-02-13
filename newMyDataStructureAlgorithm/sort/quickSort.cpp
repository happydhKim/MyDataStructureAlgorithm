// 퀵 정렬
// 퀵 정렬(Quick Sort)은 배열에 있는 수 중 사용자가 지정한 규칙대로 임의의 pivot을 잡고, 해당 pivot을 기준으로 작거나 같은 수를 왼쪽 파티션, 큰 수를 오른쪽 파티션으로 보내고 다시 왼쪽 파티션 구간에 한하여 pivot을 잡고 파티션을 나누고 오른쪽 파티션 구간에서도 pivot을 잡고 파티션을 나누는 과정을 반복하여 정렬시키는 정렬 알고리즘입니다.
// 이 알고리즘의 핵심은 pivot을 잘 설정하여 왼쪽 파티션과 오른쪽 파티션을 적절하게 나누는 것입니다.
// 왜냐하면 pivot을 해당 구간의 중앙값으로 잘 설정하면 merge sort와 같은 시간 복잡도 O(nlogn)에 수행할 수 있지만, 만약 매 케이스마다 구간의 가장 큰 값이나 가장 작은 값으로 나눠버리면 O(n^2)의 수행 시간을 갖게 됩니다.
// 이해를 돕기 위해 그림을 통해 설명하겠습니다.

// (1) 먼저 구간에서 가장 왼쪽 원소를 pivot으로 놓으면 pivot = 15입니다.
// (2) 이제 구간의 제일 오른쪽 위치 right에서 왼쪽 방향으로 진행하면서 pivot값보다 작거나 같은 값이 나올 때까지 진행합니다.
// (3) idx=4일 때, 원소는 6이므로 pivot보다 작습니다. 이 값을 빨간 포인터 left가 가리키는 대상에 넣어줍니다.
//       (left에서는 right가 가리키는 대상에 넣어준다)
// (4) 그리고 이제 제일 왼쪽 위치 left에서 오른쪽 방향으로 진행하면서 pivot값보다 큰 값이 나올 때까지 진행합니다.
// (5) 그러면 left와 right가 같아질 때까지 진행되고 left와 right가 같아지면 종료가 됩니다.
// (6) 이제 이 위치에 pivot값을 넣고, pivot보다 작거나 같은 구간과 큰 구간을 나누고, 각각의 구간에 대해서 다시 퀵 정렬합니다.
// (7) 이러한 행동을 반복하면, 각 구간에 대해 원소가 1개만 남게 되고, 이 위치가 원소의 정렬된 위치입니다.

// input
// 6
// 15  4  7  3  6  1
//
// output
// 1  3  4  6  7  15

#include <stdio.h>
#include <algorithm>

void quickSort(int *arr, int left, int right) {
	int pivot, left_temp, right_temp;
	left_temp = left;
	right_temp = right;
	pivot = arr[left];
	while (left < right) {
		while (arr[right] >= pivot && (left < right)) {
			right--;
		}
		if (left != right) {
			arr[left] = arr[right];
		}
		while (arr[left] <= pivot && (left < right)) {
			left++;
		}
		if (left != right) {
			arr[right] = arr[left];
			right--;
		}
	}
	arr[left] = pivot;
	pivot = left;
	left = left_temp;
	right = right_temp;
	if (left < pivot) quickSort(arr, left, pivot - 1);
	if (right > pivot) quickSort(arr, pivot + 1, right);
}
int N;
int arr[100010];
int main() {
	scanf_s("%d",&N);
	for (int i = 0; i < N; i++) {
		scanf_s("%d", &arr[i]);
	}
	quickSort(arr, 0, N - 1);
	for (int i = 0; i < N; i++) {
		printf("%d ", arr[i]);
	}
}
