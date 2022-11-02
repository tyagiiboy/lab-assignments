package interfaces;

public interface Queue<T> {
	void enQueue(T element);
	T deQueue();
	T peek();
	int size();
	boolean isEmpty();
}
