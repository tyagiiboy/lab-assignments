package concretes;

import interfaces.LinkedList;

public class DoublyLinkedList<T extends Comparable<T>> implements LinkedList<T>{

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
	public void addLast(T element) {
		Node node = new Node(element, tail, null);
		tail.right = node;
		tail = node;
		size++;
	}

	@Override
	public T removeLast() {
		if (isEmpty()) return null;
		T element = tail.data;
		tail = tail.left;
		tail.right = null;
		size = size - 1;
		return element;
	}

	@Override
	public void addFirst(T element) {
		Node node = new Node(element, head, head.right);
		head.right = node;
		if (isEmpty()) tail = node;
		size++;
	}

	@Override
	public T removeFirst() {
		if (isEmpty()) return null;
		T element = head.right.data;
		head.right = head.right.right;
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
		while (curr.right.data.compareTo(element) != 1 && curr.right != null) 
			curr = curr.right;
		Node node = new Node(element, curr, curr.right);
		curr.right = node;
		node.right.left = node;
		if (curr == tail) tail = curr.right;
		size = size + 1;
	}

	@Override
	public T delete(T element) {
		T deletedElement = null;
		curr = head;
		while (curr.right != null && !curr.right.data.equals(element))
			curr = curr.right;
		if (curr == head) return removeFirst();
		else if (curr.right == tail) return removeLast();
		else if (curr.right.data.equals(deletedElement)) {
			deletedElement = curr.right.data;
			curr.right.right.left = curr;
			curr.right = curr.right.right;
			size = size - 1;
		}
		return deletedElement;
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
		curr = head.right;			// iterating from first node
		curr.left = null;			// removing link to the dummy head node
		Node temp;
		// to swap the links
		while (curr != null) {
			temp = curr.right;
			curr.right = curr.left;
			curr.left = temp;
			curr = curr.left;
		}
		temp = head.right;
		tail.left = head;
		head.right = tail;
		tail = temp;
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
		return head == tail || head.right == null;
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
