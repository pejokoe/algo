package algo;

public class Warehouse {
	private Tree stock; 				/* structure underlying tree not yet decided, tree will be sorted by string name
										   of products */
	private Vector location;			/* this vector will serve as the base for a vector + linkedList representation of the 
										   graph for locations */
	
	public Warehouse() {
		stock = new Tree();
		location = new Vector(10);
	}
	
}
