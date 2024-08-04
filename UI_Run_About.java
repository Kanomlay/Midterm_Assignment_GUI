import java.awt.*;
import javax.swing.*;
public class UI_Run_About {
    public static void main(String[] args) {
        JFrame frame = new JFrame();      
        frame.setSize(1000, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("PM 2.5");
        //UI_About about=new UI_About(cardLayout,mainpanel);
        frame.setResizable(false);

        //frame.add(about);
        frame.setVisible(true);
    }
}