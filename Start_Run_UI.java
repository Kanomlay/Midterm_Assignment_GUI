import javax.swing.JFrame;
import java.awt.BorderLayout;

public class Start_Run_UI extends JFrame {
    
    public Start_Run_UI() {
        setTitle("PM 2.5 Data Buttons");
        setSize(1000, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create panels
        DataPanel dataPanel = new DataPanel();
        ControlPanel controlPanel = new ControlPanel(); // Assuming ControlPanel is created as before

        // Add panels to the frame
        add(dataPanel, BorderLayout.WEST);
        add(controlPanel, BorderLayout.SOUTH);
        
        setVisible(true);
    }
    
    public static void main(String[] args) {
        new Start_Run_UI();
    }
}
