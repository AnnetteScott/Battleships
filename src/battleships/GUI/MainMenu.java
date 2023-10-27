package battleships.GUI;

import battleships.RoundManager;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * @author gmt3870
 */
public class MainMenu extends JPanel {
    private JLabel playerScore;
    private JLabel botScore;

    public MainMenu(RoundManager roundMng) {
        setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridwidth = GridBagConstraints.REMAINDER;
        constraints.anchor = GridBagConstraints.NORTH;

        add(new JLabel("<html><h1><strong>Battleships</strong></h1></html>"), constraints);


        JButton startButton = new JButton("<html><h1><strong>Start Game</strong></h1></html>");
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) getParent().getLayout();
                cardLayout.show(getParent(), "Game");
            }
        });
        startButton.setBackground(new Color(23, 188, 22));
        startButton.setForeground(Color.WHITE);
        startButton.setFocusPainted(false);  
        
        JPanel buttons = new JPanel(new GridBagLayout());
        buttons.add(startButton, constraints);
        
        constraints.weighty = 1;
        
        JPanel scores = new JPanel(new GridLayout(1, 2));
        
        this.playerScore = new JLabel("Player Score: " + roundMng.getPLAYER().getScore(), SwingConstants.CENTER);
        this.botScore = new JLabel("Bot Score: " + roundMng.getBOT().getScore(), SwingConstants.CENTER);
        
        scores.add(this.playerScore);
        scores.add(this.botScore);
        add(scores, constraints);
        
        add(buttons, constraints);
    }
    
    public void updateScoreLabel(RoundManager roundMng){
        this.playerScore.setText("Player Score: " + roundMng.getPLAYER().getScore());
        this.botScore.setText("Bot Score: " + roundMng.getBOT().getScore());
    }
    
}
