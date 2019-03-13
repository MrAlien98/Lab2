package stack;

import queue.IQueue;
import queue.Queue;

public class Stack<T> implements IStack<T>{

	private IQueue<T> queue;
	private IQueue<T> iqueue;
	
	public Stack() {
		queue=new Queue<T>();
		iqueue=new Queue<T>();
	}
	
	public Queue<T> getCola() {
		return (Queue<T>) queue;
	}

	public void setCola(Queue<T> cola) {
		this.queue = cola;
	}

	public Queue<T> getColaT() {
		return (Queue<T>) iqueue;
	}

	public void setColaT(Queue<T> colaT) {
		this.iqueue = colaT;
	}

	@Override
	public void push(T elemento) {
		if(queue.isEmpty()) {
			queue.offer(elemento);
		}else {
			iqueue.offer(elemento);
			while(!queue.isEmpty()) {
				iqueue.offer(queue.poll());
			}
			while(!iqueue.isEmpty()) {
				queue.offer(iqueue.poll());
			}
			iqueue.clear();
		}
	}
	
	@Override
	public T pop() {
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
	public Stack<T> reverse(Stack<T> p) {
		
		return p;
	}
	
}
