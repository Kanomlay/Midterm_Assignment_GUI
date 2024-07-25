import java.awt.*;
import javax.swing.*;

public class RoundButton extends JButton {
    private Color buttonColor = new Color(248, 196, 113); // Default button color
    private Color hoverColor = Color.WHITE; // Color when hovered over

    public RoundButton(String label) {
        super(label);
        setContentAreaFilled(false); // ไม่เติมสีพื้นของปุ่ม
        setFocusPainted(false); // ลบการเน้นเมื่อปุ่มถูกเลือก
    }

    @Override
    protected void paintComponent(Graphics g) {
        if (getModel().isArmed()) {
            g.setColor(hoverColor); // เปลี่ยนสีเมื่อปุ่มถูกกด
        } else {
            g.setColor(buttonColor); // ใช้สีพื้นของปุ่ม
        }
        g.fillRoundRect(0, 0, getWidth(), getHeight(), 30, 30); // วาดปุ่มเป็นรูปวงรี
        super.paintComponent(g);
    }

    @Override
    protected void paintBorder(Graphics g) {
        g.setColor(Color.BLACK); // สีของขอบปุ่ม
        g.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 30, 30); // วาดขอบปุ่มเป็นรูปวงรี
    }

    // Setters for button colors
    public void setButtonColor(Color color) {
        this.buttonColor = color;
        repaint();
    }

    public void setHoverColor(Color color) {
        this.hoverColor = color;
    }
}
