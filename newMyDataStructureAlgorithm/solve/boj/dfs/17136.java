package dss;
//fail
import java.util.Scanner;

public class test03 {
	static final int N = 10;
	static int a[][], things[], ans;
	static boolean check[][], write;

	static boolean possible(int x, int y, int size) {
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (a[i + x][j + y] != 1 || check[i + x][j + y]) {
					return false;
				}
			}
		}
		return true;
	}

	static void chkTrue(int x, int y, int size) {
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				check[i + x][j + y] = true;
			}
		}
	}

	static void chkFalse(int x, int y, int size) {
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				check[i + x][j + y] = false;
			}
		}
	}

	static boolean chkEnd() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (a[i][j] == 1 && !check[i][j]) {
					return false;
				}
			}
		}
		return true;
	}

	static void dfs(int cnt) {
		if (ans <= cnt) {
			return;
		}
		if (chkEnd()) {
			if (ans > cnt) {
				ans = cnt;
			}
			return;
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (a[i][j] == 0 || check[i][j]) {
					continue;

				}
//				System.out.println(i + " " + j +" "+cnt);
				for (int k = 5; k >= 1; k--) {
					if (things[k] >= 5 ) {
						continue;
//						return;
					}
					int x = i + k - 1;
					int y = j + k - 1;
					if (x < N && y < N) {
						if (possible(i, j, k)) {
							chkTrue(i, j, k);
							things[k] += 1;
							dfs(cnt + 1);
							things[k] -= 1;
							chkFalse(i, j, k);
						}
					}
				}
			}
		}
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		a = new int[N][N];
		ans = 987654321;
		check = new boolean[N][N];
		things = new int[6];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				a[i][j] = sc.nextInt();
			}
		}
		dfs(0);
		if (ans == 987654321) {
			ans = -1;
		}
		System.out.println(ans);
		sc.close();
	}
}
