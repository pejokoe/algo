package algo;

import java.util.Comparator;

public class PQUnsorted {
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
		
		public Comparable getPriority() {
			return priority;
		}

	}

	private LinkedList data;

	public PQUnsorted()
	{
		data = new LinkedList();
	}

	public void push(Comparable o, int priority) {
		PriorityPair toAdd = new PriorityPair(o, priority);
		data.addFirst(toAdd);
	}

	public Comparable pop() {
		Comparable prio = ((PriorityPair)data.getFirst()).getPriority();
		Comparable ret = ((PriorityPair)data.getFirst()).getElement();
		for (int i = 0; i < data.size(); i++) {
			PriorityPair prio2 = ((PriorityPair)data.get(i));
			if (prio.compareTo(prio2.getPriority()) > 0){
				prio = prio2;
				ret = prio2.getElement();
			}
		}
		return ret;
	}

	public Comparable top() {
		return ((PriorityPair) data.getFirst()).getElement();
	}

	public int size() {
		return data.size();
	}
}
