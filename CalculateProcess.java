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
    private int[][] pm25Levels = new int[HEIGHT][WIDTH];
    private JButton[][] buttons = new JButton[HEIGHT][WIDTH];
    private int[][] populations = new int[HEIGHT][WIDTH];
    private int targetRow = -1;
    private int targetCol = -1;
    DataPanel dataPanel;
    ControlPanel controlPanel = new ControlPanel(this, pm25Levels, buttons, populations);
    public CalculateProcess() {
        setLayout(new BorderLayout());

        dataPanel = new DataPanel(pm25Levels, buttons, populations, this);
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

    // เลือกปุ่มเพื่อที่ให้ให้ฝนแบบไหนทำงานตามที่ผู้ใช้ต้องการ
    public void setTarget(int row, int col) {
        this.targetRow = row;
        this.targetCol = col;
        updateButtons();
    }

    // ฝนเทียม
    public void useFonTaerm() {
        if (targetRow != -1 && targetCol != -1) {
            RainSimu.useArtificialRain(pm25Levels, targetRow, targetCol);
            updateButtons();
        } else {
        }
    }

    // ฝนตามธรรมชาติ
    public void useFonJing() {
        RainSimu.useNaturalRain(pm25Levels);
        updateButtons();
    }

    public void loadFile() {
        dataPanel.AddFile();
    }
    public void setBackActionListener(CardLayout cardLayout,JPanel maiPanel){
        controlPanel.getBack().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                cardLayout.show(maiPanel, "Main menu");
            }
            
        });
     }

}
