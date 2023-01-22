import datastructures.*;

public class Client implements Comparable{
	private static int idGeneratorClient = 0;
	private int uniqueId;
	private String name;
	private String email;
	
	public Client(String name, String email) {
		uniqueId = idGeneratorClient++;
		this.name = name;
		this.email = email;
	}

	public int compareTo(Object o) {
		return uniqueId - ((Client)o).getUniqueID();
	}

	public int getUniqueID() {
		return uniqueId;
	}
	
	public void setUniqueId(int id) {
		uniqueId = id;
	}

	public String getName() {
		return name;
	}
	
	public String getEmail() {
		return email;
	}
	
	
}
