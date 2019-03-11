package model;

public class Book{
	
	private String isbn;
	private double price;
	private int quantity;
	
	public Book(String isbn, double price) {
		this.isbn=isbn;
		this.price=price;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	
}
