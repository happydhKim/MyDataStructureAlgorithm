// BFS (Breadth-First Search, 너비 우선 탐색)
// 너비 우선 탐색은 그래프의 모든 정점들을 특정한 순서에 따라 방문하는 알고리즘 중 하나입니다.
// 현재 정점과 인접한 간선들을 검사하다가 방문하지 않은 정점들을 발견하면 그 간선을 통해 방문하지 않은 정점들을 자료구조 큐에 넣습니다.
// 그리고 큐의 front 정점을 방문하고 pop합니다.
// 또 해당 정점에서 인접한 간선을 검사해 방문하지 않은 정점들을 큐에 넣고 방문하기는 과정을 반복하다가 더 이상 방문할 수 있는 정점이 없으면 종료합니다.
// 이러한 과정을 반복하여 큐에 더 이상 정점이 존재하지 않을 때까지 실행하여 그래프의 모든 정점을 방문하는 알고리즘이 BFS 알고리즘입니다.
//
// 해당 알고리즘을 구현하기 위해서는 해당 정점이 방문되었는지 확인하는 boolean타입의 1차원 배열과 정점들의 집합 그리고 정점과 정점 사이의 연결을 확인할 수 있는 간선 집합들이 필요합니다.
//
// 그리고 해당 알고리즘의 시간복잡도는 모든 정점을 방문하며 모든 간선을 검사하기 때문에 시간복잡도는 O(V+E)입니다. ( V: 정점의 개수, E: 간선의 개수)
// 아래는 인접 리스트 방식을 이용하여 만든 BFS

// 첫 줄에 정점의 개수 N과 간선의 개수 M이 주어집니다.
// 다음 M줄에 간선의 관계 시작정점 u와 도착정점 v가 주어집니다.
// 입력에 따른 너비 우선 탐색 결과를 출력합니다.
//
// input
// 7 11
// 1 2
// 1 3
// 1 7
// 2 3
// 2 4
// 3 5
// 4 3
// 5 7
// 6 5
// 7 6
// 6 4
//
// output
// 1 2 3 7 4 5 6

#include <iostream>
#include <vector>
#include <queue>
using namespace std;

vector<vector<int> > edge;
vector<bool> visited;
int N, M;
int u, v;

void bfs(int cur) {
    queue<int> q;
    visited[cur] = true;
    q.push(cur);
    while (!q.empty()) {
        int here = q.front();
        q.pop();
        cout << here << ' ';
        for (int i = 0; i < edge[here].size(); i++) {
            int there = edge[here][i];
            if (visited[there]) continue;
            visited[there] = true;
            q.push(there);
        }
    }
}

int main() {
    cin >> N >> M;
    edge.resize(N + 1);
    visited.resize(N + 1);
    for (int i = 0; i < M; i++) {
        cin >> u >> v;
        edge[u].push_back(v);
    }
    bfs(1);
}
