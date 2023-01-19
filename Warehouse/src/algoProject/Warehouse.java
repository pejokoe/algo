package algoProject;

import algo.DictionaryTree;
import algo.LinkedList;
import algo.Tree;
import algo.Vector;

public class Warehouse {
	private Tree stock; 											/* structure underlying tree not yet decided, 
																	   tree will be sorted by unique barcode id of 
																	   products */
	private DictionaryTree productDictionary;						/* use a dictionary to associate product IDs with product names,
																	   because finding products has to be possible based on both
																	   This way, name based lookup will be 2 * log(n) instead of n * log(n) */
	private Vector location;										/* this vector will serve as the base for a 
																	   vector + linkedList representation of the 
																	   graph for locations */
	private Vector clients;
	private Tree orders;
	
	public Warehouse() {
		stock = new Tree();
		productDictionary = new DictionaryTree();
		location = new Vector(10);
		clients = new Vector(10);
		orders = new Tree();
	}
	
	public int searchName(String name) {
		
		/* find product id based on name (log(n)) */
		int id = (int)productDictionary.findKey(name);
		/* create dummy product with right id */
		Product dummy = new Product(name, 0, id);
		Product product = (Product)stock.find(dummy);
		if (product != null) {
			return product.getQuantity();
		} else {
			return -1;
		}
	}
	
	public Product searchId(int id) {
		Product dummy = new Product("dummy", 0, id);
		Product product = (Product)stock.find(dummy);
		if (product != null) {
			return product;
		} else {
			return null;
		}
	}
	
	public int addProduct(String name, int quantity) {
		Product p = new Product(name, quantity);
		stock.insert(p);
		productDictionary.add(name, p.getUniqueBarcodeId());
		return p.getUniqueBarcodeId();
	}
	
	public boolean removeProduct(int productId, int quantity) {
		Product p = searchId(productId);
		if (p == null) {
			return false;
		}
		if (quantity > p.getQuantity()) {
			p.setQuantity(0);
			return false;
		} else {
			p.setQuantity(p.getQuantity() - quantity);
			return true;
		}
	}
	
	public int registerClient(String name, String email) {
		Client client = new Client(name, email);
		clients.addLast(client);
		return client.getUniqueID();
	}
	
	public int createOrder(int clientId) {
		Order order = new Order(clientId);
		orders.insert(order);
		return order.getUniqueId();
	}
	
	public void addToOrder(int productId, int quantity, int orderId) {
		Order dummy = new Order(0);
		dummy.setUniqueId(orderId);
		Order addTo = (Order)orders.find(dummy);
		Product p = searchId(productId);
		if (quantity > p.getQuantity()) {
			quantity = p.getQuantity();
		}
		p.setQuantity(p.getQuantity() - quantity);
		addTo.addItem(new Product(p.getName(), quantity, productId));
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
}
