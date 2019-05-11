package hu.uszeged.inf.ui;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

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















        moreOperations.setVisible(true);




        /* CustomClassLoader classLoader = new CustomClassLoader();
        try {
            classLoader.findClass("SinusOperation.class");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }*/

    }
}
