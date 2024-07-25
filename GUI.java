import java.awt.*;
import javax.swing.*;

public class GUI {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Simple Calculator"); // Create a frame
        frame.setTitle("GUI"); // Set the title
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Exits on close
        frame.setResizable(false); // Prevent frame from being resized
        frame.setSize(500, 420); // Set the size of the frame
        
        // Set background color of the frame
        //Color background = new Color(133, 193, 233);
        //frame.getContentPane().setBackground(background); // Change background of the frame
        
        // Add the custom panel
        mybutton panel = new mybutton();
        frame.add(panel);
        
        // Set the frame to be visible
        frame.setVisible(true);
    }
}
