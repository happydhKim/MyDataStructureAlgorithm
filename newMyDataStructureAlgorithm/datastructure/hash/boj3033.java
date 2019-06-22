import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	private static final int MOD = 1000007;
	private static final int radix = 26;
	private static char charArray[];
	private static int hashTable[] = new int[MOD];
	private static int size;

	private static int binarySearch(int left, int right) {
		if (left == right) {
			return left;
		}
		int mid = (left + right + 1) / 2;
		Arrays.fill(hashTable, 0);
		int hash = 0;
		int prime = 1;
		for (int i = 0; i < mid; i++) {
			hash = (hash * radix + charArray[i] - 'a') % MOD;
			prime = (prime * radix) % MOD;
        }
		hashTable[hash] = mid - 1;
		K: for (int i = mid; i < size; i++) {
			hash = (hash * radix + charArray[i] - 'a') % MOD;
			hash = (hash - ((charArray[i - mid] - 'a') * prime)) % MOD;
			hash = (hash + MOD) % MOD;
			if (hashTable[hash] == 0) {
				hashTable[hash] = i;
			} else {
				int comp = hashTable[hash];
				for (int j = 0; j < mid; j++) {
					if (charArray[i - j] != charArray[comp - j]) {
						continue K;
					}
				}
				return binarySearch(mid, right);
			}
		}
		return binarySearch(left, mid - 1);
	}

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		size = Integer.parseInt(br.readLine().trim());
		charArray = br.readLine().trim().toCharArray();
		int result = binarySearch(0, size - 1);
		System.out.println(result);
	}
}
