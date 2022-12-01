package algo;
import java.util.Comparator;

public class Stack {
	
//	private Vector data;
//
//	public Stack() {
//		data = new Vector(10);
//	}
//
//	public void push(Comparable o) {
//		data.addLast(o);
//	}
//
//	public Comparable pop() {
//		Comparable ret = data.getLast();
//		data.removeLast();
//		return ret;
//	}
//
//	public Comparable top() {
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
	
	public void push(Comparable o) {
		data.addFirst(o);
	}

	public Comparable pop() {
		Comparable ret = data.getFirst();
		data.removeFirst();
		return ret;
	}

	public Comparable top() {
		return data.getFirst();
	}

	public int size() {
		return data.size();
	}

	public boolean empty() {
		return data.getHead() == null;
	}
}
