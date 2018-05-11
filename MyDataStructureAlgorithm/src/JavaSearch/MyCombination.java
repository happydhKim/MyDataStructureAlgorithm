package JavaSearch;

public class MyCombination {

	public static void combination(int data[], int index, int n, int r, int target) {
		if (r == 0) {
			print(data, index);
		} else if (target == n) {
			return;
		} else {
			data[index] = target;
			combination(data, index + 1, n, r - 1, target + 1);
			combination(data, index, n, r, target + 1);
		}
	}

	public static void print(int data[], int length) {
		for (int i = 0; i < length; i++) {
			System.out.print(data[i]);
		}
		System.out.println();
	}

	public static void main(String args[]) {
		int data[] = new int[5];
		combination(data, 0, 5, 3, 0);
	}
}
/*
 * output 012 013 014 023 024 034 123 124 134 234
 */