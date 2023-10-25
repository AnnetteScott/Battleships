package battleships.UI;

import battleships.Board;
import battleships.PointState;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;

/**
 *
 * @author gmt3870
 */
public class DisplayBoard extends JPanel{

    private int BOARD_SIZE;
    private Board board;
    private boolean isPlayer;

    public DisplayBoard(int BOARD_SIZE, Board board, boolean isPlayer){
        setLayout(new GridLayout(BOARD_SIZE + 2, BOARD_SIZE + 2));
        setSize(300, 300);
        this.BOARD_SIZE = BOARD_SIZE;
        this.board = board;
        this.isPlayer = isPlayer;
        
        drawBoard();
    }

    public void drawBoard(){
        JLabel topCell = new JLabel();
        topCell.setBorder(new MatteBorder(1, 1, 1, 1, Color.BLACK));
        Dimension dim = new Dimension(45, 45);
        topCell.setPreferredSize(dim);
        add(topCell);
        
        for(int i = 0; i < BOARD_SIZE; i++){
            char letter = (char)('A' + i);
            JLabel display = new JLabel(String.valueOf(letter), SwingConstants.CENTER);
            display.setBorder(new MatteBorder(1, 1, 1, 1, Color.BLACK));
            display.setPreferredSize(dim);
            add(display);
        }
        
        for(int y = 0; y < BOARD_SIZE; y++){
            JLabel num = new JLabel(String.valueOf(y + 1), SwingConstants.CENTER);
            num.setBorder(new MatteBorder(1, 1, 1, 1, Color.BLACK));
            num.setPreferredSize(dim);
            add(num);
            
            for(int x = 0; x < BOARD_SIZE; x++){
                JLabel cell = new JLabel();
                cell.setOpaque(true);

                if(board.getGrid()[x][y].getState() == PointState.Hit){
                    cell.setBackground(Color.RED);
                }else if(board.getGrid()[x][y].getState() == PointState.Miss){
                    cell.setBackground(Color.GRAY);
                }else if(board.getGrid()[x][y].getState() == PointState.Ship && isPlayer){
                    cell.setBackground(Color.BLACK);
                }else{
                    cell.setBackground(Color.WHITE);
                }
                
                cell.setBorder(new MatteBorder(1, 1, 1, 1, Color.BLACK));
                cell.setPreferredSize(dim);
                
                add(cell);
            }
        }
    }
}
