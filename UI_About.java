import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

    public UI_About(CardLayout cardLayout,JPanel mainpanel){  

        setLayout(null);
        label_1 = new JLabel("<html>Namgern<br>66011212232<br>นายกัญจน์ ธนมาลาพงศ์</html>");
        label_2 = new JLabel("<html>Kan<br>66011212006<br>นายกาญจน์ เจริญยุทธ</html>");
        label_3 = new JLabel("<html>Mix<br>66011212078<br>ขจรพัฒน์ สุมชาวง</html>");

        Border border = BorderFactory.createLineBorder(Color.BLACK, 2);
        setBackground(new Color(174, 214, 241));

        Icon_1 = new ImageIcon(new ImageIcon("S__3891207.jpg").getImage().getScaledInstance(350, 285, Image.SCALE_SMOOTH));
        Icon_2 = new ImageIcon(new ImageIcon("13728.jpg").getImage().getScaledInstance(350, 285, Image.SCALE_SMOOTH));
        Icon_3 = new ImageIcon(new ImageIcon("13729.jpg").getImage().getScaledInstance(350, 285, Image.SCALE_SMOOTH));

        panel_Top = new JPanel();
        panel_Top.setBounds(0, 0, 1500, 50);
        panel_Top.setLayout(new BorderLayout());
        panel_Top.setPreferredSize(new Dimension(700, 50));
        panel_Top.setBorder(border);
        panel_Top.setBackground(getBackground());

        JButton button_back = new JButton("Back");
        button_back.setPreferredSize(new Dimension(80, 30));
        button_back.setBackground(new Color(133, 193, 233));
        panel_Top.add(button_back, BorderLayout.WEST);

        panel_Bottom = new JPanel();
        panel_Bottom.setBounds(0, 715, 1500, 50);
        panel_Bottom.setPreferredSize(new Dimension(700, 50));
        panel_Bottom.setBorder(border);
        panel_Bottom.setBackground(getBackground());


        label_1.setBounds(50, 150, 400, 500);
        label_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
        label_1.setIcon(Icon_1);
        label_1.setHorizontalTextPosition(JLabel.CENTER);
        label_1.setVerticalTextPosition(JLabel.BOTTOM);
        label_1.setBackground(getBackground());
        label_1.setIconTextGap(NEXT);
        label_1.setOpaque(true);// ทำให้พื้นหลังโปร่งใส
        label_1.setBorder(border);
        label_1.setVerticalAlignment(JLabel.CENTER);
        label_1.setHorizontalAlignment(JLabel.CENTER);

        label_2.setBounds(540, 150, 400, 500);
        label_2.setFont(new Font("Tahoma", Font.PLAIN, 22));
        label_2.setIcon(Icon_2);
        label_2.setHorizontalTextPosition(JLabel.CENTER);
        label_2.setVerticalTextPosition(JLabel.BOTTOM);
        label_2.setBackground(getBackground());
        label_2.setIconTextGap(NEXT);
        label_2.setOpaque(true);
        label_2.setVerticalAlignment(JLabel.CENTER);
        label_2.setHorizontalAlignment(JLabel.CENTER);

        label_3.setBounds(1025, 150, 400, 500);
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

        add(panel_Top);
        add(panel_Bottom);
        add(label_1);
        add(label_2);
        add(label_3);
        button_back.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                cardLayout.show(mainpanel, "Main menu");
            }
            
        });
        
    }
}
