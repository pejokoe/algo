package datastructures;

public class LinkedList {

	private int count = 0;
	private class ListElement {
		private Comparable el1;
		private ListElement el2;

		public ListElement(Comparable el, ListElement nextElement) {
			el1 = el;
			el2 = nextElement;
		}

		public ListElement(Comparable el) {
			this(el, null);
		}

		public Comparable first() {
			return el1;
		}

		public ListElement rest() {
			return el2;
		}

		public void setFirst(Comparable value) {
			el1 = value;
		}

		public void setRest(ListElement value) {
			el2 = value;
		}
	}

	private ListElement head;

	public LinkedList() {
		head = null;
	}

	public void addFirst(Comparable o) {
		head = new ListElement(o, head);
		count++;
	}

	public Comparable getFirst() {
		return head.first();
	}

	public Comparable get(int n) {
		ListElement d = head;
		while (n > 0) {
			d = d.rest();
			n--;
		}
		return d.first();
	}

	public String toString() {
		String s = "";
		ListElement d = head;
		while (d != null) {
			s += d.first().toString();
			d = d.rest();
		}
		return s;
	}

	// return size of linked list
	public int size() {
		return count;
	}

	// change Comparable at position n to o
	public void set(int n, Comparable o) {
		ListElement d = head;
		for (int i = 0; i < n; i++) {
			d = d.rest();
		}
		d.setFirst(o);
	}

	// return last Comparable
	public Comparable getLast() {
		ListElement d = head;
		while (d.rest() != null) {
			d = d.rest();
		}
		return d.first();
	}

	// insert Comparable o at last position
	public void addLast(Comparable o) {
		ListElement d = head;
		if (head == null) {
			this.addFirst(o);
		} else {
			while (d.rest() != null) {
				d = d.rest();
			}
			d.setRest(new ListElement(o, d.rest()));
		}
		count++;
	}

	// return position of Comparable o, -1 if not found
	public int search(Comparable o) {
		ListElement d = head;
		int position = 0;
		while (d != null) {
			if (d.first().compareTo(o) == 0) {
				return position;
			}
			position += 1;
			d = d.rest();
		}
		return -1;
	}

	// remove first element
	public void removeFirst() {
		head = head.rest();
		count--;
	}

	// remove last element
	public void removeLast() {
		ListElement d = head;
		while (d.rest().rest() != null) {
			d = d.rest();
		}
		d.setRest(null);
		count--;
	}

	// check if linked list contains Comparable o
	public boolean contains(Comparable o) {
		boolean contains = false;
		if (this.search(o) != -1) {
			contains = true;
		}
		return contains;
	}

	// reverse order of all elements of linked list
	public void reverse() {
		ListElement d = head;
		ListElement head2 = null;
		while (head != null) {
			d = head;
			head = head.rest();
			d.setRest(head2);
			head2 = d;
		}
		head = head2;
	}

	// creates a new linked list that contains every element of "this" twice
	public LinkedList repeat() {
		LinkedList tmp = new LinkedList();
		ListElement d = head;
		while (d != null) {
			tmp.addLast(d.first());
			tmp.addLast(d.first());
			d = d.rest();
		}
		return tmp;
	}

	// interleave two linked lists (only works if lists have same length)
	public LinkedList interleave(LinkedList toInterleave) {
		LinkedList tmp = new LinkedList();
		ListElement d = head;
		ListElement e = toInterleave.getHead();
		while (d != null) {
			tmp.addLast(d.first());
			tmp.addLast(e.first());
			d = d.rest();
			e = e.rest();
		}
		return tmp;
	}

	public ListElement getHead() {
		return this.head;
	}

	public void fropple() {
		ListElement d = head;
		ListElement e = null;
		if (head != null && head.rest() != null) {
			head = d.rest();
			d.setRest(head.rest());
			head.setRest(d);
		}
		while (d.rest()!= null && d.rest().rest() != null) {
			e = d;
			d = d.rest();
			e.setRest(d.rest());
			d.setRest(d.rest().rest());
			e.rest().setRest(d);
		}
	}
	
	public void append(LinkedList list2) {
		ListElement d = list2.getHead();
		while(d != null) {
			this.addLast(d.first());
			d = d.rest();
		}
	}
	
	public void addSorted(Comparable o) {
		// an empty list , add element in front
		if (head == null)
			head = new ListElement(o, null);
		else if (head.first().compareTo(o) > 0) {
			// we have to add the element in front
			head = new ListElement(o, head);
		} else {
			// we have to find the first element which is bigger
			ListElement d = head;
			while ((d.rest() != null) && (d.rest().first().compareTo(o) < 0)) {
				d = d.rest();
			}
			ListElement next = d.rest();
			d.setRest(new ListElement(o, next));
		}
		count++;
	}
	
	public void removeAt(int n) {
		ListElement d = head;
		for (int i = 0; i < n-1; i++) {
			d = d.rest();
		}
		if (n == 0) {
			head = d.rest();
		} else {
			d.setRest(d.rest().rest());
		}
		count--;
	}
	
	// remove and search in one function
	public void remove(Comparable ele) {
		ListElement d = head;
		while (d.rest() != null) {
			if (d.rest().first() == ele) {
				d.setRest(d.rest().rest());
				count--;
				return;
			}
			d = d.rest();
		}
		System.out.printf("The list does not contain %s. \n" , ele.toString());
	}	
}
