package JavaDataStructure;

public class MyLinkedStack implements OStack {
	private ONode topNode;

	public static void main(String args[]) {
		MyLinkedStack ls = new MyLinkedStack();
		ls.push("1");
		ls.push(1);
		ls.push("hiih");

		System.out.println(ls.pop());
		System.out.println(ls.pop());
		System.out.println(ls.pop());
	}

	public MyLinkedStack() {
		this.topNode = null;
	}

	@Override
	public void push(Object data) {
		// 새로운 노드 생성
		ONode newNode = new ONode(data);
		// 새로운 노드의 다음노드를 삽입 이전의 top을 참조하도록
		newNode.setNextNode(topNode);
		// 삽입 이후의 탑은 새로운 노드
		topNode = newNode;
	}

	@Override
	public Object pop() {
		if (isEmpty()) {
			throw new IndexOutOfBoundsException("empty");
		} else {
			// 탑노드의 데이터
			Object data = peek();
			// 새로운 탑노드는 현재 탑노드의 nextNode
			topNode = topNode.getNextNode();
			// 데이터 반환
			return data;
		}
	}

	@Override
	public Object peek() {
		if (isEmpty()) {
			throw new IndexOutOfBoundsException();
		} else {
			return topNode.getData(); // 데이터만 반환
		}
	}

	@Override
	public boolean isEmpty() {
		return (topNode == null);
	}
}

class ONode { // 스택에 활용할 노드 클래스
	private Object data; // 데이터를 저장
	private ONode nextNode; // 이전의 노드를 저장하기 위한 노드

	public ONode(Object data) {
		this.data = data;
		this.nextNode = null;
	}

	public Object getData() {
		return data;
	}

	public void setNextNode(ONode node) {
		nextNode = node;
	}

	public ONode getNextNode() {
		return nextNode;
	}
}