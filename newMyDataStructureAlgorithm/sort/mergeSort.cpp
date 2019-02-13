// 분할정복
// 분할정복(Divide and Conquer)은 말 그대로 문제를 분할한 다음, 분할한 문제들 (sub-problems)을 해결하고, 그 결과를 합쳐서 원래의 문제를 해결하는 것입니다.
// 분할정복의 대표적인 예로는 합병 정렬, 고속 푸리에 변환 등이 있습니다.
//
// 합병정렬을 예로 설명해보겠습니다.
// 영역을 나눈 후, 나누어진 영역을 투 포인터(Two Pointer) 알고리즘으로 합병하는 방식으로 동작합니다.
// 투 포인터 알고리즘을 사용하려면 나눠진 영역이 정렬이 되어있어야 하기 때문에 먼저 영역을 작게 나눈 후 합치는 재귀적인 방법이 사용된다.

//분할 정복의 시간 복잡도는 최대 분할 * 합병 = O(log N) * O(N) = O(N log N)으로 상당히 빠르므로 효율적인 알고리즘으로 볼 수 있습니다.

// 이와 같은 문제는 분할정복보다는 동적계획법의 Top-Down 접근법(Memoization)으로 접근하는 것이 효율적일 것입니다.

// input
// 7
// 5  1  8  -3  2  6  -5
//
// output
// -5  -3  1  2  5  6  8

#include <stdio.h>

#define MAX 5005

int d[MAX];
int temp[MAX];

void MergeSort(int L, int R) {
	if (L >= R) return;

	int M = (L + R) / 2;

	// Divide
	MergeSort(L, M);
	MergeSort(M + 1, R);

	// Conquer
	for (int i = L, l = L, r = M + 1; l != M + 1 || r != R + 1; i++) {
		if ((r != R + 1 && l <= M && d[l] < d[r]) || r == R + 1) {
			temp[i] = d[l++];
		} else {
			temp[i] = d[r++];
    }
	}

	for (int i = L; i <= R; i++) {
		d[i] = temp[i];
  }
}

int main() {
	int n;
	scanf_s("%d", &n);
	for (int i = 0; i < n; i++) {
		scanf_s("%d", &d[i]);
  }
	MergeSort(0, n - 1);
	for (int i = 0; i < n; i++) {
    printf("%d ", d[i]);
  }
}
