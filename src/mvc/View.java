package mvc;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import connectmodel.GameBoard;
import connectmodel.GameEngine;
import connectmodel.PieceType;

/**
 * View class uses information from the model and the controller to produce a GUI that looks like a connect 
 * four gameboard.  Takes input from buttons and sends signals to controller to perform game actions.
 * 
 * Due Date: 04/12/2019
 * 
 * @author Lannie Dalton Hough III
 * @version 1.0
 */

@SuppressWarnings("serial")
public class View extends JFrame {
	private Controller myController;
	GameEngine engine; 
	public GameBoard myBoard;
	public PieceType[][] myBoardArray; 
	private ButtonListener[] mySquareListener;
	private Can[][] mySquare;
	private JPanel myBoardPanel;
	private ButtonListener[] myBoardListener;
	private JTextField myComputerPlayer;
	private JTextField myPlayer;
	private JTextField playerWins;
	private Image myBlankImage;
	private Image myBlackPiece;
	private Image myRedPiece;
	private Image myGreenPiece;
	private Image myYellowPiece;
	private JPanel myTextPanel;
	private JPanel myTextPanel2;
	private JPanel myTextPanel3;
	private JPanel myTextPanel4;
	private JPanel myTextPanel5;
	private JPanel myTextPanel6;
	private JLabel playerScore;
	private JLabel computerScore;
	
	/**
	 * Constructs view object with necessary information for the GUI including various scores, player names, and the board itself
	 */
	
	public View(Controller controller) {
		myController = controller;
		
		JFrame frame = new JFrame("Connect 4 Game");
		
		frame.setSize(800, 400);
		frame.setLayout(null);
		frame.setBackground(Color.gray);
		
		myBlankImage = Toolkit.getDefaultToolkit().getImage("images/blankpiece.jpg");
		myBlackPiece = Toolkit.getDefaultToolkit().getImage("images/blackpiece.jpg");
		myRedPiece = Toolkit.getDefaultToolkit().getImage("images/redpiece.jpg");
		myGreenPiece = Toolkit.getDefaultToolkit().getImage("images/greenpiece.jpg");
		myYellowPiece = Toolkit.getDefaultToolkit().getImage("images/yellowpiece.jpg");
		
		mySquare = new Can[6][7];
		
		mySquareListener = new ButtonListener[7];
		myBoardPanel = new JPanel(new GridLayout(6, 7));
		myBoardPanel.setSize(500, 300);
		myBoardPanel.setLocation(20, 20);
		
		for(int i = 0; i < 6; i++) {
			for(int j = 0; j < 7; j++) {
				mySquare[i][j] = new Can(myBlankImage);
				myBoardPanel.add(mySquare[i][j]);
			}
		}
		
		JLabel player1 = new JLabel("Player 1:");
		player1.setLocation(540, 20);
		JLabel player2 = new JLabel("Player 2:");
		player2.setLocation(540, 80);
		JLabel player1name = new JLabel("");
		player1name.setLocation(540, 40);
		JLabel player2name = new JLabel("The Machine");
		player2.setLocation(540, 100);
		player1name.setText(myController.getThePlayer());
		playerScore = new JLabel("Player Score: 0");
		computerScore = new JLabel("Computer Score: 0");
		
		myTextPanel = new JPanel(new FlowLayout());
		myTextPanel.setSize(50, 20);
		myTextPanel.setLocation(540, 20);
		
		myTextPanel2 = new JPanel(new FlowLayout());
		myTextPanel2.setSize(150, 20);
		myTextPanel2.setLocation(600, 20);
		
		myTextPanel3 = new JPanel(new FlowLayout());
		myTextPanel3.setSize(50, 20);
		myTextPanel3.setLocation(540, 40);
		
		myTextPanel4 = new JPanel(new FlowLayout());
		myTextPanel4.setSize(150, 20);
		myTextPanel4.setLocation(600, 40);
		
		myTextPanel5 = new JPanel(new FlowLayout());
		myTextPanel5.setSize(150, 20);
		myTextPanel5.setLocation(540, 60);
		
		myTextPanel6 = new JPanel(new FlowLayout());
		myTextPanel6.setSize(150, 20);
		myTextPanel6.setLocation(540, 80);
		
		frame.add(myBoardPanel);
		myTextPanel.add(player1);
		myTextPanel3.add(player2);
		myTextPanel2.add(player1name);
		myTextPanel4.add(player2name);
		myTextPanel5.add(playerScore);
		myTextPanel6.add(computerScore);
		frame.add(myTextPanel);
		frame.add(myTextPanel2);
		frame.add(myTextPanel3);
		frame.add(myTextPanel4);
		frame.add(myTextPanel5);
		frame.add(myTextPanel6);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.associateListeners();
		
	}
	
	/**
	 * Sets up button listeners for board columns
	 */
	
    public void associateListeners() {
        Class<? extends Controller> controllerClass;
        Method placePieceMethod;
        Class<?>[] classArgs;

        controllerClass = myController.getClass();
        
        placePieceMethod = null;
        classArgs = new Class[1];
        
        try {
           classArgs[0] = Class.forName("java.lang.Integer");
        }
        catch(ClassNotFoundException e) {
           String error;
           error = e.toString();
           System.out.println(error);
        }
        
        
        try {
           placePieceMethod = controllerClass.getMethod("placePiece",classArgs);
        }
        catch(NoSuchMethodException exception) {
           String error;
           error = exception.toString();
           System.out.println(error);
        }
        catch(SecurityException exception) {
           String error;
           error = exception.toString();
           System.out.println(error);
        }
        
        int i;
        int rows;
        Integer[] args;
        
        for (i=0; i < 7; i++) {
           args = new Integer[1];
           args[0] = new Integer(i);
           mySquareListener[i] = new ButtonListener(myController, placePieceMethod, args);
           for (rows = 0; rows < 6; rows++) {
        	   mySquare[rows][i].addMouseListener(mySquareListener[i]);
           }
        }
    }
    
	/**
	 * Updates the GUI with proper visual information in the form of playing pieces
	 */
    
    public void changeImage(int num, int row, int col){
        if (num == 1) {
        	mySquare[5-row][col].setImage(myRedPiece);
        }
        else if (num == 2) {
        	mySquare[5-row][col].setImage(myBlackPiece);
        } else if (num == 3) {
        	mySquare[5-row][col].setImage(myBlankImage);
        } else if (num == 4) {
        	mySquare[5-row][col].setImage(myGreenPiece);
        } else if (num == 5) {
        	mySquare[5-row][col].setImage(myYellowPiece);
        }
    }
    
	/**
	 * Updates the GUI with proper visual information in the form of player score
	 */
    
    public void setPlayerScore(String value) {
    	playerScore.setText("Player Score: " + value);
    }
    
	/**
	 * Updates the GUI with proper visual information in the form of computer score
	 */
    
    public void setComputerScore(String value) {
    	computerScore.setText("Computer Score: " + value);
    }
	
}
