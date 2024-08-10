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

            // คำนวณค่า randomPopulation, populationSick และ goodPopulation
            int randomPopulation = Utility.getRandomValueInRange(min, max);
            int populationSick = Utility.calculatePopulationSick(min, max, pm25Value);
            int goodPopulation = randomPopulation - populationSick;

            // แสดงผลลัพธ์
            JOptionPane.showMessageDialog(null, 
                String.format("For Button at Row %d, Column %d:\nRandom Population: %d\nPopulation Sick: %d\nGood Population: %d", row, col, randomPopulation, populationSick, goodPopulation));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Invalid input: Please enter valid integers in the text fields.");
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
}
