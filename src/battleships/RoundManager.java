package battleships;

import java.util.HashMap;

/**
 *
 * @author gmt3870
 */
public class RoundManager {
    private final Player PLAYER;
    private final Bot BOT;
    private final Round ROUND;
    private final DBManager DB_MANAGER;
    

    public RoundManager(DBManager DB_Manager){
        this.DB_MANAGER = DB_Manager;
        HashMap<String, Integer> data = this.DB_MANAGER.getAllData();
        this.PLAYER = new Player(data.get("Player"));
        this.BOT = new Bot(data.get("Bot"));
        this.ROUND = new Round(this.getBOT(), this.getPLAYER(), this.DB_MANAGER);
    }
    
    

    /**
     * @return the currentRound
     */
    public Round getROUND() {
        return this.ROUND;
    }       

    /**
     * @return the PLAYER
     */
    public Player getPLAYER() {
        return PLAYER;
    }

    /**
     * @return the BOT
     */
    public Bot getBOT() {
        return BOT;
    }
}
