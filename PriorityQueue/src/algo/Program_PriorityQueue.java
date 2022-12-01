package algo;

public class Program_PriorityQueue {
	public static void main(String[] args) {
		PQUnsorted pq = new PQUnsorted();
		pq.push(10, 45);
		pq.push(11, 23);
		pq.push(5, 11);
		pq.push(26, 87);
		pq.push(3, 100);
		pq.push(76, 5);
		pq.push(8, 12);
		pq.push(2, 3);
		int size = pq.size();
		for (int i = 0; i < size; i++) {
			System.out.println(pq.pop());
		}
	}
}
