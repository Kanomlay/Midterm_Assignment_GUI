import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class GUI extends JFrame{
    private JPanel mainpanel;
    private CardLayout cardLayout;
    public GUI(){
        cardLayout = new CardLayout();//
        mainpanel = new JPanel(cardLayout);

        mybutton button = new mybutton();
        UI_About about = new UI_About(cardLayout,mainpanel);
        CalculateProcess calculateProcess = new CalculateProcess();
        calculateProcess.setBackActionListener(cardLayout, mainpanel);

        mainpanel.add(button,"Main menu");// เพิ่ม button เข้าไปใน mainpanel โดยใช้ชื่อ "Main menu"
        mainpanel.add(calculateProcess,"calculateProcess");// เพิ่ม calculateProcess เข้าไปใน mainpanel โดยใช้ชื่อ "calculateProcess"
        mainpanel.add(about,"About");// เพิ่ม about เข้าไปใน mainpanel โดยใช้ชื่อ "About"

        cardLayout.show(mainpanel, "Main menu");// แสดง "Main menu" เมื่อเริ่มต้น

        add(mainpanel);
        setTitle("PM 2.5");
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setResizable(false);
        setSize(1500,800);
        setLocationRelativeTo(null);
        setVisible(true);
        button.getButton1().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                cardLayout.show(mainpanel, "calculateProcess");// เมื่อกดปุ่ม แสดงหน้า calculateProcess
            }
            
        });
        button.getButton2().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                cardLayout.show(mainpanel, "About");// เมื่อกดปุ่ม แสดงหน้า About
            }
            
        });
        button.getButton3().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                System.exit(0);
            }
            
        });
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                // TODO Auto-generated method stub
                new GUI();
            }
            
        });
    }
}
