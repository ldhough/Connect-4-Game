package connectmodeltests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
//import static org.junit.jupiter.api.Assertions.*;

import java.awt.Point;

import org.junit.Before;
import org.junit.Test;

//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;

import connectmodel.GameBoard;
import connectmodel.PieceType;

class Test4X4Board 
{
	private GameBoard myGameBoard;
	private PieceType[] myPieceTypes;

	@Before
	void setUp() throws Exception 
	{
		myPieceTypes = new PieceType[2];
		myPieceTypes[0] = PieceType.RED;
		myPieceTypes[1] = PieceType.BLACK;
		myGameBoard = new GameBoard(4, 4, 3, myPieceTypes);
	}

	@Test
	void testRowIndexCorrect() 
	{
		myGameBoard.placePiece(0, PieceType.RED);
		Point last = myGameBoard.getLastPoint();
		int x = last.x;
		int y = last.y;
		assertTrue("Piece should be in column 0", x == 0);
		assertTrue("Piece should be in row 3", y == 3);
		assertFalse("Rows seem inverted", y == 0);
	}
	
	@Test
	void testDiagonalWinBottomLeftCorner()
	{
		myGameBoard.placePiece(1, PieceType.BLACK);
		myGameBoard.placePiece(2, PieceType.BLACK);
		myGameBoard.placePiece(2, PieceType.BLACK);
		myGameBoard.placePiece(0, PieceType.RED);
		myGameBoard.placePiece(1, PieceType.RED);
		assertFalse("Game should not have been won yet", myGameBoard.checkIfWin());
		myGameBoard.placePiece(2, PieceType.RED);
		assertTrue("Game should have been won", myGameBoard.checkIfWin());
		Point start = myGameBoard.getWinBegin();
		Point end = myGameBoard.getWinEnd();
	}

}
