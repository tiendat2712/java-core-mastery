package exception;

public class InvalidImageException extends Exception {
	
	private static final long serialVersionUID = -3569727925756722826L;
	
	// Runtime(Unchecked) Exception
	// Compile(Checked) Exception
	
	// Code
	
	// Class extends Exception
	// Class extends RuntimeException

	// text data
	// serialized data

	public InvalidImageException(String message) {
		super(message);
	}
	
}
