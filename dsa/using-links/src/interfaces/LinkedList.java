package interfaces;

public interface LinkedList<T extends Comparable<T>> {
	void insert(T element);
	void delete(T element);
	void addLast(T element);
	T removeLast();
	void addFirst(T element);
	T removeFirst();
	void append(LinkedList<T> list);
	void prepend(LinkedList<T> list);
	void append(T element);
	void prepend(T element);
	T peekFront();
	T peekBack();
	int size();
	boolean isEmpty();
	void sort();
	void reverse(boolean usingRecursion);
}
