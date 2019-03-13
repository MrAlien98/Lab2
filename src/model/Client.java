package model;

import stack.IStack;
import stack.Stack;

public class Client {
	
	private String id;
	private double bill;
	
	private IStack<Book> booksList;
	private IStack<Book> bookStack;
	
	public Client(String identification) {
		this.id=identification;
		bill=0;
		bookStack=new Stack<>();
		booksList=new Stack<>();
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
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
	
	/**
	 * 
	 * @param b1
	 */
	public void buyBook(Book b1) {
		bookStack.push(b1);
	}

	/**
	 * @return the bookList
	 */
	public IStack<Book> getBooksList() {
		return booksList;
	}

	/**
	 * @param bookList the bookList to set
	 */
	public void setBooksList(IStack<Book> bookList) {
		this.booksList = bookList;
	}

	/**
	 * @return the bill
	 */
	public double getBill() {
		return bill;
	}

	/**
	 * @param bill the bill to set
	 */
	public void setBill(double bill) {
		this.bill = bill;
	}
	
}
