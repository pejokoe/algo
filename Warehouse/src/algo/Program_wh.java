package algo;

public class Program_wh {
	public static void main(String[] args) {
		Warehouse wh = new Warehouse();
		Client kev = new Client("Kevin");
		Product fb = new Product("football", 20, 98765, "somwhere");
		for (int i = 0; i < 10; i++) {
			wh.addItem(fb);
		}
		Order test = new Order(kev);
		test.addItem(fb);
		wh.finalizeOrder(test);
		System.out.println(wh.search("football"));
	}
}
