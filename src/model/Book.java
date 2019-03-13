package model;

public class Book{
	
	private int bookshelf;
	private String isbn;
	private double price;
	private int quantity;
	
	public Book(String isbn, double price, int quantity) {
		this.isbn=isbn;
		this.price=price;
		this.quantity=quantity;
	}

	/**
	 * @return the bookshelf
	 */
	public int getBookshelf() {
		return bookshelf;
	}

	/**
	 * @param bookshelf the bookshelf to set
	 */
	public void setBookshelf(int bookshelf) {
		this.bookshelf = bookshelf;
	}

	/**
	 * @return the isbn
	 */
	public String getIsbn() {
		return isbn;
	}

	/**
	 * @param isbn the isbn to set
	 */
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	
	
}
