package Package;

import java.util.*;
import Package.Main;
import java.awt.*;

public class TypeofHells {
    int first, second, third, fourth, fifth;
    ArrayList<String> classList = new ArrayList<>();
    String[] other = new String[4];
    Main m = new Main();
    public TypeofHells(){
        
        try {
        first = Integer.parseInt(m.first.getText());
        second = Integer.parseInt(m.second.getText());
        third = Integer.parseInt(m.third.getText());
        fourth = Integer.parseInt(m.fourth.getText());
        fifth = Integer.parseInt(m.fifth.getText());
        } catch(NumberFormatException e) {
            if(m.debug) System.out.println("Cannot turn String into number here");
        }   
    }
    public void options(String current) {
        
        if(current.equals("French SL")) IBFrenchSL();
        
    }
    public void courses() {
        classList.add("French SL");
        classList.add("Philosophy SL");
    }

    /**
     * Does the calculations needed to find out What one needs to get value x
     * in the French portion of their IB Diploma.
     * Also returns how many exams are in that class.
     * @return
     */
    public int IBFrenchSL(){
        double interactive = 10;
        double writtenPaper = 20; 
        double oral = 20; 
        double paper1 = 25;
        double paper2 = 25;

        return 5;
    }
}
