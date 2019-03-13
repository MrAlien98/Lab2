package model;

import stack.IStack;
import stack.Stack;

public class Cashier {

	private IStack<Book> bookStack;
	
	public Cashier() {
		setBookStack(new Stack<>());
	}

	/**
	 * @return the bookStack
	 */
	public IStack<Book> getBookStack() {
		return bookStack;
	}

	/**
	 * @param bookStack the bookStack to set
	 */
	public void setBookStack(IStack<Book> bookStack) {
		this.bookStack = bookStack;
	}

	public void registerBook(Book b1) {
		bookStack.push(b1);
	}
	
}
