package hu.uszeged.inf.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import java.io.File;
import java.lang.reflect.*;
import java.util.ArrayList;


public class SideWindow {

    public SideWindow (JTextField textField) {



           JFrame moreOperations = new JFrame();
           moreOperations.setBounds(170, 200, 50, 700);
           moreOperations.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
           moreOperations.setLayout(new GridLayout(2, 1));
           moreOperations.setUndecorated(true);
           moreOperations.setBackground(new Color(0x0));
           moreOperations.setForeground(new Color(0x0));
           moreOperations.setShape(new RoundRectangle2D.Double(0, 0, 50, 700, 15, 15));



           JButton close = new JButton("X");
           close.setBackground(new Color(80, 0, 0));
           close.setForeground(Color.LIGHT_GRAY);
           close.addActionListener(e -> System.exit(0));
           moreOperations.add(close);

           File actual = new File("hu/uszeged/inf/ui/plugin");
           ArrayList<String> files = new ArrayList<>();
           for( File f : actual.listFiles()){
                  files.add(f.getName());
           }






                  try {
                         Class c = Class.forName("Sin");
                         Field id = c.getField("id");
                         id.setAccessible(true);
                         Object value = id.get(new Object());
                         System.out.println(value);
                         /*Button newButton = new Button(id, showingID);
                         moreOperations.add(newButton);*/

                  } catch (Throwable e) {
                         e.printStackTrace();
                  }
























        moreOperations.setVisible(true);




        /* CustomClassLoader classLoader = new CustomClassLoader();
        try {
            classLoader.findClass("SinusOperation.class");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }*/

    }
}
