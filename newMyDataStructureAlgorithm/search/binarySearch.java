import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] d = new int[5005];
        for (int i = 0; i < n; i++)
            d[i] = scanner.nextInt();

        // bubble sorting
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n - i - 1; j++)
                if (d[j] > d[j + 1]) {
                    int temp = d[j];
                    d[j] = d[j + 1];
                    d[j + 1] = temp;
                }

        // binary search for each query
        int query = scanner.nextInt();
        for (int i = 0; i < query; i++) {
            int x = scanner.nextInt();
            int l = 0, r = n - 1;
            boolean answer = false;

            while (l <= r) {
                int mid = (l + r) / 2;
                if (x == d[mid]) {
                    answer = true;
                    break;
                }
                else if (x > d[mid]) l = mid + 1;
                else r = mid - 1;
            }

            if (answer == true) System.out.println("exist");
            else System.out.println("not exist");
        }
    }
}
