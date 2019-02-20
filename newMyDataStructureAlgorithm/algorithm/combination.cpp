//https://www.acmicpc.net/problem/15650

#include <cstdio>

int a[10];
int N, M;
void dfs(int depth, int start)
{
	if (depth == M + 1)
	{
		for (int i = 1; i <= M; i++) {
			printf("%d ", a[i]);
		}
		printf("\n");
		return;
	}
	for (int i = start; i <= N; i++)
	{
		a[depth] = i;
		dfs(depth + 1, i + 1);
	}
}

int main() {
	scanf_s("%d %d", &N, &M);
	dfs(1, 1);
}
