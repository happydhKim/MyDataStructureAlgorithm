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
	static int N, L, R, cnt, ans, sum, a[][];
	static boolean check[][], answer, cycle;
	static Queue<Pair> sq;// search q
	static Queue<Pair> nq;// 이웃

	static void bfs() {
		boolean first = true;
		while (!sq.isEmpty()) {
			Pair p = sq.remove();
			int x = p.x;
			int y = p.y;
			for (int k = 0; k < 4; k++) {
				int nx = x + X[k];
				int ny = y + Y[k];
				if (nx < 0 || ny < 0 || nx >= N || ny >= N || check[nx][ny]) {
					continue;
				}
				int calc = Math.abs(a[x][y] - a[nx][ny]);
				if (calc >= L && calc <= R) {
					if (first) {
						first = false;
						sq.add(new Pair(x, y));
						nq.add(new Pair(x, y));
						sum += a[x][y];
					}
					check[nx][ny] = true;
					sq.add(new Pair(nx, ny));
					nq.add(new Pair(nx, ny));
					sum += a[nx][ny];
				}
				first = false;
			}
		}
		int size = nq.size();
		System.out.println(size);
		if (size == 0) {
			return;
		} else {
			int val = sum / size;

			while (!nq.isEmpty()) {
				Pair p = nq.remove();
				int x = p.x;
				int y = p.y;
//				System.out.println(size);
				a[x][y] = val;

			}
//			for (int i = 0; i < N; i++) {
//				for (int j = 0; j < N; j++) {
//					System.out.print(a[i][j] + " ");
//				}
//				System.out.println();
//			}
//			System.out.println();
			cycle = true;
		}
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		L = sc.nextInt();
		R = sc.nextInt();
		a = new int[N][N];
		answer = false;
		ans = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				a[i][j] = sc.nextInt();
			}
		}
		while (!answer) {
			check = new boolean[N][N];
			cycle = false;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					sq = new LinkedList<>();
					nq = new LinkedList<>();
					if (!check[i][j]) {
						check[i][j] = true;
						sq.add(new Pair(i, j));
						sum = 0;
						bfs();
					}
				}
			}
			if (cycle) {
				ans++;
			} else {
				answer = true;
			}
		}
		System.out.println(ans);
		sc.close();
	}
}
