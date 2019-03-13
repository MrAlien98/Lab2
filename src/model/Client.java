package model;

import stack.IStack;
import stack.Stack;

public class Client {
	
	private String id;
	private IStack<Book> booksList;
	private IStack<Book> bookStack;
	
	private double account;
	
	public Client(String identification) {
		this.id=identification;
		bookStack=new Stack<>();
		booksList=new Stack<>();
		account=0;
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
	 * @return the account
	 */
	public double getAccount() {
		return account;
	}

	/**
	 * @param account the account to set
	 */
	public void setAccount(double account) {
		this.account = account;
	}
	
}
