// 느림
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class pairSortLib {
	static int N, a[][];

	static void go() {
		Arrays.sort(a, new Comparator<int[]>() {
			@Override
			public int compare(int x[], int y[]) {
				if (x[1] == y[1]) {
					return Integer.compare(x[0], y[0]);
				} else {
					return Integer.compare(x[1], y[1]);
				}
			}
		});
	}

	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		a = new int[N][2];
		for (int i = 0; i < N; i++) {
			a[i][0] = sc.nextInt();
			a[i][1] = sc.nextInt();
		}
		go();
		for (int i = 0; i < N; i++) {
			System.out.println(a[i][0] + " " + a[i][1]);
		}
		sc.close();
	}
}
