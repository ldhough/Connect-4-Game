package connectmodeltests;

/**
 * Test Cases for Player Class
 * 
 */

import static org.junit.Assert.*;
import org.junit.Test;
import connectmodel.*;

public class TestPlayer
{
    /**
    * Tests to see if the correct default name is set up.
    */
    @Test
    public void testNoName() 
    {
        Player testPlayer = new Player("", PieceType.RED);
        assertTrue(testPlayer.getName().equals("JohnCena"));
    }

    /**
    * Makes sure special characters are banned.
    */
    @Test
    public void testSpecialCharacterName()
    {
        Player testPlayer = new Player("!", PieceType.RED);
        assertTrue(testPlayer.getName().equals("JohnCena"));
    }
    
    /**
    * Makes sure special characters are banned.
    */
    @Test
    public void testSpecialCharacterName2()
    {
        Player testPlayer = new Player("Br@ndon", PieceType.RED);
        assertTrue(testPlayer.getName().equals("JohnCena"));
    }
    
    /**
     * Tests to make sure a good name passes through.
     */
    @Test
    public void testGoodName()
    {
        Player testPlayer = new Player("Brandon", PieceType.RED);
        assertTrue(testPlayer.getName().equals("Brandon"));
    }
    
    /**
     * Tests to make sure a good name with numerals also passes through.
     */
    @Test
    public void testGoodNameWithNumbers()
    {
        Player testPlayer = new Player("Brandon123", PieceType.RED);
        assertTrue(testPlayer.getName().equals("Brandon123"));
    }
    
    /**
     * Tests to make sure a name with a space doesn't pass.
     */
    @Test
    public void testBadSpace()
    {
        Player testPlayer = new Player("Brandon B", PieceType.RED);
        assertTrue(testPlayer.getName().equals("JohnCena"));
    }
    
    /**
     * Tests to make sure a name with an underscore doesn't pass.
     */
    @Test
    public void testBadUnderscore()
    {
        Player testPlayer = new Player("Brandon_B", PieceType.RED);
        assertTrue(testPlayer.getName().equals("JohnCena"));
    }
    
    /**
     * Tests to make sure a name with a period doesn't pass.
     */
    @Test
    public void testBadPeriod()
    {
        Player testPlayer = new Player("Brandon.B", PieceType.RED);
        assertTrue(testPlayer.getName().equals("JohnCena"));
    }
    
    
    /**
     * Checks to see if the scoring works properly.
     */
    @Test
    public void testScoring()
    {
        Player testPlayer = new Player("JohnCena", PieceType.RED);
        testPlayer.incrementScore();
        testPlayer.incrementScore();
        assertTrue("Player score should equal 2!", testPlayer.getScore() == 2);
        testPlayer.incrementScore();
        assertTrue("Player score should equal 3!", testPlayer.getScore() == 3);
    }
    
    /**
     * Checks that the players piece type is set correctly
     */
	@Test
	public void testGetPieceType() 
	{
		Player player = new Player("Joe", PieceType.RED);
		assertTrue("Should have returned red piece type", player.getPieceType() == PieceType.RED);
	}
}
