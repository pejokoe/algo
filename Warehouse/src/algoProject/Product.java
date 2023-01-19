package algoProject;

/**
 * decision for now: one product instance for every type of product, hold quantity internally
 * maybe change later: product instance for every single product that exists
 * this means: for a product that is added to an order, a new instance of the product has to be created
 * this decision will be easier once I know the warehouse interface
 */

public class Product implements Comparable{
	private static int idGenerator = 0;
	private int uniqueBarcodeId;
	private String name;
	private float price;
	private String location;
	private int quantity;
	
	/*
	public Product(String name, float price, int id, String loc) {
		this.name = name;
		this.price = price;
		this.uniqueBarcodeId = id;
		this.location = loc;
		this.quantity = 1;
	}
	 */
	
	/**
	 * Constructor for product assigning a name and a quantity to the newly created product
	 * 
	 * @param name
	 * @param quantity
	 */
	public Product(String name, int quantity) {
		this.uniqueBarcodeId = idGenerator++;
		this.name = name;
		this.quantity = quantity;
	}
	
	public Product(String name, int quantity, int id) {
		this.name = name;
		this.quantity = quantity;
		this.uniqueBarcodeId = id;
	}

	/**
	 *	products are compared based on their unique barcode ID
	 */
	public int compareTo(Object o) {
		return uniqueBarcodeId - ((Product)o).getUniqueBarcodeId();
	}
	
	public void setQuantity(int q) {
		quantity = q;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public float getPrice() {
		return price;
	}
	
	public void setPrice(float price) {
		this.price = price;
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
	
	public String toString() {
		return " Product name: " + name +
			   "\n  Price: " + price +
			   "\n  Barcode: " + uniqueBarcodeId +
			   "\n  Quantity: " + quantity + "\n";
	}
}
