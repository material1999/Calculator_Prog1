package hu.uszeged.inf.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import java.io.File;
import java.lang.reflect.*;
import java.util.ArrayList;


public class SideWindow {

       private int sorszam = 0;
       JFrame moreOperations = new JFrame();
      public void makeNewButton (String id, String showingID, GridBagConstraints gbc, JFrame frame) {
              Button newButton = new Button(id, showingID);
              gbc.gridy = sorszam/5+1;
              gbc.gridx = sorszam%5;
              frame.add(newButton, gbc);
              sorszam++;
       }
       private boolean isVisible = false;

       public boolean isVisible() {
              return isVisible;
       }

       public void setVisible() {
              isVisible = !isVisible;
       }

       public void toggle(JFrame frame) {
             frame.setVisible(!isVisible);
       }

    public SideWindow (JTextField textField) {




           moreOperations.setBounds(170, 200, 100, 700);
           moreOperations.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
           GridBagLayout grid = new GridBagLayout();
           GridBagConstraints gbc = new GridBagConstraints();
           moreOperations.setLayout(grid);
           gbc.fill = GridBagConstraints.BOTH;
           gbc.weightx = 1.0;
           gbc.weighty = 1.0;
           moreOperations.setUndecorated(true);
           moreOperations.setBackground(new Color(0x0));
           moreOperations.setForeground(new Color(0x0));
           moreOperations.setShape(new RoundRectangle2D.Double(0, 0, 100, 700, 15, 15));



           /*JButton close = new JButton("X");
           close.setBackground(new Color(80, 0, 0));
           close.setForeground(Color.LIGHT_GRAY);
           close.addActionListener(e -> System.exit(0));
           moreOperations.add(close);*/



           makeNewButton("asd", "asd", gbc, moreOperations);
           makeNewButton("asd", "asd", gbc, moreOperations);
           makeNewButton("asd", "asd", gbc, moreOperations);
           makeNewButton("asd", "asd", gbc, moreOperations);
           makeNewButton("asd", "asd", gbc, moreOperations);
           makeNewButton("asd", "asd", gbc, moreOperations);
           makeNewButton("asd", "asd", gbc, moreOperations);
           makeNewButton("asd", "asd", gbc, moreOperations);
           makeNewButton("asd", "asd", gbc, moreOperations);
           makeNewButton("asd", "asd", gbc, moreOperations);
           makeNewButton("asd", "asd", gbc, moreOperations);
           makeNewButton("asd", "asd", gbc, moreOperations);
           makeNewButton("asd", "asd", gbc, moreOperations);
           makeNewButton("asd", "asd", gbc, moreOperations);
           makeNewButton("asd", "asd", gbc, moreOperations);
           makeNewButton("asd", "asd", gbc, moreOperations);
           makeNewButton("asd", "asd", gbc, moreOperations);
           makeNewButton("asd", "asd", gbc, moreOperations);
           makeNewButton("asd", "asd", gbc, moreOperations);
           makeNewButton("asd", "asd", gbc, moreOperations);
           makeNewButton("asd", "asd", gbc, moreOperations);
           makeNewButton("asd", "asd", gbc, moreOperations);
           makeNewButton("asd", "asd", gbc, moreOperations);
           makeNewButton("asd", "asd", gbc, moreOperations);
           makeNewButton("asd", "asd", gbc, moreOperations);
           makeNewButton("asd", "asd", gbc, moreOperations);





























        /* CustomClassLoader classLoader = new CustomClassLoader();
        try {
            classLoader.findClass("SinusOperation.class");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }*/

    }
}
