package algoProject;

import algo.DictionaryTree;
import algo.Graph;
import algo.LinkedList;
import algo.Tree;
import algo.Vector;


public class Warehouse {
	/**
	 * Due to the nature the ids are generated in this piece of software, all structures will be sorted automatically.
	 * This can be exploited using vectors' binary search to achieve O(log(n)) for all find operations.
	 * To achieve O(log(n)) also for product name search, a dictionary tree is maintained resolving names to products' uniqueBarcodeIds.
	 * No special measures are taken however to ensure this dictionary tree is balanced.
	 */
	private Vector stock; 											
	private DictionaryTree productDictionary;			
	private Graph location;										
	private Vector clients;
	private Vector orders;
	
	public Warehouse() {
		stock = new Vector(50);
		productDictionary = new DictionaryTree();
		location = new Graph();
		clients = new Vector(50);
		orders = new Vector(50);
	}
	
	public int searchName(String name) {
		
		/* find product id based on name (log(n)) */
		int id = (int)productDictionary.findKey(name);
		Product product = searchProductId(id);
		if (product != null) {
			return product.getQuantity();
		} else {
			return -1;
		}
	}
	
	public Product searchId(int id) {
		Product dummy = new Product("dummy", 0, id);
		Product product = (Product)stock.binSearch(dummy);
		if (product != null) {
			return product;
		} else {
			return null;
		}
	}
	
	public int addProduct(String name, int quantity) {
		Product p = new Product(name, quantity);
		stock.addLast(p);
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
		Client client = searchClientId(clientId);
		Order order = new Order(client);
		orders.addLast(order);
		return order.getUniqueId();
	}
	
	public void addToOrder(int productId, int quantity, int orderId) {
		Order dummy = new Order(null);
		dummy.setUniqueId(orderId);
		Order addTo = (Order)orders.binSearch(dummy);
		addTo.addItem(new Product("placeholder", quantity, productId));
	}
	
	public void finalizeOrder(int orderId) {
		Order order = searchOrderId(orderId);
		LinkedList itemsToShip = new LinkedList();
		int size = order.getItems().size();
		for (int i = 0; i < size; i++) {
			Product p = (Product)order.getItems().getFirst();
			Product stock_p = (Product) stock.binSearch(p);
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
	
	public Product searchProductId(int productId) {
		Product dummy = new Product("dummy", 0, productId);
		return (Product)stock.binSearch(dummy);
	}
	
	public Order searchOrderId(int orderId) {
		Order dummy = new Order(null);
		dummy.setUniqueId(orderId);
		return (Order)orders.binSearch(dummy);
	}
	
	public Client searchClientId(int clientId) {
		Client dummy = new Client("dummy", "dummy");
		dummy.setUniqueId(clientId);
		return (Client)clients.binSearch(dummy);
	}
	
	public void searchProduct(String productName) {
		int id = (int)productDictionary.findKey(productName);
		Product product = searchProductId(id);
		System.out.printf("Product name: %s\nQuantity: %d\n", product.getName(), product.getQuantity());
	}
	
	/**
	 * assigns location to a product, also adding the location to the local warehouse tree to organize a graph
	 * @param locationName
	 * @param productId
	 */
	public void assignLocation(String locationName, int productId) {
		Product product = searchProductId(productId);
		product.setLocation(locationName);
		location.addNode(locationName);
	}
	
	public void connectLocations(String firstLocation, String secondLocation, int distance) {
		location.addEdge(firstLocation, secondLocation, distance);
	}
}
