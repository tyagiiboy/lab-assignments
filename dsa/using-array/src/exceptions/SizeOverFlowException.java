package exceptions;

public class SizeOverFlowException extends Exception {
	private static final long serialVersionUID = -3930600189632998908L;

	public SizeOverFlowException(String msg) {
		super(msg);
	}
}
