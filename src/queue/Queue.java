package queue;

public class Queue<T> implements IQueue<T>{

	private Node<T> front;
	private Node<T> back;
	private int size;
	
	public Queue() {
		size=0;
		front=null;
		back=null;
	}
	
	public Node<T> getFront() {
		return front;
	}

	public void setFront(Node<T> front) {
		this.front = front;
	}

	public Node<T> getBack() {
		return back;
	}

	public void setBack(Node<T> back) {
		this.back = back;
	}

	@Override
	public T peek() {
		return front.getElement();
	}

	@Override
	public T poll() {
		if(isEmpty()) {
			return null;
		}else {
			Node<T> temp=front;
			front=temp.getNext();
			size--;
			return temp.getElement();
		}
	}

	@Override
	public void offer(T element) {
		Node<T> newnode=new Node<>(element);
		if(isEmpty()) {
			front=newnode;
		}else {
			back.setNext(newnode);
		}
		back=newnode;
		size++;
	}

	@Override
	public boolean isEmpty() {
		if (size==0)
			return true;
		else
			return false;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public void clear() {
		size=0;
		front=back=null;
	}
	
}
