import java.util.*;

public class mergeSort {

    static void mergesort(int[]d, int L, int R){
        if(L >= R) return;
        int M = (L + R) / 2;

        mergesort(d, L, M);
        mergesort(d, M + 1, R);

        ArrayList <Integer> temp = new ArrayList<>();
        
        for (int i = L, l = L, r = M + 1;
            l != M + 1 || r != R + 1;
            i++) {

            if ((r != R + 1 && l <= M && d[l] < d[r]) || r == R + 1)
                temp.add(d[l++]);
            else
                temp.add(d[r++]);
        }

        for (int i = L; i <= R; i++)
            d[i] = temp.get(i - L);
    }

	public static void main(String args[]){
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();

		int [] d = new int[5005];

		for (int i = 0; i < n; i++)
			d[i] = scanner.nextInt();

		mergesort(d, 0, n - 1);

		for(int i = 0 ; i < n ; i++)
			System.out.print(d[i] + " ");
	}
}
