package algoProject;


// decision for now: one product instance for every type of product, hold quantity internally
// maybe change later: product instance for every single product that exists
// this means: for a product that is added to an order, a new instance of the product has to be created
// this decision will be easier once I know the warehouse interface

public class Product implements Comparable{
	private String name;
	private float price;
	private int uniqueBarcodeId;
	private String location;
	private int quantity;
	
	public Product(String name, float price, int id, String loc) {
		this.name = name;
		this.price = price;
		this.uniqueBarcodeId = id;
		this.location = loc;
		this.quantity = 1;
	}

	
	public Product(String name, float price, int id, String loc, int quantity) {
		this.name = name;
		this.price = price;
		this.uniqueBarcodeId = id++;
		this.location = loc;
		this.quantity = quantity;
	}

	public int compareTo(Object o) {
		return name.compareTo(((Product)o).name); /* name as metric 
													 for comparison (needed for 
									   			     binary tree)
									   			     also allows easy implementation
									   			     of search(String name) */
	}
	
	public void setQuantity(int q) {
		quantity = q;
	}

	public String getName() {
		return name;
	}

	public float getPrice() {
		return price;
	}

	public int getUniqueBarcodeId() {
		return uniqueBarcodeId;
	}

	public String getLocation() {
		return location;
	}

	public int getQuantity() {
		return quantity;
	}
	
	public void increaseQuantity(int by) {
		quantity += by;
	}
	
	public String toString() {
		return "Product name: " + name +
			   "\nPrice: " + price +
			   "\nBarcode: " + uniqueBarcodeId +
			   "\nQuantity: " + quantity + "\n";
	}
}
