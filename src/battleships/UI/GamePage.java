package battleships.UI;

import battleships.RoundManager;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * @author gmt3870
 */
public class GamePage extends JPanel{
    
    public GamePage(RoundManager roundMng){
        setLayout(new FlowLayout(FlowLayout.CENTER, 30, 20));
        
        JPanel header = new JPanel();
        header.setSize(1200, 40);
        header.setPreferredSize(new Dimension(1200, 40));
        
        JButton menuButton = new JButton("Menu");
        menuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) getParent().getLayout();
                cardLayout.show(getParent(), "Menu");
            }
        });
        menuButton.setFocusPainted(false);
        header.add(menuButton);
        
        DisplayBoard enemyWaters = new DisplayBoard( roundMng.getEnemyBoard().getBOARD_LENGTH(), roundMng.getEnemyBoard(), false);
        DisplayBoard playerFleet = new DisplayBoard( roundMng.getPlayerBoard().getBOARD_LENGTH(), roundMng.getPlayerBoard(), true);

        JButton restart = new JButton("Restart");
        restart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                roundMng.restartRound();
                enemyWaters.removeAll();
                enemyWaters.revalidate();
                enemyWaters.drawBoard();

                playerFleet.removeAll();
                playerFleet.revalidate();
                playerFleet.drawBoard();
            }
        });
        restart.setFocusPainted(false);
        header.add(restart);
        
        add(header);
        
        JPanel titles = new JPanel();
        titles.setLayout(new GridLayout(1, 2));
        titles.setSize(1200, 40);
        titles.setPreferredSize(new Dimension(1200, 40));
        JLabel enemyLabel = new JLabel("Enemy Waters", SwingConstants.CENTER);
        JLabel playerFleetLabel = new JLabel("Your Fleet", SwingConstants.CENTER);
        titles.add(enemyLabel);
        titles.add(playerFleetLabel);
        
        add(titles);
        
        add(enemyWaters);
        add(playerFleet);
    }
}