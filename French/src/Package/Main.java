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
    JTextField exam1, exam2, exam3, exam4, exam5, total;
    Choice classes;
    JLabel lbl1, lbl2, lbl3, lbl4, lbl5, askl;
    ArrayList<Integer> marker = new ArrayList<>();
    
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
       main.setResizable(true);
       main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       main.setLocationRelativeTo(null);
       pane = main.getContentPane();
       pane.setLayout(layout);
       if(debug) main.addMouseListener(new PanelListener());
       //all the info for main is ready.
       
       //Components
       calcButton = new Button("Calculate Results");
       calcButton.setPreferredSize(new Dimension(110,50));
       calcButton.addActionListener(new c());
       pane.add(calcButton);
       
       exam1 = new JTextField();textfields(exam1);
       lbl1 = new JLabel("This is text"); pane.add(lbl1);
       exam2 = new JTextField();textfields(exam2);
       lbl2 = new JLabel("This is text"); pane.add(lbl2);
       exam3 = new JTextField();textfields(exam3);
       lbl3 = new JLabel("This is text"); pane.add(lbl3);
       exam4 = new JTextField();textfields(exam4);
       lbl4 = new JLabel("This is text"); pane.add(lbl4);
       exam5 = new JTextField();textfields(exam5);
       lbl5 = new JLabel("This is text"); pane.add(lbl5);
       askl = new JLabel("What Score would you like?"); 
       pane.add(askl);
       
       total = new JTextField(); pane.add(total);
       total.setColumns(3);textfields(total);
       
       classes = new Choice();
       TypeofHells c = new TypeofHells();  
       c.courses();
       for(String course : c.classList) {
           classes.add(course);
       } pane.add(classes);
       classes.addItemListener(new change());
       
       layouts();
       
    }
    public void textfields(final JTextField t) {
        pane.add(t);
        if(!t.equals(total))t.setColumns(2);
        t.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent ke) {
                int value = ke.getKeyChar();
                if( !(value <= 55 && value >= 48)) ke.consume();
                if(t.getText().length() > 0) ke.consume();
            }            

            @Override
            public void keyPressed(KeyEvent ke) {}
            @Override
            public void keyReleased(KeyEvent ke) {
                if(t.getText().equals("")){ //if field is empty
                    String name = t.getName();
                    System.out.println("yay");
                    if(name.matches(".*lbl*.")) {
                        name = name.replaceAll("lbl", "");
                        System.out.println(name);
                    }
                }
            }
        });
        if(!( t.equals(total)) ) {
        t.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getClickCount() == 2) {
                t.setText("");
                Color windowsGray = new Color(0xEEEEEE);
                t.getCaret().setVisible(!(t.isEditable()));
                t.setEditable(!(t.isEditable()));
                }
            }
        }); }
    }
    

    public void layouts() {
        Layout(calcButton, 338, 337);
        Layout(classes, 100, 350);
        Layout(exam1, 300, 65);
        Layout(exam2, 300, 105);
        Layout(exam3, 300, 145);
        Layout(exam4, 300, 185);
        Layout(exam5, 300, 225);
        Layout(total, 300, 300);
        Layout(askl, 120, 300);
        Layout(lbl1, 100, 65);
        Layout(lbl2, 100, 105);
        Layout(lbl3, 100, 145);
        Layout(lbl4, 100, 185);
        Layout(lbl5, 100, 225);
        main.setVisible(true);
    }
    private class PanelListener extends MouseAdapter {
        @Override
        public void mousePressed(MouseEvent e) {
            int xc = e.getX();
            int yc = e.getY();
            int x = e.getXOnScreen();
            int y = e.getYOnScreen();
            System.out.print("(" + (xc - 8) + ", " + (yc - 30) + ")" );
            System.out.println("\t(" + x + ", " + y + ")");
        }
    }
    
    public void Layout(Component c, int x, int y) {
        layout.putConstraint(SpringLayout.WEST, c,x, SpringLayout.WEST, pane);
        layout.putConstraint(SpringLayout.NORTH, c,y,SpringLayout.NORTH, pane);
    }
    private class c implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
        if(true) {
        calcButton.removeActionListener(this);
        calcButton.addActionListener(new resetAction());
        classes.setEnabled(false);
        calcButton.setLabel("Reset");
        TypeofHells c = new TypeofHells();
        c.options(classes.getSelectedItem());
        }
        }   
        
    }
    private class resetAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            classes.setEnabled(true);
            calcButton.removeActionListener(this);
            calcButton.addActionListener(new c());
            exam1.setText("");
            exam2.setText("");
            exam3.setText("");
            exam4.setText("");
            exam5.setText("");
            total.setText("");
            calcButton.setLabel("Calculate Results");
        }
        
    }
    
    public class change implements ItemListener {
        @Override
        public void itemStateChanged(ItemEvent ie) {
            if(ie.getItem().equals("French SL")) {
                lbl3.setVisible(true);
                lbl4.setVisible(true);
                lbl5.setVisible(true);
                exam3.setVisible(true);
                exam4.setVisible(true);
                exam5.setVisible(true);
                lbl1.setText("Interactive Oral");
                lbl2.setText("Written Paper");
                lbl3.setText("Oral Exam");
                lbl4.setText("Paper 1");
                lbl5.setText("Paper 2");
                marker.removeAll(marker);
                marker.add(0);//zero means the user is inputing a number into
                marker.add(0);//the slot
                marker.add(0);//One means the user disselected the slot
                marker.add(0);//I forgot what I was going to do for 2 :/
                marker.add(0); 
            }
            if(ie.getItem().equals("Philosophy SL")) {
                lbl3.setVisible(true);
                lbl4.setVisible(false);
                lbl5.setVisible(false);
                exam3.setVisible(true);
                exam4.setVisible(false);
                exam5.setVisible(false);
                lbl1.setText("Critical Analysis Paper");
                lbl2.setText("Paper 1");
                lbl3.setText("Paper 2");
                lbl4.setText("");
                lbl5.setText("");
                marker.removeAll(marker);
                marker.add(0);
                marker.add(0);
                marker.add(0);

            }
        }
        
    }
}
