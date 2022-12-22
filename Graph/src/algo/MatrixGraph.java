package algo;

public class MatrixGraph 
{
	private Matrix data;
	private int nodes;
	
	public MatrixGraph(int nrNodes)
	{
		data = new Matrix(nrNodes);
		nodes = nrNodes;
	}
	
	public void addEdge(int from, int to, double w)
	{
		data.set(from, to, w);
	}
	
	public double getEdge(int from, int to)
	{
		return (Double)data.get(from, to);
	}
	
	public String toString() {
		System.out.println("Matrix representation: ");
		System.out.println(data);
		System.out.println("Interpretation: ");
		String output = "";
		for (int i = 0; i < nodes; i++) {
			output += i + ". node: \n";
			for (int j = 0; j < nodes; j++) {
				output += "Connection to node " + j + ": " + data.get(i, j).toString() + "\n";
			}
			output += "\n\n";
		}
		return output;
	}
	
	public Matrix getData() {
		return data;
	}
}
