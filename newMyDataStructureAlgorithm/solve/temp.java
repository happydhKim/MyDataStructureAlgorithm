import java.util.Scanner;

public class temp {
	static String answer;

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		sc.nextLine();
		for (int TC = 1; TC <= T; TC++) {
			String s = sc.nextLine();
			String str[] = s.split(" ");
			answer = "SAME";
			if (str[0].length() != str[1].length()) {
				answer = "DIFF";
			} else {
				for (int i = 0; i < str[0].length(); i++) {
					char c = str[0].charAt(i);
					char c2 = str[1].charAt(i);
					if (c == 'B') {
						if (c2 != 'B') {
							answer = "DIFF";
							break;
						}
					} else {
						if (c == 'A' || c == 'D' || c == 'O' || c == 'P' || c == 'Q' || c == 'R') {
							if (c2 != 'A' && c2 != 'D' && c2 != 'O' && c2 != 'P' && c2 != 'Q' && c2 != 'R') {
								answer = "DIFF";
								break;
							}
						}
					}
				}
			}
			System.out.println("#" + TC + " " + answer);
		}
		sc.close();
	}
}
