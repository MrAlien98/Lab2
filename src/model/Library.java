package model;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import exceptions.NoBookException;
import queue.IQueue;
import queue.Queue;

/**
 * 
 * @author c
 *
 */
public class Library {
	
	private IQueue<Client> clients;
	private Cashier[] cashiers;
	private Bookshelf[] bookshelfs;
	
	/**
	 * 
	 * @param cashierSize
	 * @param bookshelfsSize
	 */
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

	/**
	 * Adds a new book to an specific Bookshelf
	 * @param bookshelfN number of the bookshel where the book will be saved
	 * @param isbn identificator for the book
	 * @param price price of the book
	 * @param quantity how many of the same book will be available
	 */
	public void addBook(int bookshelfN, String isbn, double price, int quantity) {
		Book book1=new Book(bookshelfN, isbn, price, quantity);
		bookshelfs[bookshelfN].getBookHash().add(book1.getIsbn(), book1);
	}
	
	/**
	 * This method makes the client buy all of the
	 * books on it´s bookList (Stack) and
	 * passes them to his shopping cart (Stack)
	 * @throws NoBookException if the book that the client is trying
	 * 			to buy is not on the bookshelf or is not available
	 * 
	 */
	public void buyBook() throws NoBookException {
		IQueue<Client> clientsT=new Queue<>();
		while(!clients.isEmpty()) {
			while(!clients.peek().getBookStack().isEmpty()) {
				if(clients.peek().getBookStack().peek().getQuantity()>0) {
					clients.peek().buyBook(bookshelfs[clients.peek().getBooksList().peek().getBookshelf()].getBookHash().find(clients.peek().getBooksList().pop().getIsbn()).getValue());
					clients.peek().setBill(clients.peek().getBill()+clients.peek().getBookStack().peek().getPrice());
					clients.peek().getBookStack().peek().setQuantity(clients.peek().getBookStack().peek().getQuantity()-1);
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
	 * Writes an output to the case that has been passed from the GUI
	 */
	public void writeOutput() {
		String output="";
		while(!clients.isEmpty()) {
			output+=clients.peek().getId()+" "+clients.peek().getBill()+"\n";
			clients.peek().setBookStack(clients.peek().getBookStack().reverse(clients.peek().getBookStack()));
			while(!clients.peek().getBookStack().isEmpty()) {
				output+=clients.peek().getBookStack().pop().getIsbn()+" ";
			}
			output+="\n";
		}
		try {
			BufferedWriter bw=new BufferedWriter(new FileWriter("src/testCases/Output.txt"));
			bw.write(output);
			bw.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Writes a new input for the test case
	 * on a.txt file named RandomInput.txt
	 */
	public void writeInput(String input) {
		try {
			BufferedWriter bw=new BufferedWriter(new FileWriter("src/testCases/RandomInput.txt"));
			bw.write(input);
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
