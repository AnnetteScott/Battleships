package battleships.GUI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * @author gmt3870
 */
public class MainMenu extends JPanel {

    public MainMenu() {
        setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridwidth = GridBagConstraints.REMAINDER;
        constraints.anchor = GridBagConstraints.NORTH;

        add(new JLabel("<html><h1><strong>Battleships</strong></h1></html>"), constraints);

        constraints.anchor = GridBagConstraints.CENTER;
        constraints.fill = GridBagConstraints.HORIZONTAL;

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
        
        JButton highScores = new JButton("<html><h2>High Scores</h2></html>");
        highScores.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) getParent().getLayout();
                cardLayout.show(getParent(), "Scores");
            }
        });  
        
        JPanel buttons = new JPanel(new GridBagLayout());
        buttons.add(startButton, constraints);
        buttons.add(highScores, constraints);
        
        constraints.weighty = 1;
        add(buttons, constraints);
    }
}
