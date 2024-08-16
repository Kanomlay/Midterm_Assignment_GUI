import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Random;

public class DataPanel extends JPanel {
    private JButton[][] buttons;
    private int[][] pm25;
    private int[][] populations;
    private CalculateProcess frame;
    private ControlPanel controlPanel;
    private ShowInformation showInformation;
    private Random random;

    public DataPanel(int[][] pm25, JButton[][] buttons, int[][] populations, CalculateProcess frame, ControlPanel controlPanel, ShowInformation showInformation) {
        this.pm25 = pm25;
        this.buttons = buttons;
        this.populations = populations;
        this.frame = frame;
        this.controlPanel = controlPanel;
        this.showInformation = showInformation;

        random = new Random();

        setLayout(new GridLayout(10, 20, 0, 0)); 
    }

    // ฟังก์ชันสำหรับการเพิ่มไฟล์ข้อมูล
    public void AddFile() {
        JFileChooser fileChooser = new JFileChooser();
        int returnValue = fileChooser.showOpenDialog(frame);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            Path filePath = fileChooser.getSelectedFile().toPath();
            loadDataFromFile(filePath);
        }
    }

    public void loadDataFromFile(Path filePath) {
        removeAll(); // ล้างปุ่มที่มีอยู่เดิม
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath.toFile()))) {
            String line;
            int row = 0;
            while ((line = reader.readLine()) != null && row < 10) {
                String[] values = line.split("\\s+");// แยกข้อมูลด้วยช่องว่าง
                for (int col = 0; col < values.length && col < 20; col++) {

                    int random_chance = random.nextInt(100);//สุ่มโอกาศผิดพลาด
                    if (random_chance < 15) {
                        int  OriginalValue = Integer.parseInt(values[col]);
                        int random_error = random.nextInt(21)-10;
                    int random_chance = random.nextInt(100);
                    if (random_chance < 3) {
                        int  OriginalValue = Integer.parseInt(values[col]);
                        int random_error = random.nextInt(100)-50;
                        int error_data =  OriginalValue + random_error;
                        pm25[row][col] = Math.max(error_data,0);
                    } else { 
                        pm25[row][col] = Integer.parseInt(values[col]);
                    }
                   
                    JButton button = new JButton();
                    button.setPreferredSize(new Dimension(50, 30));
                    button.setBackground(Utility.getColorForHealthRisk(pm25[row][col]));
                    buttons[row][col] = button;
                    button.addActionListener(new ButtonTarget(row, col, frame, buttons, pm25, populations, controlPanel, showInformation));
                    add(button);// เพิ่มปุ่มลงใน panel
                }
                row++;
            }
        } catch (IOException e) {
            System.out.println("IOException: " + e.getMessage());
        }catch (NumberFormatException ex){
            JOptionPane.showMessageDialog(null, "Wrong File");
        }
        revalidate(); 
        repaint();    
    }
}
