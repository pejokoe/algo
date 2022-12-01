
public class Stack {
	
//	private Vector data;
//
//	public Stack() {
//		data = new Vector(10);
//	}
//
//	public void push(Object o) {
//		data.addLast(o);
//	}
//
//	public Object pop() {
//		Object ret = data.getLast();
//		data.removeLast();
//		return ret;
//	}
//
//	public Object top() {
//		return data.getLast();
//	}
//
//	public int size() {
//		return data.size();
//	}
//
//	public boolean empty() {
//		return data.isEmpty();
//	}
	
	private LinkedList data;
	
	public Stack () {
		data = new LinkedList();
	}
	
	public void push(Object o) {
		data.addFirst(o);
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
		return data.getHead() == null;
	}
}
