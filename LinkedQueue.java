public class LinkedQueue<T> implements Queue<T> {
	
	private static class Elem<E> {
		private E value;
		private Elem<E> next;
		private Elem(E value, Elem<E> next) {
			this.value = value;
			this.next = next;
		}
	}
	
	
	private Elem<T> front;
	private Elem<T> rear;
	private int size = 0;
	
	public LinkedQueue() {
		front = rear = null;
	}
	
	public boolean isEmpty() {
		return (front == null);
	}
	
	public int getSize() {
		return size;
	}
	
	public void enqueue(T elem) {
		
		if (elem == null) {
			throw new NullPointerException("no null values in queue");
		}
		
		Elem<T> newElem;
		newElem = new Elem<T>(elem, null);
		
		// SPECIAL CASE: EMPTY QUEUE
		if (isEmpty()) { // Special case: no elements in queue
			front = newElem;
			rear = newElem;
		}
		else {
			rear.next = newElem;
			rear = newElem;
		}
		
		size++;
	}
	
	public T dequeue() {
		
		if (isEmpty()) {
			throw new IllegalStateException("Cannot dequeue empty queue");
		}
		
		T result = front.value;
		
		if (front.next == null) { // Special case: only one element in queue
			front = rear = null;
		} else {
			front = front.next;
		}
		
		size--;
		return result;
	}
	
	public String toString() {
		StringBuffer buffer = new StringBuffer('{');
		
		if (!isEmpty()) {
			Elem<T> current = front;
			buffer.append(current.value);
			while (current.next != null) {
				current = current.next;
				buffer.append("," + current.value);
			}
		}
		
		buffer.append("}");
		
		return buffer.toString();
	}
	
	
	
}