package battleships;

import battleships.GUI.DisplayBoard;
import java.util.HashMap;
import javax.swing.JLabel;

/**
 * Contains all current round data, allowing it to be reset when needed
 * @author gmt3870
 */
public class Round {
    private DisplayBoard enemyWaters;
    private DisplayBoard playerFleet;
    private final Board playerBoard;
    private final Board enemyBoard;
    private boolean playerTurn;
    private final Bot bot;
    private final Player player;
    private JLabel whoWon = null;
    private final DBManager DB_Manager;
    
    public Round(Bot bot, Player player, DBManager DB_Manager){
        this.playerTurn = true;
        this.bot = bot;
        this.player = player;
        this.playerBoard = new Board();
        this.enemyBoard = new Board();
        this.DB_Manager = DB_Manager;
    }
    
    /**
     * Set the DisplayBoard variables for use later.
     * @param enemyWaters
     * @param playerFleet 
     */
    public void setDisplayBoards(DisplayBoard enemyWaters, DisplayBoard playerFleet){
        this.enemyWaters = enemyWaters;
        this.playerFleet = playerFleet;
    }
    
    /**
     * Set the who won label for use later
     * @param label 
     */
    public void setWhoWonLabel(JLabel label){
        this.whoWon = label;
    }
    
    /**
     * Start a round, clearing all current data beyond what is default
     */
    public void startRound(){
        this.getPlayerBoard().initialiseBoard();
        this.getEnemyBoard().initialiseBoard();
        this.playerTurn = true;
        if(this.whoWon != null){
            this.whoWon.setText("");
        }
    }
    
    /**
     * Updates the enemy board to reflect user firing shot
     * Checks if the player has sunk all the ships and proceed to end of game state
     * Otherwise the bot takes it's turn
     */
    public void nextTurn() {
        enemyWaters.removeAll();
        enemyWaters.revalidate();
        enemyWaters.drawBoard();
        
        if(this.enemyBoard.allShipsSunk()){
            this.playerTurn = false;
            this.player.updateScore(10);
            updateData();
            this.whoWon.setText("Player Wins!");
            System.out.println("Player Wins");
            return;
        }
        
        this.playerTurn = false;
        if(!botTurn()){
            this.playerTurn = true;
        }
    }
    
    /**
     * Bot takes it's tun, checks if it sunk all of the ships
     * If it has, proceed to end of game state, otherwise the player can take their turn
     * @return true if the bot won, false otherwise
     */
    private boolean botTurn(){
        this.bot.takeTurn(playerBoard);
        playerFleet.removeAll();
        playerFleet.revalidate();
        playerFleet.drawBoard();
        
        if(this.playerBoard.allShipsSunk()){
            this.playerTurn = false;
            this.bot.updateScore(10);
            updateData();
            this.whoWon.setText("Bot Wins!");
            System.out.println("Bot Wins");
            return true;
        }
        return false;
    }
    
    /**
     * Create a HashMap of the team data and pass it to the database manager
     * for updating
     */
    private void updateData(){
        HashMap<String, Integer> data = new HashMap<>();
        data.put(this.player.getName(), this.player.getScore());
        data.put(this.bot.getName(), this.bot.getScore());
        
        this.DB_Manager.updateData(data);
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