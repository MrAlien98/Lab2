package exceptions;

@SuppressWarnings("serial")
public class NoBookException extends Exception {

	public NoBookException(Object key) {
		super("Couldn't find specified book: "+key);
	}
	
}
