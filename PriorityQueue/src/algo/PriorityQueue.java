package algo;

import java.util.Comparator;

public class PriorityQueue {
	private class PriorityPair implements Comparable {
		private Comparable element;
		private Comparable priority;

		public PriorityPair(Comparable element, Comparable priority) {
			this.element = element;
			this.priority = priority;
		}

		public int compareTo(Object o) {
			PriorityPair p2 = (PriorityPair) o;
			return ((Comparable) priority).compareTo(p2.priority);
		}

		public Comparable getElement() {
			return element;
		}

		public void setElement(Comparable element) {
			this.element = element;
		}

	}

	private LinkedList data;

	public PriorityQueue() {
		data = new LinkedList();
	}

	public void push(Comparable o, Comparable priority) {
		PriorityPair toAdd = new PriorityPair(o, priority);
		data.addSorted(toAdd);
	}

	public Comparable pop() {
		Comparable ret = ((PriorityPair) data.getFirst()).getElement();
		data.removeFirst();
		return ret;
	}

	public Comparable top() {
		return ((PriorityPair) data.getFirst()).getElement();
	}

	public int size() {
		return data.size();
	}
}
