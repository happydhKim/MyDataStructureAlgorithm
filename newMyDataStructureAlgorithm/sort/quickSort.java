// 퀵 정렬은 불안정 정렬 에 속하며, 다른 원소와의 비교만으로 정렬을 수행하는 비교 정렬 에 속한다.

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
