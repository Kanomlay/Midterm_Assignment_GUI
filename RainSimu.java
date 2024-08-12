public class RainSimu {
    public static void useArtificialRain(int[][] pm25Levels, int targetRow, int targetCol) {
        int[][] directions = {
                { 0, 0 }, { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 },
                { -1, -1 }, { -1, 1 }, { 1, -1 }, { 1, 1 }
        };

        for (int[] direction : directions) {
            int newRow = targetRow + direction[0];
            int newCol = targetCol + direction[1];
            if (isInBounds(newRow, newCol, pm25Levels.length, pm25Levels[0].length)) {
                if (direction[0] == 0 && direction[1] == 0) {
                    pm25Levels[newRow][newCol] *= 0.5;
                } else {
                    pm25Levels[newRow][newCol] *= 0.7;
                }
            }
        }
    }

    public static void useNaturalRain(int[][] pm25Levels) {
        for (int row = 0; row < pm25Levels.length; row++) {
            for (int col = 0; col < pm25Levels[row].length; col++) {
                pm25Levels[row][col] -= 50;
                if (pm25Levels[row][col] < 0) {
                    pm25Levels[row][col] = 0;
                }
            }
        }
    }

    private static boolean isInBounds(int row, int col, int height, int width) {
        return row >= 0 && row < height && col >= 0 && col < width;
    }
}
