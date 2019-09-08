import java.util.Arrays;

public class ChangingSounds {
    public int maxFinal(int[] changeIntervals, int beginLevel, int maxLevel) {
        boolean[][] filled = new boolean[changeIntervals.length+1][maxLevel+1];
        for (int i = 0; i < changeIntervals.length; i++) {
            Arrays.fill(filled[i], false);
        }
        filled[0][beginLevel] = true;

        for (int i = 0; i < changeIntervals.length; i++) {
            for (int j = 0; j < maxLevel; j++) {
                if (filled[i][j]) {
                    if (j + changeIntervals[i] <= maxLevel)
                        filled[i + 1][j + changeIntervals[i]] = true;
                    if (j - changeIntervals[i] >= 0)
                        filled[i+1][j - changeIntervals[i]] = true;
                }
            }
        }

        int max = -1;
        for (int i = 0; i < changeIntervals.length; i++) {
            if (filled[changeIntervals.length][i])
                max = i;
        }
        return max;
    }
}
