import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class ShowInformation extends JPanel {
    JPanel panel_1;
    JPanel panel_2;
    JPanel panel_3;
    ImageIcon image_good;
    ImageIcon image_normal;
    ImageIcon image_bad;
    ImageIcon image_veryBad;
    JLabel label_1;
    JLabel infoLabel;
    Utility utility;
    double percentageSick;
    public ShowInformation() {
        setLayout(new BorderLayout());
        utility = new Utility();
        Border border = BorderFactory.createLineBorder(new Color(243, 138, 138), 10);

        image_good = new ImageIcon(new ImageIcon("good-weather.jpg").getImage().getScaledInstance(480, 285, Image.SCALE_SMOOTH));
        image_normal = new ImageIcon(new ImageIcon("normal-weather.jpg").getImage().getScaledInstance(405, 285, Image.SCALE_SMOOTH));
        image_bad = new ImageIcon(new ImageIcon("bad-weather.jpg").getImage().getScaledInstance(405, 285, Image.SCALE_SMOOTH));
        image_veryBad = new ImageIcon(new ImageIcon("very-bad-weather.jpg").getImage().getScaledInstance(405, 285, Image.SCALE_SMOOTH));

        label_1 = new JLabel();
        label_1.setPreferredSize(new Dimension(405, 285));

        infoLabel = new JLabel();
        infoLabel.setPreferredSize(new Dimension(405, 50));
        infoLabel.setHorizontalAlignment(SwingConstants.CENTER);
        infoLabel.setVerticalAlignment(SwingConstants.CENTER);

        panel_1 = new JPanel(new BorderLayout());
        panel_1.setBackground(new Color(174, 214, 241));
        panel_1.setPreferredSize(new Dimension(489, 50));
        //panel_1.add(infoLabel, BorderLayout.SOUTH);

        panel_2 = new JPanel(new GridBagLayout());
        panel_2.setBackground(Color.LIGHT_GRAY);
        panel_2.setPreferredSize(new Dimension(420, 300));
        panel_2.add(label_1);
        panel_2.setBorder(border);
 
        panel_3 = new JPanel(new BorderLayout());
        panel_3.setBackground(new Color(174, 214, 241));
        panel_3.setPreferredSize(new Dimension(420, 300));

        add(panel_1, BorderLayout.WEST);
        panel_1.add(panel_2, BorderLayout.NORTH);
        panel_3.add(infoLabel,BorderLayout.CENTER);
        panel_1.add(panel_3,BorderLayout.CENTER);

    }

    public void updateImage(double percentageSick) {
        if (percentageSick > 30.0) {
            label_1.setIcon(image_veryBad);
        } else if (percentageSick > 20.0) {
            label_1.setIcon(image_bad);
        } else if (percentageSick > 10.0) {
            label_1.setIcon(image_normal);
        } else {
            label_1.setIcon(image_good);
        }
        label_1.repaint();
        panel_2.repaint();

    }

    /*private static void setFontWithThaiSupport(JLabel infoLabel) {
        infoLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
    }*/

    public void getText(int pm25Value, int randomPopulation, int populationSick, double percentageSick, int goodPopulation) {
        setFont(getFont());
        infoLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        String text = "<html>"
                    + "<h1><b>ปริมาณฝุ่น : </b> " + pm25Value + "<br>"
                    + "<b>จำนวนประชากร : </b> " + randomPopulation + "<br>"
                    + "<b>ประชากรที่สุขภาพดี : </b> " + goodPopulation +"<br>"
                    + "<b>ประชากรที่ป่วย : </b> " + populationSick + "<br>"
                    + "<b>ร้อยละของประชากรที่ป่วย : </b> " + String.format("%.2f", percentageSick) + "%<br>"
                    + "</h1></html>";

        infoLabel.setText(text);
    }
}
