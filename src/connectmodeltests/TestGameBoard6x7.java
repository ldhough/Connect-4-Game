package connectmodeltests;

/**
 * Test Cases for GameBoard Class using 6x7 Sized Board
 * 
 */

import static org.junit.Assert.*;

import java.awt.Point;

import org.junit.Before;
import org.junit.Test;

import connectmodel.GameBoard;
import connectmodel.PieceType;

public class TestGameBoard6x7 
{
	private GameBoard myGameBoard; 
	private PieceType myPieceTypes[];
	
	/**
	 * Set GameBoard and PieceType objects for all test scripts.
	 * Also, assume that board row and column indices begin at 0.
	 * (e.g. for 7 columns, index 0 thru 6, not 1 thru 7)
	 * 
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception 
	{
		myPieceTypes = new PieceType[2];
		myPieceTypes[0] = PieceType.BLACK;
		myPieceTypes[1] = PieceType.RED;

		 myGameBoard = new GameBoard(6, 7, 4, myPieceTypes);
	}
	/*
	 * Checks if Columns are full
	 */
	@Test
	public void columnLeftFull() 
	{
		myGameBoard.resetBoard();
		assertFalse(myGameBoard.isColumnFull(0));
		myGameBoard.placePiece(0, myPieceTypes[0]);
		assertFalse(myGameBoard.isColumnFull(0));
		myGameBoard.placePiece(0, myPieceTypes[1]);
		assertFalse(myGameBoard.isColumnFull(0));
		myGameBoard.placePiece(0, myPieceTypes[0]);
		assertFalse(myGameBoard.isColumnFull(0));
		myGameBoard.placePiece(0, myPieceTypes[1]);
		assertFalse(myGameBoard.isColumnFull(0));
		myGameBoard.placePiece(0, myPieceTypes[0]);
		assertFalse(myGameBoard.isColumnFull(0));
		myGameBoard.placePiece(0, myPieceTypes[1]);
		assertTrue(myGameBoard.isColumnFull(0));
		assertFalse(myGameBoard.placePiece(0, myPieceTypes[0]));
	}

	@Test
	public void columnRightFull() 
	{
		myGameBoard.resetBoard();
		assertFalse(myGameBoard.isColumnFull(6));
		myGameBoard.placePiece(6, myPieceTypes[0]);
		assertFalse(myGameBoard.isColumnFull(6));
		myGameBoard.placePiece(6, myPieceTypes[1]);
		assertFalse(myGameBoard.isColumnFull(6));
		myGameBoard.placePiece(6, myPieceTypes[0]);
		assertFalse(myGameBoard.isColumnFull(6));
		myGameBoard.placePiece(6, myPieceTypes[1]);
		assertFalse(myGameBoard.isColumnFull(6));
		myGameBoard.placePiece(6, myPieceTypes[0]);
		assertFalse(myGameBoard.isColumnFull(6));
		myGameBoard.placePiece(6, myPieceTypes[1]);
		assertTrue(myGameBoard.isColumnFull(6));
		assertFalse(myGameBoard.placePiece(6, myPieceTypes[0]));
	}
	
	@Test
	public void columnMiddleFull() 
	{
		myGameBoard.resetBoard();
		assertFalse(myGameBoard.isColumnFull(3));
		myGameBoard.placePiece(3, myPieceTypes[0]);
		assertFalse(myGameBoard.isColumnFull(3));
		myGameBoard.placePiece(3, myPieceTypes[1]);
		assertFalse(myGameBoard.isColumnFull(3));
		myGameBoard.placePiece(3, myPieceTypes[0]);
		assertFalse(myGameBoard.isColumnFull(3));
		myGameBoard.placePiece(3, myPieceTypes[1]);
		assertFalse(myGameBoard.isColumnFull(3));
		myGameBoard.placePiece(3, myPieceTypes[0]);
		assertFalse(myGameBoard.isColumnFull(3));
		myGameBoard.placePiece(3, myPieceTypes[1]);
		assertTrue(myGameBoard.isColumnFull(3));
		assertFalse(myGameBoard.placePiece(3, myPieceTypes[0]));
	}
	/*
	 * Tests vertical, horizontal, and diagonal wins from
	 * both corners, bottom, top, and in the middle of
	 * the board.  Test case names describe each.
	 */
	
