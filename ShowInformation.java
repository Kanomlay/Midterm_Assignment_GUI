import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class ShowInformation extends JPanel {
    JPanel panel_1;
    JPanel panel_2;
    ImageIcon image_good;
    ImageIcon image_normal;
    ImageIcon image_bad;
    JLabel label_1;
    JLabel label_2;
    JLabel label_3;

    public ShowInformation() {
        setLayout(new BorderLayout());

        Border border = BorderFactory.createLineBorder(new Color(243, 138, 138), 10);
        TextField textField = new TextField();
        
        label_1 = new JLabel();
        label_2 = new JLabel();
        label_3 = new JLabel();

        image_good = new ImageIcon(new ImageIcon("good-weather.jpg").getImage().getScaledInstance(480, 285, Image.SCALE_SMOOTH));
        image_normal = new ImageIcon(new ImageIcon("331067992_527005219423324_4972405245421874783_n.jpg").getImage().getScaledInstance(405, 285, Image.SCALE_SMOOTH));
        image_bad = new ImageIcon(new ImageIcon("weather_bad.jpg").getImage().getScaledInstance(405, 285, Image.SCALE_SMOOTH));

        panel_1 = new JPanel(new BorderLayout()); // Ensure BorderLayout is used
        panel_1.setBackground(new Color(174, 214, 241));
        panel_1.setPreferredSize(new Dimension(489, 50));
        
        panel_2 = new JPanel(new GridBagLayout());
        panel_2.setBackground(Color.LIGHT_GRAY);
        panel_2.setPreferredSize(new Dimension(420, 300));
        panel_2.add(label_1);
        panel_2.setBorder(border);

        label_1.setBounds(10, 10, 30, 30);
        label_1.setIcon(image_good);

    
    }
}