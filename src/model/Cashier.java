package model;

import stack.IStack;
import stack.Stack;

public class Cashier {

	private IStack<Book> bookStack;
	private boolean bussy;
	
	public Cashier() {
		setBookStack(new Stack<>());
		setBussy(false);
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
	 * @return the bussy
	 */
	public boolean isBussy() {
		return bussy;
	}

	/**
	 * @param bussy the bussy to set
	 */
	public void setBussy(boolean bussy) {
		this.bussy = bussy;
	}
	
	public Client attendClient(Client c) {
		setBussy(true);
		double bill=0;
		while(!c.getBookStack().isEmpty()) {
			bookStack.push(c.getBookStack().pop());
			bill+=bookStack.peek().getPrice();
		}
		c.setBill(bill);
		c.setBookStack(bookStack);
		setBussy(false);
		return c;
	}
	
}
