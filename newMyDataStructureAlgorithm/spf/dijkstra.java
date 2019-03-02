다익스트라 알고리즘
다익스트라 알고리즘은 그래프의 한 노드에서 연결된 다른 노드들로 가는 최단 거리를 구하는 알고리즘입니다.
만약 모든 노드 쌍간의 최단 거리를 구하고 싶다면 N개의 각 정점에 대해 해당 정점을 출발점으로 하는 다익스트라 알고리즘을 수행해야 합니다.
이러한 상황에서는 이후에 다룰 플로이드 워셜 알고리즘 알고리즘이 다익스트라를 N번 수행하는 것보다 유효합니다.
다익스트라 알고리즘은 한 노드에서 다른 노드로 가는 최단 경로를 구성하는 간선들은 항상 최단 거리를 갖는다는 아이디어를 기반으로 하며 이는 귀류법으로 간단하게 증명 가능합니다.

다익스트라의 동작 과정에 대해서 설명하면, 너비 우선 탐색 방법과 비슷합니다.
먼저, 해당 노드까지의 최단 거리를 저장할 dist 배열이 필요합니다.
또한 이 값은 처음에 방문하지 않았다는 것을 알려주기 위해 -1이라는 값으로 초기화 해줍니다.
그리고 문제의 입력에 따라 그래프를 구성해주면 사전 준비는 모두 끝난 것입니다.

다익스트라 알고리즘은 너비 우선 탐색과 달리 큐 대신에 우선순위 큐를 사용하여 방문할 정점과 방문할 정점까지 거리를 넣어줘야 합니다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 백준 최단경로 https://www.acmicpc.net/problem/1753
 */

class Element implements Comparable<Element> {
	int node;
	int dist;

	Element(int node, int dist) {
		this.node = node;
		this.dist = dist;
	}

	@Override
	public int compareTo(Element o) {
		return this.dist < o.dist ? -1 : 1;
	}
}

public class study01 {
	private static final int INF = 987654321;

	private static void dijkstra(int src, int V, ArrayList<ArrayList<Integer>> W, int[] dist) {
		PriorityQueue<Element> pq = new PriorityQueue<>();
		dist[src] = 0;
		pq.add(new Element(src, dist[src]));
		while (!pq.isEmpty()) {
			int cost = pq.peek().dist;
			int here = pq.peek().node;
			pq.poll();
			if (dist[here] < cost) {
				continue;
			}
			for (int x : W.get(here)) {
				int adjNode = x / 11;
				int weight = x % 11;
				if (dist[adjNode] > dist[here] + weight) {
					dist[adjNode] = dist[here] + weight;
					pq.add(new Element(adjNode, dist[adjNode]));
				}
			}
		}
	}

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V; // 정점의 개수 <= 20,000
		int E; // 간선의 개수 <= 300,000
		ArrayList<ArrayList<Integer>> W = new ArrayList<>();
		int dist[];
		int startNode;

		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		dist = new int[V + 1];
		for (int i = 0; i < V + 1; i++) {
			Arrays.fill(dist, INF);
			W.add(new ArrayList<>());
		}
		startNode = Integer.parseInt(br.readLine());
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			W.get(a).add(b * 11 + w);
		}
		dijkstra(startNode, V, W, dist);
		for (int i = 1; i < V + 1; i++) {
			System.out.print(dist[i] < INF ? dist[i] + "\n" : "INF\n");
		}
		br.close();
	}
}
