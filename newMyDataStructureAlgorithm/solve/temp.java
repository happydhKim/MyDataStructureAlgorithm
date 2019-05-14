import java.util.Scanner;

public class temp {
	static int N, ans;

	static void dfs(int d) {
		if (d == N / 2) {
			System.out.println(d);
			return;
		}
		int temp = d;
		int cnt = d;
		while (temp < N / 2) {
			System.out.println("Asd");
			if (cnt == N) {
				ans++;
			}
			temp++;
			cnt += temp;
		}
		dfs(d+1);
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int TC = 1; TC <= T; TC++) {
			N = sc.nextInt();
			ans = 0;
			dfs(1);
			System.out.println("#" + TC + " " + ans);
		}
		sc.close();
	}
}
