public interface Queue<T> {
	
	boolean isEmpty();
	int getSize();
	void enqueue(T newElement);
	T dequeue();
	
}