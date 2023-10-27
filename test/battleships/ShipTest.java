package battleships;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test the vital ship functions
 * @author gmt3870
 */
public class ShipTest {
    
    public ShipTest() {
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
     * Test of isHit method, of class Ship.
     */
    @Test
    public void testIsHit() {
        Ship instance = new ShipImpl();
        Point[] location = new Point[2];
        location[0] = new Point(0, 0);
        location[1] = new Point(0, 1);
        instance.setLocation(location);
        
        int x = 0;
        int y = 5;
        boolean expResult = false;
        boolean result = instance.isHit(x, y);
        assertEquals(expResult, result);
        
        x = 0;
        y = 0;
        expResult = true;
        result = instance.isHit(x, y);
        assertEquals(expResult, result);
        
        x = 0;
        y = 0;
        expResult = true;
        result = instance.isHit(x, y);
        assertEquals(expResult, result);
        
        x = 0;
        y = -1;
        expResult = false;
        result = instance.isHit(x, y);
        assertEquals(expResult, result);
    }

    /**
     * Test of isSunk method, of class Ship.
     */
    @Test
    public void testIsSunk() {
        System.out.println("isSunk");
        Ship instance = new ShipImpl();
        Point[] location = new Point[2];
        location[0] = new Point(0, 0);
        location[1] = new Point(0, 1);
        location[0].setState(PointState.Ship);
        location[1].setState(PointState.Ship);
        instance.setLocation(location);
        
        
        boolean expResult = false;
        boolean result = instance.isSunk();
        assertEquals(expResult, result);
        
        
        instance.getLocation()[0].setState(PointState.Hit);
        expResult = false;
        result = instance.isSunk();
        assertEquals(expResult, result);
        
        
        instance.getLocation()[1].setState(PointState.Hit);
        expResult = true;
        result = instance.isSunk();
        assertEquals(expResult, result);
    }

    public class ShipImpl extends Ship {

        public ShipImpl() {
            super(2);
        }
    }
    
}
