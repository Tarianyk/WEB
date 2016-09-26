package ua.nure.tarianyk.SummaryTask4.exception;

/**
 * Used for demonstrating that custom
 * container does not contains needed command.
 * 
 * @author Anton
 * @version 1.0
 *
 */
public class ContainerDoesNotContainsCommandException extends Exception {

	private static final long serialVersionUID = 8729428269084194581L;

	public ContainerDoesNotContainsCommandException() {
		super();
	}

	public ContainerDoesNotContainsCommandException(String message) {
		super(message);
	}

}

