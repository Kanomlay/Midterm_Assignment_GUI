import java.awt.*;
import javax.swing.*;

public class RoundButton extends JButton {
    private Color buttonColor = new Color(248, 196, 113);
    private Color hoverColor = Color.WHITE; 

    public RoundButton(String label) {
        super(label);
        setContentAreaFilled(false);
        setFocusPainted(false); 
    }

    @Override
    protected void paintComponent(Graphics g) {
        if (getModel().isArmed()) {
            g.setColor(hoverColor); 
        } else {
            g.setColor(buttonColor); 
        }
        g.fillRoundRect(0, 0, getWidth(), getHeight(), 30, 30); 
        super.paintComponent(g);
    }

    @Override
    protected void paintBorder(Graphics g) {
        g.setColor(Color.BLACK); 
        g.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 30, 30); 
    }

    public void setButtonColor(Color color) {
        this.buttonColor = color;
        repaint();
    }

    public void setHoverColor(Color color) {
        this.hoverColor = color;
    }
}
