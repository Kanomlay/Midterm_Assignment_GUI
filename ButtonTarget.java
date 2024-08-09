import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class ButtonTarget implements ActionListener {
    private int row; // เก็บแถวของปุ่มที่ถูกคลิก
    private int col; // เก็บคอลัมน์ของปุ่มที่ถูกคลิก
    private CalculateProcess cal;
    private JButton[][] buttons;

    // Constructor รับค่า row, col, cal, และ buttons เพื่อกำหนดค่าให้กับตัวแปร
    public ButtonTarget(int row, int col, CalculateProcess cal, JButton[][] buttons) {
        this.row = row;
        this.col = col;
        this.cal = cal;
        this.buttons = buttons;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        cal.setTarget(row, col);
        cal.updateButtons();
    }
}/*import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class ButtonTarget implements ActionListener {
    private int row;
    private int col;
    private CalculateProcess frame;
    private JButton[][] buttons;

    public ButtonTarget(int row, int col, CalculateProcess frame, JButton[][] buttons) {
        this.row = row;
        this.col = col;
        this.frame = frame;
        this.buttons = buttons;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // กำหนดเป้าหมายที่ปุ่มนี้เมื่อถูกคลิก
        frame.setTarget(row, col);
    }
}
 */
