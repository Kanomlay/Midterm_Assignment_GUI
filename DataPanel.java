import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class DataPanel extends JPanel {
    private JButton[][] buttons;
    private int[][] pm25;
    private int[][] populations;
    private CalculateProcess frame;
    private ControlPanel controlPanel; // เพิ่ม ControlPanel

    public DataPanel(int[][] pm25, JButton[][] buttons, int[][] populations, CalculateProcess frame, ControlPanel controlPanel) {
        this.pm25 = pm25;
        this.buttons = buttons;
        this.populations = populations;
        this.frame = frame;
        this.controlPanel = controlPanel; // กำหนด ControlPanel

        //setBackground(new Color(174, 214, 241)); 
        setLayout(new GridLayout(10, 20, 0, 0));
    }

    public void AddFile() {
        JFileChooser fileChooser = new JFileChooser();
        int returnValue = fileChooser.showOpenDialog(frame);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            Path filePath = fileChooser.getSelectedFile().toPath();
            loadDataFromFile(filePath);
        }
    }

    public void loadDataFromFile(Path filePath) {
        removeAll(); // Clear existing buttons
        try (BufferedReader reader = Files.newBufferedReader(filePath, StandardCharsets.UTF_8)) {
            String line;
            int row = 0;
            while ((line = reader.readLine()) != null && row < 10) {
                String[] values = line.split("\\s+");
                for (int col = 0; col < values.length && col < 20; col++) {
                    pm25[row][col] = Integer.parseInt(values[col]);
                    JButton button = new JButton();
                    button.setBackground(Utility.getColorForHealthRisk(pm25[row][col])); // Set color based on PM2.5 level
                    button.setPreferredSize(new Dimension(50, 30));
                    buttons[row][col] = button;
                    button.addActionListener(new ButtonTarget(row, col, frame, buttons, pm25, populations, controlPanel)); // Pass additional parameters
                    add(button);
                }
                row++;
            }
        } catch (IOException e) {
            System.out.println("IOException: " + e.getMessage());
        }
        revalidate(); // Refresh panel
        repaint();    // Repaint panel
    }
}
