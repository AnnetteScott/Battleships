package battleships;

import battleships.Ships.*;

/**
 * Single matrix that holds a fleet of ships
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
    
    /**
     * Create the board and place ships
     */
    public void initialiseBoard(){
        this.fleet = generateShips();
        this.grid = generateGrid(BOARD_LENGTH);
        
        for (int x = 0; x < BOARD_LENGTH; x++) {
            for (int y = 0; y < BOARD_LENGTH; y++) {
                grid[x][y] = new Point(x, y);
            }
        }
        
        ShipPlacer placer = new ShipPlacer();
        if(grid != null && fleet != null){
            placer.placeShips(grid, fleet);
        }
    }
    
    /**
     * Generate the board
     * @param length of the board
     * @return Point[][]
     */
    public Point[][] generateGrid(int length){
        Point[][] newGrid = new Point[length][length];
        
        for (int x = 0; x < length; x++) {
            for (int y = 0; y < length; y++) {
                newGrid[x][y] = new Point(x, y);
            }
        }
        
        return newGrid;
    }
    
    /**
     * Create a ship array
     * @return Ship[]
     */
    public Ship[] generateShips(){
        Ship[] ships = new Ship[SHIP_AMOUNT];
        ships[0] = new Carrier();
        ships[1] = new Battleship();
        ships[2] = new Destroyer();
        ships[3] = new Submarine();
        ships[4] = new Patrol();
        
        return ships;
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
    
    /**
     * Check if all ships are sunk
     * @return true if all are sunk, false otherwise
     */
    public boolean allShipsSunk() {
        for (Ship ship : fleet) {
            if (!ship.isSunk()) {
                return false;
            }
        }
        return true;
    }
    
    /**
     * Fire a shot at the grid and check if a ship was hit
     * @param x coordinate
     * @param y coordinate
     * @return false if invalid shot, true otherwise
     */
    public boolean fireShot(int x, int y){
        if (x < 0 || x >= BOARD_LENGTH || y < 0 || y >= BOARD_LENGTH) {            
            return false;
        }
        
        Point point = grid[x][y];
        
        if (point.getState().equals(PointState.Hit) || point.getState().equals(PointState.Miss)) {
            return false;
        }
        
        
        for(Ship ship : fleet){
            if(ship.isHit(x, y)){
                point.setState(PointState.Hit);
                break;
            }
        }
        
        if(!point.getState().equals(PointState.Hit)){
            point.setState(PointState.Miss);
        }
        
        return true;
    }
}
