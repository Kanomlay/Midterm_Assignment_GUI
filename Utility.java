import java.awt.Color;

public class Utility {

    public static Color getColorForHealthRisk(int pm25) {
        double percentageSick;
        if (pm25 >= 0 && pm25 <= 50) {
            percentageSick = Math.random() * 0.09; // 0-9%
        } else if (pm25 >= 51 && pm25 <= 100) {
            percentageSick = 0.10 + Math.random() * 0.09; // 10-19%
        } else if (pm25 >= 101 && pm25 <= 150) {
            percentageSick = 0.20 + Math.random() * 0.09; // 20-29%
        } else if (pm25 >= 151 && pm25 <= 250) {
            percentageSick = 0.30 + Math.random() * 0.20; // 30-50%
        } else {
            percentageSick = 0.0; // ตั้งให้ค่าเป็น 0 ถ้า pm25 น้อยกว่า 0 หรือมากกว่า 250
        }

        if (percentageSick > 0.30) {
            return Color.RED; // 30% or more
        } else if (percentageSick > 0.20) {
            return Color.ORANGE; // 20-29%
        } else if (percentageSick > 0.10) {
            return Color.YELLOW; // 10-19%
        } else {
            return Color.GREEN; // 0-9%
        }
    }
}
