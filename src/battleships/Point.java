package battleships;

/**
 * Point class for use within a grid or ship location data
 * @author gmt3870
 */
public class Point {
    private final int x;
    private final int y;
    private PointState state;
    
    public Point(int x, int y){
        this.x = x;
        this.y = y;
        this.state = PointState.Empty;
    }
    
    public Point(int x, int y, PointState state){
        this.x = x;
        this.y = y;
        this.state = state;
    }

    /**
     * @return the x
     */
    public int getX() {
        return x;
    }

    /**
     * @return the y
     */
    public int getY() {
        return y;
    }

    /**
     * @return the state
     */
    public PointState getState() {
        return state;
    }

    /**
     * @param state the state to set
     */
    public void setState(PointState state) {
        this.state = state;
    }
    
    
}
