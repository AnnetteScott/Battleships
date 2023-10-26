package battleships;

import battleships.GUI.DisplayBoard;
import javax.swing.JLabel;

/**
 *
 * @author gmt3870
 */
public class Round {
    private DisplayBoard enemyWaters;
    private DisplayBoard playerFleet;
    private Board playerBoard;
    private Board enemyBoard;
    private boolean playerTurn;
    private final Bot bot;
    private final Player player;
    private JLabel whoWon;
    
    public Round(Bot bot, Player player){
        this.playerTurn = true;
        this.bot = bot;
        this.player = player;
        this.playerBoard = new Board();
        this.enemyBoard = new Board();
    }
    
    public void setDisplayBoards(DisplayBoard enemyWaters, DisplayBoard playerFleet){
        this.enemyWaters = enemyWaters;
        this.playerFleet = playerFleet;
    }
    
    public void setWhoWonLabel(JLabel label){
        this.whoWon = label;
    }
    
    public void startRound(){
        this.getPlayerBoard().initialiseBoard();
        this.getEnemyBoard().initialiseBoard();
        this.playerTurn = true;
    }
    
    /**
     * the playerTurn to set
     */
    public void nextTurn() {
        enemyWaters.removeAll();
        enemyWaters.revalidate();
        enemyWaters.drawBoard();
        
        if(this.enemyBoard.allShipsSunk()){
            this.playerTurn = false;
            this.whoWon.setText("Player Wins!");
            System.out.println("Player Wins");
            return;
        }
        
        this.playerTurn = false;
        this.bot.takeTurn(playerBoard);
        playerFleet.removeAll();
        playerFleet.revalidate();
        playerFleet.drawBoard();
        
        if(this.playerBoard.allShipsSunk()){
            this.playerTurn = false;
            this.whoWon.setText("Bot Wins!");
            System.out.println("Bot Wins");
            return;
        }
        
        this.playerTurn = true;
    }
    
    /**
     * @return the playerTurn
     */
    public boolean isPlayerTurn() {
        return playerTurn;
    }

    /**
     * @return the playerBoard
     */
    public Board getPlayerBoard() {
        return playerBoard;
    }

    /**
     * @return the enemyBoard
     */
    public Board getEnemyBoard() {
        return enemyBoard;
    }
}
