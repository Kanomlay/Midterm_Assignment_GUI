import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Start_GUI_Color extends JPanel {
    private JButton button_rain;
    private JButton Random_rain;

    public Start_GUI_Color() {
        setBackground(new Color(174, 214, 241)); // Set background color
        button_rain = new JButton("artificial rain"); // Create button with label
        button_rain.setSize(100, 100); // Set button size
        button_rain.setBounds(150, 700, 150, 50); // Set button position and size
        button_rain.setBackground(new Color(133, 193, 233));
        button_rain.setForeground(Color.BLACK);
        Random_rain = new JButton("Random Rain"); // Create button with labe
        Random_rain.setSize(100, 100);
        Random_rain.setBounds(350, 700, 125, 50); // Set button size
        Random_rain.setBackground(new Color(133, 193, 233));
        Random_rain.setForeground(Color.BLACK);
        setLayout(null); // Set layout to null for absolute positioning
        add(button_rain); // Add button to the panel
        add(Random_rain);
    }

    public JButton getButtonRain() {
        return button_rain;
    }
    public JButton getRandomRain() {
        return Random_rain;
    }
}

