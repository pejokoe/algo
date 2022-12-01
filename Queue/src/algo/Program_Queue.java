package algo;

public class Program_Queue {
	public static void main(String[] args) {
		Queue q = new Queue();
		for (int i = 0; i < 10; i++) {
			q.push(i);
		}
		for (int i = 0; i < 10; i++) {
			System.out.println(q.pop());
		}
	}
}
