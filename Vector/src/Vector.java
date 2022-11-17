public class Vector
{
	private Object data[];
	private int count;
	
	public Vector(int capacity)
	{
		data = new Object[capacity];
		count = 0;
	}

	public int size()
	{
		return count;
	}
 
	public boolean isEmpty()
	{
		return size() == 0;
	}

	public Object get(int index)
	{
		if (index > count-1) {
			System.out.println("Index out of bounds!");
			return -1;
		}
		return data[index];
	}

	public void set(int index, Object obj)
	{
		data[index] = obj;
	}

	public boolean contains(Object obj)
	{
		for(int i=0;i<count;i++)
		{
			if(data[i] == obj) return true;
		}
		return false;
	}
	
	public void addFirst(Object item)
	{
		Object[] tmp = new Object[count+1];
		for (int i = count; i > 0; i--){
			tmp[i] = data[i-1];
		}
		tmp[0] = item;
		count++;
		data = tmp;
	}

	public void addLast(Object o)
	{
		if (!(data.length > count + 1)) {
			this.extendCapacity();
		}
		data[count] = o;
		count++;
	}
	
	/*
	public boolean binarySearch(Object key)
	{
	int start = 0;
	int end = count - 1;
	while(start <= end)
	{
		int middle = (start + end + 1) / 2;
		if(key < data[middle]) end = middle -1;
		else if(key > data[middle]) start = middle + 1;
		else return true;
	}
	return false;
	}
	*/

	public Object getFirst()
	{
		// returns the first element
		return data[0];
	}

	public Object getLast()
	{
		//returns the last element
		return data[this.size()]; 
	}

	public void removeLast()
	{
		// removes the last element
		if (this.count > 0) {
			count--;
		} else {
			System.out.println("Empty vector, removal not possible!");
		}
		
	} 

	public void removeFirst()
	{
		// removes the first element
		if (this.count > 0) {
			Object[] tmp = new Object[count-1];
			for (int i = 0; i < count-1; i++) {
				tmp[i] = data[i+1];
			}
			data = tmp;
		}
	}
	
	public String toString() {
		// returns a string representation of the contents of "this"
		String string = new String("[ ");
		for (int i = 0; i < this.count ; i++) {
			string += data[i];
			string += " ";
		}
		string += "]";
		return string;
	}
	
	public void reverse() {
		// reverses the order of the elements in "this"
		Object tmp = 0;
		for (int i = 0; i < count/2; i++) {
			tmp = data[i];
			data[i] = data[count-1-i];
			data[count-1-i] = tmp;
		}
	}
	
	public Vector repeat() {
		// creates a new vector that contains every element of "this" twice
		Vector to_return = new Vector(count*2);
		for (int i = 0; i < count; i++) {
			to_return.addLast(data[i]);
			to_return.addLast(data[i]);
		}
		return to_return;
	}
	
	public Vector interleave(Vector v2) {
		Vector to_return = new Vector(count*2);
		for (int i = 0; i < count; i++) {
			to_return.addLast(data[i]);
			to_return.addLast(v2.get(i));
		}
		return to_return;
	}

	private void extendCapacity() {
		Object[] data2 = new Object[count*2];
		for (int i = 0; i < count; i++) {
			data2[i] = data[i];
		}
		data = data2;
	}
	
	public static void main(String[] args) {
		// testing the vector class
		Vector vector = new Vector(100);
		
		// fill vector with numbers 1 to 100
		for (int i = 1; i < 10; i++) {
			vector.addLast(i);
		}

		System.out.printf("Size of vector: %d\n", vector.size());
		System.out.printf("Vector contains %d: %b\n", 6, vector.contains(6));
		System.out.printf("Vector contains %d: %b\n", 101, vector.contains(101));
		vector.addFirst(666);
		System.out.println(vector);
		vector.reverse();
		System.out.println(vector);
		Vector vector2 = vector.repeat();
		System.out.println(vector2);
		int iteration = vector2.size()/2;
		for (int i = 0; i < iteration; i++) {
			vector2.removeLast();
		}
		vector2.reverse();
		System.out.println(vector2);
		System.out.printf("Length v1: %d\nLength v2: %d\n", vector.size(), vector2.size());
		Vector vector3 = vector.interleave(vector2);
		System.out.println(vector3);
		System.out.printf("Length v3: %d\n", vector3.size());
		Vector v4 = new Vector(2);
		v4.addLast(1);
		v4.addLast(1);
		v4.addLast(1);
		v4.addLast(1);
		System.out.println(v4);
		
	}
	
}