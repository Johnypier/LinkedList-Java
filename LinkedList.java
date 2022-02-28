public class LinkedList {

	private Node elements;
	private int length = 0;

	public LinkedList() {
	}

	public Node getFirstElement() {
	    return elements;
	}

	public Node getLastElement() {
	        Node current = elements;
	        while (current.getNext() != null) {
	        	current = current.getNext();
	        }
	        return current;
	}

	public void add(int info) {
		if (elements == null) {
			elements = new Node(info);
		} else {
		Node temp = new Node(info);
		Node current = elements;
	        while(current.getNext() != null){
	        	current = current.getNext();	
	        }
	        current.setNext(temp);
		}
		length++;
	}

	public int size() {
		return length;
	}

	public void remove(int pos) {
        if (pos < 0 || pos > size()-1){
        	System.out.println("Index is out of bound.");
        }else {
        	if (elements!=null) {
        		if (pos == 0) {
        			Node temp = elements;
        			elements = elements.getNext(); 
        			temp.setNext(null);
        			length--;
        		}else {
        		Node previous = elements;
        		int count = 0;
        		while (count < pos - 1) {
        			previous = previous.getNext();
        			count++;
        		}
        		//Remove an element
        		Node current = previous.getNext();
        		previous.setNext(current.getNext());
        		current.setNext(null);
        		length--;
        		}
        	}
        }
	}
	//Converts list to String
	public String toString() {
		String ret = "";
		Node current = elements; //Point to header
		//Just add each element to String
		while (current != null) {
			if(current.getNext() == null) {
				ret +=current.getInfo();
				break;
			}
			ret +=current.getInfo()+",";
			current = current.getNext();
		}
		return ret;
	}
	//Returns the sum of all elements in the list
	public int sum() {
		Node current = elements;
		int sum = 0;
		while (current != null) {
			sum +=current.getInfo();
			current = current.getNext();
		}
		return sum;
	}

	public LinkedList copy() {
		LinkedList copy = new LinkedList();
		if (elements != null) {
		copy.add(elements.getInfo());
		Node current = elements;
			while (current.getNext()!=null) {
				copy.add(current.getNext().getInfo());
				current = current.getNext();
			}
		}
		return copy;
	}

	public int hits(int value) {
		int amount=0;
		Node current = elements;
		while (current.getNext()!=null) {
			if (current.getInfo()==value) {
				amount++;
			}
			current = current.getNext();
		}
		return amount;
	}

	public Node[] search(int value) {
		int i = 0;
		//Important: length of the array must be equal to amount of "hits"
		Node[] listArray = new Node[hits(value)];
		Node current = elements;
		while (current!=null) {
			if (current.getInfo()==value && i<hits(value)) {
				listArray[i] = current;
				i++;
			}
			current = current.getNext();
		}
		return listArray;
	}

	public int[] toArray() {
		int i = 1;
		int[] intArray = new int[size()];
		Node current = elements;
		while(current!=null && i<size()) {
			intArray[i] = current.getNext().getInfo();
			current = current.getNext();
			i++;
		}
		intArray[0] = elements.getInfo();
		return intArray;
	}

	public static LinkedList fromArray(int[] intArray) {
		if (intArray == null) {
			return null;
		}
		LinkedList copy = new LinkedList();
		for (int i = 0; i<intArray.length;i++) {
			copy.add(intArray[i]);
		}
		return copy;
	}

	public LinkedList reverse() {
		if (elements == null || elements.getNext()==null) {
			return null;
		}
		Node previous = null, next = null;
		Node current = elements;
		while (current!=null) {
			next = current.getNext();
			current.setNext(previous);
			previous = current;
			current = next;
		}
		elements = previous;
		return copy();
	}
}
