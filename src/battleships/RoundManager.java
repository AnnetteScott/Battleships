package battleships;

/**
 *
 * @author gmt3870
 */
public class RoundManager {
    private final Player player;
    private final Bot bot;
    private final Round currentRound;
    

    public RoundManager(){
        this.player = new Player(0);
        this.bot = new Bot(0);
        this.currentRound = new Round(this.bot, this.player);
    }

    public void restartRound(){
        this.currentRound.startRound();
    }

    /**
     * @return the currentRound
     */
    public Round getCurrentRound() {
        return this.currentRound;
    }       
}
