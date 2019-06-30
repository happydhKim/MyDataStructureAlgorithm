https://blog.csdn.net/zy704599894/article/details/82969086

#include<stdio.h>
#include<string.h>
#include<algorithm>
using namespace std;
const int maxm = 1005;
struct node
{
	int x, y;
	node() {};
	node(int x, int y) :x(x), y(y) {};
}U[maxm][maxm], D[maxm][maxm], L[maxm][maxm], R[maxm][maxm];
int f[maxm][maxm];
int main()
{
	int n, i, j, k, sum, m, Q;
	int a, b, c, d, h, w;
	node u, v, p, q;
	scanf("%d%d%d", &n, &m, &Q);
	for (i = 1;i <= n;i++)
		for (j = 1;j <= m;j++)
			scanf("%d", &f[i][j]);
	for (i = 0;i <= n + 1;i++)
	{
		for (j = 0;j <= m + 1;j++)
		{
			U[i][j] = node(i - 1, j), D[i][j] = node(i + 1, j);
			L[i][j] = node(i, j - 1), R[i][j] = node(i, j + 1);
		}
	}
	while (Q--)
	{
		scanf("%d%d%d%d%d%d", &a, &b, &c, &d, &h, &w);
		u.x = a, u.y = 0, v.x = c, v.y = 0;
		for (i = 1;i <= b;i++) u = R[u.x][u.y];
		for (i = 1;i <= d;i++) v = R[v.x][v.y];
		for (i = 1;i <= w;i++)
		{
			p = U[u.x][u.y], q = U[v.x][v.y];
			U[u.x][u.y] = q, U[v.x][v.y] = p;
			D[p.x][p.y] = v, D[q.x][q.y] = u;
			if (i < w) u = R[u.x][u.y], v = R[v.x][v.y];
		}
		for (i = 1;i <= h;i++)
		{
			p = R[u.x][u.y], q = R[v.x][v.y];
			R[u.x][u.y] = q, R[v.x][v.y] = p;
			L[p.x][p.y] = v, L[q.x][q.y] = u;
			if (i < h) u = D[u.x][u.y], v = D[v.x][v.y];
		}
		for (i = 1;i <= w;i++)
		{
			p = D[u.x][u.y], q = D[v.x][v.y];
			D[u.x][u.y] = q, D[v.x][v.y] = p;
			U[p.x][p.y] = v, U[q.x][q.y] = u;
			if (i < w) u = L[u.x][u.y], v = L[v.x][v.y];
		}
		for (i = 1;i <= h;i++)
		{
			p = L[u.x][u.y], q = L[v.x][v.y];
			L[u.x][u.y] = q, L[v.x][v.y] = p;
			R[p.x][p.y] = v, R[q.x][q.y] = u;
			if (i < h) u = U[u.x][u.y], v = U[v.x][v.y];
		}
	}
	for (i = 1;i <= n;i++)
	{
		p.x = i, p.y = 0;
		for (j = 1;j <= m;j++)
		{
			p = R[p.x][p.y];
			printf("%d%c", f[p.x][p.y], j == m ? '\n' : ' ');
		}
	}
	return 0;
}
