import java.util.Scanner;

public class permutation {
	static int N, cnt, ans, a[][], team[];
	static boolean check[];


	static void dfs(int depth,int idx) {
		if (depth == N) {
			for (int i = 0; i < N; i++) {
				System.out.print(team[i]+" ");
			}
			System.out.println();
			return;
		}
		for (int i = idx; i < N; i++) {
			// if (check[i]) {
			// 	continue;
			// }
			check[i] = true;
			team[depth] = i;
			dfs(depth + 1,idx+1);
			check[i] = false;
		}
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		a = new int[N][N];
		team = new int[N];
		check = new boolean[N];
		ans = 987654321;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				a[i][j] = sc.nextInt();
			}
		}
		dfs(0,0);
		System.out.println(ans);
		sc.close();
	}
}