	/*
	 * Vertical tests
	 */
	@Test
	public void testVerticalLeftBottomWin() 
	{
		myGameBoard.resetBoard();
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(0, myPieceTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(0, myPieceTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(0, myPieceTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(0, myPieceTypes[0]);
		assertTrue(myGameBoard.checkIfWin()==true);
		
		boolean check1 = this.checkEndPoints(new Point(0, 0), new Point(0, 3));
		boolean check2 = this.checkEndPoints(new Point(0, 2), new Point(0, 5));
		assertTrue(check1 || check2);
	}
	
	@Test
	public void testVerticalRightBottomWin() 
	{
		myGameBoard.resetBoard();
		myGameBoard.placePiece(6, myPieceTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(6, myPieceTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(6, myPieceTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(6, myPieceTypes[0]);
		assertTrue(myGameBoard.checkIfWin()==true);
		
		boolean check1 = this.checkEndPoints(new Point(6, 0), new Point(6, 3));
		boolean check2 = this.checkEndPoints(new Point(6, 2), new Point(6, 5));
		assertTrue(check1 || check2);
	}
	
	@Test
	public void testVerticalMiddleBottomWin() 
	{
		myGameBoard.resetBoard();
		myGameBoard.placePiece(3, myPieceTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(3, myPieceTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(3, myPieceTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(3, myPieceTypes[0]);
		assertTrue(myGameBoard.checkIfWin()==true);
		
		boolean check1 = this.checkEndPoints(new Point(3, 0), new Point(3, 3));
		boolean check2 = this.checkEndPoints(new Point(3, 2), new Point(3, 5));
		assertTrue(check1 || check2);
	}
	
	@Test
	public void testVerticalLeftTopWin() 
	{
		myGameBoard.resetBoard();
		myGameBoard.placePiece(0, myPieceTypes[1]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(0, myPieceTypes[1]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(0, myPieceTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(0, myPieceTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(0, myPieceTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(0, myPieceTypes[0]);
		assertTrue(myGameBoard.checkIfWin()==true);
		
		boolean check1 = this.checkEndPoints(new Point(0, 0), new Point(0, 3));
		boolean check2 = this.checkEndPoints(new Point(0, 2), new Point(0, 5));
		assertTrue(check1 || check2);
	}
	
	@Test
	public void testVerticalRightTopWin() 
	{
		myGameBoard.resetBoard();
		myGameBoard.placePiece(6, myPieceTypes[1]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(6, myPieceTypes[1]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(6, myPieceTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(6, myPieceTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(6, myPieceTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(6, myPieceTypes[0]);
		assertTrue(myGameBoard.checkIfWin()==true);
		
		boolean check1 = this.checkEndPoints(new Point(6, 0), new Point(6, 3));
		boolean check2 = this.checkEndPoints(new Point(6, 2), new Point(6, 5));
		assertTrue(check1 || check2);
	}
	
	@Test
	public void testVerticalMiddleTopWin() 
	{
		myGameBoard.resetBoard();
		myGameBoard.placePiece(3, myPieceTypes[1]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(3, myPieceTypes[1]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(3, myPieceTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(3, myPieceTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(3, myPieceTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(3, myPieceTypes[0]);
		assertTrue(myGameBoard.checkIfWin()==true);
		
		boolean check1 = this.checkEndPoints(new Point(3, 0), new Point(3, 3));
		boolean check2 = this.checkEndPoints(new Point(3, 2), new Point(3, 5));
		assertTrue(check1 || check2);
	}

	@Test
	public void testVerticalLeftNotBottomWin() 
	{
		myGameBoard.resetBoard();
		myGameBoard.placePiece(0, myPieceTypes[1]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(0, myPieceTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(0, myPieceTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(0, myPieceTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(0, myPieceTypes[0]);
		assertTrue(myGameBoard.checkIfWin()==true);
		
		/*
		 * 1,4 same as 4,1 for testing
		 */
		boolean check = this.checkEndPoints(new Point(0, 1), new Point(0, 4));
		assertTrue(check);
	}
	
	@Test
	public void testVerticalMiddleNotBottomWin() 
	{
		myGameBoard.resetBoard();
		myGameBoard.placePiece(4, myPieceTypes[1]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(4, myPieceTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(4, myPieceTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(4, myPieceTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(4, myPieceTypes[0]);
		assertTrue(myGameBoard.checkIfWin()==true);

		/*
		 * 1,4 same as 4,1 for testing
		 */
		boolean check = this.checkEndPoints(new Point(4, 1), new Point(4, 4));
		assertTrue(check);
	}
	
	@Test
	public void testVerticalRightNotBottomWin() 
	{
		myGameBoard.resetBoard();
		myGameBoard.placePiece(6, myPieceTypes[1]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(6, myPieceTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(6, myPieceTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(6, myPieceTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(6, myPieceTypes[0]);
		assertTrue(myGameBoard.checkIfWin()==true);
		
		/*
		 * 1,4 same as 4,1 for testing
		 */
		boolean check = this.checkEndPoints(new Point(6, 1), new Point(6, 4));
		assertTrue(check);
	}
	
	/*
	 * Horizontal tests
	 */
	@Test
	public void testHorizontalLeftBottomWin() 
	{
		myGameBoard.resetBoard();
		myGameBoard.placePiece(0, myPieceTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(1, myPieceTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(2, myPieceTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(3, myPieceTypes[0]);
		assertTrue(myGameBoard.checkIfWin()==true);

		boolean check1 = this.checkEndPoints(new Point(0, 0), new Point(3, 0));
		boolean check2 = this.checkEndPoints(new Point(0, 5), new Point(3, 5));
		assertTrue(check1 || check2);
	}
	
	@Test
	public void testHorizontalRightBottomWin() 
	{
		myGameBoard.resetBoard();
		myGameBoard.placePiece(6, myPieceTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(5, myPieceTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(4, myPieceTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(3, myPieceTypes[0]);
		assertTrue(myGameBoard.checkIfWin()==true);

		boolean check1 = this.checkEndPoints(new Point(3, 0), new Point(6, 0));
		boolean check2 = this.checkEndPoints(new Point(3, 5), new Point(6, 5));
		assertTrue(check1 || check2);
	}
	
	@Test
	public void testHorizontalMiddleBottomWin() 
	{
		myGameBoard.resetBoard();
		myGameBoard.placePiece(2, myPieceTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(3, myPieceTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(4, myPieceTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(5, myPieceTypes[0]);
		assertTrue(myGameBoard.checkIfWin()==true);
		
		boolean check1 = this.checkEndPoints(new Point(2, 0), new Point(5, 0));
		boolean check2 = this.checkEndPoints(new Point(2, 5), new Point(5, 5));
		assertTrue(check1 || check2);
	}
	
	@Test
	public void testHorizontalLeftNotBottomWin() 
	{
		myGameBoard.resetBoard();
		myGameBoard.placePiece(0, myPieceTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(1, myPieceTypes[1]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(2, myPieceTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(3, myPieceTypes[1]);
		assertFalse(myGameBoard.checkIfWin());

		myGameBoard.placePiece(0, myPieceTypes[1]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(1, myPieceTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(2, myPieceTypes[1]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(3, myPieceTypes[0]);
		assertFalse(myGameBoard.checkIfWin());

		myGameBoard.placePiece(0, myPieceTypes[1]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(1, myPieceTypes[1]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(2, myPieceTypes[1]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(3, myPieceTypes[1]);
		assertTrue(myGameBoard.checkIfWin()==true);
		
		boolean check1 = this.checkEndPoints(new Point(0, 2), new Point(3, 2));
		boolean check2 = this.checkEndPoints(new Point(0, 3), new Point(3, 3));
		assertTrue(check1 || check2);
	}
	
	@Test
	public void testHorizontalRightNotBottomWin() 
	{
		myGameBoard.resetBoard();
		myGameBoard.placePiece(6, myPieceTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(5, myPieceTypes[1]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(4, myPieceTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(3, myPieceTypes[1]);
		assertFalse(myGameBoard.checkIfWin());

		myGameBoard.placePiece(6, myPieceTypes[1]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(5, myPieceTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(4, myPieceTypes[1]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(3, myPieceTypes[0]);
		assertFalse(myGameBoard.checkIfWin());

		myGameBoard.placePiece(6, myPieceTypes[1]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(5, myPieceTypes[1]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(4, myPieceTypes[1]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(3, myPieceTypes[1]);
		assertTrue(myGameBoard.checkIfWin()==true);
		
		boolean check1 = this.checkEndPoints(new Point(3, 2), new Point(6, 2));
		boolean check2 = this.checkEndPoints(new Point(3, 3), new Point(6, 3));
		assertTrue(check1 || check2);
	}
	
	@Test
	public void testHorizontalMiddleNotBottomWin() 
	{
		myGameBoard.resetBoard();
		myGameBoard.placePiece(1, myPieceTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(2, myPieceTypes[1]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(3, myPieceTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(4, myPieceTypes[1]);
		assertFalse(myGameBoard.checkIfWin());

		myGameBoard.placePiece(1, myPieceTypes[1]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(2, myPieceTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(3, myPieceTypes[1]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(4, myPieceTypes[0]);
		assertFalse(myGameBoard.checkIfWin());

		myGameBoard.placePiece(1, myPieceTypes[1]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(2, myPieceTypes[1]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(3, myPieceTypes[1]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(4, myPieceTypes[1]);
		assertTrue(myGameBoard.checkIfWin()==true);
		
		boolean check1 = this.checkEndPoints(new Point(1, 2), new Point(4, 2));
		boolean check2 = this.checkEndPoints(new Point(1, 3), new Point(4, 3));
		assertTrue(check1 || check2);
	}
	
	@Test
	public void testHorizontalLeftTopWin() 
	{
		myGameBoard.resetBoard();
		myGameBoard.placePiece(0, myPieceTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(1, myPieceTypes[1]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(2, myPieceTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(3, myPieceTypes[1]);
		assertFalse(myGameBoard.checkIfWin());

		myGameBoard.placePiece(0, myPieceTypes[1]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(1, myPieceTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(2, myPieceTypes[1]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(3, myPieceTypes[0]);
		assertFalse(myGameBoard.checkIfWin());

		myGameBoard.placePiece(0, myPieceTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(1, myPieceTypes[1]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(2, myPieceTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(3, myPieceTypes[1]);
		assertFalse(myGameBoard.checkIfWin());

		myGameBoard.placePiece(0, myPieceTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(1, myPieceTypes[1]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(2, myPieceTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(3, myPieceTypes[1]);
		assertFalse(myGameBoard.checkIfWin());

		myGameBoard.placePiece(0, myPieceTypes[1]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(1, myPieceTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(2, myPieceTypes[1]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(3, myPieceTypes[0]);
		assertFalse(myGameBoard.checkIfWin());

		myGameBoard.placePiece(0, myPieceTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(1, myPieceTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(2, myPieceTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(3, myPieceTypes[0]);
		assertTrue(myGameBoard.checkIfWin()==true);
		
		boolean check1 = this.checkEndPoints(new Point(0, 5), new Point(3, 5));
		boolean check2 = this.checkEndPoints(new Point(0, 0), new Point(3, 0));
		assertTrue(check1 || check2);
	}
	
	@Test
	public void testHorizontalRightTopWin() 
	{
		myGameBoard.resetBoard();
		myGameBoard.placePiece(3, myPieceTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(4, myPieceTypes[1]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(5, myPieceTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(6, myPieceTypes[1]);
		assertFalse(myGameBoard.checkIfWin());

		myGameBoard.placePiece(3, myPieceTypes[1]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(4, myPieceTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(5, myPieceTypes[1]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(6, myPieceTypes[0]);
		assertFalse(myGameBoard.checkIfWin());

		myGameBoard.placePiece(3, myPieceTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(4, myPieceTypes[1]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(5, myPieceTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(6, myPieceTypes[1]);
		assertFalse(myGameBoard.checkIfWin());

		myGameBoard.placePiece(3, myPieceTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(4, myPieceTypes[1]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(5, myPieceTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(6, myPieceTypes[1]);
		assertFalse(myGameBoard.checkIfWin());

		myGameBoard.placePiece(3, myPieceTypes[1]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(4, myPieceTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(5, myPieceTypes[1]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(6, myPieceTypes[0]);
		assertFalse(myGameBoard.checkIfWin());

		myGameBoard.placePiece(3, myPieceTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(4, myPieceTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(5, myPieceTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(6, myPieceTypes[0]);
		assertTrue(myGameBoard.checkIfWin()==true);
		
		boolean check1 = this.checkEndPoints(new Point(3, 5), new Point(6, 5));
		boolean check2 = this.checkEndPoints(new Point(3, 0), new Point(6, 0));
		assertTrue(check1 || check2);
	}
	
	@Test
	public void testHorizontalMiddleTopWin() 
	{
		myGameBoard.resetBoard();
		myGameBoard.placePiece(1, myPieceTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(2, myPieceTypes[1]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(3, myPieceTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(4, myPieceTypes[1]);
		assertFalse(myGameBoard.checkIfWin());

		myGameBoard.placePiece(1, myPieceTypes[1]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(2, myPieceTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(3, myPieceTypes[1]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(4, myPieceTypes[0]);
		assertFalse(myGameBoard.checkIfWin());

		myGameBoard.placePiece(1, myPieceTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(2, myPieceTypes[1]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(3, myPieceTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(4, myPieceTypes[1]);
		assertFalse(myGameBoard.checkIfWin());

		myGameBoard.placePiece(1, myPieceTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(2, myPieceTypes[1]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(3, myPieceTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(4, myPieceTypes[1]);
		assertFalse(myGameBoard.checkIfWin());

		myGameBoard.placePiece(1, myPieceTypes[1]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(2, myPieceTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(3, myPieceTypes[1]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(4, myPieceTypes[0]);
		assertFalse(myGameBoard.checkIfWin());

		myGameBoard.placePiece(1, myPieceTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(2, myPieceTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(3, myPieceTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(4, myPieceTypes[0]);
		assertTrue(myGameBoard.checkIfWin()==true);
		
		boolean check1 = this.checkEndPoints(new Point(1, 5), new Point(4, 5));
		boolean check2 = this.checkEndPoints(new Point(1, 0), new Point(4, 0));
		assertTrue(check1 || check2);
	}
	
	/*
	 * Diagonal wins
	 */
	@Test
	public void testDiagonalBottomLeftWin() 
	{
		myGameBoard.resetBoard();
		myGameBoard.placePiece(0, myPieceTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(1, myPieceTypes[1]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(1, myPieceTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(2, myPieceTypes[1]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(2, myPieceTypes[1]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(2, myPieceTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(3, myPieceTypes[1]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(3, myPieceTypes[1]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(3, myPieceTypes[1]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(3, myPieceTypes[0]);
		assertTrue(myGameBoard.checkIfWin()==true);
		
		boolean check1 = this.checkEndPoints(new Point(0, 0), new Point(3, 3));
		boolean check2 = this.checkEndPoints(new Point(0, 5), new Point(3, 2));
		assertTrue(check1 || check2);
	}
	
	@Test
	public void testDiagonalBottomRightWin() 
	{
		myGameBoard.resetBoard();
		myGameBoard.placePiece(6, myPieceTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(5, myPieceTypes[1]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(5, myPieceTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(4, myPieceTypes[1]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(4, myPieceTypes[1]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(4, myPieceTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(3, myPieceTypes[1]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(3, myPieceTypes[1]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(3, myPieceTypes[1]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(3, myPieceTypes[0]);
		assertTrue(myGameBoard.checkIfWin()==true);
		
		boolean check1 = this.checkEndPoints(new Point(6, 0), new Point(3, 3));
		boolean check2 = this.checkEndPoints(new Point(6, 5), new Point(3, 2));
		assertTrue(check1 || check2);
	}
	
	@Test
	public void testDiagonalBottomMiddleWin() 
	{
		myGameBoard.resetBoard();
		myGameBoard.placePiece(5, myPieceTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(4, myPieceTypes[1]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(4, myPieceTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(3, myPieceTypes[1]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(3, myPieceTypes[1]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(3, myPieceTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(2, myPieceTypes[1]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(2, myPieceTypes[1]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(2, myPieceTypes[1]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(2, myPieceTypes[0]);
		assertTrue(myGameBoard.checkIfWin()==true);
		
		boolean check1 = this.checkEndPoints(new Point(5, 0), new Point(2, 3));
		boolean check2 = this.checkEndPoints(new Point(5, 5), new Point(2, 2));
		assertTrue(check1 || check2);
	}
	
	@Test
	public void testDiagonalUpperRightWin() 
	{
		myGameBoard.resetBoard();
		myGameBoard.placePiece(6, myPieceTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(6, myPieceTypes[1]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(6, myPieceTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(6, myPieceTypes[1]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(6, myPieceTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(6, myPieceTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		
		myGameBoard.placePiece(5, myPieceTypes[1]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(5, myPieceTypes[1]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(5, myPieceTypes[1]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(5, myPieceTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(5, myPieceTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(5, myPieceTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		
		myGameBoard.placePiece(4, myPieceTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(4, myPieceTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(4, myPieceTypes[1]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(4, myPieceTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(4, myPieceTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		
		myGameBoard.placePiece(3, myPieceTypes[1]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(3, myPieceTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(3, myPieceTypes[0]);
		assertTrue(myGameBoard.checkIfWin()==true);
		
		boolean check1 = this.checkEndPoints(new Point(6, 5), new Point(3, 2));
		boolean check2 = this.checkEndPoints(new Point(6, 0), new Point(3, 3));
		assertTrue(check1 || check2);
	}
	
	@Test
	public void testDiagonalUpperLeftWin() 
	{
		myGameBoard.resetBoard();
		myGameBoard.placePiece(0, myPieceTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(0, myPieceTypes[1]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(0, myPieceTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(0, myPieceTypes[1]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(0, myPieceTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(0, myPieceTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		
		myGameBoard.placePiece(1, myPieceTypes[1]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(1, myPieceTypes[1]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(1, myPieceTypes[1]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(1, myPieceTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(1, myPieceTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(1, myPieceTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		
		myGameBoard.placePiece(2, myPieceTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(2, myPieceTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(2, myPieceTypes[1]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(2, myPieceTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(2, myPieceTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		
		myGameBoard.placePiece(3, myPieceTypes[1]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(3, myPieceTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(3, myPieceTypes[0]);
		assertTrue(myGameBoard.checkIfWin());
		
		boolean check1 = this.checkEndPoints(new Point(0, 5), new Point(3, 2));
		boolean check2 = this.checkEndPoints(new Point(0, 0), new Point(3, 3));
		assertTrue(check1 || check2);
	}
	
	@Test
	public void testDiagonalUpperMiddleWin() 
	{
		myGameBoard.resetBoard();
		myGameBoard.placePiece(1, myPieceTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(1, myPieceTypes[1]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(1, myPieceTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(1, myPieceTypes[1]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(1, myPieceTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(1, myPieceTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		
		myGameBoard.placePiece(2, myPieceTypes[1]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(2, myPieceTypes[1]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(2, myPieceTypes[1]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(2, myPieceTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(2, myPieceTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(2, myPieceTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		
		myGameBoard.placePiece(3, myPieceTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(3, myPieceTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(3, myPieceTypes[1]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(3, myPieceTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(3, myPieceTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		
		myGameBoard.placePiece(4, myPieceTypes[1]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(4, myPieceTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(4, myPieceTypes[0]);
		assertTrue(myGameBoard.checkIfWin()==true);

		boolean check1 = this.checkEndPoints(new Point(1, 5), new Point(4, 2));
		boolean check2 = this.checkEndPoints(new Point(1, 0), new Point(4, 3));
		assertTrue(check1 || check2);
	}
	
	/**
	 * No preference will be given to which win a piece provides.
	 * Test if a piece will yield both a horizontal and diagonal
	 * win, that a win is recorded.  Either win is acceptable.
	 */
	@Test
	public void testDoubleWin() 
	{
		myGameBoard.resetBoard();
		myGameBoard.placePiece(1, myPieceTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(1, myPieceTypes[1]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(1, myPieceTypes[1]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(1, myPieceTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		
		myGameBoard.placePiece(2, myPieceTypes[1]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(2, myPieceTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(2, myPieceTypes[1]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(2, myPieceTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		
		myGameBoard.placePiece(3, myPieceTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(3, myPieceTypes[1]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(3, myPieceTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(3, myPieceTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		
		myGameBoard.placePiece(4, myPieceTypes[1]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(4, myPieceTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(4, myPieceTypes[1]);
		assertFalse(myGameBoard.checkIfWin());
		
		myGameBoard.placePiece(5, myPieceTypes[1]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(5, myPieceTypes[0]);
		assertFalse(myGameBoard.checkIfWin());
		myGameBoard.placePiece(5, myPieceTypes[1]);
		assertFalse(myGameBoard.checkIfWin());
		
		myGameBoard.placePiece(4, myPieceTypes[0]);
		assertTrue(myGameBoard.checkIfWin()==true);
		
		boolean checkDiag1 = this.checkEndPoints(new Point(1, 0), new Point(4, 3));
		boolean checkHoriz1 = this.checkEndPoints(new Point(1, 3), new Point(4, 3));
		boolean checkDiag2 = this.checkEndPoints(new Point(1, 2), new Point(4, 5));
		boolean checkHoriz2 = this.checkEndPoints(new Point(1, 2), new Point(4, 2));
		assertTrue(checkDiag1 || checkHoriz1 || checkDiag2 || checkHoriz2);
	}
	
	/**
	 * Test tie
	 */
	@Test
	public void testTie()
	{
		myGameBoard.placePiece(0, myPieceTypes[0]);
		myGameBoard.placePiece(0, myPieceTypes[0]);
		myGameBoard.placePiece(0, myPieceTypes[1]);
		myGameBoard.placePiece(0, myPieceTypes[0]);
		myGameBoard.placePiece(0, myPieceTypes[1]);
		myGameBoard.placePiece(0, myPieceTypes[0]);
		
		myGameBoard.placePiece(1, myPieceTypes[0]);
		myGameBoard.placePiece(1, myPieceTypes[0]);
		myGameBoard.placePiece(1, myPieceTypes[1]);
		myGameBoard.placePiece(1, myPieceTypes[0]);
		myGameBoard.placePiece(1, myPieceTypes[1]);
		myGameBoard.placePiece(1, myPieceTypes[0]);

		myGameBoard.placePiece(2, myPieceTypes[1]);
		myGameBoard.placePiece(2, myPieceTypes[1]);
		myGameBoard.placePiece(2, myPieceTypes[0]);
		myGameBoard.placePiece(2, myPieceTypes[1]);
		myGameBoard.placePiece(2, myPieceTypes[0]);
		myGameBoard.placePiece(2, myPieceTypes[1]);

		myGameBoard.placePiece(3, myPieceTypes[1]);
		myGameBoard.placePiece(3, myPieceTypes[1]);
		myGameBoard.placePiece(3, myPieceTypes[0]);
		myGameBoard.placePiece(3, myPieceTypes[1]);
		myGameBoard.placePiece(3, myPieceTypes[0]);
		myGameBoard.placePiece(3, myPieceTypes[1]);

		myGameBoard.placePiece(4, myPieceTypes[0]);
		myGameBoard.placePiece(4, myPieceTypes[0]);
		myGameBoard.placePiece(4, myPieceTypes[1]);
		myGameBoard.placePiece(4, myPieceTypes[0]);
		myGameBoard.placePiece(4, myPieceTypes[1]);
		myGameBoard.placePiece(4, myPieceTypes[0]);
		
		myGameBoard.placePiece(5, myPieceTypes[0]);
		myGameBoard.placePiece(5, myPieceTypes[0]);
		myGameBoard.placePiece(5, myPieceTypes[1]);
		myGameBoard.placePiece(5, myPieceTypes[0]);
		myGameBoard.placePiece(5, myPieceTypes[1]);
		myGameBoard.placePiece(5, myPieceTypes[0]);

		myGameBoard.placePiece(6, myPieceTypes[1]);
		myGameBoard.placePiece(6, myPieceTypes[1]);
		myGameBoard.placePiece(6, myPieceTypes[0]);
		myGameBoard.placePiece(6, myPieceTypes[1]);
		myGameBoard.placePiece(6, myPieceTypes[0]);
		myGameBoard.placePiece(6, myPieceTypes[1]);
		
		assertTrue(myGameBoard.isBoardFull());
		assertFalse(myGameBoard.getIsAWin());
		assertFalse(myGameBoard.checkAllNull());
	}
	
	
	/**
	 *Test to ensure pieces cannot be placed past left boundary. 
	 */
	@Test
	public void testOutOfBoundsLeft()
	{
		assertFalse(myGameBoard.placePiece(-1, myPieceTypes[0]));
	}
	
	/**
	 *Test to ensure pieces cannot be placed past left boundary. 
	 */
	@Test
	public void testOutOfBoundsRight()
	{
		assertFalse(myGameBoard.placePiece(7, myPieceTypes[0]));
	}
	
	/**
	 *Test to ensure pieces cannot be placed over top row. 
	 */
	@Test
	public void testOutOfBoundsUp()
	{
		assertTrue(myGameBoard.placePiece(0, myPieceTypes[1]));
		assertTrue(myGameBoard.placePiece(0, myPieceTypes[0]));
		assertTrue(myGameBoard.placePiece(0, myPieceTypes[1]));
		assertTrue(myGameBoard.placePiece(0, myPieceTypes[0]));
		assertTrue(myGameBoard.placePiece(0, myPieceTypes[1]));
		assertTrue(myGameBoard.placePiece(0, myPieceTypes[0]));
		
		assertTrue(myGameBoard.isColumnFull(0));
		assertFalse(myGameBoard.placePiece(0, myPieceTypes[0]));
	}	
	
	/**
	 * Test for best next move if next move leads to win.
	 */
	@Test
	public void testBestMoveHorizontalWin()
	{
		assertTrue(myGameBoard.placePiece(0,myPieceTypes[0]));
		assertFalse(myGameBoard.checkIfWin());
		assertTrue(myGameBoard.placePiece(0,myPieceTypes[1]));
		assertFalse(myGameBoard.checkIfWin());
		assertTrue(myGameBoard.placePiece(1,myPieceTypes[0]));
		assertFalse(myGameBoard.checkIfWin());
		assertTrue(myGameBoard.placePiece(1,myPieceTypes[1]));
		assertFalse(myGameBoard.checkIfWin());
		assertTrue(myGameBoard.placePiece(2,myPieceTypes[0]));
		assertFalse(myGameBoard.checkIfWin());
		assertTrue(myGameBoard.placePiece(2,myPieceTypes[1]));
		assertFalse(myGameBoard.checkIfWin());
		
		int best = myGameBoard.findBestMoveColumn(myPieceTypes[0]);
		
		assertTrue("Best column should be 3", best == 3);
		assertTrue(myGameBoard.placePiece(3, myPieceTypes[0]));
		assertTrue("Best column 3 should have won", myGameBoard.checkIfWin());
	}
	
	/**
	 * Test for best next move if next move blocks other 
	 * player from winning.
	 */
	@Test
	public void testBestMoveDiagonalBlock()
	{
		assertTrue(myGameBoard.placePiece(0,myPieceTypes[0]));
		assertFalse(myGameBoard.checkIfWin());
		assertTrue(myGameBoard.placePiece(1,myPieceTypes[1]));
		assertFalse(myGameBoard.checkIfWin());
		assertTrue(myGameBoard.placePiece(2,myPieceTypes[0]));
		assertFalse(myGameBoard.checkIfWin());
		assertTrue(myGameBoard.placePiece(2,myPieceTypes[1]));
		assertFalse(myGameBoard.checkIfWin());
		assertTrue(myGameBoard.placePiece(3,myPieceTypes[0]));
		assertFalse(myGameBoard.checkIfWin());
		assertTrue(myGameBoard.placePiece(3,myPieceTypes[1]));
		assertFalse(myGameBoard.checkIfWin());
		assertTrue(myGameBoard.placePiece(3,myPieceTypes[1]));
		assertFalse(myGameBoard.checkIfWin());
		assertTrue(myGameBoard.placePiece(4,myPieceTypes[1]));
		assertFalse(myGameBoard.checkIfWin());
		assertTrue(myGameBoard.placePiece(4,myPieceTypes[0]));
		assertFalse(myGameBoard.checkIfWin());
		assertTrue(myGameBoard.placePiece(4,myPieceTypes[1]));
		assertFalse(myGameBoard.checkIfWin());
		assertTrue(myGameBoard.placePiece(5,myPieceTypes[0]));
		assertFalse(myGameBoard.checkIfWin());
		
		int best = myGameBoard.findBestMoveColumn(myPieceTypes[0]);
		
		assertTrue("Best column should be 4", best == 4);
		assertTrue(myGameBoard.placePiece(4, myPieceTypes[0]));
		assertFalse("Best column 4 should not have won", myGameBoard.checkIfWin());
	}
	
	/**
	 * Test for next best move if cannot win nor 
	 * block other player.
	 */
	@Test
	public void testBestMovePlacePiece()
	{
		assertTrue(myGameBoard.placePiece(0,myPieceTypes[0]));
		assertFalse(myGameBoard.checkIfWin());
		assertTrue(myGameBoard.placePiece(0,myPieceTypes[0]));
		assertFalse(myGameBoard.checkIfWin());
		assertTrue(myGameBoard.placePiece(1,myPieceTypes[1]));
		assertFalse(myGameBoard.checkIfWin());
		assertTrue(myGameBoard.placePiece(1,myPieceTypes[0]));
		assertFalse(myGameBoard.checkIfWin());
		assertTrue(myGameBoard.placePiece(2,myPieceTypes[1]));
		assertFalse(myGameBoard.checkIfWin());
		assertTrue(myGameBoard.placePiece(2,myPieceTypes[1]));
		assertFalse(myGameBoard.checkIfWin());
		assertTrue(myGameBoard.placePiece(3,myPieceTypes[1]));
		assertFalse(myGameBoard.checkIfWin());
		assertTrue(myGameBoard.placePiece(3,myPieceTypes[1]));
		assertFalse(myGameBoard.checkIfWin());
		assertTrue(myGameBoard.placePiece(4,myPieceTypes[0]));
		assertFalse(myGameBoard.checkIfWin());
		
		int best = myGameBoard.findBestMoveColumn(myPieceTypes[1]);
		
		assertTrue("Best column should be 3", best == 3);
		assertTrue(myGameBoard.placePiece(3, myPieceTypes[0]));
		assertFalse("Best column 3 should not have won", myGameBoard.checkIfWin());
	}
	
	/**
	 * Test of the reset board function.
	 */
	@Test
	public void testResetBoard()
	{
		myGameBoard.resetBoard();
		assertTrue(myGameBoard.checkAllNull() == true);
	}

	/*
	 * Do not show preference for how end points of a win
	 * are selected, as long as both are correct.
	 * 
	 * @param p1 one end point
	 * @param p2 the other end point
	 */
	private boolean checkEndPoints(Point p1, Point p2)
	{
		boolean option1 = myGameBoard.getWinBegin().equals(p1)
				&& myGameBoard.getWinEnd().equals(p2);
		boolean option2 = myGameBoard.getWinBegin().equals(p2)
				&& myGameBoard.getWinEnd().equals(p1);
		return option1 || option2;
	}
}