import java.awt.*;
import javax.swing.*;

public class mybutton extends JPanel {
    private RoundButton button_1;
    private RoundButton button_2;
    private RoundButton button_3;

    public mybutton() {
        // Set the background color of the panel
        setBackground(new Color(133, 193, 233)); // Light gray background for the panel

        // Create buttons with different colors
        button_1 = new RoundButton("START");
        button_1.setButtonColor(Color.GREEN); // Set color for button 1
        button_1.setHoverColor(Color.YELLOW); // Set hover color for button 1

        button_2 = new RoundButton("About");
        button_2.setButtonColor(Color.ORANGE); // Set color for button 2
        button_2.setHoverColor(Color.RED); // Set hover color for button 2

        button_3 = new RoundButton("EXIT");
        button_3.setButtonColor(Color.PINK); // Set color for button 3
        button_3.setHoverColor(Color.MAGENTA); // Set hover color for button 3

        // Set button sizes
        button_1.setPreferredSize(new Dimension(100, 40));
        button_2.setPreferredSize(new Dimension(100, 40));
        button_3.setPreferredSize(new Dimension(100, 40));

        // Set layout manager
        setLayout(new FlowLayout());

        // Add buttons to panel
        add(button_1);
        add(button_2);
        add(button_3);
    }

    public RoundButton getButton1() {
        return button_1;
    }

    public RoundButton getButton2() {
        return button_2;
    }

    public RoundButton getButton3() {
        return button_3;
    }
}
