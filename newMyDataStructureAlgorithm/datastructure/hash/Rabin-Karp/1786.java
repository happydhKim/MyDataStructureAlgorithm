//미완성

import java.util.Scanner;

public class 1786 {
	static final int MOD = 1000000000;
	static int N, M, ans[], cnt;
	static char W[], S[];

	static long mod(long n) {
		if (n >= 0) {
			return n % MOD;
		}
		return ((-n / MOD + 1) * MOD + n) % MOD; // 음수일 경우
	}

	static void hashing() {
		long G = 0;
		long H = 0;
		long step = 1;
		for (int i = 0; i <= N - M; i++) {
			System.out.println(i);
			// W와 S 첫 위치의 해시값을 계산
			if (i == 0) {
				for (int j = 0; j < M; j++) {
					G = mod(G + 1 * W[M - 1 - j] * step);
					H = mod(H + 1 * S[M - 1 - j] * step);
					if (j < M - 1) {
						step = mod(step * 2);
					}
				}
			} else {
				// 아닐 경우 이전 위치의 해시값을 사용해 이번 해시값을 얻음
				H = mod(2 * (H - 1 * S[i - 1] * step) + S[i + M - 1]);
			}
			// 해시값이 같다면 단순 비교
			if (G == H) {
				boolean same = true;
				for (int j = 0; j < M; j++) {
					if (S[i + j] != W[j]) {
						same = false;
						break;
					}
				}
				// 단순 비교해서 문자열을 찾았다면 결과에 추가
				if (same) {

					ans[cnt++] = i + 1;
				}
			}
		}
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		String p = sc.nextLine();
		S = new char[1000001];
		W = new char[1000001];
		N = s.length();
		M = p.length();
		ans = new int[2];
		for (int i = 0; i < N; i++) {
			S[i] = s.charAt(i);
		}
		for (int i = 0; i < M; i++) {
			W[i] = p.charAt(i);
		}
		hashing();
		System.out.println(ans[0]);
		System.out.println(ans[1]);
		sc.close();
	}
}
