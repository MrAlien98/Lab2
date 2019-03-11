package model;

import stack.IStack;
import stack.Stack;

public class Cashier {

	private IStack<Book> bookStack;
	
	public Cashier() {
		bookStack=new Stack<>();
	}

	public IStack<Book> getBooks() {
		return bookStack;
	}

	public void setBooks(IStack<Book> books) {
		this.bookStack = books;
	}
	
}
