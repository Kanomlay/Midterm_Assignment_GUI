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
    private double percentageSick;

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
        cal.setTarget(row, col);
        int pm25Value = pm25[row][col];

        try {
            int min = Integer.parseInt(controlPanel.getTextField1().getText());
            int max = Integer.parseInt(controlPanel.getTextField2().getText());
            if (min<0||max<0) {
                JOptionPane.showMessageDialog(null, "Number is negative");
                return;
            }

            if (randomPopulation == null) {
                randomPopulation = Utility.getRandomValueInRange(min, max);
            }

            if (lastPm25Value == -1 || pm25Value < lastPm25Value) {
                populationSick = Utility.calculatePopulationSick(randomPopulation, pm25Value);
                goodPopulation = Utility.calculateGoodPopulation(randomPopulation, populationSick);
                percentageSick = (populationSick / (double) randomPopulation) * 100;

                showInformation.updateImage(percentageSick);
                showInformation.getText(pm25Value, randomPopulation, populationSick, percentageSick, goodPopulation);
                
                lastPm25Value = pm25Value; 
            } else {
                showInformation.getText(pm25Value, randomPopulation, populationSick, (populationSick / (double) randomPopulation) * 100, goodPopulation);
            }

            showInformation.updateImage(percentageSick);

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "An error occurred because there were too many characters or data.");
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }

       
        }
    
    public void resetPopulationCalculations() {
        randomPopulation = null;
        populationSick = null;
        goodPopulation = null;
        lastPm25Value = -1;
    }
}
