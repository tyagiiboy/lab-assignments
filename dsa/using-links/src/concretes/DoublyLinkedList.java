package concretes;

import interfaces.LinkedList;

public class DoublyLinkedList<T extends Comparable<T>> implements LinkedList<T>{

	private class Node {
		T data;
		Node prev, next;

		Node(T d, Node l, Node r) {
			data = d;
			prev = l;
			next = r;
		}
	}

	private int size;
	private Node head, tail, curr;

	public DoublyLinkedList() {
		head = tail = curr = new Node(null, null, null);
		size = 0;
	}

	@Override
	public void addLast(T element) {
		Node node = new Node(element, tail, null);
		tail.next = node;
		tail = node;
		size++;
	}

	@Override
	public T removeLast() {
		if (isEmpty()) return null;
		T element = tail.data;
		tail = tail.prev;
		tail.next = null;
		size = size - 1;
		return element;
	}

	@Override
	public void addFirst(T element) {
		Node node = new Node(element, head, head.next);
		head.next = node;
		if (isEmpty()) tail = node;
		size++;
	}

	@Override
	public T removeFirst() {
		if (isEmpty()) return null;
		T element = head.next.data;
		head.next = head.next.next;
		if (isEmpty()) tail = head;
		size--; return element;
	}

	@Override
	public void insert(T element) {
		if (isEmpty()) {
			addFirst(element);
			return;
		}
		curr = head;
		while (curr.next != null && curr.next.data.compareTo(element) != 1) 
			curr = curr.next;
		Node node = new Node(element, curr, curr.next);
		curr.next = node;
		node.next.prev = node;
		if (curr == tail) tail = curr.next;
		size = size + 1;
	}

	@Override
	public void delete(T element) {
		curr = head;
		while (curr.next != null && !curr.next.data.equals(element))
			curr = curr.next;
		if (curr == head) removeFirst();
		else if (curr.next == tail) removeLast();
		else if (curr.next.data.equals(element)) {
			curr.next.next.prev = curr;
			curr.next = curr.next.next;
			size = size - 1;
		}
	}

	@Override
	public void append(LinkedList<T> list) {
		if (!list.isEmpty() && !this.isEmpty()) {
			tail.next = ((DoublyLinkedList<T>)list).head.next;
			((DoublyLinkedList<T>)list).head.next.prev = tail;
			tail = ((DoublyLinkedList<T>)list).tail;
			((DoublyLinkedList<T>)list).head.next = null;
			((DoublyLinkedList<T>)list).tail = ((DoublyLinkedList<T>)list).head;
		}
		
		else if (this.isEmpty() && !list.isEmpty()) {
			this.head = ((DoublyLinkedList<T>)list).head.next;
			((DoublyLinkedList<T>)list).head.next.prev = this.head;
			this.tail = ((DoublyLinkedList<T>)list).tail;
		}
	}

	@Override
	public void prepend(LinkedList<T> list) {
		list.append(this);
		append(list);
	}

	@Override
	public void append(T element) {
		addLast(element);
	}

	@Override
	public void prepend(T element) {
		addFirst(element);
	}

	@Override
	public void sort() {
		DoublyLinkedList<T> newList = new DoublyLinkedList<T>();
		while (!isEmpty()) newList.insert(removeFirst());
		curr = head = newList.head;
		tail = newList.tail;
	}

	@Override
	public void reverse(boolean usingRecursion) {
		if (isEmpty() || size() == 1) return;
		curr = head.next;			// iterating from first node
		curr.prev = null;			// removing link to the dummy head node
		Node temp;
		// to swap the links
		while (curr != null) {
			temp = curr.next;
			curr.next = curr.prev;
			curr.prev = temp;
			curr = curr.prev;
		}
		temp = head.next;
		tail.prev = head;
		head.next = tail;
		tail = temp;
	}

	@Override
	public T peekFront() {
		if (isEmpty()) return null;
		return head.next.data;
	}

	@Override
	public T peekBack() {
		if (isEmpty()) return null;
		return tail.data;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return head == tail || head.next == null;
	}

	@Override
	public String toString() {
		if (isEmpty()) return "[]";

		StringBuilder sb = new StringBuilder();
		curr = head.next;
		sb.append("[");
		while (curr != null) {
			if (curr.next == null) {
				sb.append(curr.data.toString());
			} else {
				sb.append(curr.data.toString() + ", ");
			}
			curr = curr.next;
		}
		sb.append("]");
		return sb.toString();
	}

}
