package interfaces;

import exceptions.SizeOverFlowException;
import exceptions.SizeUnderFlowException;

public interface Queue<T> {
	int DEFAULT_SIZE = 16;
	void enQueue(T element) throws SizeOverFlowException;
	T deQueue() throws SizeUnderFlowException;
	T peek();
	int size();
	boolean isFull();
	boolean isEmpty();
}
