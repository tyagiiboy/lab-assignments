package interfaces;

public interface LinkedList<T> {
	void insertBack(T element);
	T deleteBack();
	void insertFront(T element);
	T deleteFront();
	T peekFront();
	T peekBack();
	int size();
	boolean isEmpty();
}
