import java.util.Scanner;

class Solution {
	static int palindrome(String str[]) {
		for (int i = 0; i < str.length / 2; i++) {
			int compIdx = str.length - i - 1;
			if (!str[i].equals(str[compIdx])) {
				return 0;
			}
		}
		return 1;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		sc.nextLine();
		for (int TC = 1; TC <= T; TC++) {
			String str[] = sc.next().split("");
			System.out.println("#" + TC + " " + palindrome(str));
		}
		sc.close();
	}
}
