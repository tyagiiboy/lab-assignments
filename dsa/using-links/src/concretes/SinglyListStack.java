package concretes;

import exceptions.SizeUnderFlowException;
import interfaces.Stack;

public class SinglyListStack<T> extends SinglyLinkedList<T> implements Stack<T> {
	
	public SinglyListStack() {
		super();
	}

	@Override
	public void push(T element) {
		super.insertFront(element);
	}

	@Override
	public T pop() throws SizeUnderFlowException {
		return super.deleteFront();
	}

	@Override
	public T peek() {
		return super.peekFront();
	}
	
}
