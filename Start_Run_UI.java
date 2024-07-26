import javax.swing.JFrame;

public class Start_Run_UI extends JFrame{

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        Start_GUI_Color color_Background = new Start_GUI_Color();        
        frame.setSize(1000, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("PM 2.5");

        
        frame.add(color_Background);
        frame.setVisible(true);
    }
}
