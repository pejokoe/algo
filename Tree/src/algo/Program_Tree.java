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
		notLinear.insert(16);
		notLinear.insert(6);
		notLinear.insert(100);
		notLinear.insert(4);
		notLinear.insert(22);
		notLinear.insert(87);
		notLinear.insert(50);
		
		System.out.printf("\nDepth: %d", notLinear.depth());
	}
}
