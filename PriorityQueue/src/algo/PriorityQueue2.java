package algo;

import java.util.Comparator;

public class PriorityQueue2 {
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

	private LinkedList dataA;
	private LinkedList dataB;
	private Comparable prioA;
	private Comparable prioB;
	private PriorityPair atPrioB;

	public PriorityQueue2(Comparable a, Comparable b) {
		dataA = new LinkedList();
		dataB = new LinkedList();
		prioA = a;
		prioB = b;
	}

	public void push(Comparable o, Comparable priority) {
		PriorityPair toAdd = new PriorityPair(o, priority);
		if (priority == prioA) {
			dataA.addFirst(toAdd);
		} else if (priority == prioB){
			dataB.addFirst(toAdd);
		} else {
			System.out.println("This priority can not be stored in this Priority Queue.");
		}
	}

	public Comparable pop() {
		Comparable ret = 0;
		if(dataA.getHead() == null) {
			ret = ((PriorityPair)dataB.getFirst()).getElement();
			dataB.removeFirst();
		} else {
			ret = ((PriorityPair)dataA.getFirst()).getElement();
			dataA.removeFirst();
		}
		return ret;
	}

	public int size() {
		return dataA.size() + dataB.size();
	}
}
