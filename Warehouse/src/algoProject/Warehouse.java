package algoProject;

import algo.DictionaryTree;
import algo.LinkedList;
import algo.Tree;
import algo.Vector;

public class Warehouse {
	// due to the nature ids are generated, all structures will always be sorted automatically
	private Tree stock; 											/* structure underlying tree not yet decided, 
																	   tree will be sorted by unique barcode id of 
																	   products */
	private DictionaryTree productDictionary;						/* use a dictionary to associate product IDs with product names,
																	   because finding products has to be possible based on both
																	   This way, name based lookup will be 2 * log(n) instead of n * log(n) */
	private Tree location;										/* this vector will serve as the base for a 
																	   vector + linkedList representation of the 
																	   graph for locations */
	private Tree clients;
	private Tree orders;
	
	public Warehouse() {
		stock = new Tree();
		productDictionary = new DictionaryTree();
		location = new Tree();
		clients = new Tree();
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
		clients.insert(client);
		return client.getUniqueID();
	}
	
	public int createOrder(int clientId) {
		Client client = searchClient(clientId);
		Order order = new Order(client);
		orders.insert(order);
		return order.getUniqueId();
	}
	
	public void addToOrder(int productId, int quantity, int orderId) {
		Order dummy = new Order(null);
		dummy.setUniqueId(orderId);
		Order addTo = (Order)orders.find(dummy);
		addTo.addItem(new Product("placeholder", quantity, productId));
	}
	
	public void finalizeOrder(int orderId) {
		Order order = searchOrder(orderId);
		LinkedList itemsToShip = new LinkedList();
		for (int i = 0; i < order.getItems().size(); i++) {
			Product p = (Product)order.getItems().getFirst();
			Product stock_p = (Product) stock.find(p);
			if (stock_p != null) {
				int quantity = p.getQuantity();
				if (quantity > stock_p.getQuantity()) {
					quantity = stock_p.getQuantity();
					p.setQuantity(quantity);
				}
				stock_p.setQuantity(stock_p.getQuantity() - quantity);
				p.setName(stock_p.getName());
				itemsToShip.addFirst(p);
			}
			order.getItems().removeFirst(); // work through the list this way
		}
		order.done();
		// then do something with itemsToShip
		// for testing print
		System.out.printf("%s's order, id %d:\n", order.getClient().getName(), order.getUniqueId());
		System.out.println(itemsToShip);
	}
	
	public Order searchOrder(int orderId) {
		Order dummy = new Order(null);
		dummy.setUniqueId(orderId);
		return (Order)orders.find(dummy);
	}
	
	public Client searchClient(int clientId) {
		Client dummy = new Client("dummy", "dummy");
		dummy.setUniqueId(clientId);
		return (Client)clients.find(dummy);
	}
}
