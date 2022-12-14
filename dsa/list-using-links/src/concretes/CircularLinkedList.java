package concretes;
import interfaces.LinkedList;

public class CircularLinkedList<T extends Comparable<T>> implements LinkedList<T> {

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
	private Node head;

	public CircularLinkedList() {
		head = new Node(null, null, null);
		head.next = head.prev = head;
		size = 0;
	}
	
	private void addFirstNode(T element) {
		Node node = new Node(element, head, head.next);
		head.next = node;
		head.prev = node;
		size++;
	}

	@Override
	public void addLast(T element) {
		if (isEmpty()) {
			addFirstNode(element); 
			return;
		}
		
		Node node = new Node(element, head.prev, head);
		head.prev.next = node;
		head.prev = node;
	}

	@Override
	public void addFirst(T element) {
		if (isEmpty()) {
			addFirstNode(element); return;
		}
		Node node = new Node(element, head, head.next);
		head.next.prev = head.next = node;
		size++;
	}
	
	private T removeSingleNode() {
		T element = head.next.data;
		head.next = head.prev = head;
		return element;
	}
	
	@Override
	public T removeLast() {
		if (isEmpty()) return null;
		if (size() == 1) return removeSingleNode();
		T element = head.prev.data;
		head.prev.prev.next = head;
		head.prev = head.prev.prev;
		size = size - 1;
		return element;
	}

	@Override
	public T removeFirst() {
		if (isEmpty()) return null;
		if (size() == 1) return removeSingleNode();
		T element = head.next.data;
		head.next.next.prev = head;
		head.next = head.next.next;
		size--; 
		return element;
	}

	@Override
	public void insert(T element) {
		if (isEmpty()) {
			addFirstNode(element);
			return;
		}
		Node curr = head;
		while (curr.next != head && curr.next.data.compareTo(element) != 1)
			curr = curr.next;
		Node node = new Node(element, curr, curr.next);
		curr.next = node;
		node.next.prev = node;
		size = size + 1;
	}

	@Override
	public void delete(T element) {
		Node curr = head;
		while (curr.next != head && !curr.next.data.equals(element))
			curr = curr.next;
		if (curr == head) removeFirst();
		else if (curr.next.data.equals(element)) {
			curr.next.next.prev = curr;
			curr.next = curr.next.next;
			size = size - 1;
		}
	}

	@Override
	public void sort() {
		CircularLinkedList<T> newList = new CircularLinkedList<T>();
		while (!isEmpty()) newList.insert(removeFirst());
		head = newList.head;
	}

	@Override
	public void reverse() {
		if (isEmpty() || size() == 1) return;
		Node t, c = head, n = head.next;
		
		do {
			// swapping prev and next links of current node
			t = c.next;
			c.next = c.prev;
			c.prev = t;
			
			// iterating further
			c = n;
			n = n.next;
		} while (c != head);
	}

	@Override
	public T peekFront() {
		if (isEmpty()) return null;
		return head.next.data;
	}

	@Override
	public T peekBack() {
		if (isEmpty()) return null;
		return head.prev.data;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return head.next == head || head.prev == head;
	}

	@Override
	public void append(LinkedList<T> list) {
		CircularLinkedList<T> secondList = (CircularLinkedList<T>)list;
		
		if (!secondList.isEmpty() && !this.isEmpty()) {
			Node 	firstListLastNode = this.head.prev, 
					secondListFirstNode = secondList.head.next, 
					secondListLastNode = secondList.head.prev;
			
			firstListLastNode.next = secondListFirstNode;
			secondListFirstNode.prev = firstListLastNode;
			this.head.prev = secondListLastNode;
			secondListLastNode.next = this.head;
			secondList.head.next = secondList.head.prev = secondList.head;
			secondList.size = 0;
		}
		
		else if (this.isEmpty() && secondList.isEmpty()) {
			Node temp = this.head;
			this.head = secondList.head;
			secondList.head = temp;
			this.size = secondList.size;
			secondList.size = 0;
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
	public String toString() {
		if (isEmpty()) return "[]";

		StringBuilder sb = new StringBuilder();
		Node curr = head.next;
		sb.append("[");
		while (curr.next != head) {
			sb.append(curr.data.toString() + ", ");
			curr = curr.next;
		}
		sb.append(curr.data + "]");
		return sb.toString();
	}

}
