package dss;

import java.util.Scanner;

class Pair {
	int x;
	int y;

	Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class temp {
	static int N, M, H, cnt, ans, a[][], made[];
	static boolean check[][], cont[];
	static Pair ladder[];

	static boolean go(int a[][]) {
		boolean chk = true;
		for (int i = 0; i < N + 1; i++) {
			int nx = 0;
			int ny = i;
			for (int j = 1; j < H + 1; j++) {
				nx = j;
				if (i - 1 >= 0 && a[nx][ny] == 1) {
					ny--;
				} else if (i + 1 <= H && a[nx][ny] == 1) {
					ny++;
				}
			}
			if (ny == i) {
				chk = true;
			} else {
				chk = false;
				return false;
			}
		}
		return chk;
	}

	static void dfs(int depth, int r, int lCnt) {
		if (ans != 987654321) {
			return;
		}
		if (depth >= lCnt) {
//			for (int i = 0; i < H + 1; i++) {
//				for (int j = 0; j < N + 1; j++) {
//					System.out.print(a[i][j]+" ");
//				}
//				System.out.println();
//			}
//			System.out.println();
			if (go(a)) {
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
		cont = new boolean[N * H];
		check = new boolean[H + 1][N + 1];
		made = new int[3];
		ans = 987654321;
		ladder = new Pair[M];
		for (int i = 0; i < M; i++) {
			ladder[i] = new Pair(sc.nextInt(), sc.nextInt());
			a[ladder[i].x][ladder[i].y] = 1;
			check[ladder[i].x][ladder[i].y] = true;
		}
		for (int i = 0; i < 4; i++) {
			dfs(0, 1, i);
			if (ans != 987654321) {
				break;
			}

		}
//		dfs(0, 1, 1);
		if (ans != 987654321) {
			System.out.println("-1");
		} else {
			System.out.println(ans);
		}
		sc.close();
	}
}
