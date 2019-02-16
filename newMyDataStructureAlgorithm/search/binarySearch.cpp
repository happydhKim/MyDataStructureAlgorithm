// Binary Search (이진 탐색)
// 이진 탐색(Binary Search)은 정렬된 배열에서 원하는 값을 시간복잡도 O(log N) 만에 찾아내는 탐색하는 방법입니다.
// 오름차순으로 정렬된 사이즈가 N인 배열 D에서 원하는 값 k를 찾는 방법은 다음과 같습니다.
// 먼저 탐색할 데이터의 범위를 두 개의 인덱스(왼쪽, 오른쪽)로 지정하고 이를 L, R이라고 하겠습니다. 정렬되어있기 때문에 D[L]은 최솟값, D[R]은 최대값이 됩니다.
// 당연히 처음 탐색 시에는 전체영역이므로 L = 0, R = N - 1 입니다. 이중 중앙값(Median)을 찾아 찾으려는 값 k와 비교합니다. 중앙값 M은 (L+R)/2 로 구할 수 있습니다.


// input
// 첫번째줄에 배열 D의 원소의 수 N,
// 두번째줄에는 배열 D의 원소들이 주어집니다.
// 세번째줄에는 질문의 수 M이 들어오며,
// 네번째줄 ~ M + 3번째줄까지 질문 Qi가 들어옵니다.
//
// 8
// -3 0 1 4 7 9 11 16
// 5
// 15
// 0
// -3
// 14
// 100
//
// output
// 입력되는 질문이 배열 D에 포함되어 있다면 “exist”, 그렇지 않다면 “not exist”를 출력합니다.
// not exist
// exist
// exist
// not exist
// not exist

#include <iostream>
#include <algorithm>
using namespace std;

#define MAX 5005

int d[MAX], n;

bool bsearch(int val) {
	int l = 0, r = n - 1;
	while (l <= r) {
		int mid = (l + r) / 2;
		if (val == d[mid]) return true;
		else if (val > d[mid]) l = mid + 1;
		else r = mid - 1;
	}
	return false;
}

int main() {
	cin >> n;
	for (int i = 0; i < n; i++) {
		cin >> d[i];
	}
	sort(d, d + n);
	int query;
	cin >> query;
	while (query--) {
		int x; cin >> x;
		if (bsearch(x)) { cout << "exist" << endl; }
		else { cout << "not exist" << endl; }
	}
}
