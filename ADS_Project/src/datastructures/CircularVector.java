package datastructures;

public class CircularVector 
{
	private Comparable[] data;
	private int first;
	private int count;
	private int length;

	public CircularVector(int length)
	{
		this.length = length;
		count = 0;
		first = 1;
		data = new Comparable[5];
	}

	public int size()
	{
		return count;
	}

	public void addFirst(Comparable element)
	{
		if(count + 1 > length) {
			System.out.println("This vector is full!");
		} else {
			data[first = (first - 1 + data.length) % data.length] = element;
			count++;
		}
	}

	public void addLast(Comparable element)
	{
		if(count + 1 > length) {
			System.out.println("This vector is full!");
		} else {
			data[(first+count)% data.length] = element;
			count++;
		}
	}

	public Comparable getFirst()
	{
		return data[first];
	}

	public Comparable getLast()
	{
		return data[(first+count)%data.length-1];
	}

	public void removeFirst()
	{
		if(count > 0)
		{
			first = (first+1)%data.length;
			count--;
		}
	}

	public void removeLast()
	{
		count--;
	}

	public String toString()
	{
    String s = "[";
		for(int i=0;i<count;i++)
		{
			int index = (first + i) % data.length;
			s += data[index].toString();
			s += " ";
		}
    s += "]";
    return s;
	}
	
	public boolean isEmpty() {
		return count == 0;
	}
	
	// addFirst CircularList
//	public void addFirst(Comparable element) {
//		public void addFirst(Comparable o) {
//			head = new ListElement(o, head);
//			if (tail == null) {
//				tail = head;
//			} else {
//			tail.setRest(head);
//			}
//			count++;
//		}
//	}
}