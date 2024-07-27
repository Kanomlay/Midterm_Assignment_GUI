import java.awt.Color;
import java.awt.GridLayout;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Read_txt extends JFrame {
    
    public Read_txt() {
        setTitle("PM 2.5 Data Buttons");
        setSize(1000, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        Start_GUI_Color panel = new Start_GUI_Color();
        add(panel);
        
        setVisible(true);
    }
    
    public static void main(String[] args) {
        new Read_txt();
    }
}

class Start_GUI_Color extends JPanel {
    
    public Start_GUI_Color() {
        setBackground(new Color(174, 214, 241)); // Set background color
        setLayout(new GridLayout(20, 5, 10, 10)); // Layout with 20 rows and 5 columns, with gaps
        
        Path file = Paths.get("C:\\Users\\moonl\\Downloads\\pm2.5.txt");
        try (BufferedReader reader = Files.newBufferedReader(file, StandardCharsets.UTF_8)) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] values = line.split("\\s+"); // Split numbers by whitespace
                for (String value : values) {
                    JButton button = new JButton(value); // Create button with the value
                    button.setBackground(new Color(133, 193, 233)); // Set button background color
                    button.setForeground(Color.BLACK); // Set button text color
                    add(button); // Add button to panel
                }
            }
        } catch (IOException e) {
            System.err.println("IOException: " + e.getMessage());
        }
    }
}
