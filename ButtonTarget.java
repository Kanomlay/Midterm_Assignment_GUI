import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class ButtonTarget implements ActionListener {
    private int row;
    private int col;
    private CalculateProcess cal;
    private JButton[][] buttons;
    private int[][] pm25;
    private int[][] populations;
    private ControlPanel controlPanel;
    private ShowInformation showInformation;

    private Integer randomPopulation; 
    private Integer populationSick; 
    private Integer goodPopulation;
    private int lastPm25Value = -1; // เก็บค่า PM2.5 ครั้งก่อนหน้า

    public ButtonTarget(int row, int col, CalculateProcess cal, JButton[][] buttons, int[][] pm25, int[][] populations, ControlPanel controlPanel, ShowInformation showInformation) {
        this.row = row;
        this.col = col;
        this.cal = cal;
        this.buttons = buttons;
        this.pm25 = pm25;
        this.populations = populations;
        this.controlPanel = controlPanel;
        this.showInformation = showInformation;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (cal.getMode() == "ArtificialRain") {
            cal.setTarget(row, col);
        } else {
            int pm25Value = pm25[row][col];

        try {
            int min = Integer.parseInt(controlPanel.getTextField1().getText());
            int max = Integer.parseInt(controlPanel.getTextField2().getText());
            if (min<0||max<0) {
                JOptionPane.showMessageDialog(null, "Number is negative");
                return;
            }
            /*if (min > max) {
                throw new IllegalArgumentException("Min should be less than or equal to Max.");
            }*/

            if (randomPopulation == null) {
                // ถ้ายังไม่ได้คำนวณมาก่อน ให้สร้าง randomPopulation
                randomPopulation = Utility.getRandomValueInRange(min, max);
            }

            if (lastPm25Value == -1 || pm25Value < lastPm25Value) {
                // ถ้ายังไม่เคยคำนวณมาก่อนหรือค่า PM2.5 ปัจจุบันลดลง ให้คำนวณใหม่
                populationSick = Utility.calculatePopulationSick(randomPopulation, pm25Value);
                goodPopulation = Utility.calculateGoodPopulation(randomPopulation, populationSick);
                double percentageSick = (populationSick / (double) randomPopulation) * 100;

                showInformation.updateImage(percentageSick);
                showInformation.getText(pm25Value, randomPopulation, populationSick, percentageSick, goodPopulation);

                lastPm25Value = pm25Value; // เก็บค่าล่าสุด
            } else {
                // ถ้าไม่มีการเปลี่ยนแปลง หรือค่า PM2.5 ไม่ได้ลดลง ก็เก็บค่าที่มีอยู่เดิม
                showInformation.getText(pm25Value, randomPopulation, populationSick, (populationSick / (double) randomPopulation) * 100, goodPopulation);
            }

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "To much number");
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        }
    }

    public void resetPopulationCalculations() {
        randomPopulation = null;
        populationSick = null;
        goodPopulation = null;
        lastPm25Value = -1;
    }
}
