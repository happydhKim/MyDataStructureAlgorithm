package onlineStudy;

import java.util.Scanner;

public class goDs {
	static final int X[] = { 1, 0, -1, 0 };
	static final int Y[] = { 0, 1, 0, -1 };
	static final int GEN[] = { 0, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048 };
	static int N, ans, a[][], dragon[], size;

	static void generation(int x, int y, int d, int g) {
		dragon[0] = d;
		boolean first = true;
		for (int i = 1; i <= g; i++) {
			int step = 0;
			for (int j = GEN[i] - 1; j >= GEN[i - 1]; j--) {
				d = dragon[step++] + 1;
				if (d == 4) {
					d = 0;
				}
				dragon[j] = d;
				size++;
				if (first) {
					first = false;
					break;
				}
			}
		}
		writing(x, y);
	}

	static void writing(int x, int y) {
		int nx = x+200;
		int ny = y+200;
		a[x][y] = 1;
		for (int i = 0; i < size; i++) {
			nx = nx + X[dragon[i]];
			ny = ny + Y[dragon[i]];
			a[nx][ny] = 1;
		}
	}

	static int count() {
		for (int i = 0; i < 1049; i++) {
			for (int j = 0; j < 1049; j++) {
				if (a[i][j] == 1 && a[i + 1][j] == 1 && a[i][j + 1] == 1 && a[i + 1][j + 1] == 1) {
					ans++;
				}
			}
		}
		return ans;
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		a = new int[1050][1050];
		ans = 0;
		for (int i = 0; i < N; i++) {
			dragon = new int[1080];
			size = 1;
			int x = sc.nextInt();
			int y = sc.nextInt();
			int d = sc.nextInt();
			int g = sc.nextInt();
			generation(x, y, d, g);
		}
		System.out.println(count());
		sc.close();
	}
}
