package concretes;

import interfaces.LinkedList;

public class SinglyLinkedList<T> implements LinkedList<T> {
	
	private class Node {
		T data;
		Node next;
		
		Node(T element, Node nextNode) {
			data = element;
			next = nextNode;
		}
	}
	
	private int size;
	private Node head, tail, curr;
	
	public SinglyLinkedList() {
		head = tail = curr = new Node(null, null);
		size = 0;
	}

	@Override
	public void insertBack(T element) {
		tail.next = new Node(element, null);
		tail = tail.next;
		size++;
	}

	/*
	 * this operation is packed with heavy iteration.
	 */
	@Override
	public T deleteBack() {
		if (isEmpty()) return null;
		curr = head;
		while (curr.next.next != null) curr = curr.next;
		curr.next = null;
		T element = tail.data;
		tail = curr;
		size--;
		return element;
	}

	@Override
	public void insertFront(T element) {
		Node node = new Node(element, head.next);
		head.next = node;
		if (isEmpty()) tail = node;
		size++;
	}

	@Override
	public T deleteFront() {
		if (isEmpty()) return null;
		curr = head.next;
		head.next = curr.next;
		T element = curr.data;
		size--;
		return element;
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
		return head == tail;
	}
	
	@Override
	public String toString() {
		if (isEmpty()) return "[]";
		
		StringBuilder sb = new StringBuilder();
		curr = head.next;
		sb.append("[");
		while (curr != null) {
			if (curr == tail) {
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
