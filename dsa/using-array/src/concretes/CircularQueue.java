package concretes;

import exceptions.SizeOverFlowException;
import exceptions.SizeUnderFlowException;

public class CircularQueue<T> extends ArrayQueue<T> implements Cloneable {
	
	private int nextIndexOf(int i) {
		return (i+1) % maxSize;
	}
	
	public CircularQueue() {
		super();
	}
	
	public CircularQueue(int size) {
		super(size);
	}
	
	@Override
	public void enQueue(T element) throws SizeOverFlowException {
		if (isFull()) throw new SizeOverFlowException("max size limit reached");
		
		currSize++;
		arr[tail = nextIndexOf(tail)] = element;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public T deQueue() throws SizeUnderFlowException {
		if (isEmpty()) throw new SizeUnderFlowException("min size limit reached");
		
		currSize--;
		T element = (T) arr[head = nextIndexOf(head)];
		arr[head] = null;
		return element; 
	}
	
	@Override
	public boolean isFull() {
		return nextIndexOf(tail) == head;
	}
	
}
