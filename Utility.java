import java.awt.Color;

public class Utility {

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


    public static int getRandomValueInRange(int min, int max) {
        int value = 0;
        if (min > max) {
            value = max + (int) (Math.random() * ((min - max) + 1));
        }
        else if(max > min){
            value = min + (int) (Math.random() * ((max - min) + 1));
        }
    
        else{
            value = max + (int) (Math.random() * ((min - max) + 1));
        }
        return value;
    }

    public static final int calculatePopulationSick(int randomPopulation, int pm25) {
        double percentageSick = calculatePercentageSick(pm25);
        double populationSick = randomPopulation * percentageSick;
        return (int) populationSick;
    }

    public static int calculateGoodPopulation(int randomPopulation, int populationSick) {
        int goodPopulation = randomPopulation - populationSick;
        return goodPopulation;
    }


    public static Color getColorForHealthRisk(int pm25) {
        double percentageSick = calculatePercentageSick(pm25);

        if (percentageSick >= 0.30) {
            return Color.RED; // 30% or more
        } else if (percentageSick >= 0.20) {
            return Color.ORANGE; // 20-29%
        } else if (percentageSick >= 0.10) {
            return Color.YELLOW; // 10-19%
        } else {
            return Color.GREEN; // 0-9%
        }
    }
}
