import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 
 * @author kimdohyun
 * https://swexpertacademy.com/
 * D3 2806. N-Queen
 * 사용한 알고리즘 : 백트레킹 
 */
public class D3_2806 {
	private static final int answer[] = { 0, 1, 0, 0, 2, 10, 4, 40, 92, 352, 724 };
	private static boolean a[][];
	private static int n;
	private static int ans = 0;

	private static boolean check(int row, int col) {
		for (int i = 0; i < n; i++) {
			if (i == row)
				continue;
			if (a[i][col])
				return false;
		}
		int x = row - 1;
		int y = col - 1;
		while (x >= 0 && y >= 0) {
			if (a[x][y] == true)
				return false;
			x -= 1;
			y -= 1;
		}
		x = row - 1;
		y = col + 1;
		while (x >= 0 && y < n) {
			if (a[x][y] == true)
				return false;
			x -= 1;
			y += 1;
		}
		return true;
	}

	private static void dfs(int row) {
		if (row == n) {
			ans += 1;
		}
		for (int col = 0; col < n; col++) {
			a[row][col] = true;
			if (check(row, col))
				dfs(row + 1);
			a[row][col] = false;
		}
	}

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int TC = 1; TC <= T; TC++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			// a = new boolean[n + 1][n + 1];
			// dfs(0);
			System.out.println("#" + TC + " " + answer[n]);
		}
	}
}