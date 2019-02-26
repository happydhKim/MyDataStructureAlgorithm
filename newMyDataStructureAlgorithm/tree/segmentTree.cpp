Segment Tree
세그먼트 트리(Segment Tree)는 구간에 대한 정보를 빠르게 구해낼 수 있으며 완전 이진트리 형식의 구조를 가지는 자료구조입니다.
구간의 최솟값을 구하는 세그먼트 트리는 먼저 구하고자 하는 배열을 완전 이진트리의 최하단에 위치시킨 후, 모든 부모 노드가 자식 노드들 중 작은 값을 가지게 하며 트리를 완성시킵니다.
이를 통해 트리의 어떤 노드 X는 X의 하위 노드 중 최솟값을 가지게 됨은 자명합니다.
이 자료구조의 시간 복잡도는 세그먼트 트리 구성에 O(N log N), 갱신에 O(log N), 구간 값을 알아내는데 O(log N)이 걸리므로 매우 빠르게 구간에 대한 정보를 얻을 수 있습니다.
최댓값, 최솟값뿐만 아니라 누적값을 비롯한 여러 정보들을 알맞은 변형을 통하여 빠르게 알아낼 수 있으며, 늦은 전파(lazy propagation)이라는 기법으로 구간 갱신을 효율적으로 개선할 수 있습니다.
그리고 위와 같은 구현은 Bottom-up 구현이라고 합니다. 동작은 유사하지만, 재귀를 활용한 Top-Down 구현 방법도 알아두시면 좋습니다. 시간 복잡도는 같지만, 상수가 다르므로 제한시간을 잘 고려하여 코드를 작성하시면 됩니다.
아래는 Bottom-up 방법으로 구현된 구간의 최솟값을 구할 수 있는 세그먼트 트리 코드입니다.

입력
7
1 -2 3 4 -5 -6 7
3
1 1
2 4
2 7

출력
1
-2
-6

#include <iostream>
#include <vector>
#include <algorithm>
#include <numeric>

using namespace std;

class SegmentTree {
public:
	typedef int dtype;
	vector <dtype> tree;
	int s;
	SegmentTree(int n) {
		for (s = 1; s < n; s *= 2) {}
		tree.resize(s * 2);
		for (int i = 1; i < s * 2; i++) tree[i] = numeric_limits<dtype>::max();
	}

	void insert(vector <dtype> &d) {
		for (int i = s; i < s + d.size(); i++)
			tree[i] = d[i - s];
		for (int i = s - 1; i >= 1; i--)
			tree[i] = min(tree[i * 2], tree[i * 2 + 1]);
	}

	dtype getMin(int Left, int Right) {
		int l = Left + s - 1, r = Right + s - 1;
		dtype rval = numeric_limits<dtype>::max();
		while (l <= r) {
			if (l % 2 == 0) l /= 2;
			else {
				rval = min(rval, tree[l]);
				l = (l / 2) + 1;
			}
			if (r % 2 == 1) r /= 2;
			else {
				rval = min(rval, tree[r]);
				r = (r / 2) - 1;
			}
		}
		return rval;
	}
};

int main() {
	int n, m;
	cin >> n;
	SegmentTree t(n);
	vector <int> v(n);
	for (int i = 0; i < n; i++) cin >> v[i];
	t.insert(v);
	cin >> m;
	while (m--) {
		int a, b; cin >> a >> b;
		cout << t.getMin(a, b) << endl;
	}
}
