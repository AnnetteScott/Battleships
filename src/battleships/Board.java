package battleships;

import battleships.Ships.*;

/**
 *
 * @author gmt3870
 */
public class Board {
    private Ship[] fleet;
    private Point[][] grid;
    private final int SHIP_AMOUNT = 5;
    private final int BOARD_LENGTH = 10;
    
    public Board(){
        initialiseBoard();
    }
    
    public void initialiseBoard(){
        this.fleet = new Ship[SHIP_AMOUNT];
        this.fleet[0] = new Carrier();
        this.fleet[1] = new Battleship();
        this.fleet[2] = new Destroyer();
        this.fleet[3] = new Submarine();
        this.fleet[4] = new Patrol();
        
        this.grid = new Point[BOARD_LENGTH][BOARD_LENGTH];
        
        for (int x = 0; x < BOARD_LENGTH; x++) {
            for (int y = 0; y < BOARD_LENGTH; y++) {
                grid[x][y] = new Point(x, y);
            }
        }
        
        ShipPlacer placer = new ShipPlacer();
        
        placer.placeShips(grid, fleet);
    }

    /**
     * @return the fleet
     */
    public Ship[] getFleet() {
        return fleet;
    }

    /**
     * @return the grid
     */
    public Point[][] getGrid() {
        return grid;
    }

    /**
     * @return the BOARD_LENGTH
     */
    public int getBOARD_LENGTH() {
        return BOARD_LENGTH;
    }
    
    
}
