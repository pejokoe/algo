package programs;
import datastructures.*;

public class Program_DicTree {
	public static void main (String[] args) {
		DictionaryTree dt = new DictionaryTree();
		dt.add(5, 10);
		dt.add(7, 10);
		dt.add(1, 11);
		dt.add(56, 10);
		dt.add(23, 10);
		dt.add(4, 10);
		dt.add(1, 10);
		dt.add(767, 10);
		dt.add(9, 10);
		dt.add(15, 10);
		System.out.println(dt.findKey(56));
		System.out.println(dt);
	}
}
