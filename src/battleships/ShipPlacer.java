package battleships;

import java.util.Random;

/**
 *
 * @author gmt3870
 */
public class ShipPlacer {
    
    public void placeShips(Point[][] grid, Ship[] fleet){
        Random random = new Random();
        for(Ship ship : fleet){
            int x = random.nextInt(grid.length);
            int y = random.nextInt(grid.length);
            boolean vertical = random.nextBoolean();
            
            while(!validPlacement(ship, x, y, vertical, grid)){
                x = random.nextInt(grid.length);
                y = random.nextInt(grid.length);
                vertical = random.nextBoolean();
            }
            
            Point[] location = new Point[ship.getSize()];
            
            for(int i = 0; i < ship.getSize(); i++){
                if(vertical){
                    grid[x + i][y].setState(PointState.Ship);
                    location[i] = new Point(x + i, y, PointState.Ship);
                }
                else {
                    grid[x][y + i].setState(PointState.Ship);
                    location[i] = new Point(x, y + i, PointState.Ship);
                }
            }
            
            ship.setLocation(location);
        }
    }
    
    /**
     * Check if coordinates are valid
     * @param ship Ship object
     * @param x int coordinate to place ship
     * @param y int coordinate to place ship
     * @param isVertical Boolean of whether the ship if vertical or not
     * @param grid the board grid
     * @return Boolean if valid placement, false otherwise
     */
    private boolean validPlacement(Ship ship, int x, int y, boolean isVertical, Point[][] grid){
        if(isVertical && x + ship.getSize() > grid.length){
            return false;
        }
        else if (!isVertical && y + ship.getSize() > grid.length) {
            return false;
        }
        
        for(int i = 0; i < ship.getSize(); i++){
            if(isVertical && grid[x + i][y].getState().equals(PointState.Ship)){
               return false;
            }
            else if(!isVertical && grid[x][y + i].getState().equals(PointState.Ship)){
                return false;
            }
        }
        return true;
    }
}
