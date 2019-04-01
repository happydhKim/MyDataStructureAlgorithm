import java.util.Scanner;

class 15684 {
	static int N, M, H, cnt, ans, a[][];

	static boolean go() {
		for (int z = 1; z <= N; z++) {
			int val = z;
			for (int i = 1; i <= H; i++) {
				if (a[i][val] == 1) {
					val++;
				} else if (a[i][val - 1] == 1) {
					val--;
				}
			}
			if (val == z)
				continue;
			else
				return false;
		}
		return true;
	}

	static void dfs(int depth, int r, int lCnt) { //사다리 몇번?, row, 최대 사다리
		if (ans != 987654321) {
			return;
		}
		if (depth >= lCnt) {
			if (go()) {
				ans = depth;
			}
			return;
		}
		for (int i = r; i <= H; i++) {
			for (int j = 1; j < N; j++) {
				if (a[i][j] == 1 || a[i][j - 1] == 1 || a[i][j + 1] == 1) {
					continue;
				}
				a[i][j] = 1;
				dfs(depth + 1, i, lCnt);
				a[i][j] = 0;
			}
		}
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); // 가로
		M = sc.nextInt(); // 세로 수
		H = sc.nextInt(); // 세로
		a = new int[H + 1][N + 1];
		ans = 987654321;
		for (int i = 0; i < M; i++) {
			a[sc.nextInt()][sc.nextInt()] = 1;
		}
		for (int i = 0; i < 4; i++) {
			dfs(0, 1, i);
			if (ans != 987654321) {
				break;
			}
		}
		if (ans != 987654321) {
			System.out.println(ans);
		} else {
			System.out.println("-1");
		}
		sc.close();
	}
}
