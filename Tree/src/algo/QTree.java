package algo;

import algo.Tree.TreeNode;

public class QTree {
	public class TreeNode implements Comparable {
		private Comparable xValue;
		private Comparable yValue;
		private TreeNode left;
		private TreeNode centerLeft;
		private TreeNode centerRight;
		private TreeNode right;

		public TreeNode(Comparable x, Comparable y) {
			xValue = x;
			yValue = y;
			left = null;
			centerLeft = null;
			centerRight = null;
			right = null;
		}

		public TreeNode(Comparable x, Comparable y, TreeNode left, TreeNode centerLeft,
				TreeNode centerRight, TreeNode right) {
			xValue = x;
			yValue = y;
			this.left = left;
			this.centerLeft = centerLeft;
			this.centerRight = centerRight;
			this.right = right;
		}

		public TreeNode getLeftTree() {
			return left;
		}
		
		public TreeNode getCenterLeftTree() {
			return centerLeft;
		}
		
		public TreeNode getCenterRightTree() {
			return centerRight;
		}

		public TreeNode getRightTree() {
			return right;
		}

		public Comparable getXValue() {
			return xValue;
		}
		
		public Comparable getYValue() {
			return yValue;
		}

		@Override
		public int compareTo(Object arg0) {
			// TODO Auto-generated method stub
			return 0;
		}
		
		public String toString() {
			return "(" + xValue.toString() + ", " + yValue.toString() + ")";
		}
	}
	
	protected TreeNode root;

	public QTree() {
		root = null;
	}
	
	public void insert(Comparable xElement, Comparable yElement) {
		insertAtNode(xElement, yElement, root, null);
	}
	
	private void insertAtNode(Comparable xElement, Comparable yElement, 
			TreeNode current, TreeNode parent) {
		// if the node we check is empty
		if (current == null) {
			TreeNode newNode = new TreeNode(xElement, yElement);
			// the current node is empty, but we have a parent
			if (parent != null) {
				// do we add it to the left?
				if (xElement.compareTo(parent.xValue) <= 0) {
					if (yElement.compareTo(parent.yValue) <= 0){
						parent.left = newNode;
					} else {
						parent.centerLeft = newNode;
					}
				} 
				// or do we add it to the right?
				else {
					if (yElement.compareTo(parent.yValue) <= 0) {
						parent.centerRight = newNode;
					} else {
						parent.right = newNode;
					}
				}
			}
			// the current node is empty and it has no parent, we actually have an empty
			// tree
			else
				root = newNode;
		} else if (xElement.compareTo(current.xValue) == 0 &&
				yElement.compareTo(current.yValue) == 0) {
			// if the element is already in the tree, what to do?
		}
		// if the element is smaller than current, go left
		else if (xElement.compareTo(current.xValue) <= 0) {
			if (yElement.compareTo(current.yValue) <= 0) {
				insertAtNode(xElement, yElement, current.left, current);
			} else {
				insertAtNode(xElement, yElement, current.centerLeft, current);
			}
		}
		// if the element is bigger than current, go right
		else {
			if (yElement.compareTo(current.yValue) <= 0) {
				insertAtNode(xElement, yElement, current.centerRight, current);
			} else {
				insertAtNode(xElement, yElement, current.right, current);
			}
		}
	}
	
	public Comparable smallestX() {
		return smallestXAtNode(root, root.xValue);
	}
	
	private Comparable smallestXAtNode(TreeNode n, Comparable smallestX) {
		Comparable l = null;
		Comparable cl = null;
		if (n.left != null && n.centerLeft != null) {
			l = smallestXAtNode(n.left, smallestX);
			if (l.compareTo(smallestX) < 0) {
				smallestX = l;
			}
			cl = smallestXAtNode(n.centerLeft, smallestX);
			if (cl.compareTo(smallestX) < 0) {
				smallestX = cl;
			}
			return smallestX;
		} else if (n.left != null && n.centerLeft == null) {
			l = smallestXAtNode(n.left, smallestX);
			if (l.compareTo(smallestX) < 0) {
				smallestX = cl;
			}
			return smallestX;
		} else if (n.left == null && n.centerLeft != null) {
			cl = smallestXAtNode(n.centerLeft, smallestX);
			if (cl.compareTo(smallestX) < 0) {
				smallestX = cl;
			}
			return smallestX;
		} else {
			return n.xValue;
		}
	}
}
