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
		Stack<T> f=new Stack<T>();
		while(!p.isEmpty()) {
			f.push(p.pop());
		}
		return f;
	}
	
}
