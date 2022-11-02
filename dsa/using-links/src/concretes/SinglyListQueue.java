package concretes;

import interfaces.Queue;

public class SinglyListQueue<T> extends SinglyLinkedList<T> implements Queue<T> {

	@Override
	public void enQueue(T element) {
		super.insertBack(element);
	}

	@Override
	public T deQueue() {
		return super.deleteFront();
	}

	@Override
	public T peek() {
		return super.peekFront();
	}

}
