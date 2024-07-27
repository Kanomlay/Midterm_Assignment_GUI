import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.*;
import java.awt.*;
public class UI_About extends JLabel{
    private JLabel label_1;
    private ImageIcon Icon_1;
    private JPanel panel_1;
    private JPanel panel_Top;
    public UI_About(){  
        setLayout(new BorderLayout());
        label_1 = new JLabel("<html>Namgern<br>66011212232<br>นายกัญจน์ ธนมาลาพงศ์</html>");

        // Load and resize the image
        Icon_1 = new ImageIcon("S__3891207.jpg");
        Image image = Icon_1.getImage(); // transform it
        Image newimg = image.getScaledInstance(250, 250, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        Icon_1 = new ImageIcon(newimg);  // transform it back

        // Initialize the panels
        panel_1 = new JPanel();
        panel_1.setBackground(new Color(174, 214, 241));
        panel_1.setPreferredSize(new Dimension(700, 580));
        panel_1.setLayout(null);

        panel_Top = new JPanel();
        panel_Top.setPreferredSize(new Dimension(700, 50));
        panel_Top.setBackground(Color.LIGHT_GRAY);

        // Set properties for the label
        label_1.setBounds(100, 150, 400, 400);
        label_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
        label_1.setIcon(Icon_1);
        label_1.setHorizontalTextPosition(JLabel.CENTER);
        label_1.setVerticalTextPosition(JLabel.BOTTOM);

        // Add components to the panels
        panel_1.add(label_1);
        add(panel_Top, BorderLayout.NORTH);
        add(panel_1, BorderLayout.WEST);

    }
    public JLabel getLabel(){
        return label_1;
    }
}
