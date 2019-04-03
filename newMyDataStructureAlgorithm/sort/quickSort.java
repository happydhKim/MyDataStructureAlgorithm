// 퀵 정렬은 불안정 정렬 에 속하며, 다른 원소와의 비교만으로 정렬을 수행하는 비교 정렬 에 속한다.
// https://gmlwjd9405.github.io/2018/05/10/algorithm-quick-sort.html + codeground 참조
15 4 9 3 6 21 34 31
(1) 먼저 구간에서 가장 왼쪽 원소를 pivot으로 놓으면 pivot = 15입니다.
(2) 이제 구간의 제일 오른쪽 위치 right에서 왼쪽 방향으로 진행하면서 pivot값보다 작거나 같은 값이 나올 때까지 진행합니다.
(3) idx=4일 때, 원소는 6이므로 pivot보다 작습니다. 이 값을 빨간 포인터 left가 가리키는 대상에 넣어줍니다.
      (left에서는 right가 가리키는 대상에 넣어준다)
(4) 그리고 이제 제일 왼쪽 위치 left에서 오른쪽 방향으로 진행하면서 pivot값보다 큰 값이 나올 때까지 진행합니다.
(5) 그러면 left와 right가 같아질 때까지 진행되고 left와 right가 같아지면 종료가 됩니다.
(6) 이제 이 위치에 pivot값을 넣고, pivot보다 작거나 같은 구간과 큰 구간을 나누고, 각각의 구간에 대해서 다시 퀵 정렬합니다.
(7) 이러한 행동을 반복하면, 각 구간에 대해 원소가 1개만 남게 되고, 이 위치가 원소의 정렬된 위치입니다.

장점
속도가 빠르다.
시간 복잡도가 O(nlog₂n)를 가지는 다른 정렬 알고리즘과 비교했을 때도 가장 빠르다.
추가 메모리 공간을 필요로 하지 않는다.
퀵 정렬은 O(log n)만큼의 메모리를 필요로 한다.
단점
정렬된 리스트에 대해서는 퀵 정렬의 불균형 분할에 의해 오히려 수행시간이 더 많이 걸린다.
퀵 정렬의 불균형 분할을 방지하기 위하여 피벗을 선택할 때 더욱 리스트를 균등하게 분할할 수 있는 데이터를 선택한다.
EX) 리스트 내의 몇 개의 데이터 중에서 크기순으로 중간 값(medium)을 피벗으로 선택한다.

import java.util.*;

public class quickSort {
    static int N;
    static int arr[];

    static void quickSort(int arr[], int left, int right) {
        int pivot, left_temp, right_temp;
        left_temp = left;
        right_temp = right;
        pivot = arr[left];
        while (left < right) {
            while (arr[right] >= pivot && (left < right)) {
                right--;
            }
            if (left != right) {
                arr[left] = arr[right];
            }
            while (arr[left] <= pivot && (left < right)) {
                left++;
            }
            if (left != right) {
                arr[right] = arr[left];
                right--;
            }
        }
        arr[left] = pivot;
        pivot = left;
        left = left_temp;
        right = right_temp;
        if (left < pivot) quickSort(arr, left, pivot - 1);
        if (right > pivot) quickSort(arr, pivot + 1, right);
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = scanner.nextInt();
        }
        quickSort(arr, 0, N - 1);
        for (int i = 0; i < N; i++) {
            System.out.print(String.valueOf(arr[i]) + ' ');
        }
    }
}
