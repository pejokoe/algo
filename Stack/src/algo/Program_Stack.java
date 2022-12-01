package algo;

public class Program_Stack {
	public static void main(String[] args) {
		Stack stack = new Stack();
			for (int i = 0; i < 10; i++) {
				stack.push(i);
			}
			int a = (int) stack.pop();
			System.out.println(a);
			int limit = stack.size();
			for (int i = 0; i < limit; i++) {
				System.out.println(stack.pop());
			}
	}
}
