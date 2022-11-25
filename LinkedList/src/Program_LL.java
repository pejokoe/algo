public class Program_LL {
	public static void main(String[] args) {
		LinkedList my_llist = new LinkedList();
		for (int i = 10; i > 0; i--) {
			my_llist.addFirst(i);
		}
		System.out.println(my_llist);
		System.out.println(my_llist.size());
		my_llist.set(3, 17);
		System.out.println(my_llist);
		System.out.println(my_llist.getLast());
		my_llist.addLast("last");
		System.out.println(my_llist);
		System.out.println("Position of searched object: " + my_llist.search("last"));
		my_llist.removeLast();
		System.out.println(my_llist);
		System.out.println(my_llist.contains(6));
		my_llist.reverse();
		System.out.println("inversed :" + my_llist);
		LinkedList twice = my_llist.repeat();
		System.out.println(twice);
		LinkedList other = new LinkedList();
		for (int i = 0; i < 10; i++) {
			other.addFirst(5);
		}
		LinkedList inter = my_llist.interleave(other);
		System.out.println(inter);
		inter.removeFirst();
		inter.fropple();
		System.out.println(inter);
	}
}