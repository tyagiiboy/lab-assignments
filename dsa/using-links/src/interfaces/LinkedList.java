package interfaces;

public interface LinkedList<T extends Comparable<T>> {
	void insert(T element);
	T delete(T element);
	void addLast(T element);
	T removeLast();
	void addFirst(T element);
	T removeFirst();
	T peekFront();
	T peekBack();
	int size();
	boolean isEmpty();
	void sort();
	void reverse(boolean usingRecursion);
}
