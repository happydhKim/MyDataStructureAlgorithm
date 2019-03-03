//https://mygumi.tistory.com/310

// 힙 정렬은 완전 이진 트리를 기본으로 하는 힙(Heap) 자료구조를 기반으로한 정렬 방식이다.
// 힙에는 부모 노드의 값이 자식 노드의 값보다 항상 큰 최대 힙과 그 반대인 최소 힙이 존재한다. (힙 위키)
// 완전 이진 트리는 삽입할 때 왼쪽부터 차례대로 추가하는 이진 트리를 말한다.
// 주의할 점은 부모-자식 관계간의 이야기이고, 형제간은 고려하지 않는다.
// 시간복잡도는 최악, 최선, 평균 모두 O(nlogn) 을 가진다.
// 또한 불안정 정렬에 속한다.

public class heapSort {
	private static void heapify(int array[], int n, int i) {
		int p = i;
		int l = i * 2 + 1;
		int r = i * 2 + 2;
		if (l < n && array[p] < array[l]) {
			p = l;
		}
		if (r < n && array[p] < array[r]) {
			p = r;
		}
		if (i != p) {
			swap(array, p, i);
			heapify(array, n, p);
		}
	}

	private static void heapSort(int array[]) {
		int n = array.length;
		// init, max heap
		for (int i = n / 2 - 1; i >= 0; i--) {
			heapify(array, n, i);
		}
		// for extract max element from heap
		for (int i = n - 1; i > 0; i--) {
			swap(array, 0, i);
			heapify(array, i, 0);
		}
	}

	private static void swap(int array[], int a, int b) {
		int temp = array[a];
		array[a] = array[b];
		array[b] = temp;
	}

	private static void solve() {
		int array[] = { 230, 10, 60, 550, 40, 220, 20 };
		heapSort(array);
		for (int v : array) {
			System.out.println(v);
		}
	}

	public static void main(String args[]) {
		solve();
	}
}
