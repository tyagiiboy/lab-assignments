package concretes;

import interfaces.LinkedList;

public class DoublyLinkedList<T> implements LinkedList<T>{

	private class Node {
		T data;
		Node left, right;

		Node(T d, Node l, Node r) {
			data = d;
			left = l;
			right = r;
		}
	}

	private int size;
	private Node head, tail, curr;

	public DoublyLinkedList() {
		head = tail = curr = new Node(null, null, null);
		size = 0;
	}

	@Override
	public void insertBack(T element) {
		Node node = new Node(element, tail, null);
		tail.right = node;
		tail = node;
		size++;
	}

	@Override
	public T deleteBack() {
		if (isEmpty()) return null;
		T element = tail.data;
		tail = tail.left;
		tail.right = null;
		size--;
		return element;
	}

	@Override
	public void insertFront(T element) {
		Node node = new Node(element, head, head.right);
		head.right = node;
		size++;
	}

	@Override
	public T deleteFront() {
		if (isEmpty()) return null;
		T element = head.right.data;
		head.right = head.right.right;
		size--;
		return element;
	}

	@Override
	public T peekFront() {
		return head.right.data;
	}

	@Override
	public T peekBack() {
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
		curr = head.right;
		sb.append("[");
		while (curr != null) {
			if (curr.right == null) {
				sb.append(curr.data.toString());
			} else {
				sb.append(curr.data.toString() + ", ");
			}
			curr = curr.right;
		}
		sb.append("]");
		return sb.toString();
	}

}
