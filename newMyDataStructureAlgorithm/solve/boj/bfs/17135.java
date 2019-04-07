import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

class Pair {
	int x;
	int y;

	Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Main {
	static int X[] = { 0, 0, -1, 1 };
	static int Y[] = { -1, 1, 0, 0 };
	static int N, M, D, cnt, ans, a[][], dist[][], arrow[];
	static boolean arrowc[], check[][];
	static Queue<Pair> q;

	static void goArmy() {
		for (int m = 0; m < M; m++) {
			Stack<Integer> st = new Stack<>();
			for (int n = 0; n < N - 1; n++) {
				st.add(dist[n][m]);
			}
			for (int n = N - 1; n >= 1; n--) {
				dist[n][m] = st.pop();
			}
		}
		for (int m = 0; m < M; m++) {
			dist[0][m] = 0;
		}
	}

	static void bfs() {
		boolean end = false;
		for (int i = 0; i < D; i++) {
			int size = q.size();
			if (end) {
				break;
			}
			for (int s = 0; s < size; s++) {
				Pair p = q.remove();
				int x = p.x;
				int y = p.y;
				for (int k = 0; k < 4; k++) {
					int nx = x + X[k];
					int ny = y + Y[k];
					if (nx < 0 || ny < 0 || nx >= N + 1 || ny >= M || check[nx][ny] || dist[nx][ny] == -1) {
						continue;
					}
					check[nx][ny] = true;
					if (dist[nx][ny] != 0) {
						end = true;
					}
					q.add(new Pair(nx, ny));
				}
			}
		}
		if (end) {
			int dx = 0;
			int dy = 999;
			while (!q.isEmpty()) {
				Pair p = q.remove();
				int x = p.x;
				int y = p.y;
				if (dist[x][y] >= 1) {
					if (y < dy) {
						dx = x;
						dy = y;
					} else if (y == dy) {
						if (x < dx) {
							dx = x;
							dy = y;
						}
					}
				}
			}
			dist[dx][dy]++;
		}
	}

	static void go() {
		cnt = 0;
		dist = new int[N + 1][M];
		for (int i = 0; i < N + 1; i++) {
			for (int j = 0; j < M; j++) {
				dist[i][j] = a[i][j];
			}
		}
		for (int t = 0; t < N; t++) {
			for (int i = 0; i < 3; i++) {
				q = new LinkedList<>();
				check = new boolean[N + 1][M];
				q.add(new Pair(N, arrow[i]));
				bfs();
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (dist[i][j] > 1) {
						dist[i][j] = 0;
						cnt++;
					}
				}
			}
			goArmy();
		}
	}

	static void dfs(int depth, int idx) {
		if (depth == 3) {
			a[N][arrow[0]] = -1;
			a[N][arrow[1]] = -1;
			a[N][arrow[2]] = -1;
			go();
			if (ans < cnt) {
				ans = cnt;
			}
			a[N][arrow[0]] = 0;
			a[N][arrow[1]] = 0;
			a[N][arrow[2]] = 0;
			return;
		}
		for (int i = idx; i < M; i++) {
			if (arrowc[i]) {
				continue;
			}
			arrow[depth] = i;
			arrowc[i] = true;
			dfs(depth + 1, i + 1);
			arrowc[i] = false;
		}
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		D = sc.nextInt();
		a = new int[N + 1][M];
		arrow = new int[3];
		arrowc = new boolean[M];
		ans = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				a[i][j] = sc.nextInt();
			}
		}
		dfs(0, 0);
		System.out.println(ans);
		sc.close();
	}
}
