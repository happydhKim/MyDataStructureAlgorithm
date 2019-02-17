// DFS (Depth-First Search, 깊이 우선 탐색)
// 깊이 우선 탐색은 그래프의 모든 정점들을 특정한 순서에 따라 방문하는 알고리즘 중 하나입니다.
// 현재 정점과 인접한 간선들을 검사하다가 방문하지 않은 정점을 발견하면 그 간선을 통해 방문하지 은 정점으로 이동하는 것입니다.
// 이 과정을 반복하다가 더 이상 방문할 수 있는 정점이 없으면 마지막으로 통과한 간선을 통해 뒤로 돌아가서 해당 정점에서 방문할 수 있는 정점을 탐색합니다.
// 이러한 과정을 반복하여 그래프의 모든 정점을 방문하는 알고리즘이 DFS 알고리즘입니다.
// 인접리스트 방식

// 첫 줄에 정점의 개수 N과 간선의 개수 M이 주어집니다.
// 다음 M줄에 간선의 관계 시작정점 u와 도착정점 v가 주어집니다.
//
// 입력에 따른 깊이 우선 탐색 결과를 출력합니다.

// input
// 7 11
// 1 2
// 1 3
// 1 7
//
// output
// 1 2 3 5 7 6 4

#include <iostream>
#include <vector>
using namespace std;

vector<vector<int> > edge;
vector<bool> visited;
int N, M;
int u, v;

void dfs(int cur) {
    visited[cur] = true;
    cout << cur << ' ';
    for (int i = 0; i < edge[cur].size(); i++) {
        int there = edge[cur][i];
        if (visited[there]) continue;
        dfs(there);
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
    dfs(1);
}
