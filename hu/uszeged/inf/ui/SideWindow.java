package hu.uszeged.inf.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import java.io.File;
import java.lang.reflect.*;
import java.util.ArrayList;


public class SideWindow {

       private int sorszam = 0;
       private MainFrame parent_window = null;
       private JFrame moreOperations = new JFrame();
       private GridBagConstraints gbc = new GridBagConstraints();
      public void makeNewButton (String id, String showingID) {
              Button newButton = new Button(id, showingID);
              gbc.gridy = sorszam/3+1;
              gbc.gridx = sorszam%3;
              moreOperations.add(newButton, gbc);
              newButton.setForeground(Color.LIGHT_GRAY);
              newButton.setBackground(Color.DARK_GRAY);
              newButton.setBorder(BorderFactory.createEmptyBorder());
              //newButton.setFont(newButton.getFont().deriveFont(18.0f));

          newButton.addActionListener(e -> {
                parent_window.textField.setText(parent_window.input.append(showingID).toString());
                parent_window.processInput.append(id);
              System.out.println(parent_window.processInput.toString());
          });

              sorszam++;
       }
       private boolean isVisible = false;

      
       public void toggle() {
              isVisible = !isVisible;
              moreOperations.setVisible(isVisible);
       }

      

    public SideWindow (MainFrame parent) {
    	parent_window = parent;
    	moreOperations.setType(javax.swing.JFrame.Type.UTILITY);
    		moreOperations.getContentPane().setBackground(Color.DARK_GRAY);
           moreOperations.setBounds(170, 200, 120, 700);
           moreOperations.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
           GridBagLayout grid = new GridBagLayout();
          
           moreOperations.setLayout(grid);
           gbc.fill = GridBagConstraints.BOTH;
           gbc.weightx = 1.0;
           gbc.weighty = 1.0;
           moreOperations.setUndecorated(true);
           moreOperations.setBackground(new Color(0x0));
           moreOperations.setForeground(new Color(0x0));
           moreOperations.setShape(new RoundRectangle2D.Double(0, 0, 120, 700, 15, 15));
           moreOperations.setResizable(false);
          


           /*JButton close = new JButton("X");
           close.setBackground(new Color(80, 0, 0));
           close.setForeground(Color.LIGHT_GRAY);
           close.addActionListener(e -> System.exit(0));
           moreOperations.add(close);*/


        /* CustomClassLoader classLoader = new CustomClassLoader();
        try {
            classLoader.findClass("SinusOperation.class");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }*/

    }
}
