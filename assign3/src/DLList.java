/**
 * @author Maya Michalik March 21 2019
 * March 21 2019
 * this program creates various node methods for doubly linked lists
 */
public class DLList<T> implements DLListADT<T> {
	private DLNode<T> front;
	private DLNode<T> rear;
	private int count;
	// initiates variables

	/**
	 * constructor method Initializes front, rear and count
	 */
	public DLList() {
		front = null;
		rear = null;
		count = 0;
	}

	/**
	 * inserts new node if list is empty the newNode is the front and rear if the
	 * list contains other nodes we add the new node to the rear count increases
	 * 
	 * @param dataItem, value
	 */
	public void insert(T dataItem, int value) {
		DLNode<T> newNode = new DLNode<T>(dataItem, value);
		if (front == null) {
			front = newNode;
			rear = newNode;
		} else {
			rear.setNext(newNode);
			newNode.setPrevious(rear);
			newNode.setNext(null);
			rear = newNode;
		}
		count++;
	}

	/**
	 * gets the data value at the given dataItem if given dataItem is not found an
	 * exception is thrown
	 * 
	 * @param dataItem
	 * @throws InvalidDataItemException
	 */
	public int getDataValue(T dataItem) throws InvalidDataItemException {
		DLNode<T> curr = front;
		boolean found = false;

		while (curr != null) {
			if (curr.getData().equals(dataItem)) {
				found = true;
				break;
			}
			curr = curr.getNext();
		}
		if (found = false) {
			throw new InvalidDataItemException("Linked List has invalid dataItem.");
		}
		return curr.getValue();
	}

	/**
	 * changes value at the given dataItem to the given value
	 * 
	 * @param dataItem, newValue
	 * @throws InvalidDataItemException
	 */
	public void changeValue(T dataItem, int newValue) throws InvalidDataItemException {
		DLNode<T> curr = front;
		boolean found = false;

		while (curr != null) {
			if (curr.getData().equals(dataItem)) {
				curr.setValue(newValue);
				found = true;
				break;
			}
			curr = curr.getNext();
		}
		if (!found) {
			throw new InvalidDataItemException("Linked List");
		}
	}

	/**
	 * searches through the list looking for the smallest value removes the node
	 * associated with the smallest value
	 * 
	 * @throws EmptyListException
	 * @returns small.getData()
	 */
	public T getSmallest() throws EmptyListException {
		if (isEmpty()) {
			throw new EmptyListException("linked List is empty.");
		}
		
		DLNode<T> curr = front;
		DLNode<T> small = front;

		while (curr != null) {
			if (curr.getValue() < small.getValue()) {
				small = curr;
			}
			curr = curr.getNext();
			}
		if (size() == 1) {
			front = null;
			rear = null;
		}

		else if (front == small) {
			front = small.getNext();
			front.setPrevious(null);
		}

		else if (rear == small) {
			rear = small.getPrevious();
			rear.setNext(null);
		}

		else {
			small.getPrevious().setNext(small.getNext());
			small.getNext().setPrevious(small.getPrevious());
		}
		
	count--;
	return small.getData();
	}

	/**
	 * if list is empty
	 * 
	 * @return true if list is not
	 * @return false
	 */
	public boolean isEmpty() {
		if (count == 0) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * returns the size of the list
	 * 
	 * @return count
	 */
	public int size() {
		return count;
	}

	/**
	 * returns the string representation of the list
	 * 
	 * @return result
	 */
	public String toString() {
		String result = "List: ";
		DLNode<T> curr = front;

		while (curr != null) {
			result = result + curr.getData().toString() + ", " + curr.getValue() + ";";
			curr = curr.getNext();
		}
		return result;
	}

}