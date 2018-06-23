import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 
 * @author kimdohyun
 * https://swexpertacademy.com/
 * D4 1486. 장훈이의 높은 선반 
 * 사용한 알고리즘 : 재귀 완전탐색 
 */
public class D4_1486 {
	private static int n, b, min, h[];

	private static void dfs(int now, int sum) {
		int temp = 0;
		for (int i = now + 1; i <= n; i++) {
			temp = sum + h[i];
			if (temp < b)
				dfs(i, temp);
			else
				min = Math.min(min, temp);
		}
	}

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int TC = 1; TC <= T; TC++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			min = 987654321;
			h = new int[n + 1];
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= n; i++) {
				h[i] = Integer.parseInt(st.nextToken());
			}
			dfs(0, 0);
			System.out.println("#" + TC + " " + (min - b));
		}
	}
}