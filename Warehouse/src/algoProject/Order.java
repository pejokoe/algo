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
	
	// addItem and removeItem: either add a new instance for every item or increase quantity if same 
	// item is added twice or more

	public void addItem(Product item) {
		int position = items.search(item);
		if (position == -1) {
			items.addFirst(item);
		} else {
			Product p = (Product)items.get(position);
			p.setQuantity(p.getQuantity() + item.getQuantity());
		}
	}
	
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
	
	public String toString() {
		return items.toString();
	}
	
	public void done() {
		items = null;
	}
}
