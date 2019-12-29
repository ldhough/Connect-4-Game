package connectmodeltests;

/**
 * Test Cases for GameBoard Class using 2x2 Sized Board
 * 
 */

import static org.junit.Assert.*;

import java.awt.Point;

import org.junit.Before;
import org.junit.Test;
import connectmodel.*;

public class TestGameBoard2x2
{
    private PieceType[] myPieces = {PieceType.RED, PieceType.BLACK};
    private GameBoard myTestBoard;
    
    /**
     * Sets up the GameBoard for our testing.
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception
    {
        myTestBoard = new GameBoard(2, 2, 2, myPieces);
        myTestBoard.resetBoard();
    }
    
	/**
	 * Checks if Columns are full
	 */
	@Test
	public void columnLeftFull() 
	{
		myTestBoard.placePiece(0, myPieces[0]);
		assertFalse(myTestBoard.isColumnFull(0));
		myTestBoard.placePiece(0, myPieces[1]);
		assertTrue(myTestBoard.isColumnFull(0));
		assertFalse(myTestBoard.placePiece(0, myPieces[0]));
	}

	@Test
	public void columnRightFull() 
	{
		myTestBoard.placePiece(1, myPieces[0]);
		assertFalse(myTestBoard.isColumnFull(1));
		myTestBoard.placePiece(1, myPieces[1]);
		assertTrue(myTestBoard.isColumnFull(1));
		assertFalse(myTestBoard.placePiece(1, myPieces[0]));
	}


    /**
     * Checks to see if isBoardFull() works correctly.
     */
    @Test
    public void testBoardFull()
    {
        assertTrue("Unable to place token in 0!", myTestBoard.placePiece(0, myPieces[0]));
        assertTrue("Unable to place token in 0!", myTestBoard.placePiece(0, myPieces[0]));
        assertTrue("Unable to place token in 1!", myTestBoard.placePiece(1, myPieces[1]));
        assertTrue("Unable to place token in 1!", myTestBoard.placePiece(1, myPieces[1]));
        assertTrue("Board should be full!", myTestBoard.isBoardFull());
    }
    
    /**
     * Checks to see if a vertical win can occur.
     */
    @Test
    public void testBoardVerticalWin()
    {
        assertTrue("Unable to place token in 0!", myTestBoard.placePiece(0, myPieces[0]));
        assertTrue("Unable to place token in 0!", myTestBoard.placePiece(0, myPieces[0]));
        assertTrue("Game should have yielded a win!", myTestBoard.checkIfWin());
        
		boolean check = this.checkEndPoints(new Point(0, 0), new Point(0, 1));
		assertTrue(check);
    }
        
    /**
     * Checks to see if a horizontal win can occur.
     */
    @Test
    public void testBoardHorizontalWin()
    {
        assertTrue("Unable to place token in 0!", myTestBoard.placePiece(0, myPieces[0]));
        assertTrue("Unable to place token in 1!", myTestBoard.placePiece(1, myPieces[0]));
        assertTrue("Game should have yielded a win!", myTestBoard.checkIfWin());
        
		boolean check1 = this.checkEndPoints(new Point(0, 0), new Point(1, 0));
		boolean check2 = this.checkEndPoints(new Point(0, 1), new Point(1, 1));
		assertTrue(check1 || check2);
    }
        
    /**
     * Checks to see if a diagonal win can occur.
     */
    @Test
    public void testBoardDiagonalWin()
    {
        assertTrue("Unable to place token in 0!", myTestBoard.placePiece(0, myPieces[0]));
        assertTrue("Unable to place token in 1!", myTestBoard.placePiece(1, myPieces[1]));
        assertTrue("Unable to place token in 1!", myTestBoard.placePiece(1, myPieces[0]));
        assertTrue("Game should have yielded a win!", myTestBoard.checkIfWin());
        
		boolean check1 = this.checkEndPoints(new Point(0, 0), new Point(1, 1));
		boolean check2 = this.checkEndPoints(new Point(0, 1), new Point(1, 0));
		assertTrue(check1 || check2);
    }
    
    /**
     * Checks to see if the board returns correctly when an invalid column is entered.
     */
    @Test
    public void testInvalidLeftColumn()
    {
        assertFalse("Token can not be placed in column -1!", myTestBoard.placePiece(-1, myPieces[0]));
    }

    /**
     * Checks to see if the board returns correctly when an invalid column is entered.
     */
    @Test
    public void testInvalidRightColumn()
    {
        assertFalse("Token can not be placed in column 2!", myTestBoard.placePiece(2, myPieces[0]));
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
		boolean option1 = myTestBoard.getWinBegin().equals(p1)
				&& myTestBoard.getWinEnd().equals(p2);
		boolean option2 = myTestBoard.getWinBegin().equals(p2)
				&& myTestBoard.getWinEnd().equals(p1);
		return option1 || option2;
	}
}
