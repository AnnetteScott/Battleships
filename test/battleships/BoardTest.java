package battleships;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test the vital board functions
 * @author gmt3870
 */
public class BoardTest {
    
    public BoardTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of allShipsSunk method, of class Board.
     */
    @Test
    public void testAllShipsSunk() {
        Board instance = new Board();
        boolean expResult = false;
        boolean result = instance.allShipsSunk();
        assertEquals(expResult, result);
        
        for(Ship ship : instance.getFleet()){
            for(Point point : ship.getLocation()){
                point.setState(PointState.Hit);
            }
        }
        
        expResult = true;
        result = instance.allShipsSunk();
        assertEquals(expResult, result);
    }

    /**
     * Test of fireShot method, of class Board.
     */
    @Test
    public void testFireShot() {
        Board instance = new Board();
        
        int x = 0;
        int y = 0;
        boolean expResult = true;
        boolean result = instance.fireShot(x, y);
        assertEquals(expResult, result);
        
        x = 0;
        y = 0;
        expResult = false;
        result = instance.fireShot(x, y);
        assertEquals(expResult, result);
        
        x = 11;
        y = 0;
        expResult = false;
        result = instance.fireShot(x, y);
        assertEquals(expResult, result);
        
        x = -3;
        y = 20;
        expResult = false;
        result = instance.fireShot(x, y);
        assertEquals(expResult, result);
    }
    
}
