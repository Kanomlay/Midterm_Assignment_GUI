import java.awt.Color;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class CalculateProcess extends JFrame {

    Random ran = new Random();
    private static final int WIDTH = 20;
    private static final int HEIGHT = 10;
    private int[][] pm25Levels = new int[HEIGHT][WIDTH];
    private JButton[][] buttons = new JButton[HEIGHT][WIDTH];
    private int targetRow = -1;
    private int targetCol = -1;

    public CalculateProcess() {
        setTitle("PM 2.5");
        setSize(1500, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel gridPanel = new JPanel(new GridLayout(HEIGHT, WIDTH));
        loadPM25Levels(gridPanel);
        add(gridPanel, BorderLayout.CENTER);

        JPanel controlPanel = new JPanel();
        JButton artificialRainButton = new JButton("Artificial Rain");
        artificialRainButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (targetRow != -1 && targetCol != -1) {
                    applyArtificialRain(pm25Levels, targetRow, targetCol);
                } else {
                    System.out.println("Please select a target area first.");
                }
            }
        });

        JButton naturalRainButton = new JButton("Natural Rain");
        naturalRainButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                applyNaturalRain(pm25Levels);
            }
        });

        controlPanel.add(artificialRainButton);
        controlPanel.add(naturalRainButton);
        add(controlPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    public static void main(String[] args) {
        new CalculateProcess();
    }

    private void loadPM25Levels(JPanel gridPanel) {
        Path file = Paths.get("C:\\Users\\MiGKP\\Downloads\\pm2.5.txt");
        try (BufferedReader reader = Files.newBufferedReader(file, StandardCharsets.UTF_8)) {
            String line;
            int row = 0;
            while ((line = reader.readLine()) != null && row < HEIGHT) {
                String[] values = line.split("\\s+"); // Split numbers by whitespace
                for (int col = 0; col < values.length && col < WIDTH; col++) {
                    pm25Levels[row][col] = Integer.parseInt(values[col]);
                    JButton button = new JButton(values[col]);
                    button.setBackground(getColorForHealthRisk(getHealthyPopulation(pm25Levels[row][col])));

                    button.setForeground(Color.BLACK);
                    final int currentRow = row;
                    final int currentCol = col;
                    button.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            setTarget(currentRow, currentCol);
                            System.out.println("Target set to: (" + currentRow + ", " + currentCol + ")");
                        }
                    });
                    buttons[row][col] = button;
                    gridPanel.add(button);
                }
                row++;
            }
        } catch (IOException e) {
            System.out.println("IOException: " + e.getMessage());
        }
    }

    private void applyArtificialRain(int[][] pm25Levels, int targetRow, int targetCol) {
        int[][] directions = {
                { 0, 0 }, { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 },
                { -1, -1 }, { -1, 1 }, { 1, -1 }, { 1, 1 }
        };

        for (int[] direction : directions) {
            int newRow = targetRow + direction[0];
            int newCol = targetCol + direction[1];
            if (isInBounds(newRow, newCol)) {
                if (direction[0] == 0 && direction[1] == 0) {
                    // พื้นที่ที่เลือก
                    pm25Levels[newRow][newCol] = (int) ((pm25Levels[newRow][newCol] / 100) * 50);
                } else {
                    // พื้นที่รอบๆ
                    pm25Levels[newRow][newCol] = (int) ((pm25Levels[newRow][newCol] / 100) * 30);
                }
            }
        }
    }

    private void applyNaturalRain(int[][] pm25Levels) {
        for (int row = 0; row < HEIGHT; row++) {
            for (int col = 0; col < WIDTH; col++) {
                pm25Levels[row][col] = Math.max(pm25Levels[row][col] - 50,0);
            }
        }
    }

    private boolean isInBounds(int row, int col) {
        return row >= 0 && row < HEIGHT && col >= 0 && col < WIDTH;
    }

    private int getHealthyPopulation(int pm25) {
        double sickPercentage = 0.0;
        if (pm25 >= 0 && pm25 <= 50) {
            sickPercentage = Math.random() * 0.09; // 0-9%
        } else if (pm25 >= 51 && pm25 <= 100) {
            sickPercentage = 0.10 + Math.random() * 0.09; // 10-19%
        } else if (pm25 >= 101 && pm25 <= 150) {
            sickPercentage = 0.20 + Math.random() * 0.09; // 20-29%
        } else if (pm25 >= 151 && pm25 <= 250) {
            sickPercentage = 0.30 + Math.random() * 0.20; // 30-50%
        }

        return (int) sickPercentage;
    }

    private Color getColorForHealthRisk(int sickPercentage) {
        if (sickPercentage >= 30) {
            return Color.RED; // 30% or more
        } else if (sickPercentage >= 20) {
            return Color.ORANGE; // 20-29%
        } else if (sickPercentage >= 10) {
            return Color.YELLOW; // 10-19%
        } else {
            return Color.GREEN; // 0-9%
        }
    }


    public void setTarget(int row, int col) {
        this.targetRow = row;
        this.targetCol = col;
    }
}