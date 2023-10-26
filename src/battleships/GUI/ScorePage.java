package battleships.GUI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * @author gmt3870
 */
public class ScorePage extends JPanel{
    
    public ScorePage(){
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
        add(header);
    }
}