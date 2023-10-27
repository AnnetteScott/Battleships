package battleships;

import battleships.GUI.*;
import javax.swing.*;
import java.awt.*;

/**
 *
 * @author gmt3870
 */
public class Battleships {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setResizable(false);
        frame.setTitle("Battleships");
        frame.setSize(1200, 700);
        frame.setLocation(1500, 100);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		RoundManager roundMng = new RoundManager();

        MainMenu mainMenu = new MainMenu();
        GamePage gamePage = new GamePage(roundMng);

        CardLayout cardLayout = new CardLayout();
        JPanel mainPanel = new JPanel(cardLayout);
        mainPanel.add(mainMenu, "Menu");
        mainPanel.add(gamePage, "Game");

        cardLayout.show(mainPanel, "Menu");

        frame.add(mainPanel);

        frame.setVisible(true);

    }
    
}
