package programs;
import datastructures.*;

public class Program {
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
		int iteration = vector2.size() / 2;
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
		System.out.printf("Position of searched element: %d", vector2.search(4));
		
	}
}