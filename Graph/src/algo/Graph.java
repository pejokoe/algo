package algo;

import algo.Tree.TreeNode;

public class Graph
{
    public class Node implements Comparable
    {
        private Comparable info;
        private LinkedList edges;
//        private Vector edges;
        private boolean visited;
        public double distance;
        private Node path;
        
        public Node(Comparable label)
        {
            info = label;
            edges = new LinkedList();
//            edges = new Vector(5);
            visited = false;
        }
        
        public void addEdge(Edge e)
        {
            edges.addFirst(e);
//        	edges.addLast(e);
        }
        
        public int compareTo(Object o)
        {
            // two nodes are equal if they have the same label
            Node n = (Node)o;
            return n.info.compareTo(info);
        }
        
        public Comparable getLabel()
        {
            return info;
        }
        
        public String toString() {
        	String output = "";
        	output += info.toString() + ": ";
        	for (int i = 0; i < edges.size(); i++) {
        		output += edges.get(i).toString();
        	}
        	return output;
        }
        
        public void setVisited(boolean v) {
        	visited = v;
        }
        
    }
    
    private class Edge implements Comparable
    {
        private Node toNode;
        private double weight;
        
        public Edge(Node to, double weight)
        {
            toNode = to;
            this.weight = weight;
        }
        
        public int compareTo(Object o)
        {
            // two edges are equal if they point
            // to the same node.
            // this assumes that the edges are
            // starting from the same node !!!
            Edge n = (Edge)o;
            return n.toNode.compareTo(toNode);
        }
        
        public String toString() {
        	return " --> " + toNode.info + "(" + String.format("%.2f", weight) + ")";
        }
    }
    private Vector nodes;
//    private LinkedList nodes;
//    private Vector nodes;
    
    public Graph()
    {
//    	nodes = new Tree();
//    	nodes = new LinkedList();
        nodes = new Vector(5);
    }
    
    public Graph(Tree tree) {
//    	nodes = new Tree();
    	nodes = new Vector(5);
    	treeToGraph(tree);
    }
    
    public double getCurrentDistance(Comparable label) {
    	return findNode(label).distance;
    }
    
    public void addNode(Comparable label)
    {
//    	nodes.insert(new Node(label));
//        nodes.addFirst(new Node(label));
    	nodes.addLast(new Node(label));
    }
    
    private Node findNode(Comparable nodeLabel)
    {
//    	return (Node)nodes.find(new Node(nodeLabel));
//    	return (Node)nodes.get(nodes.find(new Node(nodeLabel)));
    	return (Node)nodes.get(nodes.search(new Node(nodeLabel)));
    }
    
    public void addEdge(Comparable nodeLabel1,
                        Comparable nodeLabel2,
                        int weight)
    {
        Node n1 = findNode(nodeLabel1);
        Node n2 = findNode(nodeLabel2);
        n1.addEdge(new Edge(n2, weight));
    }
    
//    public String toString() {
//    	String[] output = {""};
//    	nodes.traverse(new TreeAction() {
//    		public void run(Tree.TreeNode n) {
//    			output[0] += n.toString() + "\n";
//    		}
//    	});
//    	return output[0];
//    }
    public String toString() {
    	String output = "";
    	for (int i = 0; i < nodes.size(); i++) {
    		Node currentNode = (Node)nodes.get(i);
    		output += "|" + currentNode.info + "|";
    		for(int j = 0; j < currentNode.edges.size(); j++) {
    			output += ((Edge)currentNode.edges.get(j)).toString();
    		}
    		output += "\n";
    	}
    	return output;
    }
    
	
	public Vector findPath(Comparable from, Comparable to) {
		resetVisited();
		Node startState = findNode(from);
		Node endState = findNode(to);
		Stack toDoList = new Stack();
		Vector startVector = new Vector(5);
		startVector.addLast(startState);
		toDoList.push(startVector);
		while(!toDoList.empty()) {
			Vector currentPath = (Vector)toDoList.pop();
			Node currentNode = (Node)currentPath.getLast();
			if (currentNode == endState) {
				//return only vector of node.info 
				Vector nodeNames = new Vector(5);
				for (int i = 0; i < currentPath.size(); i++) {
					nodeNames.addLast(((Node)currentPath.get(i)).info);
				}
				return nodeNames;
			}
			else {
				for (int i = 0; i < currentNode.edges.size(); i++) {
					Edge e = (Edge)currentNode.edges.get(i);
					if (!e.toNode.visited) {
						e.toNode.visited = true;
						Vector possiblePath = new Vector(5);
						// element-wise copy of currentPath
						for (int j = 0; j < currentPath.size(); j++) {
							possiblePath.addLast(currentPath.get(j));
						}
						possiblePath.addLast(e.toNode);
						toDoList.push(possiblePath);
					}
				}
			}
		}
		return null;
	}
	
//	public void resetVisited() {
//		nodes.traverse(new TreeAction() {
//			public void run(TreeNode n) {
//				((Node)n.getValue()).visited = false;
//			}
//		});
//	}
	
