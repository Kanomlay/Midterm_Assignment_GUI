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
            percentageSick = 0.30 + Math.random() * 0.20;} // 30-50%
            else{
                percentageSick = 1.0;
            };
        return percentageSick;
    }

    // สุ่มค่าภายในช่วง
    public static int getRandomValueInRange(int min, int max) {
        if (min > max) {
            throw new IllegalArgumentException("Min should be less than or equal to Max.");
        }
        return min + (int) (Math.random() * ((max - min) + 1));
    }

    // คำนวณประชากรที่ป่วยจากช่วงและเปอร์เซ็นต์ความเสี่ยง
    public static final int calculatePopulationSick(int min, int max, int pm25) {
        int randomPopulation = getRandomValueInRange(min, max);
        double percentageSick = calculatePercentageSick(pm25);
        double populationSick = randomPopulation * percentageSick;
        return  (int) populationSick;
    }
    
    // คำนวณจำนวนประชากรที่ดี
    public static int calculateGoodPopulation(int min, int max, int pm25) {
        int randomPopulation = getRandomValueInRange(min, max);
        int populationSick = calculatePopulationSick(min, max, pm25);
        int goodPopulation = randomPopulation - populationSick;
        return goodPopulation;
    }

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

    private int getHealthyPopulation(int pm25, int population) {
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

        return (int) (population * (1 - sickPercentage));
    }

    
}

