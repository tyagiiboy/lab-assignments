package interfaces;

import exceptions.SizeUnderFlowException;

public interface Stack<T> {
	boolean isEmpty();
	void push(T element);
	T pop() throws SizeUnderFlowException;
	T peek();
	int size();
}
