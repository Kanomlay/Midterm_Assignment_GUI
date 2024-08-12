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
    private String mode = "ShowData";
    private boolean isArtificialRainMode = false;
    private ShowInformation showInformation;
    private Integer randomPopulation; 
    private Integer populationSick; 
    private Integer goodPopulation;
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
        add(showInformation.panel_1, BorderLayout.EAST);

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
            
           /* int pm25Value = pm25[row][col];
    
            try {

                int min = Integer.parseInt(controlPanel.getTextField1().getText());
                int max = Integer.parseInt(controlPanel.getTextField2().getText());
    
                if (min > max) {
                    throw new IllegalArgumentException("Min should be less than or equal to Max.");
                }
    
                // คำนวณค่าใหม่ทุกครั้งที่กดปุ่ม
                if (randomPopulation == null) {
                    randomPopulation = Utility.getRandomValueInRange(min, max);
                    populationSick = Utility.calculatePopulationSick(randomPopulation, pm25Value);
                    goodPopulation = Utility.calculateGoodPopulation(randomPopulation, populationSick);
                }
                double percentageSick = (populationSick / (double) randomPopulation) * 100;
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Invalid input: Please enter valid integers in the text fields.");
            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }*/
        
    }
    public boolean isArtificialRainMode() {
        return isArtificialRainMode;
    }

    public void toggleArtificialRainMode() {
        this.isArtificialRainMode = !this.isArtificialRainMode;
        if (!isArtificialRainMode) {
            this.mode = "ShowData";
        } else {
            this.mode = "ArtificialRain";
            targetRow = -1;
            targetCol = -1;
            updateButtons();
        }
    }

    // Use artificial rain
    public void useFonTaerm() {
        this.mode = "ArtificialRain";
    }

    // Use natural rain
    public void useFonJing() {
        this.isArtificialRainMode = false;
        this.mode = "NaturalRain";
        RainSimu.useNaturalRain(pm25Levels);
        updateButtons();
    }

    // Load data from file
    public void loadFile() {
        dataPanel.AddFile();
    }

    // Reset data
    public void resetdata() {
        //showInformation.panel_1.setVisible(false);
        for (int row = 0; row < HEIGHT; row++) {
            for (int col = 0; col < WIDTH; col++) {
                if (buttons[row][col] != null) {
                    buttons[row][col].setVisible(false);
                    remove(buttons[row][col]);
                    buttons[row][col] = null;
                }
            }
        }
    }

    // Set back action listener for control panel
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
