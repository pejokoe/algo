package programs;
import datastructures.*;

public class Program_PriorityQueue2 {
	public static void main(String[] args) {
		PriorityQueue2 pq = new PriorityQueue2(1, 2);
		pq.push(5, 1);
		pq.push(10, 1);
		pq.push(3, 2);
		pq.push(11, 1);
		pq.push(2, 2);
		pq.push(56, 2);
		pq.push(65, 2);
		int size = pq.size();
		for (int i = 0; i < size; i++) {
			System.out.println(pq.pop());
		}
		
	}
}
