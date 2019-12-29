package mvc;

import java.awt.Point;

import javax.swing.JOptionPane;

import connectmodel.ComputerPlayer;
import connectmodel.GameBoard;
import connectmodel.GameEngine;
import connectmodel.PieceType;
import connectmodel.Player;
import connectmodel.GameEngine;

/**
 * Controller class facilitates interaction between the View class and the Model classes (Engine, Board, Player, etc).
 * 
 * Due Date: 04/12/2019
 * 
 * @author Lannie Dalton Hough III
 * @version 1.0
 */

public class Controller {
	private View myView;
	private Player myPlayer;
	private String myPlayerName;
	private GameBoard myBoard;
	private GameEngine myModel;
	private PieceType myPieceTypes[];
	private ComputerPlayer myMachine;
	
	/**
	 * Controller constructor that makes necessary objects and assignments for the class to work
	 */
	
	public Controller() {
		myPieceTypes = new PieceType[4];
		myPieceTypes[0] = PieceType.BLACK;
		myPieceTypes[1] = PieceType.RED;
		myPieceTypes[2] = PieceType.GREEN;
		myPieceTypes[3] = PieceType.YELLOW;
		String s = JOptionPane.showInputDialog("Input name: ");
		
		myPlayerName = s;
		PieceType whichPieceColor = null;
		
		String[] choices = {"Red", "Green", "Yellow"};
		
		String input = (String) JOptionPane.showInputDialog(null, "Choose which color piece you want", "Choose Color", JOptionPane.QUESTION_MESSAGE, null, choices, choices[1]);
		if (input == "Red") {
			myPieceTypes[1] = PieceType.RED;
			whichPieceColor = PieceType.RED;
		} else if (input == "Green") {
			myPieceTypes[1] = PieceType.GREEN;
			whichPieceColor = PieceType.GREEN;
		} else if (input == "Yellow") {
			myPieceTypes[1] = PieceType.YELLOW;
			whichPieceColor = PieceType.YELLOW;
		}
		
		myPlayer = new Player(s, whichPieceColor);
		myMachine = new ComputerPlayer("The Machine", PieceType.BLACK);
		myBoard = new GameBoard(6, 7, 4, myPieceTypes);
		
		myModel = new GameEngine(myPlayer, myBoard);
		myView = new View(this);
	}
	
	/**
	 * method gets game board
	 * 
	 * @return current game board
	 */
	
	public GameBoard getGameBoard() {
		return myBoard;
	}
	
	/**
	 * method gets the gameengine object
	 * 
	 * @return myModel, a gameengine object
	 */
	
	public GameEngine getGameEngine() {
		return myModel;
	}
	
	/*public PieceType[][] getBoardArray() {
		return myBoard.getBoard();
	}*/
	
	/**
	 * method gets the board
	 * 
	 * @return current game board
	 */
	
	public GameBoard getModelValue() {
		return myModel.getGameBoard();
	}
	
	
	/**
	 * method gets the name of the player and returns it
	 * 
	 * @return name of the player
	 */
	
	public String getThePlayer () {
		return myPlayerName;
	}
	
	int value;
	
	/**
	 * Increments score for the computer and updates view accordingly.
	 */
	
	public void incrementPlayer() {
		String valueString;
		value++;
		myModel.getPlayerUp().incrementScore();
		//value = myModel.getPlayerUp().getScore();
		valueString = Integer.toString(value);
		myView.setPlayerScore(valueString);
	}
	
	int value2;
	
	/**
	 * Increments score for the computer and updates view accordingly.
	 */
	
	public void incrementComputer() {
		String valueString;
		value2++;
		myModel.getPlayerUp().incrementScore();
		//value = myModel.getPlayerUp().getScore();
		valueString = Integer.toString(value2);
		myView.setComputerScore(valueString);
	}
	
	int whoStartsGame = 2;
	int startGame = 1;
	int firstMoveHappens = 1;
	
	/**
	 * method places a piece and updates view accordingly
	 */
	
