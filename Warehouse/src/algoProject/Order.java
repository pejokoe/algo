package algoProject;

import algo.LinkedList;

public class Order implements Comparable{
	private static int idGeneratorOrder = 0;
	private int uniqueId;
	private LinkedList items; 					// LinkedList allows find and remove in O(n)
	private Client client;
	
	public Order(Client client) {
		this.uniqueId = idGeneratorOrder++;
		this.client = client;
		items = new LinkedList();
	}
	
	public int compareTo(Object o) {
		return uniqueId - ((Order)o).getUniqueId();
	}
	
	/**
	 * add item to an order
	 * if item with same id is already in the order, the quantity is increased rather than adding the item again
	 * @param item
	 */
	public void addItem(Product item) {
		int position = items.search(item);
		if (position == -1) {
			items.addFirst(item);
		} else {
			Product p = (Product)items.get(position);
			p.setQuantity(p.getQuantity() + item.getQuantity());
		}
	}
	
	
	/**
	 * remove given item from the item list
	 * @param item
	 */
	public void removeItem(Product item) {
		items.remove(item);
	}
	
	public int getUniqueId() {
		return uniqueId;
	}
	
	public void setUniqueId(int id) {
		uniqueId = id;
	}

	public LinkedList getItems() {
		return items;
	}
	
	public Client getClient() {
		return client;
	}
	
	
	/**
	 * output order id, order's client and all products
	 */
	public String toString() {
		String ret = String.format("Order %d, Client %s: \n", uniqueId, client.getName()) + items.toString();
		return ret;
	}
	
	/**
	 * pass items list to garbage collector, this way no products can be added/removed anymore
	 */
	public void done() {
		items = null;
	}
}
