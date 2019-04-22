삽입 정렬
삽입정렬(Insertion Sort)은 배열을 정렬된 부분, 정렬되지 않은 부분으로 나눈 후, 원소를 순차적으로 탐색하면서 해당 원소를 정렬이 된 부분에 끼워 넣는 정렬입니다.

아래의 그림의 회색 부분은 정렬이 완료된 부분이며 흰색 부분은 정렬이 완료되지 않은 부분입니다.
적당한 위치를 찾은 후, 뒷자리 원소들을 밀어준 후 해당 원소를 삽입합니다.
뒤에서부터 한자리씩 당겨가면서 적당한 위치를 찾은 후 삽입하여도 같은 원리로 동작합니다.

시간복잡도는 각 원소에 대해 적당한 위치를 찾아주어야 하므로 총 원소의 개수 O( N ), 순차적으로 삽입 위치를 찾는데 O( N )이 들므로
O(N ^ 2)으로 힙정렬이나 합병정렬에 비해 비효율적(O(N log N))으로 잘 쓰이지 않습니다.
공간복잡도는 O(1)

import java.util.*;

public class insertionSort {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int d[] = new int[n];
        for (int i = 0; i < n; i++) {
            d[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            int temp = d[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (d[j] < temp) {
                    break;
                }
                d[j + 1] = d[j];
            }
            d[j + 1] = temp;
        }
        for (int i = 0; i < n; i++) {
            System.out.print(d[i] + " ");
        }
        sc.close();
    }
}
