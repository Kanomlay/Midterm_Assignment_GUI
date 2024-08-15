import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
    private String mode = "ShowData";// กำหนดโหมดเริ่มต้นเป็น "ShowData"
    private boolean isArtificialRainMode = false;// กำหนดสถานะโหมดฝนเทียม
    private ShowInformation showInformation;
    public CalculateProcess() {
        setLayout(new BorderLayout());
        
        // Initialize arrays
        pm25Levels = new int[HEIGHT][WIDTH];
        buttons = new JButton[HEIGHT][WIDTH];
        populations = new int[HEIGHT][WIDTH];

        // Initialize DataPanel, ControlPanel, and ShowInformation
        controlPanel = new ControlPanel(this, pm25Levels, buttons, populations);
        showInformation = new ShowInformation();
        dataPanel = new DataPanel(pm25Levels, buttons, populations, this, controlPanel, showInformation);

        // Add panels to layout
        add(dataPanel, BorderLayout.WEST);
        add(controlPanel, BorderLayout.SOUTH);

        updateButtons();
    }

    // Update button states
    public void updateButtons() {
        for (int row = 0; row < HEIGHT; row++) {
            for (int col = 0; col < WIDTH; col++) {
                JButton button = buttons[row][col];
                if (button != null) {
                    int pm25 = pm25Levels[row][col];
                    button.setBackground(Utility.getColorForHealthRisk(pm25));
                    button.setFont(new Font("Arial", Font.PLAIN, 7));
                }
            }
        }
    }

    // Set target button based on user selection
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
    // ตรวจสอบสถานะโหมดฝนเทียม
    public boolean isArtificialRainMode() {
        return isArtificialRainMode;
    }

    public void toggleArtificialRainMode() {
        this.isArtificialRainMode = !this.isArtificialRainMode;
        if (!isArtificialRainMode) {
            this.mode = "ShowData";// เปลี่ยนโหมดเป็น "ShowData" เมื่อปิดโหมดฝนเทียม
        } else {
            this.mode = "ArtificialRain";// เปลี่ยนโหมดเป็น "ArtificialRain" เมื่อเปิดโหมดฝนเทียม
            targetRow = -1;
            targetCol = -1;
            updateButtons();
        }
    }

    // ใช้ฝนเทียม
    public void useFonTaerm() {
        this.mode = "ArtificialRain";
    }

    // ใช้ฝนธรรมชาติ
    public void useFonJing() {
        this.isArtificialRainMode = false;
        this.mode = "NaturalRain";
        RainSimu.useNaturalRain(pm25Levels);
        updateButtons();
    }

    // โหลดข้อมูลจากไฟล์
    public void loadFile() {
        dataPanel.AddFile();
        add(showInformation.panel_1, BorderLayout.EAST);// เพิ่ม panel_1 ของ showInformation ทางด้านขวา (EAST)
        showInformation.panel_1.setVisible(true);// แสดง panel_1
    }

    // รีเซ็ตข้อมูล
    public void resetdata() {
        showInformation.panel_1.setVisible(false);
        showInformation.label_1.setIcon(null); // ลบรูปภาพจาก label_1
        showInformation.infoLabel.setText(""); // ลบข้อความใน infoLabel
        showInformation.revalidate(); // รีเฟรช layout เพื่ออัพเดตการเปลี่ยนแปลง
        showInformation.repaint(); // วาดใหม่
        for (int row = 0; row < HEIGHT; row++) {
            for (int col = 0; col < WIDTH; col++) {
                if (buttons[row][col] != null) {
                    buttons[row][col].setVisible(false);
                    remove(buttons[row][col]);// ลบปุ่มออกจาก layout
                    buttons[row][col] = null;
                }
            }
        }
    }
    public String getMode(){
        return mode;      
    }  
    // ตั้งค่า ActionListener สำหรับปุ่มกลับใน Mainmenu
    public void setBackActionListener(CardLayout cardLayout, JPanel maiPanel) {
        controlPanel.getBack().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(maiPanel, "Main menu");
                resetdata();
            }
        });
    }
}
