// 벨만-포드 알고리즘
// 벨만 포드 알고리즘은 다익스트라 알고리즘과 마찬가지로 어느 한 정점에서 나머지 정점까지 거리를 구하는 알고리즘입니다.
// 하지만 다익스트라와는 다르게 음수 가중치를 갖는 그래프에서도 동작을 하며, 음수 사이클을 찾아내는 기능도 가지고 있습니다.
// 이러한 장점을 갖는 대신에 알고리즘의 수행 시간은 일반적으로 다익스트라보다 느린 단점을 가지고 있습니다.
// 이 알고리즘의 기본적인 아이디어는 다익스트라와 비슷합니다.
// dist배열을 만들어서 최단 거리에 근접하게 계속 갱신시켜주는 방식입니다.
// 하지만 우선순위 큐를 이용하여 간선에 연결된 정점의 최단 거리를 갱신하는 것이 아니라, 모든 정점의 최단 거리를 구할 때까지 모든 간선들을 여러 번 확인하여 최단 거리를 구한다는 것이 차이점입니다.
//
// 벨만 포드 알고리즘의 구현 방법은 다익스트라와 비슷한 전처리 과정으로 dist배열을 만들고, 시작 정점의 dist는 0으로 만든 뒤, 모든 간선을 확인하는 것이다.
// 간선이 u->v이라면, dist[v]와 dist[u]+w[E] (간선의 가중치)를 비교하여 갱신해줍니다.
// 이러한 과정을 V번 반복하면 됩니다.
// 과정을 V번 반복하는 이유는 시작점에서 어떤 u까지 가는 간선의 개수는 최대 V-1개이고, 이러한 간선들이 불행하게도 한차례마다 한 간선씩 갱신이 된다고 해도 V-1번이면 찾을 수 있습니다.
// 그러면 왜 V-1번이 아니라 V번 반복할까요?
// 그 이유는 음수 사이클이 있을 경우 데이터 범위의 제한이 없을 경우 무한하게 갱신되기 때문입니다.
// 나머지 정상적인 경우 음수 사이클이 없을 경우에는 V-1번에 갱신되기 때문에 V번째 때 갱신이 되는 일이 없을 것입니다.
// 하지만 음수 사이클에 경우에는 V번째에 갱신이 되므로 이를 통하여 음수 사이클을 판별합니다.
// 이러한 특징은 새로운 최단 거리를 찾을 때마다 갱신해주는 다익스트라에서는 찾을 수 없는 특징입니다.

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author kimdohyun
 * BOJ 11657 타임머신
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
	private static final int inf = 100000000;

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
