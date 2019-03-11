package model;

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
	
}
