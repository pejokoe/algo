package algo;

public class Order {
	private LinkedList items; 					// LinkedList allows find and remove in O(n)
	private Client client;
	
	public Order(Client client) {
		this.client = client;
		items = new LinkedList();
	}
	
	public void addItem(Product item) {
		if (!items.contains(item)) {
			items.addFirst(item);
		} else {
			item.increaseQuantity(1);
		}
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

	public LinkedList getItems() {
		return items;
	}

	public Client getClient() {
		return client;
	}
	
	public String toString() {
		return items.toString();
	}
	
	
}
