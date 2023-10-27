package battleships;

import java.util.Random;

/**
 * Bot with simple take turn functionality
 * @author gmt3870
 */
public class Bot extends Team{
    
    private final Random random;
    
    public Bot(int score){
        super("Bot", score);
        this.random = new Random();
    }
    
    /**
     * Randomly fire a shot at a board, only stopping when a valid shot was fired
     * @param board 
     */
    public void takeTurn(Board board){
        boolean valid = false;
        int x;
        int y;
        
        while(!valid){
            x = random.nextInt(board.getBOARD_LENGTH());
            y = random.nextInt(board.getBOARD_LENGTH());
            valid = board.fireShot(x, y);
        }
    }
}
