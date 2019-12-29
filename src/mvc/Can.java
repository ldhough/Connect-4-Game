package mvc;
import java.awt.*;

/**
 * The Can class provides the implementation for updating the appearance of board elements
 * 
 * Due Date: 04/12/2019
 * 
 * @author Lannie Dalton Hough III
 * @version 1.0
 */

@SuppressWarnings("serial")
public class Can extends Canvas
{
	private Image myImage;
    private String myValue;
    
	/**
	 * Constructs Can object
	 */
    
    public Can(String value)
    {
        myImage = null;
        myValue = value;
    }
    
    public Can(Image image)
    {
        myImage = image;
        myValue = null;
    }
    
	/**
	 * Draws items on the board
	 */
    
    public void paint(Graphics g)
    {
        if(myValue==null)
        {
            g.drawImage(myImage, 0, 0, this);
        }
        else
        {
            g.setColor(Color.red);
            g.drawString(myValue,20,20); 
        }
    }
    
	/**
	 * Allows the board pieces to be updated
	 */
    
    public void setImage(Image data)
    {
      myImage = data;
      this.repaint();
    }
}