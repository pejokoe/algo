package datastructures;

public class Tree {
	/*
	 * private class NaturalComparator implements Comparator { public int
	 * compare(Object a, Object b) { return ((Comparable)a).compareTo(b); } }
	 */
	// the class for implementing a node in the tree.
	// contains a value, a pointer to the left child and a pointer to the right
	// child

	public class TreeNode implements Comparable {
		private Comparable value;
		private TreeNode leftNode;
		private TreeNode rightNode;

		public TreeNode(Comparable v) {
			value = v;
			leftNode = null;
			rightNode = null;
		}

		public TreeNode(Comparable v, TreeNode left, TreeNode right) {
			value = v;
			leftNode = left;
			rightNode = right;
		}

		public TreeNode getLeftTree() {
			return leftNode;
		}

		public TreeNode getRightTree() {
			return rightNode;
		}

		public Comparable getValue() {
			return value;
		}

		@Override
		public int compareTo(Object o) {
			return this.value.compareTo(((TreeNode)o).value);
		}
		
		public String toString() {
			return value.toString();
		}

	}


	// start of the actual tree class

	// the root of our tree
	protected TreeNode root;
	private int size;

	public Tree() {
		root = null;
		size = 0;
	}

	/**
	 * traverses the entire tree and performs a passed action with every node
	 * @param action
	 */
	public void traverse(TreeAction action) {
		Queue t = new Queue();
		//Stack t = new Stack();
		t.push(root);
		while(!t.empty())
		{
			TreeNode n = (TreeNode)t.pop();
			action.run(n);
			 
			if(n.getLeftTree() != null) t.push(n.getLeftTree());
			if(n.getRightTree() != null) t.push(n.getRightTree());
		}
	}

	public void traverseNode(TreeNode n, TreeAction action) {
		if (n != null) {
			if (n.getLeftTree() != null)
				traverseNode(n.getLeftTree(), action);
			action.run(n);
			if (n.getRightTree() != null)
				traverseNode(n.getRightTree(), action);
		}
	}

	public void traverseInOrder(TreeAction action) {
		traverseNode(root, action);
	}

	
	/**
	 * insert a given element into the tree
	 * @param element
	 */
	public void insert(Comparable element) {
		insertAtNode(element, root, null);
	}

	// we traverse the tree.
	// Current holds the pointer to the TreeNode we are currently checking
	// Parent holds the pointer to the parent of the current TreeNode
	private void insertAtNode(Comparable element, TreeNode current, TreeNode parent) {
		// if the node we check is empty
		if (current == null) {
			size += 1;
			TreeNode newNode = new TreeNode(element);
			// the current node is empty, but we have a parent
			if (parent != null) {
				// do we add it to the left?
				if (element.compareTo(parent.value) < 0) {
					parent.leftNode = newNode;
				}
				// or do we add it to the right?
				else {
					parent.rightNode = newNode;
				}
			}
			// the current node is empty and it has no parent, we actually have an empty
			// tree
			else
				root = newNode;
		} else if (element.compareTo(current.value) == 0) {
			current.value = element;
		}
		// if the element is smaller than current, go left
		else if (element.compareTo(current.value) < 0) {
			insertAtNode(element, current.getLeftTree(), current);
		}
		// if the element is bigger than current, go right
		else
			insertAtNode(element, current.getRightTree(), current);
	}
	
	public String toString() {
		String[] tmp = {""};
		traverse(
				new TreeAction() {
			public void run(TreeNode n) {
				tmp[0] += n.toString() + "\n";
			}
		});
		return tmp[0];
	}
	
	
	public int depth() {
		 return depthAtNode(root, 1);
	}
	
	/**
	 * finds the depth of given node in the tree
	 * @param n
	 * @param depth
	 * @return depth of node
	 */
	public int depthAtNode(TreeNode n, int depth) {
		int depth_left = 0;
		int depth_right = 0;
		if (n.leftNode != null) {
			depth_left = depthAtNode(n.leftNode, depth +1);	
		}
		if (n.rightNode != null) {
			depth_right = depthAtNode(n.rightNode, depth + 1);
		}
		if (depth_left > depth) {
			depth = depth_left;
		}
		if (depth_right > depth) {
			depth = depth_right;
		}		
		return depth;
	}
	
	public Comparable biggest() {
		return biggestAtNode(root);
	}
	
	private Comparable biggestAtNode(TreeNode n) {
		if (n.rightNode != null) {
			return biggestAtNode(n.rightNode);
		} else {
			return n.value;
		}
	}
	
	/**
	 * at each node swaps its leftTree and rightTree 
	 */
	public void swapTree() {
		traverse(new TreeAction() {
			public void run(TreeNode n) {
				TreeNode tmp = n.leftNode;
				n.leftNode = n.rightNode;
				n.rightNode = tmp;
			}
		});
	}
	
	public Comparable pop() {
		return popAt(root, null);
	}
	
	private Comparable popAt(TreeNode n, TreeNode parent) {
		if (n.leftNode != null) {
			return popAt(n.leftNode, n);
		} else {
			if (parent == null) {
				root = n.rightNode;
			} else {
				parent.leftNode = n.rightNode;
			}
			size -= 1;
			return n.value;
		}
	}
	
//	public Comparable median() {
//		return root.value;
//	}
	
	
	/** 
	 * finds smallest element in the tree
	 * @return smallest element
	 */
	public Comparable smallest() {
		return smallestAtNode(root);
	}
	
	/** 
	 * helper function for finding the tree's smallest element
	 * @param n
	 * @return
	 */
	private Comparable smallestAtNode(TreeNode n) {
		if (n.leftNode != null) {
			return smallestAtNode(n.leftNode);
		} else {
			return n.value;
		}
	}
	
	
	/**
	 * calculate average of all elements in the tree
	 * @return average of all elements in the tree
	 */
	public float average() {
		int[] s = {0};
		float[] num = {0};
		traverse(new TreeAction() {
			public void run(TreeNode n) {
				s[0] += (int)n.value;
				num[0]++;
			}
		});
		return s[0] / num[0];
	}
	
	public boolean contains(Comparable key) {
		return containsAt(root, key);
	}
	
	public boolean containsAt(TreeNode n, Comparable pair) {
		if (n == null) {
			return false;
		}
		if (pair.compareTo(n.value) < 0) {
			if (n.leftNode != null) {
				return containsAt(n.leftNode, pair);
			} else {
				return false;
			}
		} else if (pair.compareTo(n.value) > 0) {
			if (n.rightNode != null) {
				return containsAt(n.rightNode, pair);
			} else {
				return false;	
			}
		} else {
			return true;
		}
	}
	
	public Comparable find(Comparable pair) {
		return findAt(root, pair);
	}
	
	public Comparable findAt(TreeNode n, Comparable pair) {
		if (n==null) return null;
		if (pair.compareTo(n.value) < 0) {
			if (n.leftNode != null) {
				return findAt(n.leftNode, pair);
			} else {
				return null;
			}
		} else if (pair.compareTo(n.value) > 0) {
			if (n.rightNode != null) {
				return findAt(n.rightNode, pair);
			} else {
				return null;	
			}
		} else {
			return n.value;
		}
	}
	
	public int size() {
		return size;
	}
}
