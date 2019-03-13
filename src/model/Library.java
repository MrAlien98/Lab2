package model;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import exceptions.NoBookException;
import queue.IQueue;
import queue.Queue;

public class Library {
	
	private IQueue<Client> clients;
	private Cashier[] cashiers;
	private Bookshelf[] bookshelfs;
	
	public Library(int cashierSize, int bookshelfsSize) {
		clients=new Queue<>();
		cashiers=new Cashier[cashierSize];
		bookshelfs=new Bookshelf[bookshelfsSize];
	}

	/**
	 * @return the clients
	 */
	public IQueue<Client> getClients() {
		return clients;
	}

	/**
	 * @param clients the clients to set
	 */
	public void setClients(IQueue<Client> clients) {
		this.clients = clients;
	}

	/**
	 * @return the cashiers
	 */
	public Cashier[] getCashiers() {
		return cashiers;
	}

	/**
	 * @param cashiers the cashiers to set
	 */
	public void setCashiers(Cashier[] cashiers) {
		this.cashiers = cashiers;
	}

	/**
	 * @return the bookshelfs
	 */
	public Bookshelf[] getBookshelfs() {
		return bookshelfs;
	}

	/**
	 * @param bookshelfs the bookshelfs to set
	 */
	public void setBookshelfs(Bookshelf[] bookshelfs) {
		this.bookshelfs = bookshelfs;
	}

	public void addBook(int bookshelfN, String isbn, double price, int quantity) {
		Book book1=new Book(isbn, price, quantity);
		bookshelfs[bookshelfN].getBookHash().add(book1.getIsbn(), book1);
	}
	
	/**
	 * @throws NoBookException 
	 * 
	 */
	public void buyBook() throws NoBookException {
		IQueue<Client> clientsT=new Queue<>();
		while(!clients.isEmpty()) {
			while(!clients.peek().getBookStack().isEmpty()) {
				if(clients.peek().getBookStack().peek().getQuantity()>0) {
					clients.peek().buyBook(bookshelfs[clients.peek().getBooksList().peek().getBookshelf()].getBookHash().find(clients.peek().getBooksList().pop().getIsbn()).getValue());
				}
			}
			clientsT.offer(clients.poll());
		}
		while(!clientsT.isEmpty()) {
			clients.offer(clientsT.poll());
		}
	}
	
	/**
	 * 
	 */
	public void passCashier() {
		
	}
	
	/**
	 * 
	 */
	public void readInput() {
		
	}
	
	/**
	 * 
	 */
	public void writeOutput() {
		
	}
	
	/**
	 * Writes a new input for the test case
	 */
	public void writeInput(String input) {
		try {
			BufferedWriter bw=new BufferedWriter(new FileWriter("src/testCases/Input.txt"));
			bw.write(input);
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
