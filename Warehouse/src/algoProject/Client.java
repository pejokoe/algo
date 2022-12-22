package algoProject;

public class Client {
	private static int generateID = 0;
	private int unique_ID;
	private String name;
	
	public Client(String name) {
		unique_ID = generateID++;
		this.name = name;
	}

	public int getUnique_ID() {
		return unique_ID;
	}

	public String getName() {
		return name;
	}
}
