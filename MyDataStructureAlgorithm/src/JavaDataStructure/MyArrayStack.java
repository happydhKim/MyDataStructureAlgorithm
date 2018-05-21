package JavaDataStructure;



public class MyArrayStack implements OStack {
	private Object stackArray[];
	private int index; // 현재 인덱스 확인
	public static void main(String args[]) {
		MyArrayStack as = new MyArrayStack(10);
		as.push("hihi");
		as.push(1);
		as.push('A');
		System.out.println(as.pop());
		System.out.println(as.pop());
		System.out.println(as.pop());
		as.push('A');
		System.out.println(as.pop());
	}

	public MyArrayStack(int size) {
		this.stackArray = new Object[size];
		this.index = 0;
	}

	@Override
	public void push(Object data) {
		// TODO Auto-generated method stub
		if (index >= stackArray.length) {
			throw new IndexOutOfBoundsException("full");
		} else {
			stackArray[index++] = data;
		}
	}

	@Override
	public Object peek() {
		// TODO Auto-generated method stub
		if (isEmpty()) {
			throw new IndexOutOfBoundsException();
		} else {
			return stackArray[index - 1];
		}
	}

	@Override
	public Object pop() {
		// TODO Auto-generated method stub
		if (isEmpty()) {
			throw new IndexOutOfBoundsException();
		} else {
			Object obj = peek();
			stackArray[index] = null;
			return obj;
		}
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return (index <= 0);
	}
}