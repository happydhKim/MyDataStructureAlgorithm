package onlineStudy;

//fail
import java.util.Scanner;

public class goDs2 {
	static int a[][], ans;
	static boolean write;

	static void dfs(int x, int y, int things[], int cnt, boolean check[][]) {
		// System.out.println(x + " " + y);
		if (x == 9 && y == 10) {// end
			for (int i = 0; i < 10; i++) {
				for (int j = 0; j < 10; j++) {
					if (a[i][j] == 1 && !check[i][j]) {
						System.out.println(cnt);
						return;
					}
				}
			}
			if (ans > cnt) {
				ans = cnt;
				System.out.println(ans + "answer");
				return;
			}
		}
		if (y == 10) {
			x++;
			y = 0;
		}
		if (a[x][y] == 1 && !check[x][y]) {
			for (int i = 0; i < 5; i++) {
				if (x + i >= 10 || y + i >= 10) {
					continue;
				}
				write = false;
				if (things[i] == 0) {
					continue;
				} else {
					things[i] -= 1;
				}

				boolean possible = true;
				int size = i + 1;
				for (int q = 0; q < size; q++) {
					if (!possible) {
						break;
					}
					for (int j = 0; j < size; j++) {
						if (x + q >= 10 || y + j >= 10 || check[x + q][y + j] || a[x + q][y + j] != 1) {
							possible = false;
							break;
						}
					}
				}
				if (possible) {
					write = true;
					for (int q = 0; q < size; q++) {
						for (int j = 0; j < size; j++) {
							check[x + q][y + j] = true;
						}
					}
				}
				if (!write) {
					continue;
				}
				dfs(x, y + 1, things, cnt + 1, check);
				things[i] += 1;
				for (int q = 0; q < size; q++) {
					for (int j = 0; j < size; j++) {
						check[x + q][y + j] = false;
					}
				}
			}
		} else {
			dfs(x, y + 1, things, cnt, check);
		}
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		a = new int[10][10];
		ans = 987654321;
		boolean check[][] = new boolean[10][10];
		int things[] = new int[5];
		for (int i = 0; i < 5; i++) {
			things[i] = 5;
		}
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				a[i][j] = sc.nextInt();
			}
		}
		dfs(0, 0, things, 0, check);
		if (ans == 987654321) {
			ans = -1;
		}
		System.out.println(ans);
		sc.close();
	}
}