	public void placePiece(Integer col) { 
		double row;
		int bestMove;
		Point point;
		
		if (startGame == 1) {
			myModel.startGame();
			startGame++;
		}
		
		if (whoStartsGame % 2 != 0 && firstMoveHappens == 1) {
			firstMoveHappens++;
    		bestMove = myModel.getGameBoard().findBestMoveColumn(myModel.getPlayerUp().getPieceType());
    		myModel.placePiece(bestMove);
    		Point point2 = myModel.getGameBoard().getLastPoint();
            double row3 = point2.getY();
            int row4 = (int) row3;
            myView.changeImage(2, row4, bestMove);
            myModel.switchPlayerUp();
            return;
		}
		
		if (myBoard.isColumnFull(col) != true) {
			myModel.placePiece(col);
		} else if (myBoard.isColumnFull(col) == true) {
        	JOptionPane.showMessageDialog(null, "Cannot place piece, column is full!", "ERROR", JOptionPane.WARNING_MESSAGE);
        	return;
		}
		
		point = myModel.getGameBoard().getLastPoint();
        row = point.getY();
        int row2 = (int) row;
        if (myPlayer.getPieceType() == PieceType.RED) {
        	myView.changeImage(1, row2, col);
        } else if (myPlayer.getPieceType() == PieceType.GREEN) {
        	myView.changeImage(4, row2, col);
        } else if (myPlayer.getPieceType() == PieceType.YELLOW) {
        	myView.changeImage(5, row2, col);
        }
        
        if (myModel.getGameBoard().checkIfWin() == true) {
        	JOptionPane.showMessageDialog(null, "YOU WON!", "VICTORY", JOptionPane.INFORMATION_MESSAGE);
        	incrementPlayer();
        	whoStartsGame++;
        	firstMoveHappens = 1;
        	int reply = JOptionPane.showConfirmDialog(null, "Would you like to play again?", "RESTART?", JOptionPane.YES_NO_OPTION);
        	if (reply == JOptionPane.YES_OPTION) {
        		myModel.startGame();
        		for (int i=0; i < 7; i++) {
                    for (int rows = 0; rows < 6; rows++) {
                    	myView.changeImage(3, rows, i);
                    }
                 }

                JOptionPane.showMessageDialog(null, "Board reset.  If computer's turn to go first, click anywhere to start game.");
                return;
            } else {
                JOptionPane.showMessageDialog(null, "Thanks for playing!");
                System.exit(0);
            }
        } else {
                myModel.switchPlayerUp();
        		bestMove = myModel.getGameBoard().findBestMoveColumn(myModel.getPlayerUp().getPieceType());
                //bestMove = myMachine.nextMove();
        		myModel.placePiece(bestMove);
        		Point point2 = myModel.getGameBoard().getLastPoint();
                double row3 = point2.getY();
                int row4 = (int) row3;
                
                myView.changeImage(2, row4, bestMove);
                myModel.switchPlayerUp();
                
                if (myModel.getGameBoard().checkIfWin() == true) {
                	JOptionPane.showMessageDialog(null, "THE COMPUTER WON!", "DEFEAT", JOptionPane.INFORMATION_MESSAGE);
                	incrementComputer();
                	whoStartsGame++;
                	firstMoveHappens = 1;
                	int reply = JOptionPane.showConfirmDialog(null, "Would you like to play again?", "RESTART?", JOptionPane.YES_NO_OPTION);
                	if (reply == JOptionPane.YES_OPTION) {
                		myModel.startGame();
                		for (int i=0; i < 7; i++) {
                            for (int rows = 0; rows < 6; rows++) {
                            	myView.changeImage(3, rows, i);
                            }
                         }
                		JOptionPane.showMessageDialog(null, "Board reset.  If computer's turn to go first, click anywhere to start game.");
                	} else {
                		JOptionPane.showMessageDialog(null, "Thanks for playing!");
                        System.exit(0);
                	}
                }
        }
	}
}
