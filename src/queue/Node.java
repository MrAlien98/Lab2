package queue;

public class Node<T> {

	private T element;
	private Node<T> next;
	private Node<T> prev;
	
	public Node(T element) {
		this.element=element;
		next=null;
		setPrev(null);
	}

	public T getElement() {
		return element;
	}

	public void setElement(T element) {
		this.element = element;
	}

	public Node<T> getNext() {
		return next;
	}

	public void setNext(Node<T> next) {
		this.next = next;
	}

	/**
	 * @return the prev
	 */
	public Node<T> getPrev() {
		return prev;
	}

	/**
	 * @param prev the prev to set
	 */
	public void setPrev(Node<T> prev) {
		this.prev = prev;
	}
	
	
	
}
