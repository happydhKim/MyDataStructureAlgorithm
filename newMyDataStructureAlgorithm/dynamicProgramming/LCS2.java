import java.util.Scanner;

public class LCS2 {
	static int dp[][];
	static String ans[][];
	static char A[], B[];

	static int LCS() {
		for (int i = 1; i <= A.length; i++) {
			for (int j = 1; j <= B.length; j++) {
				if (A[i - 1] == B[j - 1]) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}
		return dp[A.length][B.length];
	}

	static String getString(int alen, int blen) {
		String str = "";
		int i = alen;
		int j = blen;
		while (i > 0 && j > 0) {
			if (dp[i][j - 1] == dp[i - 1][j] && dp[i - 1][j] == dp[i - 1][j - 1] && dp[i - 1][j - 1] == dp[i][j] - 1) {
				str += A[i - 1];
				i--;
				j--;
			} else {
				if (dp[i - 1][j] == dp[i][j]) {
					i--;
				} else if (dp[i][j - 1] == dp[i][j]) {
					j--;
				}
			}
		}
		return str;
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		String a = sc.nextLine();
		String b = sc.nextLine();
		dp = new int[a.length() + 1][b.length() + 1];
		ans = new String[a.length() + 1][b.length() + 1];
		A = a.toCharArray();
		B = b.toCharArray();
		System.out.println(LCS());
		String answer = getString(a.length(), b.length());
		for (int i = answer.length() - 1; i >= 0; i--) {
			System.out.print(answer.charAt(i));
		}
		sc.close();
	}
}
