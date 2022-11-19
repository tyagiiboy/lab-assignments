package concretes;

import interfaces.Queue;

public class SinglyListQueue<T extends Comparable<T>> implements Queue<T> {

	private SinglyLinkedList<T> list;
	
	public SinglyListQueue() {
		list = new SinglyLinkedList<>();
	}
	
	@Override
	public void enQueue(T element) {
		list.addLast(element);
	}

	@Override
	public T deQueue() {
		return list.removeFirst();
	}

	@Override
	public T peek() {
		return list.peekFront();
	}

	@Override
	public int size() {
		return list.size();
	}

	@Override
	public boolean isEmpty() {
		return list.isEmpty();
	}

}
