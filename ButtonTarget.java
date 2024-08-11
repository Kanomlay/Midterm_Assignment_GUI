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
        int pm25Value = pm25[row][col];

        try {
            int min = Integer.parseInt(controlPanel.getTextField1().getText());
            int max = Integer.parseInt(controlPanel.getTextField2().getText());

            if (min > max) {
                throw new IllegalArgumentException("Min should be less than or equal to Max.");
            }

            if (randomPopulation == null) {
                randomPopulation = Utility.getRandomValueInRange(min, max);
                populationSick = Utility.calculatePopulationSick(randomPopulation, pm25Value);
                goodPopulation = Utility.calculateGoodPopulation(randomPopulation, populationSick);
            }

            double percentageSick = (populationSick / (double) randomPopulation) * 100;

            showInformation.updateImage(percentageSick);
            showInformation.getText(pm25Value, randomPopulation, populationSick, percentageSick, goodPopulation);

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Invalid input: Please enter valid integers in the text fields.");
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    public void resetPopulationCalculations() {
        randomPopulation = null;
        populationSick = null;
        goodPopulation = null;
    }
}
