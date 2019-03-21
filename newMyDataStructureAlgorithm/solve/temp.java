import java.util.Scanner;

class Ladder {
	int x;
	int y;

	Ladder(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class test02 {
	static int N, M, H, a[][], cnt, ans;
	static Ladder ladder[];

	static void dfs() {

	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); // 세로 개수
		M = sc.nextInt(); // 가로 개수
		a = new int[M + 1][N + 1];
		ladder = new Ladder[M];
		ans = 987654321;
//			for (int i = 0; i < M; i++) {
//				for (int j = 0; j < N; j++) {
//					a[i][j] = sc.nextInt();
//				}
//			}
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
		if (M == 0) {
			System.out.println(0);
		} else {
			System.out.println(ans);
		}
		sc.close();
	}
}
