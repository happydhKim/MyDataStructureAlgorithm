import java.util.Scanner;
import java.util.Stack;

public class Main {
	static int N, a[][], dist[][], cnt, ans, dice[], dir[][];

	static void init() {
		dist = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				dist[i][j] = a[i][j];
			}
		}
	}

	static void left() {
		for (int i = 0; i < N; i++) {
			Stack<Integer> st = new Stack<>();
			for (int j = 0; j < N; j++) {
				if (dist[i][j] != 0) {
					st.add(dist[i][j]);
					dist[i][j] = 0;
				}
			}
			int pivot = 0;
			boolean check[] = new boolean[N];
			int j = 0;
			while (!st.isEmpty()) {
				pivot = st.pop();
				if (j != 0) {
					if (!check[j - 1] && pivot == dist[i][j - 1]) {
						dist[i][j - 1] = pivot * 2;
						check[j - 1] = true;
						j--;
					} else {
						dist[i][j] = pivot;
					}
				} else {
					dist[i][j] = pivot;
				}
				j++;
			}
		}
	}

	static void right() {
		for (int i = 0; i < N; i++) {
			Stack<Integer> st = new Stack<>();
			for (int j = N - 1; j >= 0; j--) {
				if (dist[i][j] != 0) {
					st.add(dist[i][j]);
					dist[i][j] = 0;
				}
			}
			int pivot = 0;
			boolean check[] = new boolean[N];
			int j = N - 1;
			while (!st.isEmpty()) {
				pivot = st.pop();
				if (j != N - 1) {
					if (!check[j + 1] && pivot == dist[i][j + 1]) {
						dist[i][j + 1] = pivot * 2;
						check[j + 1] = true;
						j++;
					} else {
						dist[i][j] = pivot;
					}
				} else {
					dist[i][j] = pivot;
				}
				j--;
			}
		}
	}

	static void up() {
		for (int i = 0; i < N; i++) {
			Stack<Integer> st = new Stack<>();
			for (int j = 0; j < N; j++) {
				if (dist[j][i] != 0) {
					st.add(dist[j][i]);
					dist[j][i] = 0;
				}
			}
			int pivot = 0;
			boolean check[] = new boolean[N];
			int j = 0;
			while (!st.isEmpty()) {
				pivot = st.pop();
				if (j != 0) {
					if (!check[j - 1] && pivot == dist[j - 1][i]) {
						dist[j - 1][i] = pivot * 2;
						check[j - 1] = true;
						j--;
					} else {
						dist[j][i] = pivot;
					}
				} else {
					dist[j][i] = pivot;
				}
				j++;
			}
		}
	}

	static void down() {
		for (int i = 0; i < N; i++) {
			Stack<Integer> st = new Stack<>();
			for (int j = N - 1; j >= 0; j--) {
				if (dist[j][i] != 0) {
					st.add(dist[j][i]);
					dist[j][i] = 0;
				}
			}
			int pivot = 0;
			boolean check[] = new boolean[N];
			int j = N - 1;
			while (!st.isEmpty()) {
				pivot = st.pop();
				if (j != N - 1) {
					if (!check[j + 1] && pivot == dist[j + 1][i]) {
						dist[j + 1][i] = pivot * 2;
						check[j + 1] = true;
						j++;
					} else {
						dist[j][i] = pivot;
					}
				} else {
					dist[j][i] = pivot;
				}
				j--;
			}
		}
	}

	static void go() {
		init();
		for (int i = 0; i < 5; i++) {
			if (dice[i] == 0) {
				left();
			} else if (dice[i] == 1) {
				right();
			} else if (dice[i] == 2) {
				up();
			} else if (dice[i] == 3) {
				down();
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (dist[i][j] > cnt) {
					cnt = dist[i][j];
				}
			}
		}
		if (ans < cnt) {
			ans = cnt;
		}
	}

	static void dfs(int depth) {
		if (depth == 5) {
			cnt = 0;
			go();
			return;
		}
		for (int i = 0; i < 4; i++) {
			dice[depth] = i;
			dfs(depth + 1);
		}
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		a = new int[N][N];
		dice = new int[5];
		dir = new int[4][2];
		ans = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				a[i][j] = sc.nextInt();
			}
		}
		dfs(0);
		System.out.println(ans);
		sc.close();
	}
}
