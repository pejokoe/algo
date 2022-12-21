package algo;

public class Warehouse {
	private Tree stock; 											/* structure underlying tree not yet decided, 
																	   tree will be sorted by unique barcode id of 
																	   products */
	private Vector location;										/* this vector will serve as the base for a 
																	   vector + linkedList representation of the 
																	   graph for locations */
	
	public Warehouse() {
		stock = new Tree();
		location = new Vector(10);
	}
	
	public void finalizeOrder(Order order) {
		LinkedList itemsToShip = new LinkedList();
		for (int i = 0; i < order.getItems().size(); i++) {
			Product p = (Product)order.getItems().getFirst();
			Product stock_p = (Product)stock.find(p);
			if (stock_p != null) {
				if(stock_p.getQuantity() >= p.getQuantity()) {
					itemsToShip.addFirst(p);
					stock_p.increaseQuantity(-p.getQuantity());
				} else {
					p.setQuantity(stock_p.getQuantity());
					stock_p.setQuantity(0);
					itemsToShip.addFirst(p);
				}
			order.getItems().removeFirst(); 						/* work through the items list this way */				
			}
		}
		// then do something with itemsToShip
		// for testing print
		System.out.printf("%s's order:\n", order.getClient().getName());
		System.out.println(itemsToShip);
	}
	
	public int search(Product p) {
		Product product = (Product)stock.find(p);
		if (product != null) {
			return product.getQuantity();
		} else {
			return -1;
		}
	}
	
	public void addItem(Product product) {
		Product p = (Product)stock.find(product);
		if (p == null) {
			stock.insert(product);
		} else {
			p.increaseQuantity(1);
		}
	}
	
}
