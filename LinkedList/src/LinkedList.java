public class LinkedList {
	
	private class ListElement {
		private Object el1;
		private ListElement el2;

		public ListElement(Object el, ListElement nextElement) {
			el1 = el;
			el2 = nextElement;
		}

		public ListElement(Object el) {
			this(el, null);
		}

		public Object first() {
			return el1;
		}

		public ListElement rest() {
			return el2;
		}

		public void setFirst(Object value) {
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

	public void addFirst(Object o) {
		head = new ListElement(o, head);
	}

	public Object getFirst() {
		return head.first();
	}

	public Object get(int n) {
		ListElement d = head;
		while (n > 0) {
			d = d.rest();
			n--;
		}
		return d.first();
	}
	
	public String toString() {
		String s = "(";
		ListElement d = head;
		while (d != null) {
			s += d.first().toString();
			s += " ";
			d = d.rest();
		}
		s += ")";
		return s;
	}
	
	// return size of linked list
	public int size() {
		int size = 0;
		ListElement d = head;	
		while(d != null) {
			size += 1;
			d = d.rest();
		}
		return size;
	}
	
	// change object at position n to o
	public void set(int n, Object o) {
		ListElement d = head;
		for (int i = 0; i < n; i++) {
			d = d.rest();
		}
		d.setFirst(o);
	}

	// return last object
	public Object getLast() {
		ListElement d = head;
		while(d.rest() != null) {
			d = d.rest();
		}
		return d.first();
	}
	
	// insert object o at last position
	public void addLast(Object o) {
		ListElement d = head;
		if (head == null) {
			this.addFirst(o);
		} else {
			while (d.rest() != null) {
				d = d.rest();
			}
			d.setRest(new ListElement(o, d.rest()));
		}
	}
	
	// return position of object o, -1 if not found
	public int search(Object o) {
		ListElement d = head;
		int position = 0;
		while(d != null) {
			if(d.first() == o) {
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
	}
	
	// remove last element
	public void removeLast() {
		ListElement d = head;
		while(d.rest().rest() != null) {
			d = d.rest();
		}
		d.setRest(null);
	}
	
	// check if linked list contains object o
	public boolean contains(Object o) {
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
		while(head != null) {
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
		while(d != null) {
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
}
