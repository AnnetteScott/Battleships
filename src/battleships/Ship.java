package battleships;

/**
 *
 * @author gmt3870
 */
public abstract class Ship {
    private final int size;
    private Point[] location;

    public Ship(int size){
        this.size = size;
        this.location = new Point[size];
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
        return this.location;
    }
    
    /**
     * @param location the location to set
     */
    public void setLocation(Point[] location) {
        this.location = location;
    }
    
    /**
     * check if the ship has been hit
     * @param x int coordinate of the shot
     * @param y int coordinate of the shot
     * @return whether the ship was hit or not
     */
    public boolean isHit(int x, int y){
        for(Point point : this.location){
            if(point.getX() == x && point.getY() == y){
                point.setState(PointState.Hit);
                return true;
            }
        }
        return false;
    }
    
    /**
     * Whether the ship has been sunk
     * @return Boolean
     */
    public boolean isSunk(){
        boolean sunk = true;
        for(Point point : this.location){
            if(point.getState().equals(PointState.Ship)){
                sunk = false;
                break;
            }
        }
        return sunk;
    }
}
