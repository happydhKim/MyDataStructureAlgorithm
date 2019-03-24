package onlineStudy;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Fish {
	int x;
	int y;
	int step;

	Fish(int x, int y, int step) {
		this.x = x;
		this.y = y;
		this.step = step;
	}
}

public class goDs {
	static final int X[] = { -1, 0, 0, 1 }; // 상 좌 우 하
	static final int Y[] = { 0, -1, 1, 0 };

	static int N, a[][], dist[][], age, cnt, eat, ans;
	static boolean check[][], door;
	static Queue<Fish> q;
	static Queue<Fish> temp;

	static void bfs() {
		door = false;
		while (true) {
			int size = q.size();
			if (size == 0) {
				return;
			}
			for (int i = 0; i < size; i++) {
				Fish f = q.remove();
				int x = f.x;
				int y = f.y;
				int step = f.step;
				for (int k = 0; k < 4; k++) {
					int nx = x + X[k];
					int ny = y + Y[k];
					if (nx < 0 || ny < 0 || nx >= N || ny >= N) {
						continue;
					}
					if (!check[nx][ny] && a[nx][ny] != 0 && a[nx][ny] < age) {
						if (door && cnt < step) {
							break;
						}
						temp.add(new Fish(nx, ny, step + 1));
						check[nx][ny] = true;
						door = true;
						cnt = step;
					}
					if ((!check[nx][ny] && a[nx][ny] == 0) || (!check[nx][ny] && a[nx][ny] == age)) {
						q.add(new Fish(nx, ny, step + 1));
						check[nx][ny] = true;
					}
				}
			}
		}

	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		a = new int[N][N];
		dist = new int[N][N];
		check = new boolean[N][N];
		q = new LinkedList<>();
		temp = new LinkedList<>();
		age = 2;
		ans = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				a[i][j] = sc.nextInt();
				if (a[i][j] == 9) {
					a[i][j] = 0;
					q.add(new Fish(i, j, 0));
					check[i][j] = true;
				}
			}
		}
		bfs();
		System.out.println(ans);
		sc.close();
	}
}
