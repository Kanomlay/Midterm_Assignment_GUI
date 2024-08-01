import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import javax.swing.JButton;
import javax.swing.JPanel;

public class DataPanel extends JPanel {

    public DataPanel() {
        setBackground(new Color(174, 214, 241)); // Set background color
        setLayout(new GridLayout(20, 10, 0, 0)); // 20 rows, 10 columns, no gaps
    }

    public void loadDataFromFile(Path filePath) {
        removeAll(); // Clear existing buttons
        try (BufferedReader reader = Files.newBufferedReader(filePath, StandardCharsets.UTF_8)) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] values = line.split("\\s+"); // Split numbers by whitespace
                for (String value : values) {
                    JButton button = new JButton(); // Create button without text
                    button.setBackground(new Color(133, 193, 233)); // Set button background color
                    button.setPreferredSize(new Dimension(60, 30)); // Set button size
                    add(button); // Add button to panel
                }
            }
        } catch (IOException e) {
            System.err.println("IOException: " + e.getMessage());
        }
        revalidate();
        repaint();
    }
}
