package hu.uszeged.inf.ui;

import hu.uszeged.inf.core.builder.ClassFinder;
import hu.uszeged.inf.core.builder.CoreBuilder;
import hu.uszeged.inf.core.builder.Operation;

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
       private boolean isVisible = false;




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

                if (parent_window.isLastCharANumber){
                    parent_window.processInput.append("}" + id);
                    parent_window.isLastCharANumber = false;
                    parent_window.textField.setText(parent_window.input.append(showingID).toString());
                }
                else {
                   parent_window.processInput.delete(parent_window.processInput.lastIndexOf("["), parent_window.processInput.lastIndexOf("]")+1);
                   parent_window.processInput.append(id);
                   parent_window.input.delete(parent_window.textField.getText().length()-1, parent_window.textField.getText().length());
                   parent_window.textField.setText(parent_window.input.append(showingID).toString());

                }
              System.out.println(parent_window.processInput.toString());
          });

              sorszam++;
       }
      
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
    }
}
