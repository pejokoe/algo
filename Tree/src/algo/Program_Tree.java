package algo;

import algo.Tree.TreePrinter;

public class Program_Tree {
	public static void main(String[] args) {
		Tree myTree = new Tree();
		int num_elements = 6;
		for (int i = 0; i < num_elements; i++) {
			myTree.insert(i+1);
		}
		System.out.println(myTree);
		TreePrinter print = myTree.new TreePrinter();
		
		myTree.traverse(print);
	}
}
