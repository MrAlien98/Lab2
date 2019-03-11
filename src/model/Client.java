package model;

import stack.IStack;
import stack.Stack;

public class Client<T> {
	
	private T id;

	private IStack<Book> bookStack;
	
	public Client(T identification) {
		this.id=identification;
		bookStack=new Stack<>();
	}

	public IStack<Book> getBooks() {
		return bookStack;
	}

	public void setBooks(IStack<Book> books) {
		this.bookStack = books;
	}

	public T getIdentification() {
		return id;
	}

	public void setIdentification(T identification) {
		this.id = identification;
	}
	
	
	
	
}
