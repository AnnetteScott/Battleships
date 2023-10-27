package battleships.GUI;

import battleships.RoundManager;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * @author gmt3870
 */
public class GamePage extends JPanel{
    
    public GamePage(RoundManager roundMng){
        setLayout(new BorderLayout());
        
        JPanel header = new JPanel();
        header.setLayout(new BorderLayout());
        
        JPanel buttons = new JPanel();
        
        JButton menuButton = new JButton("Menu");
        menuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainMenu mainMenu = (MainMenu) getParent().getComponent(0);
                mainMenu.updateScoreLabel(roundMng);
                        
                CardLayout cardLayout = (CardLayout) getParent().getLayout();
                cardLayout.show(getParent(), "Menu");
            }
        });
        menuButton.setFocusPainted(false);
        buttons.add(menuButton);
        
        DisplayBoard enemyWaters = new DisplayBoard(roundMng, false);
        DisplayBoard playerFleet = new DisplayBoard(roundMng, true);
        roundMng.getCurrentRound().setDisplayBoards(enemyWaters, playerFleet);
        
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
        buttons.add(restart);
                
        JPanel titles = new JPanel(new GridLayout(1, 2));
        JLabel enemyLabel = new JLabel("Enemy Waters", SwingConstants.CENTER);
        JLabel playerFleetLabel = new JLabel("Your Fleet", SwingConstants.CENTER);
        titles.add(enemyLabel);
        titles.add(playerFleetLabel);
        
        JLabel whoWon = new JLabel("");
        whoWon.setHorizontalAlignment(JLabel.CENTER);
        whoWon.setFont(new Font("Serif", Font.PLAIN, 30));
        whoWon.setForeground(Color.RED);
        roundMng.getCurrentRound().setWhoWonLabel(whoWon);
        
        header.add(buttons, BorderLayout.NORTH);
        header.add(titles, BorderLayout.CENTER);
        header.add(whoWon, BorderLayout.SOUTH);
        add(header, BorderLayout.NORTH);
        
        JPanel boards = new JPanel();
        boards.add(enemyWaters);
        boards.add(playerFleet);
        
        add(boards, BorderLayout.CENTER);
        
    }
}