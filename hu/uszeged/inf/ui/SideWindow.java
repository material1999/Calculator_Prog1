package hu.uszeged.inf.ui;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class SideWindow {
    /*private boolean exists = false;

    public void flipExists() {
        this.exists = !this.exists;
    }
    */

    public SideWindow (JTextField textField) {



           JFrame moreOperations = new JFrame();
           moreOperations.setBounds(170, 200, 50, 700);
           moreOperations.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
           moreOperations.setLayout(new GridLayout(2, 1));
           moreOperations.setUndecorated(true);
           moreOperations.setBackground(new Color(0x0));
           moreOperations.setForeground(new Color(0x0));
           moreOperations.setShape(new RoundRectangle2D.Double(0, 0, 50, 700, 15, 15));



           JButton asd = new JButton("asd");
           moreOperations.add(asd);












        moreOperations.setVisible(true);




        /* CustomClassLoader classLoader = new CustomClassLoader();
        try {
            classLoader.findClass("SinusOperation.class");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }*/

    }
}
