package algo;
public class Vector implements Comparable{
	private Comparable data[];
	private int count;

	public Vector(int capacity) {
		data = new Comparable[capacity];
		count = 0;
		
	}

	public int size() {
		return count;
	}

	public boolean isEmpty() {
		return size() == 0;
	}

	public Comparable get(int index) {
		if (index > count) {
			System.out.println("Index out of bounds!");
			return -1;
		}
		return data[index];
	}

	public void set(int index, Comparable obj) {
		if (index > data.length) {
			System.out.println("Index out of range, can not set element");
		} else {
			data[index] = obj;
		}
	}

	public boolean contains(Comparable obj) {
		for (int i = 0; i < count; i++) {
			if (data[i] == obj)
				return true;
		}
		return false;
	}

	public void addFirst(Comparable item) {
		if (count + 1 > data.length) {
			extendCapacity();
		}
		for (int i = count; i > 0; i--) {
			data[i] = data[i - 1];
		}
		data[0] = item;
		count++;
	}

	public void addLast(Comparable o) {
		if (count + 1 > data.length) {
			this.extendCapacity();
		}
		data[count] = o;
		count++;
	}

	/*
	 * public boolean binarySearch(Comparable key) { int start = 0; int end = count - 1;
	 * while(start <= end) { int middle = (start + end + 1) / 2; if(key <
	 * data[middle]) end = middle -1; else if(key > data[middle]) start = middle +
	 * 1; else return true; } return false; }
	 */

	// returns the first element
	public Comparable getFirst() {
		return data[0];
	}

	// returns the last element
	public Comparable getLast() {
		return data[this.size()-1];
	}

	// removes the last element
	public void removeLast() {
		if (this.count > 0) {
			count--;
		} else {
			System.out.println("Empty vector, removal not possible!");
		}

	}

	// removes the first element
	public void removeFirst() {
		if (this.count > 0) {
			for (int i = 0; i < count - 1; i++) {
				data[i] = data[i + 1];
			}
		}
		count--;
	}

	// returns a string representation of the contents of "this"
	public String toString() {
		String string = new String("[ ");
		for (int i = 0; i < this.count; i++) {
			string += data[i];
			string += " ";
		}
		string += "]";
		return string;
	}

	// reverses the order of the elements in "this"
	public void reverse() {
		Comparable tmp = 0;
		for (int i = 0; i < count / 2; i++) {
			tmp = data[i];
			data[i] = data[count - 1 - i];
			data[count - 1 - i] = tmp;
		}
	}

	// creates a new vector that contains every element of "this" twice
	public Vector repeat() {
		Vector to_return = new Vector(count * 2);
		for (int i = 0; i < count; i++) {
			to_return.addLast(data[i]);
			to_return.addLast(data[i]);
		}
		return to_return;
	}

	// interleave two vectors
	public Vector interleave(Vector v2) {
		Vector to_return = new Vector(count * 2);
		for (int i = 0; i < count; i++) {
			to_return.addLast(data[i]);
			to_return.addLast(v2.get(i));
		}
		return to_return;
	}
	
	// double size of underlying array if running out of capacity
	private void extendCapacity() {
		Comparable[] data2 = new Comparable[count * 2];
		for (int i = 0; i < count; i++) {
			data2[i] = data[i];
		}
		data = data2;
	}
	
	// return position of Comparable o, -1 if not found
	public int search(Comparable o) {
		for (int i = 0; i < count; i++) {
			if (data[i] == o) {
				return i;
			}
		}
		return -1;
	}
	
	public int capacity() {
		return data.length;
	}
	
	public void removeAt(int idx) {
		if(-1 < idx && idx < count) {
			for(int i = idx; i < count - 1; i++) {
				data[i] = data[i+1];
			}
			count--;
		} else {
			System.out.println("Index out of range!");
		}
	}
	
	public int compareTo(Object o) {
		return 0;
	}
}