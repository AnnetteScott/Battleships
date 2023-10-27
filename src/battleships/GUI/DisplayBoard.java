package battleships.GUI;

import battleships.Board;
import battleships.PointState;
import battleships.RoundManager;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;

/**
 * Creates a JPanel and adds buttons to form a square grid
 * @author gmt3870
 */
public class DisplayBoard extends JPanel{

    private int BOARD_SIZE;
    private Board board;
    private boolean isPlayer;
    private RoundManager roundMng;

    public DisplayBoard(RoundManager roundMng, boolean isPlayer){
        this.roundMng = roundMng;
        if(isPlayer){
            this.board = roundMng.getROUND().getPlayerBoard();
        }else{
            this.board = roundMng.getROUND().getEnemyBoard();
        }
        this.isPlayer = isPlayer;
        this.BOARD_SIZE = this.board.getBOARD_LENGTH();
        
        setLayout(new GridLayout(BOARD_SIZE + 2, BOARD_SIZE + 2));
        setSize(300, 300);
        
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
                JButton cell = new JButton();
                cell.setOpaque(true);

                if(board.getGrid()[x][y].getState().equals(PointState.Hit)){
                    cell.setBackground(Color.RED);
                    cell.setEnabled(false);
                }else if(board.getGrid()[x][y].getState().equals(PointState.Miss)){
                    cell.setBackground(Color.GRAY);
                    cell.setEnabled(false);
                }else if(board.getGrid()[x][y].getState().equals(PointState.Ship) && isPlayer){
                    cell.setBackground(Color.BLACK);
                }else{
                    cell.setBackground(Color.WHITE);
                }
                
                if(!isPlayer){
                    final int row = x;
                    final int col = y;
                    cell.addActionListener((ActionEvent e) -> {
                        if(!roundMng.getROUND().isPlayerTurn()){
                            return;
                        }
                        boolean validShot = board.fireShot(row, col);
                        if(validShot){
                            roundMng.getROUND().nextTurn();
                        }
                        
                    });
                }else {
                    cell.setEnabled(false);
                }
                
                if(!roundMng.getROUND().isPlayerTurn()){
                    cell.setEnabled(false);
                }
                
                cell.setBorder(new MatteBorder(1, 1, 1, 1, Color.BLACK));
                cell.setPreferredSize(dim);
                
                add(cell);
            }
        }
    }
}
