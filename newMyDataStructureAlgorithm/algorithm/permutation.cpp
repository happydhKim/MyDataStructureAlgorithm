#include <stdio.h>

int n, m, i, c[9];
char d[20];

void dfs(int depth) {
	if (depth == m) {
		printf("%s\n",d);
		return;
	}
	for (int i = 1; i <= n; i++) {
		if (c[i]) { continue; }
		d[depth * 2] = i + '0';
		c[i] = 1;
		dfs(depth + 1);
		c[i] = 0;
	}
}

int main() {
	scanf("%d%d", &n,&m);
	for (i = 0; i < 2 * m; i++) { d[i] = ' '; }
	dfs(0);
	return 0;
}
