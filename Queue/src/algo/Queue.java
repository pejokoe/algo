package algo;
import java.util.Comparator;

public class Queue {
	
	private CircularVector data;
	
	public Queue() {
		data = new CircularVector(10);
	}

	public void push(Comparable o) {
		data.addLast(o);
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
		return data.isEmpty();
	}
	
//	private LinkedList data;
//
//	public Queue() {
//		data = new LinkedList();
//	}
//
//	public void push(Comparable o) {
//		data.addLast(o);
//	}
//
//	public Comparable pop() {
//		Comparable ret = data.getFirst();
//		data.removeFirst();
//		return ret;
//	}
//
//	public Comparable top() {
//		return data.getFirst();
//	}
//
//	public int size() {
//		return data.size();
//	}
//
//	public boolean empty() {
//		return data.getHead() == null;
//	}
}
