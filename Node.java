public class Node {
	private int info = 0;
	public Node next;

	public Node(int info) {
		this.info = info;
	}

	public int getInfo() {
		return info;
	}

	public void setInfo(int info) {
	this.info = info;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	public Node getNext() {
		return next;
	}
}