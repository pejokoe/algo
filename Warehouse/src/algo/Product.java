package algo;

public class Product implements Comparable{
	private static int id = 0;
	private String name;
	private float price;
	private int uniqueBarcodeId;
	private String location;
	
	public Product(String name, float price, String loc) {
		this.name = name;
		this.price = price;
		this.uniqueBarcodeId = id++;
		this.location = loc;
	}

	public int compareTo(Object o) {
		return 0;
	}
	
	
}
