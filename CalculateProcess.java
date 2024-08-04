import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CalculateProcess extends JFrame {
    private static final int WIDTH = 20;
    private static final int HEIGHT = 10;
    private int[][] pm25Levels = new int[HEIGHT][WIDTH];
    private JButton[][] buttons = new JButton[HEIGHT][WIDTH];
    private int targetRow = -1;
    private int targetCol = -1;
    private DataPanel dataPanel;
    private ControlPanel controlPanel;

    public CalculateProcess() {
        setTitle("PM 2.5");
        setSize(1500, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        dataPanel = new DataPanel();
        add(dataPanel, BorderLayout.WEST);

        controlPanel = new ControlPanel(dataPanel);
        add(controlPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    public static void main(String[] args) {
        new CalculateProcess();
    }
}
