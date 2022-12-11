package algo;

public class Program_Tree {
	public static void main(String[] args) {
		Tree myTree = new Tree();
		int num_elements = 6;
		for (int i = 0; i < num_elements; i++) {
			myTree.insert(i+1);
		}
//		System.out.println(myTree);
//		TreePrinter print = new TreePrinter();
		
//		myTree.traverse(print);
		
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
		
//		System.out.printf("\nDepth: %d\n", notLinear.depth());
//		System.out.printf("Biggest: %s\n", notLinear.biggest().toString());
		
		
		QTree tree = new QTree();
		tree.insert(4, 4);
		tree.insert(1, 1);
		tree.insert(3, 7);
		tree.insert(6, 2);
		tree.insert(8, 6);
		tree.insert(1, 5);
		tree.insert(5, 8);
		tree.insert(2, 6);
//		System.out.printf("Smallest x: %s\n", tree.smallestX().toString());
		
		System.out.println(notLinear);
		notLinear.swapTree();
		System.out.println(notLinear);
	}
}
