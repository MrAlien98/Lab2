package model;

import hashtable.Hashtable;

public class Bookshelf{

	private String id;
	private Hashtable<String, Book> bookHash;

	public Bookshelf(String id, int size) {
		this.id=id;
		bookHash=new Hashtable<String, Book>(size);
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
	 * @return the bookHash
	 */
	public Hashtable<String, Book> getBookHash() {
		return bookHash;
	}

	/**
	 * @param bookHash the bookHash to set
	 */
	public void setBookHash(Hashtable<String, Book> bookHash) {
		this.bookHash = bookHash;
	}	
	
}
