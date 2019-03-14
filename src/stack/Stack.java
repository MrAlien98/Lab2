package stack;

import queue.IQueue;
import queue.Queue;

public class Stack<T> implements IStack<T>{

	private IQueue<T> queue;
	private IQueue<T> iqueue;
	private int size;
	
	public Stack() {
		queue=new Queue<T>();
		iqueue=new Queue<T>();
		size=0;
	}
	
	public Queue<T> getQueue() {
		return (Queue<T>) queue;
	}

	public void setQueue(Queue<T> queue) {
		this.queue = queue;
	}

	public Queue<T> getQueueT() {
		return (Queue<T>) iqueue;
	}

	public void setQueueT(Queue<T> queueT) {
		this.iqueue = queueT;
	}

	@Override
	public void push(T element) {
		if(queue.isEmpty()) {
			queue.offer(element);
		}else {
			iqueue.offer(element);
			while(!queue.isEmpty()) {
				iqueue.offer(queue.poll());
			}
			while(!iqueue.isEmpty()) {
				queue.offer(iqueue.poll());
			}
			iqueue.clear();
		}
		size++;
	}
	
	@Override
	public T pop() {
		size--;
		return queue.poll();
	}
	
	@Override
	public T peek() {
		return queue.peek();
	}
	
	@Override
	public boolean isEmpty() {
		if(queue.isEmpty()) {
			return true;
		}else{
			return false;
		}
	}

	@Override
	public Stack<T> reverse(IStack<T> p) {
		Stack<T> f=new Stack<T>();
		while(!p.isEmpty()) {
			f.push(p.pop());
		}
		return f;
	}

	/**
	 * @return the size
	 */
	@Override
	public int size() {
		return size;
	}

	/**
	 * @param size the size to set
	 */
	public void setSize(int size) {
		this.size = size;
	}
	
}
