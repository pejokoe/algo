package algoProject;

import algo.LinkedList;

public class Order implements Comparable{
	private static int idGenerator = 0;
	private int uniqueId;
	private LinkedList items; 					// LinkedList allows find and remove in O(n)
	private int clientId;
	
	public Order(int clientId) {
		this.uniqueId = idGenerator++;
		this.clientId = clientId;
		items = new LinkedList();
	}
	
	public int compareTo(Object o) {
		return uniqueId - ((Order)o).getUniqueId();
	}
	
	// addItem and removeItem: either add a new instance for every item or increase quantity if same 
	// item is added twice or more

	public void addItem(Product item) {
		items.addFirst(item);
	}
	
	public void removeItem(Product item) {
		if (item.getQuantity() == 1) {
			items.remove(item);
		} else if (item.getQuantity() > 1) {
			item.increaseQuantity(-1);
		} else {
			System.out.printf("This order does not contain the item '%s'.\n", item.getName());
		}
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
	
	public String toString() {
		return items.toString();
	}
	
	
}
