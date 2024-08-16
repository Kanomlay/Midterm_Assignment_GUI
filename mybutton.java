import java.awt.*;
import javax.swing.*;

public class mybutton extends JPanel {
    private RoundButton button_1;
    private RoundButton button_2;
    private RoundButton button_3;
    private JLabel label;

    public mybutton() {
        // Set the background color of the panel
        setBackground(new Color(174, 214, 241)); // ตั้งค่าสี background สำหรับ panel
        

        // Create buttons with different colors
        button_1 = new RoundButton("START");
        button_1.setButtonColor(new Color(133, 193, 233)); // Set color for button 1
        button_1.setHoverColor(new Color(46, 134, 193 )); // เมื่อกดจะเปลี่ยนสี

        button_2 = new RoundButton("About");
        button_2.setButtonColor(new Color(133, 193, 233));
        button_2.setHoverColor(new Color(46, 134, 193 )); 

        button_3 = new RoundButton("EXIT");
        button_3.setButtonColor(new Color(133, 193, 233)); 
        button_3.setHoverColor(new Color(46, 134, 193 )); 

        // กำหนดขนาด
        button_1.setPreferredSize(new Dimension(100, 40)); 
        button_2.setPreferredSize(new Dimension(100, 40));
        button_3.setPreferredSize(new Dimension(100, 40));

        label = new JLabel("Pm 2.5");
        label.setFont(new Font("Arial",Font.BOLD,72));
        label.setForeground(Color.BLACK);
        label.setBounds(800, 300, 500, 100);


       // ตั้งค่า layout manager เป็น null เพื่อให้สามารถกำหนดตำแหน่งของ component ได้
       setLayout(null);
       button_1.setBounds(30, 150, 200, 100);
       button_2.setBounds(30, 300, 200, 100);
       button_3.setBounds(30, 450, 200, 100); 

        // เพิ่มปุ่มและ label ไปยัง panel
        add(button_1);
        add(button_2);
        add(button_3);
        add(label);
    }
    // ฟังก์ชันสำหรับการเข้าถึงปุ่ม
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
