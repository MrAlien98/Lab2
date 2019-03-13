package model;

import hashtable.Hashtable;

public class Bookshelf{

	private int id;
	private Hashtable<String, Book> bookHash;

	public Bookshelf(int id, int size) {
		this.id=id;
		bookHash=new Hashtable<String, Book>(size);
	}
	
	public Hashtable<String, Book> getBookHash() {
		return bookHash;
	}

	public void setBookHash(Hashtable<String, Book> bookHash) {
		this.bookHash = bookHash;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
	
}
