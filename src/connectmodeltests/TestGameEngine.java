package connectmodeltests;

/**
 * Test Cases for GameEngine Class
 * 
 */

import static org.junit.Assert.*;

import java.util.Vector;

import org.junit.Before;
import org.junit.Test;

import connectmodel.GameBoard;
import connectmodel.PieceType;
import connectmodel.GameEngine;
import connectmodel.Player;

public class TestGameEngine 
{
	private PieceType[] myTypes;
	private GameBoard myGameBoard;
	private GameEngine myGameEngine;
	private Player myPlayer;
	private Vector<Player> myPlayers;
	
	/**
	 * Set up the PieceTypes, GameBoard, and GameEngine for test 
	 * cases to be run.  Note that the GameBoard constructor will
	 * be responsible for setting up the ComputerPlayer and assigning
	 * it the PieceType not selected by Player.
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception
	{		
		myTypes = new PieceType[2];
		myTypes[0] = PieceType.BLACK;
		myTypes[1] = PieceType.RED;
		myGameBoard = new GameBoard(6, 7, 4, myTypes);
		
		myPlayer = new Player("Guido", myTypes[1]);
		myGameEngine = new GameEngine(myPlayer, myGameBoard);
		
		myPlayers = myGameEngine.getPlayers();
	}
	
	/**
	 * Test players are different types
	 */
	@Test
	public void testPlayersDifferentTypes()
	{
		Player player1 = myPlayers.firstElement();
		Player player2 = myPlayers.lastElement();
		PieceType pieceType1 = player1.getPieceType();
		PieceType pieceType2 = player2.getPieceType();
		assertTrue(pieceType1 != pieceType2);
	}

	/**
	 * Tests switching players one time
	 */
	@Test
	public void testSwitchPlayerOnce()
	{
		Player player = myPlayers.firstElement();
		PieceType pieceType = player.getPieceType();
		myGameEngine.selectStartingPlayer(player);
		myGameEngine.switchPlayerUp();
		assertTrue(myGameEngine.getPlayerUp().getPieceType() != pieceType);
	}
	
	/**
	 * Tests switching players twice
	 */
	@Test
	public void testSwitchPlayerTwice()
	{
		Player player = myPlayers.firstElement();
		PieceType pieceType = player.getPieceType();
		myGameEngine.selectStartingPlayer(player);
		myGameEngine.switchPlayerUp();
		myGameEngine.switchPlayerUp();
		assertTrue(myGameEngine.getPlayerUp().getPieceType() == pieceType);
	}
	
	/**
	 * Tests correct player up after starting new game
	 */
	@Test
	public void testPlayerUpAfterNewGame()
	{
		assertTrue(myGameEngine.startGame());
		Player player1 = myGameEngine.getPlayerUp();
		PieceType pieceType1 = player1.getPieceType();
		
		assertTrue(myGameEngine.startGame());
		Player player2 = myGameEngine.getPlayerUp();
		PieceType pieceType2 = player2.getPieceType();
		
		assertTrue(pieceType1 != pieceType2);
	}
	
	/**
	 * Tests player up is same after other player gets to start
	 * first when new game occurs
	 */
	@Test
	public void testPlayerUpAfterTwoNewGames()
	{
		assertTrue(myGameEngine.startGame());
		Player player1 = myGameEngine.getPlayerUp();
		PieceType pieceType1 = player1.getPieceType();
		
		assertTrue(myGameEngine.startGame());
		Player player2 = myGameEngine.getPlayerUp();
		PieceType pieceType2 = player2.getPieceType();
		
		assertTrue(myGameEngine.startGame());
		player2 = myGameEngine.getPlayerUp();
		pieceType2 = player2.getPieceType();
		
		assertTrue(pieceType1 == pieceType2);
	}
	
	/**
	 * Tests selecting invalid player
	 */
	@Test
	public void testSelectInvalidPlayer()
	{
		Player player = new Player("GoGo123", PieceType.BLACK);
		assertFalse(myGameEngine.selectStartingPlayer(player));
	}
	
	/**
	 * Test starting game resets board
	 */
	@Test
	public void testPlacePieceBeforeStartGame()
	{
		assertTrue(myGameEngine.placePiece(3));
		assertFalse(myGameEngine.getGameBoard().checkAllNull());
		assertTrue(myGameEngine.startGame());
		assertTrue(myGameEngine.getGameBoard().checkAllNull());
	}
	
	/**
	 * Test that game cannot start if null player 
	 * 
	 * Note: must re-instantiate GameEngine
	 */
	@Test
	public void testNullPlayer()
	{
		myGameEngine = new GameEngine(null, myGameBoard);
		assertFalse(myGameEngine.startGame());
	}
	
	/**
	 * Test that game cannot start if null gameboard 
	 * 
	 * Note: must re-instantiate GameEngine
	 */
	@Test
	public void testNullGameBoard()
	{
		myGameEngine = new GameEngine(myPlayer, null);
		assertFalse(myGameEngine.startGame());
	}
		
}
