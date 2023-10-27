package battleships;

import battleships.GUI.*;
import javax.swing.*;
import java.awt.*;

/**
 * Main entry point for application
 * @author gmt3870
 */
public class Battleships {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Init managers
        DBManager dbMng = new DBManager();
        RoundManager roundMng = new RoundManager(dbMng);
        
        //Create and show frame for GUI
        JFrame frame = new JFrame();
        frame.setResizable(false);
        frame.setTitle("Battleships");
        frame.setSize(1200, 700);
        frame.setLocation(1500, 100);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        MainMenu mainMenu = new MainMenu(roundMng);
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
