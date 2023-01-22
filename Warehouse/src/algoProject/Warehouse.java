package algoProject;

import algo.DictionaryTree;
import algo.Graph;
import algo.LinkedList;
import algo.Tree;
import algo.Vector;


public class Warehouse {
	/**
	 * This is the project's main class, organizing the interaction between orders, clients and products.
	 * Due to the nature all ids are generated in this piece of software, all structures will be sorted automatically.
	 * This can be exploited using vectors' binary search to achieve O(log(n)) for all find operations.
	 * To achieve O(log(n)) also for product name search, a dictionary tree is maintained resolving names to products' uniqueBarcodeIds.
	 * No special measures are taken however to ensure this dictionary tree is balanced.
	 */
	private Vector stock; 											
	private DictionaryTree productDictionary;			
	private Graph location;										
	private Vector clients;
	private Vector orders;
	
	/**
	 * Warehouse constructor
	 */
	public Warehouse() {
		stock = new Vector(50);
		productDictionary = new DictionaryTree();
		location = new Graph();
		clients = new Vector(50);
		orders = new Vector(50);
	}
	
	public Graph getLocation() {
		return location;
	}
	
	
	/**
	 * search a product based on its name and return the quantity, performed in O(2log(n))
	 * @param name
	 * @return product quantity, if product not found return -1
	 */
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
	
	/**
	 * @param id
	 * @return Product instance product that was found, null if according product was not found
	 */
	public Product searchId(int id) {
		Product product = searchProductId(id);
		if (product != null) {
			return product;
		} else {
			return null;
		}
	}
	
	/**
	 * create a product with a given name and a given quantity, add the product to warehouse's stock structure
	 * @param name
	 * @param quantity
	 * @return newly created and added product's new barcode id
	 */
	public int addProduct(String name, int quantity) {
		Product p = new Product(name, quantity);
		stock.addLast(p);
		productDictionary.add(name, p.getUniqueBarcodeId());
		return p.getUniqueBarcodeId();
	}
	
	/**
	 * removes given quantity of product, if found in stock, from stock
	 * @param productId
	 * @param quantity
	 * @return boolean indicating success or failure
	 */
	public boolean removeProduct(int productId, int quantity) {
		Product p = searchId(productId);
		if (p == null) {
			return false;
		} else {
			p.setQuantity(p.getQuantity() - quantity);
			return true;
		}
	}
	
	
	/**
	 * create a new Client instance with given name and email and add it to warehouse's client structure
	 * @param name
	 * @param email
	 * @return newly created and added client's id
	 */
	public int registerClient(String name, String email) {
		Client client = new Client(name, email);
		clients.addLast(client);
		return client.getUniqueID();
	}
	
	/** 
	 * create a new Order instance with client associated to given client id and add it to warehouse's order structure
	 * @param clientId
	 * @return newly created and added order's id
	 */
	public int createOrder(int clientId) {
		Client client = searchClientId(clientId);
		Order order = new Order(client);
		orders.addLast(order);
		return order.getUniqueId();
	}
	
	/**
	 * add a given product with a given quantity to a given order
	 * @param productId
	 * @param quantity
	 * @param orderId
	 */
	public void addToOrder(int productId, int quantity, int orderId) {
		Order addTo = searchOrderId(orderId);
		addTo.addItem(new Product("placeholder", quantity, productId));
	}
	
	/**
	 * Finalize given order by removing all items from order item list and subsequently deleting the structure.
	 * Add every item to 'itemsToShip' list, in the process removing the requested quantity of the item from stock.
	 * Print out an overview of the order.
	 * @param orderId
	 */
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
	
	
	/**
	 * helper function to find product in the product structure in O(log(n))
	 * @param productId
	 * @return product associated to given productId
	 */
	public Product searchProductId(int productId) {
		Product dummy = new Product("dummy", 0, productId);
		return (Product)stock.binSearch(dummy);
	}
	
	/**
	 * helper function to find order in the order structure in O(log(n))
	 * @param orderId
	 * @return order associated to given orderId
	 */
	public Order searchOrderId(int orderId) {
		Order dummy = new Order(null);
		dummy.setUniqueId(orderId);
		return (Order)orders.binSearch(dummy);
	}
	
	/**
	 * helper function to find client in the client structure in O(log(n))
	 * @param clientId
	 * @return client associated to given clientId
	 */
	public Client searchClientId(int clientId) {
		Client dummy = new Client("dummy", "dummy");
		dummy.setUniqueId(clientId);
		return (Client)clients.binSearch(dummy);
	}
	
	/**
	 * search a product based on its name and print out name + quantity
	 * @param productName
	 */
	public void searchProduct(String productName) {
		int id = (int)productDictionary.findKey(productName);
		Product product = searchProductId(id);
		System.out.printf("Product name: %s\nQuantity: %d\n", product.getName(), product.getQuantity());
	}
	
	/**
	 * assigns location to a product, also adding the location to the warehouse's locations graph
	 * @param locationName
	 * @param productId
	 */
	public void assignLocation(String locationName, int productId) {
		Product product = searchProductId(productId);
		product.setLocation(locationName);
		location.addNode(locationName);
	}
	
	
	/**
	 * connecting two locations in the locations graph via a given distance
	 * @param firstLocation
	 * @param secondLocation
	 * @param distance
	 */
	public void connectLocations(String firstLocation, String secondLocation, int distance) {
		location.addEdge(firstLocation, secondLocation, distance);
	}
	
	
	/**
	 * find and print out the shortest path from one location to another location
	 * @param firstLocation
	 * @param secondLocation
	 */
	public void printShortestPath(String firstLocation, String secondLocation) {
		LinkedList shortestPath = location.findShortestPath(firstLocation, secondLocation);
		if (shortestPath == null) {
			System.out.printf("There appears to be no path from %s to %s.\n", firstLocation, secondLocation);
		} else {
			System.out.printf("Shortest path from %s to %s:\n", firstLocation, secondLocation);
			System.out.println(shortestPath);
			System.out.printf("Total Distance: %.2f\n", location.getCurrentDistance(secondLocation));
		}
	}
}
