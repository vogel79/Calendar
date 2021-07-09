package exception;

public class InvalidDateFormatException extends Exception {

    private String message;

	public InvalidDateFormatException(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

}
