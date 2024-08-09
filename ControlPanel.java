import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.file.Path;

public class ControlPanel extends JPanel {
    private JButton button_rain;
    private JButton random_rain;
    private JButton back;
    private JButton add_files;
    private CalculateProcess cal;
    private DataPanel data;

    public ControlPanel(CalculateProcess cal, int[][] pm25, JButton[][] buttons, int[][] populations) {

        this.cal = cal;
        setLayout(new GridLayout(1, 4, 10, 10));
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
                    cal.useFonTaerm();
                }
                else{
                    button_rain.setText("Artificial Rain");
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

        add(back);
        add(button_rain);
        add(random_rain);
        add(add_files);
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
    /*public void setBackActionListener(CardLayout cardLayout,JPanel maiPanel){
       getBack().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                cardLayout.show(maiPanel, "Main menu");
            }
            
        });
    }*/
}
