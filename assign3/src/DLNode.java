/**
 *  @author Maya Michalik
 *  March 21 2019
 *  this program creates setter and getter methods for doubly linked lists
 */
public class DLNode<T>{
	private T dataItem;
	private DLNode<T> next;
	private DLNode<T> previous;
	private int value;
	//initiates variables
	
	/** 
	 * constructor method 
	 * @param data, value
	 * Initializes the next, previous, value, and dataItem of the node
	 */
	public DLNode (T data, int value) {
		next = null;
		previous = null;
		this.value = value;
		dataItem = data;
	}

	/** 
	 * getter method for the value
	 * @return value
	 */
	public int getValue() {
		return value;
	}
	
	/**
	 * getter method for the dataItem
	 * @return dataItem
	 */
	public T getData() {
		return dataItem;
		}
	
	/**
	 * getter method for the next variable
	 * @return next
	 */
	public DLNode<T> getNext(){
		return next;
		}
	
	/**
	 * getter method for the previous variable
	 * @return previous
	 */
	public DLNode<T> getPrevious(){
		return previous;
		}
	
	/**
	 * setter method for dataItem
	 * @param newData
	 */
	public void setData(T newData) {
		  this.dataItem = newData;
		  }
	
	/**
	 * setter method for next variable
	 * @param newNext
	 */
	public void setNext(DLNode<T> newNext) {
		  this.next = newNext;
		  }
	
	/**
	 * setter method for previous variable
	 * @param newPrevious
	 */
	public void setPrevious(DLNode<T> newPrevious) {
		  this.previous = newPrevious;
		  }
	
	/**
	 * setter method for value
	 * @param newValue
	 */
	public void setValue(int newValue) {
		  this.value = newValue;
		  }
}