package onlineStudy;
//fail
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

public class goDs {
	static final int X[] = { 0, 0, -1, 1 };
	static final int Y[] = { -1, 1, 0, 0 };
	static int N, M, cnt, ans, a[][], dist[][], temp[][];
	static boolean check[][];
	static Pair point[];
	static Queue<Pair> q;

	static void clean(int depth) {
		while (!q.isEmpty()) {
			Pair p = q.remove();
			int x = p.x;
			int y = p.y;
			if (depth == 0) {
				dist[x][y] = 999;
				return;
			}
			for (int k = 0; k < 4; k++) {
				int nx = x + X[k];
				int ny = y + Y[k];
				if (nx < 0 || ny < 0 || nx >= N + 1 || ny >= M + 1 || check[nx][ny]) {
					continue;
				}
				if (temp[nx][ny] == depth - 1) {
					depth--;
					dist[nx][ny] = depth;
					check[nx][ny] = true;
					q.add(new Pair(nx, ny));
					break;
				}
			}
		}
	}

	static void bfs(int caseP) {
		int num = 0;
		if (caseP == -1) {
			num = 0;
		} else if (caseP == -2) {
			num = 2;
		}
		q = new LinkedList<>();
		q.add(new Pair(point[num].x, point[num].y));
		check = new boolean[N + 1][M + 1];
		check[point[num].x][point[num].y] = true;
		while (!q.isEmpty()) {
			Pair p = q.remove();
			int x = p.x;
			int y = p.y;
			for (int k = 0; k < 4; k++) {
				int nx = x + X[k];
				int ny = y + Y[k];
				if (nx < 0 || ny < 0 || nx >= N + 1 || ny >= M + 1 || check[nx][ny]) {
					continue;
				}
				if (dist[nx][ny] != 0 || (a[nx][ny] != 0 && a[point[num].x][point[num].y] != caseP)) {
					continue;
				}
				if (dist[nx][ny] == 0) {
					q.add(new Pair(nx, ny));
					check[nx][ny] = true;
					dist[nx][ny] = dist[x][y] + 1;
				}
				if (a[nx][ny] == a[point[num].x][point[num].y]) {
					dist[nx][ny] = dist[x][y] + 1;
					ans += dist[nx][ny];
					cnt++;
					q = new LinkedList<>();
					q.add(new Pair(nx, ny));
					if (cnt == 2) {
						return;
					} else {
						int tp = dist[nx][ny];
						temp = new int[N + 1][M + 1];
						for (int i = 0; i <= N; i++) {
							for (int j = 0; j <= M; j++) {
								temp[i][j] = dist[i][j];
							}
						}
						dist[nx][ny] = tp;
						check = new boolean[N + 1][M + 1];
						dist = new int[N + 1][M + 1];
						clean(tp);
					}
				}
			}
		}
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		a = new int[N + 1][M + 1];
		dist = new int[N + 1][M + 1];
		point = new Pair[4];
		ans = 0;
		cnt = 0;
		for (int i = 0; i < 4; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			point[i] = new Pair(x, y);
			if (i == 0 || i == 1) {
				a[x][y] = -1;
			} else {
				a[x][y] = -2;
			}
		}
		bfs(-1);
		System.out.println(ans);
		int answer = ans;
		bfs(-2);
		System.out.println(ans);
		if (answer == ans) {
			System.out.println("IMPOSSIBLE");
		} else {
			System.out.println(ans);
		}
		sc.close();
	}
}
