package JavaAlgorithm;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 * @author kimdohyun
 * BOJ 11667 타임머신
 */

// 벨만포드 알고리즘
// 음수사이클이 존재할 경우 최단경로 없음 
// O(EV) 의 시간 복잡도 
class TimeM {
	int from, to, cost;

	TimeM(int from, int to, int cost) {
		this.from = from;
		this.to = to;
		this.cost = cost;
	}
}

public class MyBellmanFord {
	static final int inf = 100000000;

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int dist[] = new int[n + 1];
		ArrayList<TimeM> a = new ArrayList<TimeM>();
		for (int i = 0; i < m; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			int z = sc.nextInt();
			a.add(new TimeM(x, y, z));
		}

		for (int i = 1; i <= n; i++) {
			dist[i] = inf;
		}
		dist[1] = 0;
		boolean negative_cycle = false;
		for (int i = 1; i <= n; i++) {
			for (TimeM e : a) {
				int x = e.from;
				int y = e.to;
				int z = e.cost;
				if (dist[x] != inf && dist[y] > dist[x] + z) {
					dist[y] = dist[x] + z;
					if (i == n) {
						negative_cycle = true;
					}
				}
			}
		}
		if (negative_cycle) {
			System.out.println("-1");
		} else {
			for (int i = 2; i <= n; i++) {
				if (dist[i] == inf)
					dist[i] = -1;
				System.out.println(dist[i]);
			}
		}
	}
}