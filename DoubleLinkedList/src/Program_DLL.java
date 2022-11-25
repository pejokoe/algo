
public class Program_DLL {
	public static void main(String[] args) {
		DoubleLinkedList mydll = new DoubleLinkedList();
		mydll.AddLast(1);
		mydll.AddLast(2);
		mydll.AddLast(3);
		mydll.AddLast(4);
		System.out.println(mydll);
		mydll.printReverse();
	}
}
