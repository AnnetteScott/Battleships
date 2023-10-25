package battleships;

/**
 *
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
