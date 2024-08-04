import java.awt.Color;

public class Utility {

    public static int getHealthyPopulation(int pm25) {
        double sickPercentage = 0.0;
        if (pm25 >= 0 && pm25 <= 50) {
            sickPercentage = Math.random() * 0.09; // 0-9%
        } else if (pm25 >= 51 && pm25 <= 100) {
            sickPercentage = 0.10 + Math.random() * 0.09; // 10-19%
        } else if (pm25 >= 101 && pm25 <= 150) {
            sickPercentage = 0.20 + Math.random() * 0.09; // 20-29%
        } else if (pm25 >= 151 && pm25 <= 250) {
            sickPercentage = 0.30 + Math.random() * 0.20; // 30-50%
        }
        return (int) (sickPercentage * 100);
    }
    
    public static Color getColorForHealthRisk(int sickPercentage) {
        if (sickPercentage >= 30) {
            return Color.RED; // 30% or more
        } else if (sickPercentage >= 20) {
            return Color.ORANGE; // 20-29%
        } else if (sickPercentage >= 10) {
            return Color.YELLOW; // 10-19%
        } else {
            return Color.GREEN; // 0-9%
        }
    }
}
