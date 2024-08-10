import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class CalculateProcess extends JPanel {
    private static final int WIDTH = 20;
    private static final int HEIGHT = 10;
    private int[][] pm25Levels;
    private JButton[][] buttons;
    private int[][] populations;
    private int targetRow = -1;
    private int targetCol = -1;
    private DataPanel dataPanel;
    private ControlPanel controlPanel;
    private String mode = "";
    private boolean isArtificialRainMode = false;
    
    public CalculateProcess() {
        setLayout(new BorderLayout());
        

        // Initialize arrays
        pm25Levels = new int[HEIGHT][WIDTH];
        buttons = new JButton[HEIGHT][WIDTH];
        populations = new int[HEIGHT][WIDTH];

        // Initialize DataPanel and ControlPanel
        controlPanel = new ControlPanel(this, pm25Levels, buttons, populations);
        dataPanel = new DataPanel(pm25Levels, buttons, populations, this, controlPanel);
        

        // Add panels to layout
        add(dataPanel, BorderLayout.WEST);
        add(controlPanel, BorderLayout.SOUTH);

        updateButtons();
    }
    // อัพเดตปุ่ม
    public void updateButtons() {
        for (int row = 0; row < HEIGHT; row++) {
            for (int col = 0; col < WIDTH; col++) {
                JButton button = buttons[row][col];
                if (button != null) { // Ensure button is not null
                    int pm25 = pm25Levels[row][col];
                    int population = populations[row][col];
                    button.setBackground(Utility.getColorForHealthRisk(pm25));
                    button.setFont(new Font("Arial", Font.PLAIN, 7));
                }
            }
        }
    }

    // เลือกปุ่มเพื่อที่ให้ฝนแบบไหนทำงานตามที่ผู้ใช้ต้องการ
    public void setTarget(int row, int col) {
        this.targetRow = row;
        this.targetCol = col;
        if (mode.equals("ArtificialRain")) {
            if (targetRow != -1 && targetCol != -1) {
                RainSimu.useArtificialRain(pm25Levels, targetRow, targetCol);
                updateButtons();
            }
        }
    }

    public boolean isArtificialRainMode() {
        return isArtificialRainMode;
    }

    public void toggleArtificialRainMode() {
        this.isArtificialRainMode = !this.isArtificialRainMode;
        if (!isArtificialRainMode) {
            targetRow = -1; // ยกเลิกเป้าหมายเมื่อโหมดถูกปิด
            targetCol = -1;
            this.mode = "";
            updateButtons(); // รีเฟรชปุ่มทั้งหมดเพื่อแสดงผลลัพธ์ที่เปลี่ยนแปลง
        }
    }

    // ฝนเทียม
    public void useFonTaerm() {
        this.mode = "ArtificialRain";
    }

    // ฝนตามธรรมชาติ
    public void useFonJing() {
        this.isArtificialRainMode = false;
        this.mode = "NaturalRain";
        RainSimu.useNaturalRain(pm25Levels);
        updateButtons();
    }

    public void loadFile() {
        dataPanel.AddFile();
    }

    public void setBackActionListener(CardLayout cardLayout, JPanel maiPanel) {
        controlPanel.getBack().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(maiPanel, "Main menu");
            }
        });
    }
}
