거품정렬 (Bubble Sort)
거품정렬(Bubble Sort)은 인접한 원소들의 대소관계를 비교하여 일정한 대소관계를 만족하지 않을 시, 인접한 원소를 교환하는 방법으로 진행되는 정렬입니다.

한번 교환 작업을 통해 4개의 원소 중 가장 큰 원소가 마지막으로 감을 확인할 수 있습니다.
이를 통해 마지막 원소를 정렬이 완료된 것이고, 이를 N-1 번 반복한다면 모두 정렬이 완료될 것입니다.

인접한 원소들은 대소관계에 따라 교환이 되기 때문에, 그림의 노란 영역처럼 가장 큰 수가 가장 마지막에 오게 됩니다.

이를 통해 N개의 원소가 있다면, N - 1 번의 그림과 같은 교환을 통해 정렬할 수 있습니다.

거품정렬의 시간복잡도는 고려해야 할 루프가 (정렬해야 할 원소의 개수 - 1) * (최대 교환 수)이므로 총 O ( N ^ 2 ) 가 됩니다.
힙 정렬, 퀵 정렬과 같은 정렬보다 상당히 비효율적이므로 자주 쓰이지 않습니다.

공간복잡도는 O(1)

input
4
4  2  3  1
output
1  2  3  4

import java.util.Scanner;

public class test01 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a[] = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n - i - 1; j++) {
				if (a[j] > a[j + 1]) {
					int temp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = temp;
				}
			}
		}
		for (int i = 0; i < n; i++) {
			System.out.print(a[i] + " ");
		}
		sc.close();
	}
}
