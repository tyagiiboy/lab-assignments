package concretes;

import java.util.Arrays;

import exceptions.SizeOverFlowException;
import exceptions.SizeUnderFlowException;
import interfaces.Queue;

public class ArrayQueue<T> implements Queue<T>, Cloneable {
	protected int currSize, maxSize, head, tail;
	protected Object[] arr;
	
	public ArrayQueue() {
		this(DEFAULT_SIZE - 1);
	}

	public ArrayQueue(int size) {
		maxSize = size + 1;
		currSize = 0;
		head = tail = 0;
		arr = new Object[maxSize];
	}
	
	@Override
	public void enQueue(T element) throws SizeOverFlowException {
		if (isFull()) throw new SizeOverFlowException("max size limit reached");
		
		currSize++;
		arr[++tail] = element;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public T deQueue() throws SizeUnderFlowException {
		if (isEmpty()) throw new SizeUnderFlowException("min size limit reached");
		
		currSize--;
		T element = (T) arr[++head];
		arr[head] = null;
		
		if (isEmpty()) head = tail = 0;
		
		return element;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public T peek() {
		if (isEmpty()) return null;
		return (T) arr[head + 1];
	}
	
	@Override
	public int size() {
		return currSize;
	}
	
	@Override
	public boolean isFull() {
		return (tail == maxSize-1);
	}
	
	@Override
	public boolean isEmpty() {
		return (head == tail);
	}

	@Override
	public ArrayQueue<T> clone() throws CloneNotSupportedException {
		ArrayQueue<T> newQueue = new ArrayQueue<>(maxSize);
		newQueue.currSize = currSize;
		newQueue.maxSize = maxSize;
		newQueue.head = head;
		newQueue.tail = tail;
		newQueue.arr = Arrays.copyOf(arr, maxSize);
		return newQueue;
	}

	@Override
	public String toString() {
		return "Queue: [" + Arrays.toString(arr) + "]";
	}
	
}
