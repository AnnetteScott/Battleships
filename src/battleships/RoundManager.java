package battleships;

/**
 *
 * @author gmt3870
 */
public class RoundManager {
    private Board playerBoard;
    private Board enemyBoard;

    public RoundManager(){
        this.playerBoard = new Board();
        this.enemyBoard = new Board();
    }

    /**
     * @return the playerBoard
     */
    public Board getPlayerBoard() {
        return this.playerBoard;
    }

    /**
     * @return the enemyBoard
     */
    public Board getEnemyBoard() {
        return this.enemyBoard;
    }

    public void restartRound(){
        this.playerBoard.initialiseBoard();
        this.enemyBoard.initialiseBoard();
    }

}
