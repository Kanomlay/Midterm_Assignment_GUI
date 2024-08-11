import java.awt.Color;

public class Utility {

    // คำนวณเปอร์เซ็นต์ความเสี่ยงตามค่า pm25
    private static double calculatePercentageSick(int pm25) {
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
            percentageSick = 1.0; // สำหรับค่า pm25 ที่เกิน 250 ให้ความเสี่ยงเป็น 100%
        }
        return percentageSick;
    }

    // สุ่มค่าภายในช่วง
    public static int getRandomValueInRange(int min, int max) {
        if (min > max) {
            throw new IllegalArgumentException("Min should be less than or equal to Max.");
        }
        return min + (int) (Math.random() * ((max - min) + 1));
    }

    // คำนวณประชากรที่ป่วยจากค่า randomPopulation และ pm25
    public static final int calculatePopulationSick(int randomPopulation, int pm25) {
        double percentageSick = calculatePercentageSick(pm25);
        double populationSick = randomPopulation * percentageSick;
        return (int) populationSick;
    }

    // คำนวณจำนวนประชากรที่ดี
    public static int calculateGoodPopulation(int randomPopulation, int populationSick) {
        int goodPopulation = randomPopulation - populationSick;
        return goodPopulation;
    }

    // กำหนดสีตามความเสี่ยงทางสุขภาพที่คำนวณจาก pm25
    public static Color getColorForHealthRisk(int pm25) {
        double percentageSick = calculatePercentageSick(pm25);

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
