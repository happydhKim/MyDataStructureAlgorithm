import java.lang.Math;
import java.util.Scanner;;

public class sieveOfEratosthenes {
	private static final int MAX = 1000000;
	static boolean isPrime[] = new boolean[MAX + 1];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int i = 2; i <= MAX; i++) {
			isPrime[i] = true;
		}
		int sqrtn = (int) Math.sqrt(MAX);
		for (int i = 2; i <= sqrtn; i++) {
			if (!isPrime[i]) {
				continue;
			}
			for (int j = i + i; j <= MAX; j += i) {
				isPrime[j] = false;
			}
		}
		int testcase = sc.nextInt();
		int T = 0, N = 0;
		while (testcase != T) {
			T++;
			N = sc.nextInt();
			System.out.println("Case #" + T);
			if (isPrime[N]) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
		sc.close();
	}
}
