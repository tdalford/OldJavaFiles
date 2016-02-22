
public class TicTacToe {
	
public static void main(String[] args)
{
	int moveNum;
	Point[] firstPlayerMoves = new Point[5];
	Point[] secondPlayerMoves = new Point[4];
	//first move
	firstPlayerMoves[1] = new Point(0, 2);
	firstPlayerMoves[1].fill();
	//seconnd move
	if (firstPlayerMoves[1].isCorner())
	{
		secondPlayerMoves[1] = new Point(1, 1);
	}
	
	
	
}

}
