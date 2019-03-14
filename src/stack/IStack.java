package stack;

public interface IStack<T> {

	void push(T elemento);
	public T pop();
	public T peek();
	public boolean isEmpty();
	public Stack<T> reverse(IStack<T> p);
	public int size();
}
