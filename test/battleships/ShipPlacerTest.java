package battleships;

import battleships.Ships.Carrier;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author gmt3870
 */
public class ShipPlacerTest {
    private static Point[][] grid;
    private static Ship[] fleet;
    
    public ShipPlacerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        Board board = new Board();
        grid = board.generateGrid(10);
        fleet = board.generateShips();
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
     * Test of validPlacement method, of class ShipPlacer.
     */
    @Test
    public void testValidPlacement() {
        Ship ship = new Carrier();
        ShipPlacer instance = new ShipPlacer();
        
        int x = 11;
        int y = 0;
        boolean isVertical = false;
        boolean expResult = false;
        boolean result = instance.validPlacement(ship, x, y, isVertical, grid);
        assertEquals(expResult, result);
        
        x = 5;
        y = -2;
        isVertical = true;
        expResult = false;
        result = instance.validPlacement(ship, x, y, isVertical, grid);
        assertEquals(expResult, result);
        
        x = 5;
        y = 5;
        isVertical = true;
        expResult = true;
        result = instance.validPlacement(ship, x, y, isVertical, grid);
        assertEquals(expResult, result);
        
        x = 5;
        y = 9;
        isVertical = true;
        expResult = false;
        result = instance.validPlacement(ship, x, y, isVertical, grid);
        assertEquals(expResult, result);
        
        x = 5;
        y = 9;
        isVertical = false;
        expResult = true;
        result = instance.validPlacement(ship, x, y, isVertical, grid);
        assertEquals(expResult, result);
    }
    
}
