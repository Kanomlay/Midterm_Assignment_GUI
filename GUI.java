import java.awt.Color;

//import javax.swing.ImageIcon;
import javax.swing.JFrame;


public class GUI {

    public static void main(String[] args){
        JFrame frame = new JFrame("Simple Calculator");//Create a frame    
        frame.setTitle("GUI");//set the title
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//exits on close
        frame.setResizable(false);//Prevent frame from being resized
        frame.setSize(500, 420);//set the size of the frame
        frame.setVisible(true);//make Frame visible

        //ImageIcon image = new ImageIcon();//create an imageicon
        Color background = new Color(190,239,248);
        //frame.setIconImage(image.getImage());//change icon of the frame
        frame.getContentPane().setBackground(background);//change background of the frame
    }
}
