import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class DataPanel extends JPanel {
    private JButton[][] buttons = new JButton[10][20];
    private int[][] pm25Levels = new int[10][20];

    public DataPanel() {
        setBackground(new Color(174, 214, 241)); // Set background color
        setLayout(new GridLayout(10, 20, 0, 0)); // 20 rows, 10 columns, no gaps
    }

    public void loadDataFromFile(Path filePath) {
        removeAll(); // Clear existing buttons
        try (BufferedReader reader = Files.newBufferedReader(filePath, StandardCharsets.UTF_8)) {
            String line;
            int row = 0;
            while ((line = reader.readLine()) != null && row < 10) {
                String[] values = line.split("\\s+"); // Split numbers by whitespace
                for (int col = 0; col < values.length && col < 20; col++) {
                    pm25Levels[row][col] = Integer.parseInt(values[col]);
                    JButton button = new JButton(); // Create button with the value
                    button.setBackground(Utility.getColorForHealthRisk(Utility.getHealthyPopulation(pm25Levels[row][col]))); // Set button background color
                    button.setPreferredSize(new Dimension(50, 30)); // Set button size
                    buttons[row][col] = button;
                    add(button); // Add button to panel
                }
                row++;
            }
        } catch (IOException e) {
            System.err.println("IOException: " + e.getMessage());
        }
        revalidate(); // Refresh the panel to reflect changes
        repaint();    // Redraw the panel
    }
}
