//아직 작업중
import java.util.Scanner;

public class pairSort {
	static int N;

	static void qst(int a[][], int left, int right) {
		int l = left;
		int r = right;

		int pivotX = a[(int) ((left + right) / 2)][0];
		int pivotY = a[(int) ((left + right) / 2)][1];

		while (l <= r) {
			while (a[l][0] < pivotX || (a[l][0] == pivotX && a[l][1] < pivotY)) {
				l++;
			}
			while (pivotX < a[r][0] || (pivotX <= a[r][0] && pivotY < a[r][1])) {
				r--;
			}
			if (l <= r) {
				if (l != r) {
					int tempX = a[l][0];
					int tempY = a[l][1];
					a[l][0] = a[r][0];
					a[l][1] = a[r][1];
					a[r][0] = tempX;
					a[r][1] = tempY;
				}
				l++;
				r--;
			}
		}

		if (left < r) {
			qst(a, left, r);
		}
		if (l < right) {
			qst(a, l, right);
		}
	}

	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int a[][] = new int[N][2];
		for (int i = 0; i < N; i++) {
			a[i][1] = sc.nextInt();
			a[i][0] = sc.nextInt();
		}
		qst(a, 0, N - 1);
		for (int i = 0; i < N; i++) {
			System.out.println(a[i][1] + " " + a[i][0]);
		}
		sc.close();
	}
}
