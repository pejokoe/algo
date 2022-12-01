package algo;

public class Queue {
	
	private Vector data;
	
	public Queue() {
		data = new Vector(10);
	}

	public void push(Object o) {
		data.addLast(o);
	}

	public Object pop() {
		Object ret = data.getFirst();
		data.removeFirst();
		return ret;
	}

	public Object top() {
		return data.getFirst();
	}

	public int size() {
		return data.size();
	}

	public boolean empty() {
		return data.isEmpty();
	}
}
