import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControlPanel extends JPanel {
    private JButton button_rain;
    private JButton random_rain;
    private JButton back;
    private JButton add_files;
    private JButton add_population;
    private JTextField textField_1;
    private JTextField textField_2;
    private CalculateProcess cal;
    private Utility utility;
    private int[][] pm25;
    private JButton[][] buttons;

    public ControlPanel(CalculateProcess cal, int[][] pm25, JButton[][] buttons, int[][] populations) {
        this.cal = cal;
        this.pm25 = pm25;
        this.utility = new Utility();
        this.buttons = buttons;

        setLayout(new GridLayout(1, 6, 10, 10));
        setBackground(new Color(174, 214, 241));

        back = new JButton("BACK");
        back.setPreferredSize(new Dimension(100, 50));
        back.setBackground(new Color(133, 193, 233));
        back.setForeground(Color.BLACK);

        button_rain = new JButton("Artificial Rain");
        button_rain.setPreferredSize(new Dimension(150, 50));
        button_rain.setBackground(new Color(133, 193, 233));
        button_rain.setForeground(Color.BLACK);
        button_rain.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { 
                cal.toggleArtificialRainMode();
                if (cal.isArtificialRainMode()) {
                    button_rain.setText("Exit Mode Artificial");
                    button_rain.setBackground(new Color(169, 50, 38));
                    button_rain.setForeground(Color.WHITE);
                    cal.useFonTaerm();
                } else {
                    button_rain.setText("Artificial Rain");
                    button_rain.setBackground(new Color(133, 193, 233));
                    button_rain.setForeground(Color.BLACK);
                    cal.updateButtons();
                }
            }
        });

        random_rain = new JButton("Random Rain");
        random_rain.setPreferredSize(new Dimension(125, 50));
        random_rain.setBackground(new Color(133, 193, 233));
        random_rain.setForeground(Color.BLACK);
        random_rain.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cal.useFonJing();
            }
        });

        add_files = new JButton("Add Files");
        add_files.setPreferredSize(new Dimension(100, 50));
        add_files.setBackground(new Color(133, 193, 233));
        add_files.setForeground(Color.BLACK);
        add_files.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cal.loadFile();
            }
        });

        add_population = new JButton("Add Population");
        add_population.setPreferredSize(new Dimension(100, 50));
        add_population.setBackground(new Color(133, 193, 233));
        add_population.setForeground(Color.BLACK);
        add_population.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int min = Integer.parseInt(textField_1.getText());
                    int max = Integer.parseInt(textField_2.getText());
                    int pm25Value = getAveragePM25();

                    // รีเซ็ตค่าที่คำนวณไว้ใน ButtonTarget ทุกปุ่ม
                    for (int row = 0; row < buttons.length; row++) {
                        for (int col = 0; col < buttons[row].length; col++) {
                            JButton button = buttons[row][col];
                            ButtonTarget bt = (ButtonTarget) button.getActionListeners()[0];
                            bt.resetPopulationCalculations();
                        }
                    }

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Please enter valid numbers in the text fields.");
                }
            }
        });

        textField_1 = new JTextField("0");
        textField_2 = new JTextField("100");

        add(back);
        add(button_rain);
        add(random_rain);
        add(add_files);
        add(textField_1);
        add(textField_2);
        add(add_population);
    }

    private int getAveragePM25() {
        int total = 0;
        int count = 0;
        for (int[] row : pm25) {
            for (int value : row) {
                total += value;
                count++;
            }
        }
        return count > 0 ? total / count : 0;
    }

    public JTextField getTextField1() {
        return textField_1;
    }

    public JTextField getTextField2() {
        return textField_2;
    }

    public JButton getBack() {
        return back;
    }

    public JButton getButtonRain() {
        return button_rain;
    }

    public JButton getRandomRain() {
        return random_rain;
    }

    public JButton getAddFiles() {
        return add_files;
    }

    public JButton getAddPopulation() {
        return add_population;
    }
}
