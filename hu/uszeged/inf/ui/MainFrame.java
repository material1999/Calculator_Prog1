package hu.uszeged.inf.ui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.RoundRectangle2D;
import java.io.IOException;

import hu.uszeged.inf.core.builder.*;
import hu.uszeged.inf.core.processer.Transform;

public class MainFrame extends JFrame {

    private boolean isLastCharANumber = true;
    private boolean isThereAComa = false;

    public MainFrame (CoreBuilder builder) {
        JFrame frame = new JFrame();
        GridBagLayout grid = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();
        frame.setLayout(grid);
        frame.setTitle("calc_ui_v1.0");
        frame.setUndecorated(true);
        frame.setBackground(new Color(0x0, true));
        frame.setShape(new RoundRectangle2D.Double(0, 0, 500, 700, 50, 50));









        final JTextField textField = new JTextField();
        textField.setBounds(new Rectangle(100, 800));
        textField.setBackground(new Color(45, 45, 45));
        textField.setForeground(Color.LIGHT_GRAY);
        textField.setFont(textField.getFont().deriveFont(34.0f));
        try {
            textField.setFont(Font.createFont(Font.TRUETYPE_FONT, MainFrame.class.getResourceAsStream("Roboto-Regular.ttf")));
        } catch (Exception e) {
            e.printStackTrace();
        }

        textField.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        textField.setHorizontalAlignment(SwingConstants.RIGHT);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 3;


        frame.add(textField, gbc);

        JButton exit  = new JButton("X");
        gbc.gridx = 3;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        frame.add(exit, gbc);
        exit.setBackground(new Color(80, 0, 0));
        exit.setForeground(Color.LIGHT_GRAY);
        exit.setFont(exit.getFont().deriveFont(34.0f));
        exit.setBorder(BorderFactory.createEmptyBorder());
        exit.addActionListener(e -> System.exit(0));

        JButton szam1 = new JButton("1");
        JButton szam2 = new JButton("2");
        JButton szam3 = new JButton("3");
        JButton szam4 = new JButton("4");
        JButton szam5 = new JButton("5");
        JButton szam6 = new JButton("6");
        JButton szam7 = new JButton("7");
        JButton szam8 = new JButton("8");
        JButton szam9 = new JButton("9");
        JButton szam0 = new JButton("0");
        JButton more = new JButton("...");
        JButton tizedesvesszo = new JButton(",");
        Button sum = new Button("[+]","+");
        Button sub = new Button("[-]","-");
        Button mult = new Button("[*]","*");
        Button div = new Button("[/]","/");
        Button percent = new Button("[%]","%");
        JButton delete = new JButton("C");
        JButton equals = new JButton("=");
        JButton deletestring = new JButton("CE");


        gbc.gridwidth = 1;


        JButton[] buttons = {delete, deletestring, percent, div, szam7, szam8, szam9, mult, szam4, szam5, szam6, sum,
                szam1, szam2, szam3, sub, more, szam0, tizedesvesszo, equals};

        for (int i=0; i<5; i++){
            for (int j = 0; j < 4; j++) {
                gbc.gridx = j;
                gbc.gridy = i+1;
                frame.add(buttons[i*4+j], gbc);
                buttons[i*4+j].setBackground(Color.DARK_GRAY);
                buttons[i*4+j].setForeground(Color.LIGHT_GRAY);
                buttons[i*4+j].setFont(buttons[i*4+j].getFont().deriveFont(34.0f));
                buttons[i*4+j].setBorder(BorderFactory.createEmptyBorder());
            }
        }
        StringBuilder input = new StringBuilder();
        StringBuilder processInput = new StringBuilder();
        processInput.append("{");
        JButton[] numberButtons = {szam0, szam1, szam2, szam3, szam4, szam5, szam6, szam7, szam8, szam9};
        Button[] operationButtons = {percent, div, mult, sum, sub};

        //nyomkodós gombok jelenjenek meg
        for (JButton i: numberButtons) {
            i.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    textField.setText(input.append(i.getText()).toString());
                    if (isLastCharANumber){
                        processInput.append(i.getText());
                        System.out.println(processInput.toString());
                    }
                    else {
                        processInput.append("{" + i.getText());
                        System.out.println(processInput.toString());
                    }
                    isLastCharANumber = true;
                    isThereAComa = false;

                }
            });
        }
        /////////////////////////////////////////////////////////

        for (Button operations: operationButtons
        ) {
            operations.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(isLastCharANumber){
                        textField.setText(input.append(operations.getText()).toString());
                        processInput.append("}" + operations.getID());
                        System.out.println(processInput.toString());
                        isLastCharANumber = false;
                    }
                    else {
                        input.setCharAt(textField.getText().length()-1, operations.getText().charAt(0));
                        textField.setText(input.toString());
                        processInput.delete(processInput.lastIndexOf("["),processInput.toString().length()-1);
                       processInput.append(operations.getID());

                    }

                }
            });
        }

        more.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                SideWindow sideWindow = new SideWindow(textField);
            }
        });


        ///////////////////////////////////////////////////////////

        //string torlese
        deletestring.addActionListener(e -> {
            textField.setText(input.delete(0, textField.getText().length()).toString());
            processInput.delete(0, processInput.length()).toString();
            processInput.append("{");
        });
        /////////////////////////////////////////////////////////
        //egy karakter torlese
        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    textField.setText(input.deleteCharAt(textField.getText().length()-1).toString());
                }
                catch (Exception ex) {

                }
                isLastCharANumber = true;
            }
        });

        tizedesvesszo.addActionListener(e -> {
            if (!isThereAComa){
                textField.setText(input.append(tizedesvesszo.getText()).toString());
                processInput.append(tizedesvesszo.getText()).toString();
                System.out.println(processInput);
                isThereAComa = true;
            }
        });


        ////////////////////////////////////////////
        /**
         * új inputnál törölni, majd újra hozzáfűzni
         * vesszőt megcsinálni
         *
         */
        equals.addActionListener(e ->  {
        	processInput.append("}=");
            for(String val : Transform.toReversePolishNotation(processInput.toString()/*IDE KELL*/ , builder)) {
                System.out.println(val);
            }
            System.out.println(processInput.toString());

        });

        frame.setBounds(300, 200, 500, 700);

        frame.setVisible(true);

        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

}
