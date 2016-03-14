import java.util.Random;
public class MultiArrays {
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
		for (int r = 0; r < 5; r++)
		{
			for (int c= 0; c < 5; c++)
			{
				System.out.print(mat[r][c] + "\t");
			}
			System.out.println();
		}
		
		//reverse array:
		for (int i = 5; i > 0; i++)
		{
			for (int j = 5; j > 0; j++)
			{
				int temp = mat[i][j];
			}
		}
	}
	

}
