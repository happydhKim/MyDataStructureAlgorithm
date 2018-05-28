package JavaDP;

/*
 * JAVA KnapSack
 * http://blog.daum.net/rhaoslikesan/287
 */
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class MyKnapSack {
	public static void main(String[] args) throws Exception {
		long t1, t2;
		Scanner sc = new Scanner(new File("res/knapsack.in"));
		int T;
		T = sc.nextInt();
		int N = 0;
		int W = 0;
		int[] wt = null;
		int[] val = null;
		for (int testNum = 1; testNum <= T; testNum++) {
			N = sc.nextInt(); // 개수
			W = sc.nextInt(); // 최대 수용 무게
			wt = new int[N + 1]; // 무게
			for (int i = 1; i <= N; i++) {
				wt[i] = sc.nextInt();
			}
			val = new int[N + 1]; // 가치
			for (int i = 1; i <= N; i++) {
				val[i] = sc.nextInt();
			}
			t1 = System.currentTimeMillis();
			int maxValue = getMaxValue(N, W, wt, val);
			t2 = System.currentTimeMillis();
			System.out.println("MaxValue=" + maxValue + "(" + (t2 - t1) + "ms)");
			int[] list = getMaxItems(N, W, wt, val);
			printList(list, wt, val);
		}
		sc.close();
	}

	private static void printList(int[] list, int[] wt, int[] val) {
		if (list == null || list.length == 0) {
			System.out.println("fail");
			return;
		}
		StringBuffer sb = new StringBuffer();
		long totalWeight = 0;
		long totalValue = 0;
		for (int i = 0; i < list.length; i++) {
			sb.append(list[i] + " ");
			totalWeight += wt[list[i]];
			totalValue += val[list[i]];
		}
		System.out.println("선택 번호 리스트:" + sb.toString());
		System.out.println("총 Weight:" + totalWeight);
		System.out.println("총 Value:" + totalValue);
		System.out.println("");
	}

	private static int getMaxValue(int N, int W, int[] wt, int[] val) {
		int[][] V = new int[N + 1][W + 1];
		int max = 0;
		// max = knap_recursive(N, W, wt, val);
		max = knap_table(N, W, wt, val, V);
		// max = knapack_bottomup(N, W, wt, val, V);
		// print(V);
		return max;
	}

	private static int[] getMaxItems(int N, int W, int[] wt, int[] val) {

		int[][] V = new int[N + 1][W + 1];
		knap_table(N, W, wt, val, V);
		// knapack_bottomup(N, W, wt, val, V);
		return extract(V, W, wt);
	}

	private static int[] extract(int[][] V, int W, int[] wt) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		int K = W;
		for (int i = V.length - 1; i >= 1; i--) {
			if (K >= 0 && V[i][K] != V[i - 1][K]) {
				list.add(i);
				K = K - wt[i];
			}
		}
		int[] a = new int[list.size()];
		for (int i = 0; i < a.length; i++) {
			a[i] = list.get(i);
		}
		return a;
	}

	private static void print(int[][] v) {
		for (int i = 0; i < v.length; i++) {
			for (int j = 0; j < v[i].length; j++) {
				System.out.print(v[i][j] + " ");
			}
			System.out.println("");
		}
	}

	// w: 현재기준으로 허용가능한(=더 담을 수 있는) 무게
	private static int knap_recursive(int n, int w, int[] wt, int[] val) {
		if (n <= 0 || w <= 0) {
			return 0;
		}
		if (wt[n] > w) {
			return knap_recursive(n - 1, w, wt, val);
		} else {
			return Math.max(knap_recursive(n - 1, w, wt, val), knap_recursive(n - 1, w - wt[n], wt, val) + val[n]);
		}
	}

	private static int knap_table(int n, int w, int[] wt, int[] val, int[][] table) {
		if (n <= 0 || w <= 0) {
			return 0;
		}
		if ((n > 1) && (table[n - 1][w] == 0)) {
			table[n - 1][w] = knap_table(n - 1, w, wt, val, table);
		}
		if ((n > 1 && w > wt[n]) && (table[n - 1][w - wt[n]] == 0)) {
			table[n - 1][w - wt[n]] = knap_table(n - 1, w - wt[n], wt, val, table);
		}
		if ((wt[n] <= w) && (table[n - 1][w] < table[n - 1][w - wt[n]] + val[n])) {
			table[n][w] = table[n - 1][w - wt[n]] + val[n];
		} else {
			table[n][w] = table[n - 1][w];
		}
		return table[n][w];
	}

	private static int knapack_bottomup(int N, int W, int[] wt, int[] val, int[][] V) {
		for (int i = 1; i <= N; i++) {
			for (int j = 0; j <= W; j++) {
				if ((wt[i] <= j) && (V[i - 1][j] < val[i] + V[i - 1][j - wt[i]])) {
					V[i][j] = val[i] + V[i - 1][j - wt[i]];
				} else {
					V[i][j] = V[i - 1][j];
				}
			}
		}
		return V[N][W];
	}

	static int max(int a, int b) {
		return (a > b) ? a : b;
	}
}
