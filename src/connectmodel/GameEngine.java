package connectmodel;
import java.util.Vector;
/**
 * Class creates the computer player and starts
 * the game, as well as chooses the starting
 * player and when to switch the player up and
 * controls placing pieces and setting the game 
 * board
 * 
 * @author Aaron Stewart
 *
 */
public class GameEngine 
{
	private Vector<Player> myPlayers;
	private Player myPlayerUp;
	private Player myStartingPlayer;
	private GameBoard myGameBoard;
	private boolean myGameStart;
	/**
	 * method constructor creates player vector,
	 * computer player and checks to make sure there
	 * are two players. Adds player and computer to the
	 * vector and sets the game  board.
	 * 
	 * @param player
	 * @param myGameboard
	 */
	public GameEngine(Player player, GameBoard myGameboard) 
	{
		myPlayers = new Vector<Player>(2);
		ComputerPlayer myComputer = new ComputerPlayer("Computer", PieceType.BLACK);
		if(player != null)
		{
			myPlayerUp = player;
			myStartingPlayer = player;
		}
		myPlayers.add(player);
		myPlayers.add(myComputer);
		myGameBoard = myGameboard;
		myGameStart = false;
	}
	/**
	 * method determines whether player or computer
	 * will be the starting player. Player should 
	 * always be the starting player.
	 * 
	 * @param player
	 * @return true if vector myPlayers contains player, false if not
	 */
	public boolean selectStartingPlayer(Player player)
	{
		if(!myPlayers.contains(player))
		{
			return false;
		}
		else
		{
			myPlayerUp = player;
			myStartingPlayer = player;
			return true;
		}
	}
	/**
	 * method is to determine whether 
	 * or not a game should be started
	 * and who starts it
	 * 
	 * @return true if the game board is not empty
	 * if not returns false
	 */
	public boolean startGame() 
	{
		if(myGameBoard != null && myPlayers.firstElement() != null)
		{
			if(myStartingPlayer == myPlayers.firstElement())
			{
				myPlayerUp = myPlayers.lastElement();
				myStartingPlayer = myPlayers.lastElement();
			}
			else
			{
				myPlayerUp = myPlayers.firstElement();
				myStartingPlayer = myPlayers.firstElement();
			}
			myGameStart = true;
			myGameBoard.resetBoard();
			return true;
		}
		myGameStart = false;
		return false;
	}
	/**
	 * method is used to switch the players turn
	 * 
	 * @return either player or computer as the one who is up
	 */
	public Player switchPlayerUp() 
	{
		if(myPlayerUp == myPlayers.firstElement())
		{
			myPlayerUp = myPlayers.lastElement();
		}
		else
		{
			myPlayerUp = myPlayers.firstElement();
		}
		return myPlayerUp;
	}
	/**
	 * method determines the player
	 * up has the right piece
	 * 
	 * @param column
	 * @return true for the player up to place their piece
	 */
	public boolean placePiece(int column)
	{
		myGameBoard.placePiece(column, myPlayerUp.getPieceType());
		return true;
	}
	/**
	 * method gets the player who 
	 * its supposed to be
	 * 
	 * @return the player who is up
	 */
	public Player getPlayerUp() 
	{
		return myPlayerUp;
	}
	/**
	 * method gets the starting player
	 * 
	 * @return the starting player
	 */
	public Player getStartingPlayer()
	{
		return myStartingPlayer;
	}
	/**
	 * method gets the player in the vector
	 * 
	 * @return the players in the vector
	 */
	public Vector<Player> getPlayers()
	{
		return myPlayers;
	}
	/**
	 * sets the game board up
	 * 
	 * @param gameboard
	 */
	public void setGameBoard(GameBoard gameboard)
	{
		myGameBoard = gameboard;
	}
	/**
	 * method gets the game board
	 * 
	 * @return your game board
	 */
	public GameBoard getGameBoard()
	{
		return myGameBoard;
	}
}