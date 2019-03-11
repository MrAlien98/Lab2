package exceptions;

@SuppressWarnings("serial")
public class RunOutOfBookException extends Exception {

	public RunOutOfBookException(String isbn) {
		super("We just run put of the book that you are looking for: "+isbn);
	}
	
}
