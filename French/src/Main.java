

import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.io.*;


public class Main extends JPanel{
    
    JFrame main;
    Container takePane;
    SpringLayout layout = new SpringLayout();
    TextField first = new TextField();
    TextField second = new TextField();
    TextField third = new TextField();
    TextField fourth = new TextField();
    TextField fifth = new TextField();
    
    
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
       //all the info for main is ready.
    }
    
    
    public void Layout(Component c, int x, int y) {
        layout.putConstraint(SpringLayout.WEST, c,x, SpringLayout.WEST, takePane);
        layout.putConstraint(SpringLayout.NORTH, c,y,SpringLayout.NORTH, takePane);
    }
}
