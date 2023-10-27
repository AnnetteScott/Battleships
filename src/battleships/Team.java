package battleships;

/**
 * Abstract class to provide basis for teams
 * @author gmt3870
 */
public abstract class Team {
    private final Board board;
    private final String name;
    private int score;

    public Team(String name, int score){
        this.name = name;
        this.score = score;
        this.board = new Board();
    }
    
    /**
     * @return the board
     */
    public Board getBoard() {
        return board;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the score
     */
    public int getScore() {
        return score;
    }
    
    /**
     * Update the score
     * @param points 
     */
    public void updateScore(int points){
        this.score += points;
    }
    
}
