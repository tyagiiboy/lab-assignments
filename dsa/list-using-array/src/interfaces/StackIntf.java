package interfaces;

import exceptions.SizeOverFlowException;
import exceptions.SizeUnderFlowException;

public interface StackIntf<T> {
	int DEFAULT_SIZE = 16;
	void push(T element) throws SizeOverFlowException;
	T pop() throws SizeUnderFlowException;
	T peek();
	int size();
	boolean isFull();
	boolean isEmpty();
}
