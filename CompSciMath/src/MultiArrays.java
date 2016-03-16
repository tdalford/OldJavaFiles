import java.util.Random;
public class MultiArrays {
	
	public static int[][] reverseMatrix(int[][] matrix)
	{
			int colIndex = matrix.length - 1;
			int rowIndex = matrix[0].length - 1;
			for (int i = colIndex; i >= (double) colIndex / 2; i--)
			{
				for (int j = rowIndex; j >= 0; j--)
				{
					int temp = matrix[i][j];
					matrix[i][j] = matrix[colIndex - i][rowIndex - j];
					matrix[colIndex - i][rowIndex - j] = temp;	
					if (i == (double) colIndex / 2 && j == (int) (rowIndex / 2) + 1)
					{
						return matrix;
					}
				}
			}
		return matrix;
	}
	
	public static void printMatrix(int[][] matrix)
	{
		System.out.println();
		int rows = matrix.length;
		int columns = matrix[0].length;
		for (int r = 0; r < rows; r++)
		{
			for (int c= 0; c < columns; c++)
			{
				System.out.print(matrix[r][c] + "\t");
			}
			System.out.println();
		}
	}
	
	public static int[][] createMatrix(int rows, int columns)
	{
		Random rn = new Random();
		int[][] mat = new int[rows][columns];
		for (int r = 0; r < rows; r++)
		{
			for (int c= 0; c < columns; c++)
			{
				mat[r][c] = rn.nextInt(90) + 10;
			}
		}	
		return mat;
	}
	
	public static void main(String[] args)
	{
		int[][] mat = createMatrix(5, 5);
		printMatrix(mat);
		printMatrix(reverseMatrix(mat));

		mat = createMatrix(3, 4);
		printMatrix(mat);
		System.out.println(mat.length);
		printMatrix(reverseMatrix(mat));
		
		mat = createMatrix(8, 11);
		printMatrix(mat);
		printMatrix(reverseMatrix(mat));
	}	

}
