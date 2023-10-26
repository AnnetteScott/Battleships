package battleships;

import battleships.UI.DisplayBoard;

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
        
        this.playerTurn = false;
        this.bot.takeTurn(playerBoard);
        playerFleet.removeAll();
        playerFleet.revalidate();
        playerFleet.drawBoard();
        
        
        System.out.println(this.playerBoard.allShipsSunk());
        
        if(this.playerBoard.allShipsSunk()){
            this.playerTurn = false;
            System.out.println("Bot Wins");
            return;
        }
        else if(this.enemyBoard.allShipsSunk()){
            this.playerTurn = false;
            System.out.println("Player Wins");
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
