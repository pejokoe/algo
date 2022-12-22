package algo;

public class Matrix 
{
	Comparable[][] matrix;
	
	public Matrix(int nrNodes)
	{
		matrix = new Comparable[nrNodes][nrNodes];
		// initialize matrix with all zeros
		for (int i = 0; i < nrNodes; i++) {
			for (int j = 0; j < nrNodes; j++) {
				matrix[i][j] = 0;
			}
		}
	}
	
	public void set(int row, int col, Comparable weight)
	{
		matrix[row][col] = weight;
	}

	public Comparable get(int row, int col)
	{
		return matrix[row][col];
	}
	
	public String toString() {
		String output = "";
		for (int i = 0; i < matrix[0].length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				output += matrix[i][j].toString() + "	";
			}
			output += "\n";
		}
		return output;
	}
}