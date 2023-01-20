package algoProject;

public class Program_wh {
	public static void main(String[] args) {
		Warehouse wh = new Warehouse();
		int[] p = new int[5];
		int[] c = new int[5];
		int[] o = new int[10];
		for (int i = 0; i < 5; i++) {
			c[i] = wh.registerClient("test", "test");
			o[2 * i] = wh.createOrder(c[i]);
			o[2 * i + 1] = wh.createOrder(c[i]);
		}
		p[0] = wh.addProduct("football", 6);
		p[1] = wh.addProduct("handball", 6);
		p[2] = wh.addProduct("volleyball", 1);
		p[3] = wh.addProduct("basketball", 5);
		p[4] = wh.addProduct("bat", 2);
		wh.addToOrder(p[4], 3, o[0]);
		wh.addToOrder(p[1], 5, o[1]);
		wh.addToOrder(p[1], 2, o[1]);
		wh.addToOrder(p[3], 7, o[1]);
		wh.addToOrder(p[2], 4, o[4]);
		wh.finalizeOrder(o[0]);
		wh.finalizeOrder(o[1]);
		wh.finalizeOrder(o[4]);
		wh.searchProduct("football");
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
