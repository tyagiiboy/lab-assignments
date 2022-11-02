package concretes;

import exceptions.SizeUnderFlowException;
import interfaces.Stack;

public class SinglyListStack<T extends Comparable<T>> implements Stack<T> {
	
	private SinglyLinkedList<T> list;
	
	public SinglyListStack() {
		list = new SinglyLinkedList<>();
	}

	@Override
	public void push(T element) {
		list.addFirst(element);
	}

	@Override
	public T pop() throws SizeUnderFlowException {
		return list.removeFirst();
	}

	@Override
	public T peek() {
		return list.peekFront();
	}

	@Override
	public boolean isEmpty() {
		return list.isEmpty();
	}

	@Override
	public int size() {
		return list.size();
	}
	
}
