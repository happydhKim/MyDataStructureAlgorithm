package dss;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Cell {
	int x;
	int y;
	int life;
	int time;
	String state;

	Cell(int x, int y, int life, int time, String state) {
		this.x = x;
		this.y = y;
		this.life = life;
		this.time = time;
		this.state = state;
	}
}

public class test02 {
	static final int X[] = { -1, 1, 0, 0 };
	static final int Y[] = { 0, 0, -1, 1 };
	static final int MAX = 500;
	static int N, M, K, cnt, ans, a[][], dist[][];
	static boolean death[][];
	static Queue<Cell> q;

	static void bfs(int depth) {
		int size = q.size();
		for (int i = 0; i < MAX; i++) {
			Arrays.fill(dist[i], 0);
		}
		for (int i = 0; i < size; i++) {
			Cell c = q.remove();
			int x = c.x;
			int y = c.y;
			int life = c.life;
			int time = c.time + 1;
			String state = c.state;
			if (a[x][y] > life) {
				continue;
			}
			if (state == "noact" && life > time) { // 1. 활성화 안된 녀석들 +시간 안된 녀석들 돌려 보내기
				q.add(new Cell(x, y, life, time, "noact"));
				continue;
			} else if (state == "noact" && life == time) { // 2. 활성화 안된 녀석들 시간 맞춰 활성화 시키기
				q.add(new Cell(x, y, life, 0, "act"));
				continue;
			}
			if (state == "act" && life < time) { // 3. 활성화 된 녀석들 시간 맞춰 하늘로.
				a[x][y] = 10;
				death[x][y] = true;
				continue;
			}
			for (int k = 0; k < 4; k++) {
				int nx = x + X[k];
				int ny = y + Y[k];
				if (!death[nx][ny] && a[nx][ny] < life) { // 4. 활성화 된 녀석들 번식 // 여기서 중복 되었을 때, 큐에 중복으로 집어 넣는 문제.
					a[nx][ny] = life;
					death[nx][ny] = true;
					dist[nx][ny] = 1;
					q.add(new Cell(nx, ny, life, 0, "noact"));
				} else if (death[nx][ny] && dist[nx][ny] == 1 && a[nx][ny] < life) {
					a[nx][ny] = life;
					dist[nx][ny] = 1;
					q.add(new Cell(nx, ny, life, 0, "noact"));
				}
				if (state == "act" && life == time) { // 3. 활성화 된 녀석들 시간 맞춰 하늘로. (life 1 때문)
					a[x][y] = 10;
					dist[x][y] = 1;
					death[x][y] = true;
					continue;
				} else {
					q.add(new Cell(x, y, life, time, "act"));
				}
			}
		}
		if (q.size() == 0) {
			return;
		} else {
			if (depth == K) {
				return;
			}
			bfs(depth + 1);
		}
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int TC = 1; TC <= T; TC++) {
			N = sc.nextInt(); // 세로
			M = sc.nextInt(); // 가로
			K = sc.nextInt(); // 배양 시간
			a = new int[MAX][MAX];
			dist = new int[MAX][MAX];
			death = new boolean[MAX][MAX];
			ans = 0;
			q = new LinkedList<>();
			for (int i = MAX / 2; i < (MAX / 2) + N; i++) {
				for (int j = MAX / 2; j < (MAX / 2) + M; j++) {
					a[i][j] = sc.nextInt();
					if (a[i][j] != 0) {
						q.add(new Cell(i, j, a[i][j], 0, "noact"));
						death[i][j] = true;
					}
				}
			}
			bfs(1);
			for (int i = 0; i < MAX; i++) {
				for (int j = 0; j < MAX; j++) {
					if (a[i][j] >= 1 && a[i][j] != 10) {
						ans++;
					}
				}
			}
			System.out.println("#" + TC + " " + ans);
		}
		sc.close();
	}
}
