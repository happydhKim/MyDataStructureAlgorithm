import java.util.Scanner;

public class temp {
	static int D, W, K, cnt, aCnt, bCnt, ans, a[][], temp[][], step[];

	static void init() {
		for (int i = 0; i < D; i++) {
			for (int j = 0; j < W; j++) {
				temp[i][j] = a[i][j];
			}
		}
	}

	static boolean check() {
		boolean chk = true;
		for (int i = 0; i < W; i++) {
			aCnt = 0;
			bCnt = 0;
			if (!chk) {
				return false;
			}
			for (int j = 0; j < D; j++) {
				if (temp[j][i] == 0) {
					bCnt = 0;
					aCnt++;
					if (aCnt == K) {
						chk = true;
						break;
					} else {
						chk = false;
					}
				} else {
					aCnt = 0;
					bCnt++;
					if (bCnt == K) {
						chk = true;
						break;
					} else {
						chk = false;
					}
				}
			}
		}
		return true;
	}

	static void go() {
		for (int k = 0; k < D; k++) {
			if (step[k] == 0) {
				continue;
			} else {
				for (int i = 0; i < W; i++) {
					temp[k][i] = step[k] - 1;
				}
			}
		}

	}

	static void dfs(int depth) {
		if (depth == D) {
			init();
			go();
			cnt = 0;
			if (check()) {
				for (int i = 0; i < D; i++) {
					if (step[i] != 0) {
						cnt++;
					}
				}
				if (ans > cnt) {
					ans = cnt;
				}
			}
			return;
		}
		for (int i = 0; i < 3; i++) {
			step[depth] = i;

			dfs(depth + 1);
		}
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int TC = 1; TC <= T; TC++) {
			D = sc.nextInt();
			W = sc.nextInt();
			K = sc.nextInt();
			step = new int[D];
			a = new int[D][W];
			ans = 987654321;
			temp = new int[D][W];
			for (int i = 0; i < D; i++) {
				for (int j = 0; j < W; j++) {
					a[i][j] = sc.nextInt();
				}
			}
			dfs(0);
			System.out.println("#" + TC + " " + ans);
		}
		sc.close();
	}
}
