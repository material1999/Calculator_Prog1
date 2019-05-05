
import hu.uszeged.inf.core.builder.*;
import hu.uszeged.inf.core.builder.operations.*;
import hu.uszeged.inf.core.processer.Transform;
import hu.uszeged.inf.ui.*;

import java.awt.*;


import java.awt.event.ActionListener;

public class Main {

    public static void main (String[] args) {
    	CoreBuilder builder = new CoreBuilder(); 
        MainFrame calc = new MainFrame(builder);
        builder.setTargetUI(calc);
        calc.setVisible(true);





        /**
         * to-do
         *
         * uj muveletnel uj gomb
         * ne lehessen betut beleirni
         * font
         * draggable
         * ne nyiljon meg tobbszor a kis ablak
         */






    }

}
