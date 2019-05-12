package hu.uszeged.inf.ui;
import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.RoundRectangle2D;
import java.io.IOException;
import java.math.BigDecimal;

import hu.uszeged.inf.core.builder.*;
import hu.uszeged.inf.core.processer.Transform;

public class MainFrame extends JFrame {
	//private CoreBuilder builder = CoreBuilder.getInstance(this);
    private CoreBuilder builder = new CoreBuilder(this);
	private static MainFrame instance = null; 
    public boolean isLastCharANumber = true;
    public boolean isThereAComa = false;
    private boolean isThereAlreadyAComa = false;
    final JTextField textField = new JTextField();
    StringBuilder processInput = new StringBuilder();
    StringBuilder input = new StringBuilder();
    SideWindow sideWindow = new SideWindow(this);
    Timer timer = null;
    private Point initialClick;


    public static  MainFrame getInstance() { // Singleton
    	if(instance == null) {
    		instance = new MainFrame();
    	}
    	instance.setVisible(true);
    	return instance;
    }
    
    public void finalize() {
        instance = null;
      }
    
    public void makeNewButton(String id, String showingID) {
    	 sideWindow.makeNewButton(id,showingID);
    }

    private MainFrame () {
        JFrame frame = new JFrame();
        GridBagLayout grid = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();
        frame.setLayout(grid);
        frame.setTitle("calc_ui_v1.0");
        frame.setUndecorated(true);
        frame.setBackground(new Color(0x0, true));
        frame.setShape(new RoundRectangle2D.Double(0, 0, 500, 700, 50, 50));
        
        this.builder.loadOperation();
        JTextField move = new JTextField();

        move.setBounds(new Rectangle(100, 800));        
        move.setBackground(new Color(45, 45, 45));
        move.setForeground(Color.LIGHT_GRAY);
        move.setFont(move.getFont().deriveFont(34.0f));
        move.setBorder(BorderFactory.createEmptyBorder());
        move.setEditable(false);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 3;
        gbc.gridheight = 1;
        frame.add(move,gbc);
        
        /// Need to work on :(
        move.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
            	if(e.getButton() == MouseEvent.BUTTON1) {
            		 initialClick = e.getPoint();            		
            	}
            }
            public void mouseDragged(MouseEvent e) {
            	 move.setText("drag");
                int thisX = frame.getLocation().x;
                int thisY = frame.getLocation().y;

                int xMoved = e.getX() - initialClick.x;
                int yMoved = e.getY() - initialClick.y;

                int X = thisX + xMoved;
                int Y = thisY + yMoved;
                frame.setLocation(X, Y);
            }
        });

       
        JButton exit  = new JButton();
        gbc.gridx = 3;
        gbc.gridy = 0;
        gbc.gridwidth = 4;
        frame.add(exit, gbc);
        exit.setBackground(new Color(80, 0, 0));
        exit.setForeground(Color.LIGHT_GRAY);
        exit.setFont(exit.getFont().deriveFont(34.0f));
        exit.setBorder(BorderFactory.createEmptyBorder());
        exit.addActionListener(e -> System.exit(0));
             
        
        textField.setBounds(new Rectangle(100, 800));
        textField.setBackground(new Color(45, 45, 45));
        textField.setForeground(Color.LIGHT_GRAY);
        textField.setFont(textField.getFont().deriveFont(34.0f));
        textField.setEditable(false);
        textField.setHorizontalAlignment(SwingConstants.RIGHT);
        /*try {
            textField.setFont(Font.createFont(Font.TRUETYPE_FONT, MainFrame.class.getResourceAsStream("Roboto-Regular.ttf")));
        } catch (Exception e) {
            e.printStackTrace();
        }*/

        textField.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        gbc.gridheight = 1;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 4;

        frame.add(textField, gbc);     


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
                gbc.gridy = i+2;
                frame.add(buttons[i*4+j], gbc);
                buttons[i*4+j].setBackground(Color.DARK_GRAY);
                buttons[i*4+j].setForeground(Color.LIGHT_GRAY);
                buttons[i*4+j].setFont(buttons[i*4+j].getFont().deriveFont(34.0f));
                buttons[i*4+j].setBorder(BorderFactory.createEmptyBorder());
            }
        }

        processInput.append("{");
        JButton[] numberButtons = {szam0, szam1, szam2, szam3, szam4, szam5, szam6, szam7, szam8, szam9};
        Button[] operationButtons = {percent, div, mult, sum, sub};

        ///////////////////Number Buttons//////////////////////

        for (JButton i: numberButtons) {
            i.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    input.append(i.getText());
                    textField.setText(String.valueOf(input.toString()).replace(".", ","));
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

        ////////////////////////Operation Buttons/////////////////////////////////

        for (Button operations: operationButtons) {
            operations.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(isLastCharANumber){
                        textField.setText(String.valueOf(input.append(operations.getText()).toString()).replace(".", ","));
                        processInput.append("}" + operations.getID());
                        System.out.println(processInput.toString());
                    	isLastCharANumber = false;
                    }
                    else {
                    	String delete = processInput.substring(processInput.lastIndexOf("["),processInput.length());                     	
                    	delete = builder.getShowingId(delete.substring(1, delete.length()-1));                   	
                    	input.replace(input.lastIndexOf(delete),input.lastIndexOf(delete)+ delete.length(),"");                    
                    	input.append(operations.getText());
                        textField.setText(String.valueOf(input.toString()).replace(".", ","));
                    	processInput.delete(processInput.lastIndexOf("["),processInput.toString().length());
                    	processInput.append(operations.getID());
                    }
                    isThereAlreadyAComa = false;
                }
            });
        }
        
        ////////////////////////Side Window/////////////////////////////////
       
        more.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                sideWindow.toggle();
                builder.loadOperation();
            }
        });

        /////////////////////////////Other Buttons//////////////////////////////

        //delete whole input
        deletestring.addActionListener(e -> {
            input.setLength(0);
            textField.setText(String.valueOf(input.toString()).replace(".", ","));
            processInput.setLength(0);
            processInput.append("{");
            isLastCharANumber = true;
            isThereAComa = false;
            isThereAlreadyAComa = false;
        });
        
        // delete last input
        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    input.deleteCharAt(textField.getText().length()-1);
                    textField.setText(String.valueOf(input.toString()).replace(".", ","));
                    if (isLastCharANumber) {
                        processInput.deleteCharAt(processInput.toString().length() - 1);
                        isLastCharANumber = true;
                        if (processInput.charAt(processInput.toString().length() - 1) == '{') {
                            processInput.deleteCharAt(processInput.toString().length() - 1);
                            isLastCharANumber = false;
                        }
                    } else {
                        processInput.delete(processInput.lastIndexOf("}"), processInput.toString().length());
                        isLastCharANumber = true;
                    }   
                }
                catch (Exception ex) {

                }
            }
        });

        // decimal point
        tizedesvesszo.addActionListener(e -> {
            if (!isThereAComa && !isThereAlreadyAComa){
                textField.setText(input.append(',').toString());
                processInput.append('.').toString();
                System.out.println(processInput);
                isThereAComa = true;
                isThereAlreadyAComa = true;
            }
        });

        // if equals button is pressed, then call methods to count the result
        equals.addActionListener(e ->  {
        	if (isLastCharANumber) {
        		processInput.append("}=");
        	} else {
        		processInput.append("=");
        	}

            ArrayList<String> test = Transform.toReversePolishNotation(processInput.toString(), builder);
            System.out.println(test);

        	double result = builder.process(processInput.toString());
        	if( result % 1 == 0) {
        		textField.setText("" + (int)result);
        	}else {
        		String resulttext = String.valueOf(result).replace(".", ",");
        		textField.setText(resulttext);
        	}
        	input.setLength(0);
            processInput.setLength(0);
            processInput.append("{");
        	if (result % 1 == 0) {
        		input.append((int)result);
                processInput.append((int)result);
        	} else {
        		input.append(result);
                processInput.append(result);
        	}
        	isLastCharANumber = true; 
        	
        });

        frame.setBounds(300, 200, 500, 700);

        frame.setVisible(true);

        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

}
