package JavaTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 백준 2357 최소값과 최대값
 * https://www.acmicpc.net/problem/2357
 * Segment Tree
 */
public class MySegmentTree {
	public static void main(String args[]) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder result = new StringBuilder();

		String NM[] = reader.readLine().split(" ");
		int N = Integer.parseInt(NM[0]);
		int M = Integer.parseInt(NM[1]);

		int treeSize = 1 << ((int) Math.ceil(Math.log(N) / Math.log(2)) + 1);

		int numbers[] = new int[N];
		int minTree[] = new int[treeSize];
		int maxTree[] = new int[treeSize];

		for (int index = 0; index < N; index++) {
			numbers[index] = Integer.parseInt(reader.readLine());
		}

		init(minTree, numbers, 1, 1, N, false);
		init(maxTree, numbers, 1, 1, N, true);

		for (int index = 0; index < M; index++) {
			String ab[] = reader.readLine().split(" ");
			int a = Integer.parseInt(ab[0]);
			int b = Integer.parseInt(ab[1]);

			result.append(find(minTree, 1, a, b, 1, N, false));
			result.append(" ");
			result.append(find(maxTree, 1, a, b, 1, N, true));
			result.append("\n");
		}

		System.out.println(result.toString());
	}

	private static int init(int tree[], int numbers[], int nodeNo, int start, int end, boolean isMax) {
		if (start == end) {
			return tree[nodeNo] = numbers[start - 1];
		} else if (isMax) {
			return tree[nodeNo] = Math.max(init(tree, numbers, nodeNo * 2, start, (start + end) / 2, isMax),
					init(tree, numbers, (nodeNo * 2) + 1, ((start + end) / 2) + 1, end, isMax));
		} else {
			return tree[nodeNo] = Math.min(init(tree, numbers, nodeNo * 2, start, (start + end) / 2, isMax),
					init(tree, numbers, (nodeNo * 2) + 1, ((start + end) / 2) + 1, end, isMax));
		}
	}

	private static int find(int tree[], int nodeNo, int left, int right, int start, int end, boolean isMax) {
		if (left > end || right < start) {
			if (isMax) {
				return -1;
			} else {
				return Integer.MAX_VALUE;
			}
		}

		if (left <= start && right >= end) {
			return tree[nodeNo];
		}

		if (isMax) {
			return Math.max(find(tree, nodeNo * 2, left, right, start, (start + end) / 2, isMax),
					find(tree, (nodeNo * 2) + 1, left, right, ((start + end) / 2) + 1, end, isMax));
		} else {
			return Math.min(find(tree, nodeNo * 2, left, right, start, (start + end) / 2, isMax),
					find(tree, (nodeNo * 2) + 1, left, right, ((start + end) / 2) + 1, end, isMax));
		}
	}
}