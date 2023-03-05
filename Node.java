public class Node {
	private int info = 0;
	private Node nextNode;

	public Node(int info) {
		this.info = info;
	}

	public int getInfo() {
		return info;
	}

	public void setInfo(int info) {
		this.info = info;
	}

	public void setNext(Node nextNode) {
		this.nextNode = nextNode;
	}

	public Node getNext() {
		return nextNode;
	}
}
