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
//		System.out.println(mg);
		Graph g = new Graph();
		g.addNode("A");
		g.addNode("B");
		g.addNode("C");
		g.addNode("D");
		g.addEdge("A", "B", 6);
		g.addEdge("A", "C", 5);
		g.addEdge("B", "A", 3);
		g.addEdge("B", "C", 4);
		g.addEdge("B", "D", 9);
		g.addEdge("C",  "D", 7);
		g.addEdge("C",  "A", 1);
		System.out.println(g);
		System.out.println(g.findPath("A", "C"));
		System.out.println(g.findPath("A", "D"));
		System.out.println(g);
		
//		Tree notLinear = new Tree();
//		notLinear.insert(2);
//		notLinear.insert(5);
//		notLinear.insert(3);
//		notLinear.insert(7);
//		notLinear.insert(1);
//		notLinear.insert(15);
//		notLinear.insert(3);
//		notLinear.insert(25);
//		notLinear.insert(16);
//		notLinear.insert(6);
//		notLinear.insert(100);
//		notLinear.insert(4);
//		notLinear.insert(22);
//		notLinear.insert(87);
//		notLinear.insert(50);
//		Graph formerTree = new Graph(notLinear);
//		System.out.println(notLinear);
//		System.out.println(formerTree);
	}
}
