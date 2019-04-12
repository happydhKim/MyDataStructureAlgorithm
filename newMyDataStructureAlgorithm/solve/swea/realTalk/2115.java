import java.util.Scanner;

public class 2115 {
	static int N, M, C, a[][], cnt, cnt2, ans;
	static boolean check[][];

	static int getMax(int x, int y, int m, int c) {
		if (m == 0) {
			return 0;
		}
		if (y >= N) {
			return 0;
		}
		if (m == 1 && a[x][y] > c) {
			return 0;
		}
		if (a[x][y] <= c) {
			return Math.max(a[x][y] * a[x][y] + getMax(x, y + 1, m - 1, c - a[x][y]), getMax(x, y + 1, m - 1, c));
		} else {
			return getMax(x, y + 1, m - 1, c);
		}
	}

	static void go() {
		cnt2 = 0;
		int temp;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				boolean stop = false;
				for (int k = 0; k < M + j; k++) {
					if (k >= N || check[i][k]) {
						stop = true;
						break;
					}
				}
				if (stop) {
					continue;
				}
				temp = getMax(i, j, M, C);
				if (cnt2 < temp) {
					cnt2 = temp;
				}
			}
		}
		cnt += cnt2;
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int TC = 1; TC <= T; TC++) {
			N = sc.nextInt();
			M = sc.nextInt();
			C = sc.nextInt();
			a = new int[N][N];
			ans = 0;
			check = new boolean[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					a[i][j] = sc.nextInt();
				}
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					cnt = 0;
					if (j + M - 1 >= N) {
						continue;
					}
					for (int k = j; k < M + j; k++) {
						check[i][k] = true;
					}
					cnt = getMax(i, j, M, C);
					go();
					for (int k = 0; k < M + j; k++) {
						check[i][k] = false;
					}
					if (ans < cnt) {
						ans = cnt;
					}
				}
			}
			System.out.println("#" + TC + " " + ans);
		}
		sc.close();
	}
}
