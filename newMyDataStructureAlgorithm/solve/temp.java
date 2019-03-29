package dss;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Pair {
	int x;
	int y;

	Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class test01 {
	static final int X[] = { 0, 0, -1, 1 };
	static final int Y[] = { -1, 1, 0, 0 };
	static int N, L, R, a[][], cnt, score, ans;
	static boolean check[][], moving[][];
	static Queue<Pair> q = new LinkedList<>();;
	static Queue<Pair> cp;

	static void bfs() {
		cp = new LinkedList<>();
		check = new boolean[N][N];
		moving = new boolean[N][N];
		q.add(new Pair(0, 0));
		score = 0;
		cnt = 0;
		while (!q.isEmpty()) {
			Pair p = q.remove();
			int x = p.x;
			int y = p.y;
			if (check[x][y]) {
				continue;
			}
			check[x][y] = true;
			for (int k = 0; k < 4; k++) {
				int nx = x + X[k];
				int ny = y + Y[k];
				if (nx < 0 || ny < 0 || nx >= N || ny >= N) {
					continue;
				}
				int calc = Math.abs(a[x][y] - a[nx][ny]);
				if (calc >= L && calc <= R && !moving[nx][ny]) {
					moving[nx][ny] = true;
					if (!moving[x][y]) {
						cp.add(new Pair(x, y));
						moving[x][y] = true;
					}
					cp.add(new Pair(nx, ny));
				}
				q.add(new Pair(nx, ny));
			}
		}
		while (!cp.isEmpty()) {
			Pair p = cp.remove();
			int x = p.x;
			int y = p.y;
			cnt++;
			score += a[x][y];
			a[x][y] = -1;
		}
		if (cnt == 0) {
			return;
		} else {
			int val = score / cnt;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (a[i][j] == -1) {
						a[i][j] = val;
					}
				}
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					System.out.print(a[i][j] + " ");
				}
				System.out.println();
			}
			System.out.println();
			ans++;
			bfs();
		}
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		L = sc.nextInt();
		R = sc.nextInt();
		a = new int[N][N];
		ans = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				a[i][j] = sc.nextInt();
			}
		}
		bfs();
		System.out.println(ans);
		sc.close();
	}
}
