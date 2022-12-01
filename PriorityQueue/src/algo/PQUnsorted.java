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

	
	// O(n^2) solution, no other solution found
	public Comparable pop() {
		Comparable prio = ((PriorityPair)data.getFirst()).getPriority();
		Comparable ret = ((PriorityPair)data.getFirst()).getElement();
		int position = 0;
		for (int i = 1; i < data.size(); i++) { // n times
			PriorityPair prio2 = ((PriorityPair)data.get(i)); // data.get(i) n steps
			if (prio.compareTo(prio2.getPriority()) > 0){
				prio = prio2.getPriority();
				ret = prio2.getElement();
				position = i;
			}
		}
		data.removeAt(position);
		return ret;
	}

	
	// also O(n^2)
	public Comparable top() {
		Comparable prio = ((PriorityPair)data.getFirst()).getPriority();
		Comparable ret = ((PriorityPair)data.getFirst()).getElement();
		int position = 0;
		for (int i = 1; i < data.size(); i++) { // n times
			PriorityPair prio2 = ((PriorityPair)data.get(i)); // data.get(i) n steps
			if (prio.compareTo(prio2.getPriority()) > 0){
				prio = prio2.getPriority();
				ret = prio2.getElement();
				position = i;
			}
		}
		return ret;
	}

	public int size() {
		return data.size();
	}
}
