import java.awt.*;
import javax.swing.*;
public class mybutton extends JFrame{
    JButton button_1=new JButton("START");
    JButton button_2=new JButton("About");
    JButton button_3=new JButton("EXIT");
    public mybutton(){
        button_1.setSize(20, 20);
        button_1.setLocation(20, 20);
        add(button_1);
        
    }
}

