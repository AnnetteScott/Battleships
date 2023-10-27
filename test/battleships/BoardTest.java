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
        //Test if all the ships are not sunk
        Board instance = new Board();
        boolean expResult = false;
        boolean result = instance.allShipsSunk();
        assertEquals(expResult, result);
        
        //Sink the ships
        for(Ship ship : instance.getFleet()){
            for(Point point : ship.getLocation()){
                point.setState(PointState.Hit);
            }
        }
        
        //Test if all the ships are sunk
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
        
        //Test valid shot coordinates
        int x = 0;
        int y = 0;
        boolean expResult = true;
        boolean result = instance.fireShot(x, y);
        assertEquals(expResult, result);
        
        //Test valid shot coordinates but should now return false as the point 
        //has already been shot at
        x = 0;
        y = 0;
        expResult = false;
        result = instance.fireShot(x, y);
        assertEquals(expResult, result);
        
        //Test out of bound x
        x = 11;
        y = 0;
        expResult = false;
        result = instance.fireShot(x, y);
        assertEquals(expResult, result);
        
        //Test out of bound x and y
        x = -3;
        y = 20;
        expResult = false;
        result = instance.fireShot(x, y);
        assertEquals(expResult, result);
    }
    
}
