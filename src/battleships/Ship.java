package battleships;

/**
 *
 * @author gmt3870
 */
public abstract class Ship {
    private final int size;
    private final Point[] location;

    public Ship(int size, Point[] location){
        this.size = size;
        this.location = location;
    }
    
    /**
     * @return the size
     */
    public int getSize() {
        return size;
    }

    /**
     * @return the location
     */
    public Point[] getLocation() {
        return location;
    }
    
    public boolean isSunk(){
        boolean sunk = true;
        for(Point point : location){
            if(point.getState().equals(PointState.Ship)){
                sunk = false;
                break;
            }
        }
        return sunk;
    }
}
