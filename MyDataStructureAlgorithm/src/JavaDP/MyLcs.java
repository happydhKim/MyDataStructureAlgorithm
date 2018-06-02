package JavaDP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * Longest Common Subsequence
 * https://www.acmicpc.net/problem/9251
 */

public class MyLcs {
	static int dp[][] = new int[1001][1001];

	public static void main(String args[]) throws IOException {
		StringBuffer S;
		StringBuffer T;
		int sLength, tLength;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		S = new StringBuffer(br.readLine());
		T = new StringBuffer(br.readLine());
		sLength = S.length();
		tLength = T.length();
		for (int i = 0; i < sLength; i++) {
			for (int j = 0; j < tLength; j++) {
				if (S.charAt(i) == T.charAt(j)) {
					dp[i + 1][j + 1] = dp[i][j] + 1;
				} else {
					dp[i + 1][j + 1] = Math.max(dp[i][j + 1], dp[i + 1][j]);
				}
			}
		}
		System.out.println(dp[sLength][tLength]);
	}
}