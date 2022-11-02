package exceptions;

public class SizeUnderFlowException extends Exception {
	private static final long serialVersionUID = 8401274184953454753L;

	public SizeUnderFlowException(String msg) {
		super(msg);
	}
}
