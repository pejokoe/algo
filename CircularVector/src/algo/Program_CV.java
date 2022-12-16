package algo;

public class Program_CV {
	
	public static void main(String[] args) {
		CircularVector cv = new CircularVector(5);
		cv.addFirst(45);
		cv.addFirst(2);
		cv.removeFirst();
		cv.addFirst(3);
		cv.addLast(1);
		cv.addLast(66);
		cv.addLast(0.5);
		System.out.println(cv.getFirst());
		System.out.println(cv.getLast());
		cv.removeFirst();
		cv.removeLast();
		System.out.println(cv.getFirst());
		System.out.println(cv.getLast());
	}
}