	public void treeToGraph(Tree tree) {
		Vector nodesToAdd = new Vector(10);
		tree.traverse(new TreeAction() {
			public void run(TreeNode n) {
				nodesToAdd.addLast(n);
			}
		});
		// first pass to add all nodes to nodes
		for (int i = 0; i < nodesToAdd.size(); i++) {
			addNode(((TreeNode)nodesToAdd.get(i)).getValue());
		}
		// second pass to add edges, only possible after all nodes are there
		for (int i = 0; i < nodesToAdd.size(); i++) {
			TreeNode n = (TreeNode)nodesToAdd.get(i);
			if (n.getLeftTree() != null) {
				addEdge(n.getValue(), n.getLeftTree().getValue(), 1);
			}
			if (n.getRightTree() != null) {
				addEdge(n.getValue(), n.getRightTree().getValue(), 1);
			}
		}
	}
	
	public void initializeSource(Node source) {
//		nodes.traverse(new TreeAction() {
//			public void run(TreeNode n) {
//				((Node)n.getValue()).distance = Double.POSITIVE_INFINITY;
//			}
//		});
//		source.distance = 0;
//		source.path = null;
		for (int i = 0; i < nodes.size(); i++) {
			((Node)nodes.get(i)).distance = Double.POSITIVE_INFINITY;
			((Node)nodes.get(i)).path = null;
		}
		source.distance = 0;
	}
	
	public void relax(Node u, Node v, double w) {
		if (v.distance > (u.distance + w)) {
			v.distance = u.distance + w;
			v.path = u;
		}
	}
	
	public LinkedList findShortestPath(Comparable from, Comparable to) {
		Node start = findNode(from);
		Node dest = findNode(to);
		// setting up Bellman-Ford Algorithm
		initializeSource(start);
		for (int i = 1; i < nodes.size() - 1; i++) { // |G.V| times
			for (int j = 0; j < nodes.size(); j++) { // all nodes in order to relax all edges
				Node current = (Node)nodes.get(j);
				for(int k = 0; k < current.edges.size(); k++) {
					relax(current, ((Edge)current.edges.get(k)).toNode, ((Edge)current.edges.get(k)).weight);
				}
			}
		}
		// guarantee no cycles
		for (int j = 0; j < nodes.size(); j++) { // all nodes in order to relax all edges
			Node current = (Node)nodes.get(j);
			for(int k = 0; k < current.edges.size(); k++) {
				if (((Edge)current.edges.get(k)).toNode.distance > (current.distance + ((Edge)current.edges.get(k)).weight)) {
					return null;
				}
			}
		}
		LinkedList path = new LinkedList();
		path.addFirst(String.format("(%.2f)", dest.distance));
		path.addFirst(dest.info);
		Node prev = dest.path;
		while( prev != null ) {
			path.addFirst(prev.info + String.format("(%.2f)", prev.distance) + " --> ");
			prev = prev.path;
		}
		if (path.getFirst().equals(start.info + String.format("(%.2f)", start.distance) + " --> ")) {
			return path;
		} else {
			return null;
		}
	}
	
	public void resetVisited() {
		for (int i = 0; i < nodes.size(); i++) {
			((Node)nodes.get(i)).visited = false;
		}
	}
}
