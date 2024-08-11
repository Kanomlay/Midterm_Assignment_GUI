import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class ButtonTarget implements ActionListener {
    private int row;
    private int col;
    private CalculateProcess cal;
    private JButton[][] buttons;
    private int[][] pm25;
    private int[][] populations;
    private ControlPanel controlPanel; // เพิ่ม ControlPanel เพื่อเข้าถึง textField

    private Integer randomPopulation; // เก็บค่า randomPopulation
    private Integer populationSick; // เก็บค่า populationSick
    private Integer goodPopulation; // เก็บค่า goodPopulation

    public ButtonTarget(int row, int col, CalculateProcess cal, JButton[][] buttons, int[][] pm25, int[][] populations, ControlPanel controlPanel) {
        this.row = row;
        this.col = col;
        this.cal = cal;
        this.buttons = buttons;
        this.pm25 = pm25;
        this.populations = populations;
        this.controlPanel = controlPanel; // เก็บการอ้างอิง ControlPanel
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int pm25Value = pm25[row][col];

        try {
            // ดึงค่าจาก textField_1 และ textField_2
            int min = Integer.parseInt(controlPanel.getTextField1().getText());
            int max = Integer.parseInt(controlPanel.getTextField2().getText());

            // ตรวจสอบว่าค่าของ min และ max ถูกต้องหรือไม่
            if (min > max) {
                throw new IllegalArgumentException("Min should be less than or equal to Max.");
            }

            // ถ้า randomPopulation ยังไม่ได้ถูกคำนวณหรือมีการกดปุ่ม Add Population ให้คำนวณใหม่
            if (randomPopulation == null) {
                randomPopulation = Utility.getRandomValueInRange(min, max);
                populationSick = Utility.calculatePopulationSick(randomPopulation, pm25Value);
                goodPopulation = Utility.calculateGoodPopulation(randomPopulation, populationSick);
            }
            // คำนวณเปอร์เซ็นต์ของ populationSick
            double percentageSick = (populationSick / (double) randomPopulation) * 100;

            // แสดงผลลัพธ์
            JOptionPane.showMessageDialog(null, 
                String.format("For Button at Row %d, Column %d\nPM2.5 Value: %d\nRandom Population: %d\nPopulation Sick: %d (%.2f%%)\nGood Population: %d", 
                row, col,pm25Value,randomPopulation, populationSick, percentageSick, goodPopulation));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Invalid input: Please enter valid integers in the text fields.");
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    // ฟังก์ชันที่จะเรียกเมื่อมีการกดปุ่ม Add Population เพื่อรีเซ็ตค่าที่คำนวณไว้
    public void resetPopulationCalculations() {
        this.randomPopulation = null;
        this.populationSick = null;
        this.goodPopulation = null;
    }
}
