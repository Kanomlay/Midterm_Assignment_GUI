import java.awt.*;
import javax.swing.*;

public class GUI {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Simple Calculator"); // Create a frame
        frame.setTitle("GUI"); // Set the title
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Exits on close
        frame.setResizable(false); // Prevent frame from being resized
        frame.setSize(700, 580); // Set the size of the frame
        
        // Set background color of the frame
        //Color background = new Color(133, 193, 233);
        //frame.getContentPane().setBackground(background); // Change background of the frame
        
        mybutton panel = new mybutton();
        frame.add(panel);

        JLabel label=new JLabel("PM 2.5");
        label.setBounds(400, 220, 150, 30);
        label.setFont(new Font("PM 2.5", Font.BOLD, 40));
        panel.add(label);
        
        // Set the frame to be visible
        frame.setVisible(true);
    }
}
