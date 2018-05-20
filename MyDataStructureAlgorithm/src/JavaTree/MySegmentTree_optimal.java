package JavaTree;

import java.util.ArrayList;
import java.util.Scanner;

/*
 * https://www.codeground.org/common/popCodegroundNote
 */

public class MySegmentTree_optimal {
	ArrayList<Integer> tree;
	int s;

	public MySegmentTree_optimal(int n) {
		for (s = 1; s < n; s *= 2)
			;
		tree = new ArrayList<Integer>(s * 2);
		tree.add(0);
		for (int i = 1; i < s + s; i++)
			tree.add(Integer.MAX_VALUE);
	}

	void insert(ArrayList<Integer> d) {
		for (int i = s; i < s + d.size(); i++)
			tree.set(i, d.get(i - s));
		for (int i = s - 1; i >= 1; i--)
			tree.set(i, Integer.min(tree.get(i * 2), tree.get(i * 2 + 1)));
	}

	int getMin(int Left, int Right) {
		int l = Left + s - 1, r = Right + s - 1;
		int rval = Integer.MAX_VALUE;
		while (l <= r) {
			if (l % 2 == 0)
				l /= 2;
			else {
				rval = Integer.min(rval, tree.get(l));
				l = (l / 2) + 1;
			}
			if (r % 2 == 1)
				r /= 2;
			else {
				rval = Integer.min(rval, tree.get(r));
				r = (r / 2) - 1;
			}
		}
		return rval;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		MySegmentTree_optimal T = new MySegmentTree_optimal(n);

		ArrayList<Integer> v = new ArrayList<Integer>(n + 1);

		for (int i = 0; i < n; i++)
			v.add(sc.nextInt());

		T.insert(v);

		int m = sc.nextInt();

		for (int i = 0; i < m; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			System.out.println(T.getMin(x, y));
		}
	}
}
