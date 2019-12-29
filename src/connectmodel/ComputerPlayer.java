package connectmodel;

/**
 * This class is the computer player that
 * vs player, and calls the best move from game board
 * 
 * @author Aaron Stewart
 *
 */
public class ComputerPlayer extends Player
{
	private GameBoard myGameBoard;
	/**
	 * method gets the name and type from Player
	 * class
	 * 
	 * @param name
	 * @param type
	 */
	public ComputerPlayer(String name, PieceType type)
	{
		super(name, type);
	}
	/**
	 * method calls best move method from GameBoard class
	 * 
	 * @return the next move the computer will do
	 */
	public int nextMove()
	{
		return myGameBoard.findBestMoveColumn(getPieceType());
	}
	/**
	 * method gets game board
	 * 
	 * @return current game board
	 */
	public GameBoard getMyGameBoard() 
	{
		return myGameBoard;
	}
	/**
	 * sets your game board to current game
	 * board from GameBoard class
	 * 
	 * @param myGameBoard
	 */
	public void setMyGameBoard(GameBoard myGameBoard) 
	{
		this.myGameBoard = myGameBoard;
	}
}