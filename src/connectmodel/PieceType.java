package connectmodel;
/**
 * Class creates what colors are pieces
 * will be and allows us to use 
 * these types on are game board
 * 
 * @author Aaron Stewart
 *
 */
public enum PieceType 
{
	RED ("Red"),
	BLACK ("Black"),
	GREEN ("Green"),
	YELLOW ("Yellow");
    
	private String myType;
	/**
	 * method sets your type to any of the
	 * piece types available
	 * 
	 * @param type
	 */
    private PieceType(String type) 
    {
    	myType = type;
    }
    /**
     * method gets one of the types
     * 
     * @return your type
     */
    public String getType()
    {
    	return myType;
    }
}