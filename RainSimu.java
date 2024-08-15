public class RainSimu {

    /**
     pm25Levels เก็บค่าระดับ PM2.5 ในแต่ละเซลล์
    targetRow  แถวของเซลล์ที่ต้องการใช้ฝนเทียม
    targetCol  คอลัมน์ของเซลล์ที่ต้องการใช้ฝนเทียม
    */
    public static void useArtificialRain(int[][] pm25Levels, int targetRow, int targetCol) {
        int[][] directions = {
                { 0, 0 }, // เป้าหมาย
                { -1, 0 }, // เหนือป้าหมาย
                { 1, 0 }, // ใต้เป้าหมาย
                { 0, -1 }, // ซ้ายเป้าหมาย
                { 0, 1 }, // ขวาเป้าหมาย
                { -1, -1 }, // บนซ้ายของป้าหมาย
                { -1, 1 }, // บนขวาของเป้าหมาย
                { 1, -1 }, // ล่างซ้ายของเป้าหมาย
                { 1, 1 } // ล่างขวาของเป้าหมาย
        };

        for (int[] direction : directions) {
            int newRow = targetRow + direction[0]; // แถวใหม่ที่กำหนดจากทิศทาง
            int newCol = targetCol + direction[1]; // คอลัมน์ใหม่ที่กำหนดจากทิศทาง

            // ตรวจสอบว่าเซลล์ใหม่อยู่ในขอบเขตของตารางไหม
            if (isInBounds(newRow, newCol, pm25Levels.length, pm25Levels[0].length)) {
                if (direction[0] == 0 && direction[1] == 0) {
                    //เซลล์เป้าหมาย ลดระดับ PM2.5 ลงครึ่งหนึ่ง
                    pm25Levels[newRow][newCol] *= 0.5;
                } else {
                    //ซลล์โดยรอบ ลดระดับ PM2.5 ลง 30%
                    pm25Levels[newRow][newCol] *=  0.7;
                }
            }
        }
    }

    public static void useNaturalRain(int[][] pm25Levels) {
        for (int row = 0; row < pm25Levels.length; row++) {
            for (int col = 0; col < pm25Levels[row].length; col++) {
                // ลดระดับ PM2.5 ลง 50 หน่วย
                pm25Levels[row][col] -= 50;
                // ตรวจสอบว่าไม่ให้ค่าต่ำกว่า 0
                if (pm25Levels[row][col] < 0) {
                    pm25Levels[row][col] = 0;
                }
            }
        }
    }

    /*
         ตรวจสอบว่าเซลล์ที่กำหนดอยู่ในขอบเขตของตาราง
        คืนค่า true ถ้าเซลล์อยู่ในขอบเขต, false ถ้าไม่อยู่
     */
    private static boolean isInBounds(int row, int col, int height, int width) {
        return row >= 0 && row < height && col >= 0 && col < width;
    }
}
