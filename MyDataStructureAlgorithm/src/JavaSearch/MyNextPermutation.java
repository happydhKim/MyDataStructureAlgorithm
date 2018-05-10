package JavaSearch;

public class MyNextPermutation {

	public static void perm(int data[], int depth, int n, int k) {
		if (depth == k) {
			print(data, k);
			return;
		}
		for (int i = depth; i < n; i++) {
			swap(data, i, depth);
			perm(data, depth + 1, n, k);
			swap(data, i, depth);
		}
	}

	public static void swap(int data[], int i, int j) {
		int temp = data[i];
		data[i] = data[j];
		data[j] = temp;
	}

	public static void print(int[] data, int k) {
		for (int i = 0; i < k; i++) {
			if (i == k - 1) {
				System.out.println(data[i]);
			} else {
				System.out.print(data[i] + ",");
			}
		}
	}

	public static void main(String args[]) {
		int data[] = { 1, 2, 3, 4 };
		perm(data, 0, 4, 4);
	}
}