package Package;


import Package.TypeofHells;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.io.*;


public class Main extends JPanel{
    
    JFrame main;
    Container pane;
    SpringLayout layout = new SpringLayout();
    TextField first = new TextField();
    TextField second = new TextField();
    TextField third = new TextField();
    TextField fourth = new TextField();
    TextField fifth = new TextField();
    Button calcButton;
    TextField exam1, exam2, exam3, exam4, exam5;
    int xc, yc;
    
    boolean debug = true;
    
    public static void main(String[] args) {
        //Ha, so you actually went to GitHub and looked up the code.
        //I am proud of you sir (or ma'am)
        Main f = new Main();
        f.mainRun();
    }
    public void mainRun() {
       main = new JFrame(); 
       main = new JFrame();
       main.setTitle("Main Menu");
       main.setSize(500,500);
       main.setVisible(true);
       main.setResizable(true);
       main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       main.setLocationRelativeTo(null);
       pane = main.getContentPane();
       pane.setLayout(layout);
       if(debug) main.addMouseListener(new PanelListener());
       //all the info for main is ready.
       
       calcButton = new Button();
       calcButton.setPreferredSize(new Dimension(30,30));
       calcButton.addActionListener(new c());
       pane.add(calcButton);
       
       exam1 = new TextField();textfields(exam1);
       
       exam2 = new TextField();textfields(exam2);
       
       exam3 = new TextField();textfields(exam3);
       
       exam4 = new TextField();textfields(exam4);
       
       exam5 = new TextField();textfields(exam5);
       
       
       layouts();
       
    }
    public void textfields(TextField t) {
        pane.add(t);
        t.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent ke) {
                //if(ke.)
            }

            @Override
            public void keyPressed(KeyEvent ke) {
             
            }

            @Override
            public void keyReleased(KeyEvent ke) {
                
            }
            
        });
    }
    
    public void layouts() {
        Layout(calcButton, 50, 50);
        Layout(exam1, 70,70);
        Layout(exam2, 70,90);
        Layout(exam3, 70,110);
        Layout(exam4, 70,130);
        Layout(exam5, 70,150);
    }
    private class PanelListener extends MouseAdapter {
        @Override
        public void mousePressed(MouseEvent e) {
            xc = e.getX();
            yc = e.getY();
            System.out.println("(" + (xc - 8) + ", " + (yc - 30) + ")");
        }
    }
    
    public void Layout(Component c, int x, int y) {
        layout.putConstraint(SpringLayout.WEST, c,x, SpringLayout.WEST, pane);
        layout.putConstraint(SpringLayout.NORTH, c,y,SpringLayout.NORTH, pane);
    }
    private static class c implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
        //calculations 
        }
        
    }
}
