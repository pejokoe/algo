
public class Program_DLL {
	public static void main(String[] args) {
		DoubleLinkedList mydll = new DoubleLinkedList();
		for (int i = 0; i < 4; i++) {
			mydll.AddLast(i);
		}
		System.out.println(mydll);
		mydll.printReverse();
		mydll.reverse();
		System.out.println(mydll);
	}
}
