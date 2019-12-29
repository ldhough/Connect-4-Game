package connectmodeltests;

/**
 * Test Cases for GameBoard Class using 1x1 Sized Board
 * 
 */

import static org.junit.Assert.*;

import java.awt.Point;

import org.junit.Before;
import org.junit.Test;
import connectmodel.*;

public class TestGameBoard1x1
{
    private PieceType[] myPieces = {PieceType.RED};
    private GameBoard myTestBoard;
    
    /**
     * Sets up the GameBoard for our testing.
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception
    {
        myTestBoard = new GameBoard(1, 1, 1, myPieces);
        myTestBoard.resetBoard();
    }

    /**
     * Checks to see if isBoardFull() works correctly.
     */
    @Test
    public void testBoardFull()
    {
        assertTrue("Unable to place token in 0!", myTestBoard.placePiece(0, myPieces[0]));
        assertTrue("Board should be full!", myTestBoard.isBoardFull());
    }
    
    /**
     * Checks to see if a win occurs after placing a single token.
     */
    @Test
    public void testBoardWin()
    {
        assertTrue("Unable to place token in 0!", myTestBoard.placePiece(0, myPieces[0]));
        assertTrue("Game should have yielded a win!", myTestBoard.checkIfWin());
        
        Point point = new Point(0,0);
        boolean check = myTestBoard.getWinBegin().equals(point)
        				&& myTestBoard.getWinEnd().equals(point);
        assertTrue("End points should both be 0,0", check);
    }
    
    /**
     * Checks to see if the board returns correctly when an invalid column is entered.
     */
    @Test
    public void testInvalidLeftColumn()
    {
        assertFalse("Token should not be placed in column -1!", myTestBoard.placePiece(-1, myPieces[0]));
    }
    
    /**
     * Checks to see if the board returns correctly when an invalid column is entered.
     */
    @Test
    public void testInvalidRightColumn()
    {
        assertFalse("Token should not be placed in column 1!", myTestBoard.placePiece(1, myPieces[0]));
    }
    
    /**
     * Checks to see cannot fill full column.
     */
    @Test
    public void testInvalidTop()
    {
        assertTrue("Unable to place token in 0!", myTestBoard.placePiece(0, myPieces[0]));
        assertFalse("Should not place piece in full column", myTestBoard.placePiece(0, myPieces[0]));
    }
    

    
    /**
     * Test empty board
     */
	@Test
	public void checkNull() 
	{
		assertTrue("no pieces placed", myTestBoard.checkAllNull());
		assertFalse("No pieces placed, so no chance for win", myTestBoard.checkIfWin());
	}
	
	/**
	 * Check that resetBoard works
	 */
	@Test
	public void checkReset() 
	{
        assertTrue("Unable to place token in 0!", myTestBoard.placePiece(0, myPieces[0]));
		myTestBoard.resetBoard();
		assertTrue("no pieces placed", myTestBoard.checkAllNull());
	}

}
