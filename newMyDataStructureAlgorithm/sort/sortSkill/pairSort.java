//아직 작업중

import java.util.Scanner;

public class pairSort {
	static int N, xy[][], st[], sti;

	static void st_push(int v) {
		st[sti++] = v;
	}

	static int st_pop() {
		return st[--sti];
	}

	static void qsrt() {
		sti = 0;
		int t, p;
		int i, j;
		int l, r;
		st_push(0);
		st_push(N - 1);
		while (sti != 0) {
			r = st_pop();
			l = st_pop();
			p = r;
			i = l - 1;
			j = r;
			if (i < j) {
				while (true) {
					while (xy[++i][1] != xy[p][1] ? xy[i][1] < xy[p][1] : xy[i][0] < xy[p][0]) {
					}
					while (xy[--j][1] != xy[p][1] ? xy[j][1] > xy[p][1] : xy[j][0] > xy[p][0]) {
					}
					if (i >= j) {
						break;
					}
					int xt = xy[i][0], yt = xy[i][1];
					xy[i][0] = xy[j][0];
					xy[i][1] = xy[j][1];
					xy[j][0] = xt;
					xy[j][1] = yt;
				}
				int xt = xy[i][0], yt = xy[i][1];
				xy[i][0] = xy[p][0];
				xy[i][1] = xy[p][1];
				xy[p][0] = xt;
				xy[p][1] = yt;
				st_push(l);
				st_push(i - 1);
				st_push(i + 1);
				st_push(r);
			}

		}
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		xy = new int[N][2];
		st = new int[100001];
		for (int i = 0; i < N; i++) {
			xy[i][0] = sc.nextInt();
			xy[i][1] = sc.nextInt();
		}
		qsrt();
		for (int i = 0; i < N; i++) {
			System.out.print(xy[i][0] + " " + xy[i][1]);
			System.out.println();
		}
		sc.close();
	}
}
