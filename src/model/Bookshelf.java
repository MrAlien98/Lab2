package model;

import hashtable.Hashtable;

public class Bookshelf{

	private String id;
	
	private Hashtable<String, Book> bookHash;

	public Bookshelf(String id, int size) {
		this.id=id;
		bookHash=new Hashtable<String, Book>(size);
	}
	
	public Hashtable<String, Book> getBookHash() {
		return bookHash;
	}

	public void setBookHash(Hashtable<String, Book> bookHash) {
		this.bookHash = bookHash;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	
	
}
