package algo;

public class Order {
	private LinkedList items;
	private Client client;
	
	public Order(Client client) {
		this.client = client;
		items = new LinkedList();
	}
	
	public void addItem(Product item) {
		items.addFirst(item);
	}
	
	public void removeItem(Product item) {
		int position = items.search(item);
		items.removeAt(position);
	}
}
