package JavaSort;

//주어진 리스트 중에 최소값을 찾는다.
//그 값을 맨 앞에 위치한 값과 교체한다(패스(pass)).
//맨 처음 위치를 뺀 나머지 리스트를 같은 방법으로 교체한다.
//비교하는 것이 상수 시간에 이루어진다는 가정 아래, n개의 주어진 리스트를 이와 같은 방법으로 정렬하는 데에는 Θ(n2) 만큼의 시간이 걸린다.
//
//선택 정렬은 알고리즘이 단순하며 사용할 수 있는 메모리가 제한적인 경우에 사용시 성능 상의 이점이 있다.

public class MySelectionSort {
	private void sort(int data[]) {
		int size = data.length;
		int min;
		int temp;

		for (int i = 0; i < size - 1; i++) {
			min = i;
			for (int j = i + 1; j < size; j++) {
				if (data[min] > data[j]) {
					min = j;
				}
			}
			temp = data[min];
			data[min] = data[i];
			data[i] = temp;
		}
	}

	public static void main(String args[]) {

		MySelectionSort selection = new MySelectionSort();

		int data[] = { 66, 10, 1, 99, 5 };

		selection.sort(data);

		for (int i = 0; i < data.length; i++) {
			System.out.println("data[" + i + "] : " + data[i]);
		}
	}
}
