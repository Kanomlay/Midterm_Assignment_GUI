import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.*;
import java.awt.*;
import javax.swing.border.Border;
public class UI_About extends JLabel{
    JLabel label_1;
    JLabel label_2;
    JLabel label_3;
    ImageIcon Icon_1;
    ImageIcon Icon_2;
    ImageIcon Icon_3;
    JPanel panel_1;
    JPanel panel_Top;
    JPanel panel_Bottom;

    public UI_About(){  
        setLayout(null);
        label_1 = new JLabel("<html>Namgern<br>66011212232<br>นายกัญจน์ ธนมาลาพงศ์</html>");
        label_2 = new JLabel("<html>Kan<br>66011212006<br>นายกาญจน์ เจริญยุทธ</html>");
        label_3 = new JLabel("<html>Mix<br>66011212078<br>ขจรพัฒน์ สุมชาวง</html>");

        Border border = BorderFactory.createLineBorder(Color.BLACK, 2);
        setBackground(new Color(174, 214, 241));

        
        // Load and resize the image
        Icon_1 = new ImageIcon("S__3891207.jpg");
        Image image_1 = Icon_1.getImage(); // transform it
        Image newimg_1 = image_1.getScaledInstance(250, 250, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        Icon_1 = new ImageIcon(newimg_1);  // transform it back

        Icon_2 = new ImageIcon("13728.jpg");
        Image image_2 = Icon_2.getImage(); // transform it
        Image newimg_2 = image_2.getScaledInstance(250, 250, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        Icon_2 = new ImageIcon(newimg_2);  // transform it back

        Icon_3 = new ImageIcon("13729.jpg");
        Image image_3 = Icon_3.getImage(); // transform it
        Image newimg_3 = image_3.getScaledInstance(250, 250, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        Icon_3 = new ImageIcon(newimg_3);  // transform it back

        panel_Top = new JPanel();
        panel_Top.setBounds(0, 0, 1000, 50);
        panel_Top.setPreferredSize(new Dimension(700, 50));
        panel_Top.setBorder(border);
        panel_Top.setBackground(getBackground());

        panel_Bottom = new JPanel();
        panel_Bottom.setBounds(0, 1000, 1000, 50);
        panel_Bottom.setPreferredSize(new Dimension(700, 50));
        panel_Bottom.setBorder(border);
        panel_Bottom.setBackground(getBackground());

        // Set properties for the label
        label_1.setBounds(15, 150, 300, 400);
        label_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
        label_1.setIcon(Icon_1);
        label_1.setHorizontalTextPosition(JLabel.CENTER);
        label_1.setVerticalTextPosition(JLabel.BOTTOM);
        label_1.setBackground(getBackground());
        label_1.setIconTextGap(NEXT);
        label_1.setOpaque(true);
        label_1.setBorder(border);
        label_1.setVerticalAlignment(JLabel.CENTER);
        label_1.setHorizontalAlignment(JLabel.CENTER);

        label_2.setBounds(335, 150, 300, 400);
        label_2.setFont(new Font("Tahoma", Font.PLAIN, 22));
        label_2.setIcon(Icon_2);
        label_2.setHorizontalTextPosition(JLabel.CENTER);
        label_2.setVerticalTextPosition(JLabel.BOTTOM);
        label_2.setBackground(getBackground());
        label_2.setIconTextGap(NEXT);
        label_2.setOpaque(true);
        label_2.setBorder(border);
        label_2.setVerticalAlignment(JLabel.CENTER);
        label_2.setHorizontalAlignment(JLabel.CENTER);

        label_3.setBounds(650, 150, 300, 400);
        label_3.setFont(new Font("Tahoma", Font.PLAIN, 22));
        label_3.setIcon(Icon_3);
        label_3.setHorizontalTextPosition(JLabel.CENTER);
        label_3.setVerticalTextPosition(JLabel.BOTTOM);
        label_3.setBackground(getBackground());
        label_3.setIconTextGap(NEXT);
        label_3.setOpaque(true);
        label_3.setBorder(border);
        label_3.setVerticalAlignment(JLabel.CENTER);
        label_3.setHorizontalAlignment(JLabel.CENTER);



        // Add components to the panels
        add(panel_Top);
        add(label_1);
        add(label_2);
        add(label_3);
    }
    public JLabel getLabel(){
        return label_1;
    }
}
