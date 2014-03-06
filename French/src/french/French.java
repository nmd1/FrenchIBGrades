package french;

import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.io.*;


public class French extends JPanel{
    
    JFrame main;
    Container takePane;
    SpringLayout layout = new SpringLayout();
    
    public static void main(String[] args) {
        //Ha, so you actually went to GitHub and looked up the code.
        //I am proud of you sir (or ma'am)
        French f = new French();
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
