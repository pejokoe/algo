package algo;

public class Program_Tree {
	public static void main(String[] args) {
		Tree myTree = new Tree();
		int num_elements = 6;
		for (int i = 0; i < num_elements; i++) {
			myTree.insert(i+1);
		}
		System.out.println(myTree);
		TreePrinter print = new TreePrinter();
		
		myTree.traverse(print);
		
		Tree notLinear = new Tree();
		notLinear.insert(2);
		notLinear.insert(5);
		notLinear.insert(3);
		notLinear.insert(7);
		notLinear.insert(1);
		notLinear.insert(15);
		notLinear.insert(3);
		notLinear.insert(25);
		
		System.out.printf("\nDepth: %d", notLinear.depth());
	}
}
