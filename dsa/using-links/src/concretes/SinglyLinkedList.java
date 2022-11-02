package concretes;

import interfaces.LinkedList;

public class SinglyLinkedList<T extends Comparable<T>> implements LinkedList<T> {
	
	private class Node {
		T data;
		Node next;
		Node(T element, Node nextNode) {data = element; next = nextNode;}
	}
	
	private int size;
	private Node head, tail, curr;
	
	public SinglyLinkedList() {
		head = tail = curr = new Node(null, null);
		size = 0;
	}

	@Override
	public void addLast(T element) {
		tail.next = new Node(element, null);
		tail = tail.next;
		size = size + 1;
	}

	/*
	 * this operation is packed with heavy iteration.
	 */
	@Override
	public T removeLast() {
		if (isEmpty()) return null;
		curr = head;
		while (curr.next.next != null) curr = curr.next;
		curr.next = null;
		T element = tail.data;
		tail = curr;
		size = size - 1;
		return element;
	}

	@Override
	public void addFirst(T element) {
		Node node = new Node(element, head.next);
		head.next = node;
		if (isEmpty()) tail = node;
		size = size + 1;
	}

	@Override
	public T removeFirst() {
		if (isEmpty()) return null;
		curr = head.next;
		head.next = curr.next;
		T element = curr.data;
		size = size - 1;
		if (isEmpty()) tail = head;
		return element;
	}
	
	/*
	 * sorted insert
	 */
	@Override
	public void insert(T element) {
		if (isEmpty()) {
			addFirst(element);
			return;
		}
		curr = head;
		while (curr.next.data.compareTo(element) != 1 && curr.next != null) 
			curr = curr.next;
		Node node = new Node(element, curr.next);
		curr.next = node;
		if (curr == tail) tail = curr.next;
		size = size + 1;
	}
	
	@Override
	public T delete(T element) {
		T deletedElement = null;
		curr = head;
		while (curr.next != null && !curr.next.data.equals(element))
			curr = curr.next;
		if (curr == head) return removeFirst();
		else if (curr.next == tail) return removeLast();
		else if (curr.next.data.equals(deletedElement)) {
			deletedElement = curr.next.data;
			curr.next = curr.next.next;
			size = size - 1;
		}
		return deletedElement;
	}
	
	@Override
	public void sort() {
		SinglyLinkedList<T> newList = new SinglyLinkedList<T>();
		while (!isEmpty()) newList.insert(removeFirst());
		curr = head = newList.head;
		tail = newList.tail;
	}
	
	private void reverseIterative(Node currentNode) {
		Node previousNode = null, nextNode = currentNode.next;
		do {
			currentNode.next = previousNode;
			previousNode = currentNode;
			currentNode = nextNode;
			nextNode = nextNode.next;
		} while (nextNode != null);
		currentNode.next = previousNode;
	}
	
	private void reverseRecursive(Node currentNode, Node perviousNode) {
		if (currentNode.next != null) 
			reverseRecursive(currentNode.next, currentNode);
		currentNode.next = perviousNode;
	}
	
	@Override
	public void reverse(boolean usingRecursion) {
		if (isEmpty()) return;
		if (usingRecursion) reverseRecursive(head.next, null);
		else reverseIterative(head.next);
		Node temp = head.next;
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
