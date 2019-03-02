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


#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>
using namespace std;
int N, M,u,v,d,S;
vector< vector<pair<int, int> > > edge;
vector<int> Dijkstra(int start) {
    vector<int> dist(N+1, -1);
    priority_queue<pair<int, int> > pq; // first : dist , second : vertex_pos
    dist[start] = 0;
    pq.push(make_pair(-dist[start], start)); // Min-Heap처럼 사용하기 위해 앞의 거리 인자에 -값을 곱해줌.
    while (!pq.empty()) {
        int here = pq.top().second;
        int heredist = -pq.top().first;
        pq.pop();
        if (heredist > dist[here]) continue;
        for (int i = 0; i < edge[here].size(); i++) {
            int there = edge[here][i].first;
            int nextdist = heredist + edge[here][i].second;
            if (dist[there] == -1 || dist[there] > nextdist) { //최단 거리 갱신
                dist[there] = nextdist;
                pq.push(make_pair(-nextdist, there));
            }
        }
    }
    return dist;
}

int main() {
    cin >> N >> M >> S;
    edge.resize(N + 1);
    for (int i = 0; i < M; i++) {
        cin >> u >> v >> d;
        edge[u].push_back(make_pair(v, d));
    }
    vector<int> dist = Dijkstra(S);
    for (int i = 1; i <= N; i++) {
        cout << dist[i] << endl;
    }
    return 0;
}
