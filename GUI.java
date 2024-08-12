import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class GUI extends JFrame{
    private JPanel mainpanel;
    private JPanel Aboutmenu;
    private CardLayout cardLayout;
    public GUI(){
        cardLayout = new CardLayout();
        mainpanel = new JPanel(cardLayout);

        mybutton button = new mybutton();
        UI_About about = new UI_About(cardLayout,mainpanel);
        CalculateProcess calculateProcess = new CalculateProcess();
        calculateProcess.setBackActionListener(cardLayout, mainpanel);

        mainpanel.add(button,"Main menu");
        mainpanel.add(calculateProcess,"calculateProcess");
        mainpanel.add(about,"About");

        cardLayout.show(mainpanel, "Main menu");

        add(mainpanel);
        setTitle("PM 2.5");
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setSize(1500,800);
        setLocationRelativeTo(null);
        setVisible(true);
        button.getButton1().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                cardLayout.show(mainpanel, "calculateProcess");
            }
            
        });
        button.getButton2().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(mainpanel, "About");
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
