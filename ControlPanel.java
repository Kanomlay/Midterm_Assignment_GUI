import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public class ControlPanel extends JPanel {
    private JButton button_rain;
    private JButton random_rain;
    private JButton back;
    private JButton add_files;

    public ControlPanel() {
        setLayout(new GridLayout(1, 4, 10, 10)); // Layout with 1 row and 4 columns, with gaps
        setBackground(new Color(174, 214, 241)); // Set background color

        back = new JButton("BACK");
        back.setPreferredSize(new Dimension(100, 50));
        back.setBackground(new Color(133, 193, 233));
        back.setForeground(Color.BLACK);

        button_rain = new JButton("Artificial Rain");
        button_rain.setPreferredSize(new Dimension(150, 50));
        button_rain.setBackground(new Color(133, 193, 233));
        button_rain.setForeground(Color.BLACK);

        random_rain = new JButton("Random Rain");
        random_rain.setPreferredSize(new Dimension(125, 50));
        random_rain.setBackground(new Color(133, 193, 233));
        random_rain.setForeground(Color.BLACK);

        add_files = new JButton("Add Files");
        add_files.setPreferredSize(new Dimension(100, 50));
        add_files.setBackground(new Color(133, 193, 233));
        add_files.setForeground(Color.BLACK);

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
}
