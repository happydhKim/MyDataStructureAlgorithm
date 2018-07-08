import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 
 * @author kimdohyun
 * https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWQl9TIK8qoDFAXj&categoryId=AWQl9TIK8qoDFAXj&categoryType=CODE
 * D4 러시아 국기 같은 깃발
 */
public class D4_4614 {
	private static int N, M, ans;
	private static char a[][];

	private static void white(int depth, int cnt) {
		if (depth == N - 2) {
			blue(depth, cnt);
			return;
		}
		for (int i = 0; i < M; i++) {
			if (a[depth][i] != 'W') {
				cnt++;
			}
		}
		white(depth + 1, cnt);
		blue(depth + 1, cnt);
	}

	private static void blue(int depth, int cnt) {
		if (depth == N - 1) {
			red(depth, cnt);
			return;
		}
		for (int i = 0; i < M; i++) {
			if (a[depth][i] != 'B') {
				cnt++;
			}
		}
		blue(depth + 1, cnt);
		red(depth + 1, cnt);
	}

	private static void red(int depth, int cnt) {
		if (depth == N) {
			if (ans > cnt) {
				ans = cnt;
			}
			return;
		}
		for (int i = 0; i < M; i++) {
			if (a[depth][i] != 'R') {
				cnt++;
			}
		}
		red(depth + 1, cnt);
	}

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int TC = 1; TC <= T; TC++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			a = new char[N][M];
			ans = 123456789;
			for (int i = 0; i < N; i++) {
				String s = br.readLine();
				for (int j = 0; j < M; j++) {
					a[i][j] = s.charAt(j);
				}
			}
			white(0, 0);
			System.out.println("#" + TC + " " + ans);
		}
	}
}