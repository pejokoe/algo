package algo;

public class program_graph {
	public static void main(String[] args) {
		MatrixGraph mg = new MatrixGraph(4);
		mg.addEdge(0, 1, 6);
		mg.addEdge(0, 2, 5);
		mg.addEdge(1, 0, 3);
		mg.addEdge(1, 3, 9);
		mg.addEdge(1, 2, 4);
		mg.addEdge(2, 3, 7);
		System.out.println(mg);
	}
}
