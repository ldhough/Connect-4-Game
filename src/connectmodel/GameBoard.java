package connectmodel;
import java.awt.Point;
import java.util.Arrays;
import java.util.Vector;
/**
 * GameBoard class describes a connect 4 game board,
 * mainly the size by columns and rows, and places
 * the players piece and the computers piece
 * on the board. It also checks to see if there is
 * a winner or not, and holds the components that let
 * the computer know where to place its piece. It
 * resets the board when there is a winner and 
 * checks if the board is full.
 * 
 * Due Date: 03/29/2019
 * 
 * @author Aaron Stewart
 * @version 1.0
 */
public class GameBoard
{
	//Class variables
    private int myNumRows;
    private int myNumColumns;
    private PieceType[][] myBoard;
    private int myNumTypes;
    private int myWinLength;
    private Point myLastPoint;
    private Vector<PieceType> myTypes;
    private Point myWinBegin;
    private Point myWinEnd;
    private Point myHoldPoint;
    private boolean myIsAWin;
    /**
     * Class constructor method holds the 
     * length of rows, columns, and win length,
     * as well as what will be used as pieces for
     * on the board.
     * 
     * @param cols value, rows value, winLength value, and array of types
     */
    public GameBoard(int rows, int cols, int winLength, PieceType[] types)
    {
    	myNumRows = rows;
    	myNumColumns = cols;
    	myWinLength = winLength;
    	myNumTypes = types.length;
    	myBoard = new PieceType[cols][rows];
    	myTypes = new Vector<PieceType>(Arrays.asList(types));
    }
    /**
     * Method to place pieces on the board 
     * 
     * @param col, the column to place the piece in
     * @param type, the type of piece(black, red, blue, etc)
     * @return boolean value, whether a piece can be placed there or not
     */
    public boolean placePiece(int col, PieceType type)
    {
    	if(col<myNumColumns && col>-1)
    	{
    		for(int rows=0; rows<myBoard[0].length; rows++)
    		{
    			if(myBoard[col][rows] == null)
    			{
    				myBoard[col][rows] = type;
    				myLastPoint = new Point(col, rows);
    				return true;
    			}
    		}
    	}
	    return false;
    }
    /**
     * method to reset the game board,
     * making it an empty board.
     */
    public void resetBoard() 
    {
    	for(int rows=0; rows<myNumRows; rows++)
    	{
    		for(int cols=0; cols<myNumColumns; cols++)
    		{
    			myBoard[cols][rows] = null;
    		}
    	}
    }
    /**
     * method to check if player or computerPlayer has won
     * 
     * @return true if someone won or false if not
     */
    public boolean checkIfWin() 
    {
    	if(myWinLength == 1 && myBoard[0][0] != null)
    	{
    		myWinBegin = new Point(0, 0);
    		myWinEnd = new Point(0, 0);
    		return true;
    	}
    	else if(myLastPoint != null && (checkHorizontalWin() || checkDiagonalWin() || checkVerticalWin()))
    	{
    		return true;
    	}
    	return false;
    }
    /**
     * method that finds the best move for 
     * the computer player, tells the computer player
     * where to place its piece
     * 
     * @param type
     * @return which column you want computer to place its next piece
     */
    public int findBestMoveColumn(PieceType type)
    {
    	PieceType opponentType = type == myTypes.firstElement()? myTypes.lastElement():myTypes.firstElement();
    	for(int cols=0; cols<myNumColumns; cols++)
    	{
    		if(countVerticalLengthIfPiecePlaced(cols, type) == myWinLength || countHorizontalLengthIfPiecePlaced(cols, type) == myWinLength || countDiagonalLengthIfPiecePlaced(cols, type) == myWinLength)
    		{
    			return cols;
    		}
    	}
    	for(int cols=0; cols<myNumColumns; cols++)
    	{
    		if(countVerticalLengthIfPiecePlaced(cols, opponentType) == myWinLength || countHorizontalLengthIfPiecePlaced(cols, opponentType) == myWinLength || countDiagonalLengthIfPiecePlaced(cols, opponentType) == myWinLength)
    		{
    			return cols;
    		}
    	}
    	int bestMove = 0;
    	int longest = 0;
    	for(int cols=0; cols<myNumColumns; cols++)
    	{
    		int currentLength = countVerticalLengthIfPiecePlaced(cols, type);
    		currentLength +=  countHorizontalLengthIfPiecePlaced(cols, type);
    		currentLength += countDiagonalLengthIfPiecePlaced(cols, type);
    		if(currentLength > longest)
    		{
    			longest = currentLength;
    			bestMove = cols;
    		}
    	}
	    return bestMove;
    }
    /**
     * method checks to see if there is a column
     * of pieces that meet the win condition
     * 
     * @return true if win condition has been met, if not then false
     */
    private boolean checkVerticalWin() 
    {
    	if(myLastPoint != null)
    	{
    	for(int rows=0; rows<myNumRows-myWinLength+1; rows++)
    	{	
    		for(int cols=0; cols<myNumColumns; cols++)
    		{
    			if(myBoard[cols][rows] != null)
    			{
    				for(int win=1; win<myWinLength; win++)
    				{
    					myWinBegin = new Point(cols, rows);
    					if(myBoard[cols][rows] != myBoard[cols][rows+win])
    					{
    						myWinBegin = null;
    						break;
    					}
    					if(win == myWinLength-1)
    					{
    						myWinEnd = new Point(cols, rows+myWinLength-1);
    						return true;
    					}
    				}
    			}
    		}
    	}
    	}
	    return false;
    }
    /**
     * method checks to see if there is a row
     * of pieces that meet the win condition
     * 
     * @return true if win condition has been met, if not then false
     */
    private boolean checkHorizontalWin() 
    {
    	if(myLastPoint != null)
    	{	
    		int rows = myLastPoint.y;
    		for(int cols=0; cols<myNumColumns-myWinLength+1; cols++)
    		{
    			if(myBoard[cols][rows] != null)
    			{
    				for(int win=1; win<myWinLength; win++)
    				{
    					myWinBegin = new Point(cols, rows);
    					if(myBoard[cols][rows] != myBoard[cols+win][rows])
    					{
    						myWinBegin = null;
    						break;
    					}
    					if(win == myWinLength-1)
    					{
    						myWinEnd = new Point(cols+myWinLength-1, rows);
    						return true;
    					}
    				}
    			}
    		}
    	}
    	return false;
    }
    /**
     * method checks to see if there is a diagonal
     * length of pieces that meet the win condition
     * 
     * @return true if win condition has been met, if not then false
     */
    private boolean checkDiagonalWin() 
    {
    	for(int rows=0; rows<myNumRows; rows++)
    	{	
    		for(int cols=0; cols<myNumColumns; cols++)
    		{
    			if(myBoard[cols][rows] != null)
    			{
    				for(int win=1; win<myWinLength; win++)
    				{
    					myWinBegin = new Point(cols, rows);
    					if((cols+win) == myNumColumns || (rows+win) == myNumRows || myBoard[cols][rows] != myBoard[cols+win][rows+win])
    					{
    						myWinBegin = null;
    						break;
    					}
    					if(win == myWinLength-1)
    					{
    						myWinEnd = new Point(cols+myWinLength-1, rows+myWinLength-1);
    						return true;
    					}
    				}
    				for(int win=1; win<myWinLength; win++)
    				{
    					myWinBegin = new Point(cols, rows);
    					if((cols+win)==myNumColumns || rows-win==-1 || myBoard[cols][rows] != myBoard[cols+win][rows-win])
    					{
    						myWinBegin = null;
    						break;
    					}
    					if(win == myWinLength-1)
    					{
    						myWinEnd = new Point(cols+myWinLength-1, rows-myWinLength+1);
    						return true;
    					}
    				}
    			}
    		}
    	}
    	return false;
    }
    /**
     * method that counts the lengths of pieces to
     * the left and right of the next place you would put a piece
     * 
     * @param col
     * @param type
     * @return horizontal length of pieces already placed
     */
    private int countHorizontalLengthIfPiecePlaced(int col, PieceType type) 
    {
    	int horizontalLength = 0;
    	int placeHolder = 0;
    	for(int rows = myNumRows-1; rows>0; rows--)
    	{
    		if(myBoard[col][rows] == null && myBoard[col][rows-1] != null)
    		{
    			placeHolder = rows;
    			break;
    		}
    	}
    	for(int cols = col-1; cols>-1; cols--)
    	{
    		if(myBoard[cols][placeHolder] == type)
    		{
    			horizontalLength++;
    		}
    		else
    		{
    			break;
    		}
    	}
    	for(int cols = col+1; cols<myNumColumns; cols++)
    	{
    		if(myBoard[cols][placeHolder] == type)
    		{
    			horizontalLength++;
    		}
    		else
    		{
    			break;
    		}
    	}
	    return horizontalLength;
    }
    /**
     * method that counts the lengths of pieces
     * above and below of the next place you would put a piece
     * 
     * @param col
     * @param type
     * @return vertical length of pieces already placed
     */
    private int countVerticalLengthIfPiecePlaced(int col, PieceType type) 
    {
    	int verticalLength = 1;
    	int placeHolder = 0;
    	for(int rows = myNumRows-1; rows>0; rows--)
    	{
    		if(myBoard[col][rows] == null && myBoard[col][rows-1] != null)
    		{
    			placeHolder = rows;
    			break;
    		}
    	}
    	for(int rows = placeHolder-1; rows>-1; rows--)
    	{
    		if(myBoard[col][rows] == type)
    		{
    			verticalLength++;
    		}
    		else
    		{
    			break;
    		}
    	}
	    return verticalLength;
    }
    /**
     * method that counts the lengths of pieces to
     * the rightward diagonal and leftward diagonal 
     * of the next place you would put a piece
     * 
     * @param col
     * @param type
     * @return diagonal length of pieces already placed
     */
    private int countDiagonalLengthIfPiecePlaced(int col, PieceType type) 
    {
    	int diagonalRightLength = 1;
    	int diagonalLeftLength = 1;
    	int placeHolder = 0;
    	for(int rows = myNumRows-1; rows>0; rows--)
    	{
    		if(myBoard[col][rows] == null && myBoard[col][rows-1] != null)
    		{
    			placeHolder = rows;
    			break;
    		}
    	}
    	for(int delta = 1; delta<myWinLength; delta++)
    	{
    		if(col+delta<myNumColumns && placeHolder+delta<myNumRows && myBoard[col+delta][placeHolder+delta] == type)
    		{
    			diagonalRightLength++;
    		}
    		else
    			break;
    	}
    	for(int delta = 1; delta<myWinLength; delta++)
    	{
    		if(col-delta>-1 && placeHolder-delta>-1 && myBoard[col-delta][placeHolder-delta] == type)
    		{
    			diagonalRightLength++;
    		}
    		else
    			break;
    	}
    	for(int delta = 1; delta<myWinLength; delta++)
    	{
    		if(col+delta<myNumColumns && placeHolder-delta>-1 && myBoard[col+delta][placeHolder-delta] == type)
    		{
    			diagonalLeftLength++;
    		}
    		else
    			break;
    	}
    	for(int delta = 1; delta<myWinLength; delta++)
    	{
    		if(col-delta>-1 && placeHolder+delta<myNumRows && myBoard[col-delta][placeHolder+delta] == type)
    		{
    			diagonalLeftLength++;
    		}
    		else
    			break;
    	}
    	return (diagonalRightLength>diagonalLeftLength)? diagonalRightLength:diagonalLeftLength;   
    }
    /**
     * method that holds the types of pieces
     * in a vector
     * 
     * @return your current type
     */
    public Vector<PieceType> getTypes() 
    {
	    return myTypes;
    }	
    /**
     * method that gets the point where
     * your win length begins
     * 
     * @return current point where the 
     * length of pieces counted begins
     */
    public Point getWinBegin() 
    {
	    return myWinBegin;
    }
    /**
     * method that gets the point where
     * your win length ends
     * 
     * @return current point where the
     * length of pieces counted ends
     */
    public Point getWinEnd()
    {
	    return myWinEnd;
    }
    /**
     * method that gets the point where
     * you last placed a piece
     * 
     * @return your last point you placed
     */
    public Point getLastPoint() 
    {
	    return myLastPoint;
    }
    /**
     * method that gets the piece on the
     * board
     * 
     * @param point
     * @return the coordinates of a piece on the board
     */
    public PieceType getPieceOnBoard(Point point) 
    {
	    return myBoard[point.x][point.y];
    }
    /**
     * method that gets the board array
     * 
     * @return current board
     */
    public PieceType[][] getBoard() 
    {
	    return myBoard;
    }
    /**
     * method that checks if the board is full of pieces
     * 
     * @return false is a null spot is found, if not true
     */
    public boolean isBoardFull() 
    {
    	
    	for(int rows=0; rows<myNumRows; rows++)
    	{
    		for( int cols=0; cols<myNumColumns; cols++)
    		{
    			if(myBoard[cols][rows] == null)
    			{
    				return false;
    			}
    		}
    	}
    	return true;
    }
    /**
     * method checks if each columns is full
     * 
     * @param col
     * @return false if null is found in the column, if not true
     */
    public boolean isColumnFull(int col) 
    {
   			for(int rows=0; rows<myBoard.length; rows++)
   			{
   				if(rows<myNumRows && myBoard[col][rows] == null)
   				{
   					return false;
    			}
    	}
    	return true;
    }
    /**
     * method that gets if its a win or not
     * 
     * @return myIsAWin
     */
    public boolean getIsAWin() 
    {
    	return myIsAWin;
    }
    /**
     * method that checks if all the places in the array
     * are null or not
     * 
     * @return false if a place is found thats not null, if not true
     */
    public boolean checkAllNull()
    {
    	for(int cols=0; cols<myNumColumns; cols++)
    	{
    		for(int rows=0; rows<myNumRows; rows++)
    		{
    			if(myBoard[cols][rows] != null)
    			{
    				return false;
    			}
    		}
    	}
		return true;
    }
}