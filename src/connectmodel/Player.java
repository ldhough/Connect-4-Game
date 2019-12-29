package connectmodel;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 * Player checks the name input 
 * and makes sure it is a valid name
 * and increments the score when
 * either computer or person wins
 * 
 * @author Aaron Stewart
 *
 */
public class Player
{
	public static final String DEFAULT_NAME = "JohnCena";
	private String myName;
	private int myNumWins;
	private PieceType myPieceType;
	/**
	 * method checks the name input
	 * and either sets it to default
	 * if it isnt valid or sets the name
	 * input as the name if it is valid
	 * 
	 * @param name String letters and numbers only
	 * @param type color of piece
	 */
	public Player(String name, PieceType type)
	{
	  myPieceType = type;
	  
	  if(validateName(name) == false || name.isEmpty())
	  {
		  myName = DEFAULT_NAME;
	  }
	  else
	  {
		  myName = name;
	  }
	}
	/**
	 * method makes it so that only names with
	 * letters and numbers will pass through
	 * 
	 * @param name string letters and numbers only
	 * @return true for good name, false for bad name
	 */
	private boolean validateName(String name) 
	{
		Pattern p = Pattern.compile("[^A-Za-z0-9]");
		Matcher m = p.matcher(name);
		boolean b = m.find();
		if(b == true)
		{
			return false;
		}
		else
		{
			return true;
		}
	}
	/**
	 * method increments computer or players score
	 */
	public void incrementScore() 
	{
		myNumWins++;
	}
	/**
	 * method that gets piece type
	 * 
	 * @return your piece type
	 */
	public PieceType getPieceType()
	{
		return myPieceType;
	}
	/**
	 * method gets name
	 * 
	 * @return your name you made
	 */
	public String getName() 
	{
		return myName;
	}
	/**
	 * method gets number of wins
	 * 
	 * @return number of wins player/computer have
	 */
	public int getScore()
	{
		return myNumWins;
	}
}