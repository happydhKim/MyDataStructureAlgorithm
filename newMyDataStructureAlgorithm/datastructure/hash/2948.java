//미완성.
import java.util.Scanner;

public class study02 {
	static final int MAX = 100002;
	static int a, b, ans;
	static char strArr[];
	static String table[];

	static int hash(String str) {
		strArr = str.toCharArray();
		int sum = 0;
		int mul = 1;
		int p = 31;
		int m = MAX - 1;
		for (int i = 0; i < str.length(); i++) {
			sum += ((strArr[i] = 'a' + 1) * mul) % m;
			mul = (mul * p) % m;
		}
		return sum % m;
	}

	static boolean check(String a, String b) {
		char aStr[] = a.toCharArray();
		char bStr[] = b.toCharArray();
		if (a.length() != b.length()) {
			return false;
		}
		for (int i = 0; i < a.length(); i++) {
			if (aStr[i] != bStr[i]) {
				return false;
			}
		}
		return true;
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int TC = 1; TC <= T; TC++) {
			a = sc.nextInt();
			b = sc.nextInt();
			sc.nextLine();
			ans = 0;
			table = new String[MAX];
			for (int i = 0; i < a; i++) {
				String str = sc.nextLine();
				table[hash(str)] = str;
			}
			for (int i = 0; i < b; i++) {
				String str = sc.nextLine();
				int n = hash(str);
				// int L = table[n].size();
				int L = table.length;
				for (int j = 0; j < L; j++) {
					if (check(table[n], str)) {
						ans++;
						break;
					}
				}
			}
			System.out.println("#" + TC + " " + ans);
		}
		sc.close();
	}
}
