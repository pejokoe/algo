package algo;


// decision for now: one product instance for every type of product, hold quantity internally
// maybe change later: product instance for every single product that exists
// this means: for a product that is added to an order, a new instance of the product has to be created

public class Product implements Comparable{
	private static int id = 0;
	private String name;
	private float price;
	private int uniqueBarcodeId;
	private String location;
	private int quantity;
	
	public Product(String name, float price, String loc) {
		this.name = name;
		this.price = price;
		this.uniqueBarcodeId = id++;
		this.location = loc;
	}

	public int compareTo(Object o) {
		return name.compareTo((String) o);
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
			   "Quantity: " + quantity;
	}
}
