import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.swing.JButton;
import javax.swing.JPanel;

public class DataPanel extends JPanel {
    
    public DataPanel() {
        // Use GridBagLayout for better control of component sizes
        setLayout(new GridBagLayout());
        

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.NONE; // Prevent buttons from expanding
        gbc.weightx = 0;
        gbc.weighty = 0;
        gbc.insets = new java.awt.Insets(0, 0, 0, 0); // No gap between buttons

        Path file = Paths.get("C:\\Users\\moonl\\Downloads\\pm2.5.txt");
        try (BufferedReader reader = Files.newBufferedReader(file, StandardCharsets.UTF_8)) {
            String line;
            int row = 0;
            int col = 0;
            while ((line = reader.readLine()) != null) {
                String[] values = line.split("\\s+"); // Split numbers by whitespace
                for (String value : values) {
                    JButton button = new JButton(); // Create button without text
                    button.setBackground(new Color(133, 193, 233)); // Set button background color
                    button.setForeground(Color.BLACK); // Set button text color
                    button.setPreferredSize(new Dimension(60, 35)); // Set button size to 20x20 pixels
                    
                    gbc.gridx = col;
                    gbc.gridy = row;
                    add(button, gbc); // Add button to panel
                    col++;
                    if (col >= 10) {
                        col = 0;
                        row++;
                    }
                }
                if (row >= 20) {
                    break; // Limit to 20 rows
                }
            }
        } catch (IOException e) {
            System.err.println("IOException: " + e.getMessage());
        }
    }
}
