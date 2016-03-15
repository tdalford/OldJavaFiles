import java.util.Random;
public class MultiArrays {
	
	public static int[][] reverseMatrix(int[][] matrix)
	{
			int colIndex = matrix.length - 1;
			int rowIndex = matrix[0].length - 1;
			for (int i = colIndex; i >= colIndex / 2; i--)
			{
				for (int j = rowIndex; j >= 0; j--)
				{
					/*System.out.println(i);
					System.out.println(j);
					*/
					int temp = matrix[i][j];
					matrix[i][j] = matrix[colIndex - i][rowIndex - j];
					matrix[colIndex - i][rowIndex - j] = temp;	
					if (i == colIndex / 2 && j == (int) (rowIndex / 2) + 1)
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
	
	public static void main(String[] args)
	{
		Random rn = new Random();
		int[][] mat = new int[5][5];
		for (int r = 0; r < 5; r++)
		{
			for (int c= 0; c < 5; c++)
			{
				mat[r][c] = rn.nextInt(90) + 10;
			}
		}
		printMatrix(mat);
		printMatrix(reverseMatrix(mat));
		/*//reverse array:
		all:
		for (int i = 4; i >= 2; i--)
		{
			for (int j = 4; j >= 0; j--)
			{
				int temp = mat[i][j];
				mat[i][j] = mat[4 - i][4 - j];
				mat[4 - i][4 - j] = temp;	
				if (i == 2 && j == 2)
				{
					break all;
				}
			}
		}		
		printMatrix(mat);
		*/
		mat = new int[3][4];
		for (int r = 0; r < 3; r++)
		{
			for (int c= 0; c < 4; c++)
			{
				mat[r][c] = rn.nextInt(90) + 10;
			}
		}	
		printMatrix(mat);
		System.out.println(mat.length);
		printMatrix(reverseMatrix(mat));
	}	

}
