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
		Graph g = new Graph();
		g.addNode("A");
		g.addNode("B");
		g.addNode("C");
		g.addNode("D");
		g.addEdge("A", "B", 6);
		g.addEdge("A", "C", 5);
		g.addEdge("B", "A", 3);
		g.addEdge("C", "B", 4);
		g.addEdge("B", "D", 9);
		System.out.println(g);
		System.out.println(g.findPath("A", "D"));
	}
}
