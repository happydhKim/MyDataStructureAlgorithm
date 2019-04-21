class ArrayList {
	private int size = 0;
	private Object elementData[] = new Object[100];

	public ArrayList() {

	}

	public boolean addLast(Object element) {
		elementData[size] = element;
		size++;
		return true;
	}

	public boolean add(int index, Object element) {
		for (int i = size - 1; i >= index; i--) {
			elementData[i + 1] = elementData[i];
		}
		elementData[index] = element;
		size++;
		return true;
	}

	public boolean addFirst(Object element) {
		return add(0, element);
	}

	public Object remove(int index) {
		Object removed = elementData[index];
		for (int i = index + 1; i <= size - 1; i++) {
			elementData[i - 1] = elementData[i];
		}
		size--;
		elementData[size] = null;
		return removed;
	}

	public Object removeFirst() {
		return remove(0);
	}

	public Object removeLast() {
		return remove(size - 1);
	}

	public Object get(int index) {
		return elementData[index];
	}

	public int size() {
		return size;
	}

	public int indexOf(Object o) {
		for (int i = 0; i < size; i++) {
			if (o.equals(elementData[i])) {
				return i;
			}
		}
		return -1;
	}
}

public class minArrayList {
	public static void main(String args[]) {
		ArrayList numbers = new ArrayList();
		numbers.addLast(10);
		numbers.addLast(15);
		numbers.addLast(20);
		numbers.addLast(30);
		numbers.remove(1);
		System.out.println(numbers);
	}
}
