public class Program_wh {
	public static void main(String[] args) {
		Warehouse wh = new Warehouse();
		int[] p = new int[10];
		int[] c = new int[10];
		int[] o = new int[20];
		for (int i = 0; i < 10; i++) {
			c[i] = wh.registerClient("test", "test");
			o[2 * i] = wh.createOrder(c[i]);
			o[2 * i + 1] = wh.createOrder(c[i]);
		}
		p[0] = wh.addProduct("football", 6);
		p[1] = wh.addProduct("handball", 6);
		p[2] = wh.addProduct("volleyball", 30);
		p[3] = wh.addProduct("basketball", 5);
		p[4] = wh.addProduct("bat", 2);
		p[5] = wh.addProduct("racket", 10);
		p[6] = wh.addProduct("disk", 20);
		p[7] = wh.addProduct("gloves", 5);
		p[8] = wh.addProduct("tape", 100);
		p[9] = wh.addProduct("pants", 10);
		wh.addToOrder(p[4], 3, o[0]);
		wh.addToOrder(p[1], 5, o[1]);
		wh.addToOrder(p[1], 2, o[1]);
		wh.addToOrder(p[3], 7, o[1]);
		wh.addToOrder(p[2], 15, o[4]);
		wh.finalizeOrder(o[0]);
		wh.finalizeOrder(o[1]);
		wh.finalizeOrder(o[4]);
		wh.searchProduct("football");
		wh.assignLocation("zero", p[0]);
		wh.assignLocation("one", p[1]);
		wh.assignLocation("two", p[2]);
		wh.assignLocation("three", p[3]);
		wh.assignLocation("four", p[4]);
		wh.assignLocation("five", p[5]);
		wh.assignLocation("six", p[6]);
		wh.assignLocation("seven", p[7]);
		wh.assignLocation("eight", p[8]);
		wh.assignLocation("nine", p[9]);
		wh.connectLocations("zero", "one", 7);
		wh.connectLocations("zero", "five", 3);
		wh.connectLocations("one", "two", 11);
		wh.connectLocations("two", "nine", 1);
		wh.connectLocations("two", "eight", 9);
		wh.connectLocations("five", "three", 3);
		wh.connectLocations("three", "two", 6);
		wh.connectLocations("five", "four", 1);
		wh.connectLocations("six", "four", 1);
		wh.connectLocations("four", "seven", 2);
		wh.connectLocations("six", "eight", 10);
		wh.connectLocations("seven", "eight", 5);
		wh.connectLocations("seven", "six", 1);
		System.out.println(wh.getLocation());
		wh.printShortestPath("zero","eight");
//		int clientId = wh.registerClient("Peter", "peterkoegler@gmx.de");
//		int orderId1 = wh.createOrder(clientId);
//		int orderId2 = wh.createOrder(clientId);
//		
//		int productId = wh.addProduct("Football", 10);
//		wh.addToOrder(productId, 5, orderId1);
//		wh.addToOrder(productId, 3, orderId1);
//		wh.addToOrder(productId, 4, orderId2);
//		wh.finalizeOrder(orderId1);
//		wh.finalizeOrder(orderId2);
	}
}
