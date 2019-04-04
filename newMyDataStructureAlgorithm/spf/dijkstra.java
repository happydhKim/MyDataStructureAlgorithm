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


<그림 1> 다익스트라 예제
노드 1 3 2
가중치 1~3 = 5, 3~2 = 3, 2~1 = 10

우선순위 큐를 사용하는 이유는 위의 <그림 1>을 예제로 하여 설명하도록 하겠습니다.
처음에 들어갈 노드는 시작 노드 S를 1이라 하고, 시작 노드와 거리를 우선순위 큐에 넣어줍니다.
이 때 S까지 거리는 자기 자신이기 때문에 0입니다.
따라서 dist[1]에 0을 넣어주고, 우선순위 큐에 {0,1}라는 값을 넣어줍니다.
그리고 너비 우선 탐색 방식과 마찬가지로 자신과 연결된 정점들을 확인합니다.
현재 위치 1까지 이동한 거리는 0이기 때문에, 우선순위 큐에는 (0+10, 2) , (0+5, 3) 이라는 값이 들어가게 되고 dist[2]=10, dist[3] = 5가 됩니다.
이 때, 우선순위 큐의 정렬방식이 MIN-HEAP이라고 하면 3번 정점을 먼저 방문합니다.
3번 정점에서 연결된 정점을 확인하면 2번 정점이며 현재 위치 3까지 이동한 거리는 5이고, 간선의 가중치는 3이므로 1에서 3을 거쳐 2로 이동하는 거리는 8이 되며, 이는 1에서 바로 2로 이동한 거리보다 가깝습니다.
따라서 dist[2] = 8로 갱신하고 우선순위 큐에 (5+3, 2)를 넣어줍니다.
그러면 우선순위 큐에는 (10,2) 와 (8,2)가 존재하고 이 중 MIN-HEAP이기 때문에 (8,2)를 먼저 꺼내게 됩니다.
2에서는 간선이 더 이상 존재하지 않기 때문에 갱신되는 것은 없고, 다음으로 (10,2)가 나오게 되는데 dist[2]는 10보다 작은 8이므로 바로 continue해서 넘어갑니다.
우선순위 큐가 비었으므로 과정은 종료가 됩니다.
만약 우선순위 큐를 사용하지 않고 큐를 사용했다면, 방문 순서는 1->3->2가 아니라 1->2->3->2가 되었을 수도 있습니다.
즉, 불필요한 재 방문하게 되는 것입니다.
결론적으로 다익스트라 알고리즘은 BFS와 달리 MIN-HEAP방식의 우선순위 큐를 이용하여 최적화 합니다.

이 때 시간복잡도는 모든 간선은 한 번씩 확인해야 하므로, 간선들을 검사하는데 O(E)의 시간이 걸리며(E는 간선의 개수), 우선순위 큐에 들어가는 원소는 간선마다 최대 1번씩 들어가므로 O(E)이고, 이를 한번 삽입, 삭제 하는데 O(logN)만큼 걸리기 때문에 시간복잡도는 O(ElogE)입니다.
따라서 총 시간복잡도는 O(E + ElogE) => O(ElogE)입니다.

import java.util.*;

class Edge implements Comparable<Edge> {
    int dst, weight;

    public Edge(){}

    public Edge(int dst, int weight) {
        this.dst = dst;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge arg0) {
        return this.weight - arg0.weight;
    }
}

public class Main {
    static Vector<Vector<Edge>> edge;
    static int n;
    static int m;
    static int s;

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        s = scanner.nextInt();
        edge = new Vector<Vector<Edge>>();
        for (int i = 0; i < n + 1; i++) {
            Vector<Edge> e = new Vector<Edge>();
            edge.add(e);
        }
        for (int i = 0; i < m; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            int d = scanner.nextInt();
            Edge e = new Edge(v, d);
            edge.elementAt(u).add(e);
        }
        Vector<Integer> dist = dijkstra(s);
        for (int i = 1; i < dist.size(); i++) {
            System.out.println(String.valueOf(dist.elementAt(i)));
        }
    }

    public static Vector<Integer> dijkstra(int cur) {
        PriorityQueue<Edge> q = new PriorityQueue<>();
        Vector<Integer> dist = new Vector<Integer>();
        for (int i = 0; i < n + 1; i++) {
            if (i == cur)
                dist.add(0);
            else
                dist.add(-1);
        }
        Edge e = new Edge(cur, 0);
        q.add(e);
        while (!q.isEmpty()) {
            Edge here = q.remove();
            for (int i = 0; i < edge.elementAt(here.dst).size(); i++) {
                Edge a = edge.elementAt(here.dst).elementAt(i);
                int there = a.dst;
                int nextdist = dist.elementAt(here.dst) + a.weight;
                if (dist.elementAt(there) == -1 || dist.elementAt(there) > nextdist) {
                    dist.setElementAt(nextdist, there);
                    Edge ne = new Edge(there, nextdist);
                    q.add(ne);
                }
            }
        }
        return dist;
    }
}
