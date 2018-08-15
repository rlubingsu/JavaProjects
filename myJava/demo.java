import java.util.*;
import java.awt.*;
import javax.swing.*;
public class demo{

   public static void main(String[]args){
    
   args = new String[43];
   args[0] = "da";
   System.out.println(args[0]);
   
   System.out.println("kriss sphinx");
   
   JFrame frame = new JFrame();
   frame.setSize(400,400);
   JButton but = new JButton("click me");
   JLabel lab = new JLabel("Label here");
   
   JPanel ap = new JPanel();
   ap.add(but);
   ap.add(lab);
   frame.add(ap);
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   
   frame.setVisible(true);
   
   
   }

}