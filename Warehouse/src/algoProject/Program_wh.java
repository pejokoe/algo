package algoProject;

public class Program_wh {
	public static void main(String[] args) {
		Warehouse wh = new Warehouse();
		int clientId = wh.registerClient("Peter", "peterkoegler@gmx.de");
		int orderId1 = wh.createOrder(clientId);
		int orderId2 = wh.createOrder(clientId);
		
		int productId = wh.addProduct("Football", 10);
		wh.addToOrder(productId, 5, orderId1);
		wh.addToOrder(productId, 3, orderId1);
		wh.addToOrder(productId, 4, orderId2);
		wh.finalizeOrder(orderId1);
		wh.finalizeOrder(orderId2);
	}
}
