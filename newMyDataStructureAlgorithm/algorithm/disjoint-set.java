find(x): x번 노드의 최고 조상(루트)을 찾는 함수
link(x, y): x노드가 속한 그룹과 y노드가 속한 그룹을 합치는(잇는) 함수


import java.util.Scanner;

public class disjointSet {
	static int par[] = new int[100001];

	public static int find(int x) {
		if (par[x] == x) {
			return x;
		} else {
			return par[x] = find(par[x]);
		}
	}

	public static void link(int x, int y) {
		par[find(y)] = find(x);
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int q = sc.nextInt();

		for (int i = 1; i <= n; i++) {
			par[i] = i;
		}
		while (q-- > 0) {
			int cmd = sc.nextInt();
			int x = sc.nextInt();
			int y = sc.nextInt();
			if (cmd == 1) {
				link(x, y);
			} else {
				if (find(x) == find(y)) {
					System.out.println(1);
				} else {
					System.out.println(0);
				}
			}
		}
		sc.close();
	}
}
