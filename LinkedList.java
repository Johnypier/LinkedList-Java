public class LinkedList {
	private Node rootNode;
	private int size = 0;

	/**
	 * Retrieve the first element of the linked list.
	 * 
	 * @return Root of the linked list.
	 */
	public Node getFirstElement() {
		return rootNode;
	}

	/**
	 * Retrieve the last element of the linked list.
	 * 
	 * @return Last element of the linked list.
	 */
	public Node getLastElement() {
		Node currentNode = rootNode;
		while (currentNode.getNext() != null) {
			currentNode = currentNode.getNext();
		}
		return currentNode;
	}

	/**
	 * Add the element to the linked list.
	 * 
	 * @param info Element to add.
	 */
	public void add(int info) {
		if (rootNode == null) {
			rootNode = new Node(info);
		} else {
			Node temp = new Node(info);
			Node currentNode = rootNode;
			while (currentNode.getNext() != null) {
				currentNode = currentNode.getNext();
			}
			currentNode.setNext(temp);
		}
		size++;
	}

	/*
	 * Size of the linked list.
	 */
	public int size() {
		return size;
	}

	/**
	 * Remove the element at specified index.
	 * 
	 * @param index Index of the element.
	 */
	public void remove(int index) {
		if (index < 0 || index > size() - 1) {
			throw new IllegalArgumentException("Index out of bound!");
		} else {
			if (rootNode != null) {
				if (index == 0) {
					Node temp = rootNode;
					rootNode = rootNode.getNext();
					temp.setNext(null);
					size--;
				} else {
					Node previousNode = rootNode;
					int counter = 0;
					while (counter < index - 1) {
						previousNode = previousNode.getNext();
						counter++;
					}
					Node currentNode = previousNode.getNext();
					previousNode.setNext(currentNode.getNext());
					currentNode.setNext(null);
					size--;
				}
			}
		}
	}

	/**
	 * Calculate the sum of each node's value.
	 * 
	 * @return Sum of nodes' values.
	 */
	public int sum() {
		Node current = rootNode;
		int sum = 0;
		while (current != null) {
			sum += current.getInfo();
			current = current.getNext();
		}
		return sum;
	}

	/**
	 * Create a copy of the linked list.
	 * 
	 * @return New copy of the linked list.
	 */
	public LinkedList copy() {
		LinkedList copy = new LinkedList();
		if (rootNode != null) {
			copy.add(rootNode.getInfo());
			Node currentNode = rootNode;
			while (currentNode.getNext() != null) {
				copy.add(currentNode.getNext().getInfo());
				currentNode = currentNode.getNext();
			}
		}
		return copy;
	}

	/**
	 * Create an array of the elements from the linked list which have the specified
	 * value.
	 * 
	 * @param value Value of needed elements.
	 * @return All elements with the same value.
	 */
	public Node[] search(int value) {
		int i = 0;
		// Important: length of the array must be equal to the amount of "hits"
		Node[] listArray = new Node[hits(value)];
		Node currentNode = rootNode;
		while (currentNode != null) {
			if (current.getInfo() == value && i < hits(value)) {
				listArray[i] = current;
				i++;
			}
			current = current.getNext();
		}
		return listArray;
	}

	/**
	 * Determine the amount of value's occurrences in the linked list.
	 * 
	 * @param value Value we need to find.
	 * @return Amount of value's occurrences.
	 */
	private int hits(int value) {
		int amount = 0;
		Node currentNode = rootNode;
		while (currentNode.getNext() != null) {
			if (currentNode.getInfo() == value) {
				amount++;
			}
			currentNode = currentNode.getNext();
		}
		return amount;
	}

	/*
	 * Convert the linked list into an array.
	 */
	public int[] toArray() {
		if (rootNode != null) {
			int i = 1;
			int[] intArray = new int[size()];
			intArray[0] = rootNode.getInfo();

			Node currentNode = rootNode;
			while (currentNode != null && i < size()) {
				intArray[i] = currentNode.getNext().getInfo();
				currentNode = currentNode.getNext();
				i++;
			}

			return intArray;
		}
		return new int[0];
	}

	/**
	 * Create a linked list from an array.
	 * 
	 * @param intArray Array to convert.
	 * @return New linked list.
	 */
	public static LinkedList fromArray(int[] intArray) {
		if (intArray == null) {
			return null;
		}
		LinkedList temp = new LinkedList();
		for (int i : intArray) {
			temp.add(i);
		}
		return temp;
	}

	/**
	 * Reverse the linked list.
	 * 
	 * @return Reversed linked list.
	 */
	public LinkedList reverse() {
		if (rootNode == null || rootNode.getNext() == null) {
			return null;
		}
		Node currentNode = rootNode;
		Node previousNode = null;
		Node nextNode = null;
		while (currentNode != null) {
			nextNode = currentNode.getNext();
			currentNode.setNext(previousNode);
			previousNode = currentNode;
			currentNode = nextNode;
		}
		rootNode = previousNode;
		return copy();
	}

	@Override
	public String toString() {
		Node currentNode = rootNode;
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("[");
		while (currentNode.getNext() != null) {
			stringBuilder.append(currentNode + ", ");
			currentNode = currentNode.getNext();
		}
		stringBuilder.append(currentNode + "]");
		return stringBuilder.toString();
	}
}
