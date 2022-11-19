package concretes;

import java.util.Arrays;

import exceptions.SizeOverFlowException;
import exceptions.SizeUnderFlowException;
import interfaces.StackIntf;

public class ArrayStack<T> implements StackIntf<T>, Cloneable {
	private int currSize, maxSize, top;
	private Object[] arr;
	
	public ArrayStack() {
		this(DEFAULT_SIZE);
	}
	
	public ArrayStack(int size) {
		maxSize = size;
		currSize = 0;
		top = -1;
		arr = new Object[maxSize];
	}
	
	@Override
	public void push(T element) throws SizeOverFlowException {
		if (isFull()) throw new SizeOverFlowException("max size limit reached");
		
		++currSize;
		arr[++top] = element;
	}
	
	@Override
	public T pop() throws SizeUnderFlowException {
		if (isEmpty()) throw new SizeUnderFlowException("min size limit reached");
		
		--currSize;
		T element = peek();
		arr[--top] = null;
		return element;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public T peek() {
		if (isEmpty()) return null;
		return (T) arr[top];
	}
	
	@Override
	public int size() {
		return currSize;
	}
	
	@Override
	public boolean isFull() {
		return (currSize == maxSize);
	}
	
	@Override
	public boolean isEmpty() {
		return (currSize == 0 || top == -1);
	}

	@Override
	public ArrayStack<T> clone() throws CloneNotSupportedException {
		ArrayStack<T> newStack = new ArrayStack<>(maxSize);
		newStack.currSize = currSize;
		newStack.maxSize = maxSize;
		newStack.top = top;
		newStack.arr = Arrays.copyOf(arr, maxSize);
		return newStack;
	}
	
	@Override
	public String toString() {
		return "Stack: [" + Arrays.toString(arr) + "]";
	}
}
