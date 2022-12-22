package algo;

public class Graph
{
    public class Node implements Comparable
    {
        private Comparable info;
        private Vector edges;
        
        public Node(Comparable label)
        {
            info = label;
            edges = new Vector(5);
        }
        
        public void addEdge(Edge e)
        {
            edges.addLast(e);
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
        	return info.toString();
        }
        
    }
    
    private class Edge implements Comparable
    {
        private Node toNode;
        private Comparable weight;
        
        public Edge(Node to, Comparable weight)
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
        	return " --> " + toNode.info + "(" + weight.toString() + ")";
        }
    }
    
    private Vector nodes;
    
    public Graph()
    {
        nodes = new Vector(5);
    }
    
    public void addNode(Comparable label)
    {
        nodes.addLast(new Node(label));
    }
    
    private Node findNode(Comparable nodeLabel)
    {
        Node res = null;
        for (int i=0; i<nodes.size(); i++)
        {
            Node n = (Node)nodes.get(i);
            if(n.getLabel() == nodeLabel)
            {
                res = n;
                break;
            }
        }
        return res;
    }
    
    public void addEdge(Comparable nodeLabel1,
                        Comparable nodeLabel2,
                        Comparable weight)
    {
        Node n1 = findNode(nodeLabel1);
        Node n2 = findNode(nodeLabel2);
        n1.addEdge(new Edge(n2, weight));
    }
    
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
		Node startState = findNode(from);
		Node endState = findNode(to);
		Stack toDoList = new Stack();
		Vector startVector = new Vector(5);
		startVector.addLast(startState);
		toDoList.push(startVector);
		while(!toDoList.empty()) {
			Vector currentPath = (Vector)toDoList.pop();
			Node currentNode = (Node)currentPath.getLast();
			if (currentNode == endState) return currentPath;
			else {
				for (int i = 0; i < currentNode.edges.size(); i++) {
					Edge e = (Edge)currentNode.edges.get(i);
					Vector possiblePath = new Vector(5);
					// elementwise copy of currentPath
					for (int j = 0; j < currentPath.size(); j++) {
						possiblePath.addLast(currentPath.get(j));
					}
					possiblePath.addLast(e.toNode);
					toDoList.push(possiblePath);
					
				}
			}
		}
		return null;
	}
}
