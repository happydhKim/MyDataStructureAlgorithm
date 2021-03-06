투 포인터
투 포인터(Two Pointers) 알고리즘은 주로 순차적 접근이 요구되는 조건 등의 특수한 경우에 사용되는 알고리즘입니다.
예를 들면, 정렬된 두 배열이 주어질 때 두 배열을 하나의 정렬된 배열로 합치는 경우, 어떤 배열의 연속 부분집합(contiguous subarray)의 원소의 합이 k인 경우의 수를 찾는 경우 등이 있습니다.

투 포인터 알고리즘의 기본 동작원리는 이름 그대로 두 개의 지점(포인터)를 옮겨가면서 구하고자 하는 답을 구하는 것입니다.

물론, 두 배열을 이어(catenate) 정렬한다면 O((N+M) log (N+M))에 해결을 할 수 있지만, 위의 알고리즘을 사용하면 A배열의 포인터가 한번 순회, B배열의 포인터가 한번 순회로 총 O(N+M)이 나오므로 효율적입니다.

어떤 자연수만 있는 배열의 부분 연속합이 k가 되는 경우의 수를 구하는 문제 또한 하나의 배열에 두 개의 포인터(왼쪽, 오른쪽)를 지정하면 쉽게 해결 가능합니다.
SUM[L, R] < k 일 때, R을 증가시켜주어 k에 근접할 수 있도록 범위를 넓혀주며
SUM[L, R] > k 일 때, L을 증가시켜주어 범위를 좁혀주며
SUM[L, R] == k 일 때는 정답을 카운트해주며 다음 경우를 찾기 위해 다시 L을 증가시켜주어 범위를 좁혀줍니다.

이 알고리즘 또한 두 포인터가 하나의 배열을 두 번 탐색하는 것과 같으므로 시간복잡도는 O(N)으로 빠르게 동작합니다.

특수한 상황에서 적용 가능한 알고리즘이지만, 동작속도가 빠르므로 유용하게 쓰입니다.

입력	출력
첫 번째 줄에 배열 A의 원소의 개수가 주어지고
두 번째 줄에 배열 A의 원소가 주어진다.
세 번째 줄에 배열 B의 원소의 개수가 주어지고
네 번째 줄에 배열 B의 원소가 주어진다.
배열 A, B는 모두 오름차순으로 정렬되어있다.	A, B 두 배열을 합친 후 원소들을 정렬하여 출력한다.

Sample Input
4
1  2  8  9
5
-3  3  4  5  11

Sample Output
-3  1  2  3  4  5  8  9  11


import java.util.ArrayList;
import java.util.Scanner;

public class twoPointer {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		ArrayList<Integer> A = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			A.add(sc.nextInt());
		}

		int m = sc.nextInt();
		ArrayList<Integer> B = new ArrayList<>();
		for (int i = 0; i < m; i++) {
			B.add(sc.nextInt());
		}

		ArrayList<Integer> Sorted = new ArrayList<>();
		int a = 0, b = 0;
		for (int i = 0; i < n + m; i++) {
			if (b == m || (b != m && a < n && A.get(a) < B.get(b))) {
				Sorted.add(A.get(a++));
			} else {
				Sorted.add(B.get(b++));
			}
		}

		for (int x : Sorted) {
			System.out.print(x + " ");
		}
		sc.close();
	}
}
