package model;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import queue.IQueue;
import queue.Queue;

public class Library {
	
	private IQueue<Client<String>> clients;
	private Cashier[] cashiers;
	private Bookshelf[] bookshelfs;
	
	public Library(int cashierSize, int bookshelfsSize) {
		clients=new Queue<>();
		cashiers=new Cashier[cashierSize];
		bookshelfs=new Bookshelf[bookshelfsSize];
	}

	public IQueue<Client<String>> getClients() {
		return clients;
	}

	public void setClients(IQueue<Client<String>> clients) {
		this.clients = clients;
	}

	public Cashier[] getCashiers() {
		return cashiers;
	}

	public void setCashiers(Cashier[] cashiers) {
		this.cashiers = cashiers;
	}

	public Bookshelf[] getBookshelfs() {
		return bookshelfs;
	}

	public void setBookshelfs(Bookshelf[] bookshelfs) {
		this.bookshelfs = bookshelfs;
	}
	
	public void addBook(int bookshelfN, String isbn, double price, int quantity) {
		Book book1=new Book(isbn, price, quantity);
		bookshelfs[bookshelfN].getBookHash().add(book1.getIsbn(), book1);
	}
	
	public void writeEntry() {
		try {
			BufferedWriter bw=new BufferedWriter(new FileWriter("src/testCases/Input.txt"));
			
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
