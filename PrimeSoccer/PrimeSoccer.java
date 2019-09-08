import java.util.ArrayList;
import java.util.Arrays;

public class PrimeSoccer {
    public static double getProbability(int skillOfTeamA, int skillOfTeamB) {
        double probA = prob((double) skillOfTeamA / 100);
        double probB = prob((double) skillOfTeamB / 100);
        return probA + probB - probA * probB;
    }

    private static double prob(double skill) {
        ArrayList<Double> primes = new ArrayList<>();
        primes.add(2.0);
        primes.add(3.0);
        primes.add(5.0);
        primes.add(7.0);
        primes.add(11.0);
        primes.add(13.0);
        primes.add(17.0);
        double[][] score = new double[19][19];

        for (int i = 0; i < score.length; i++) {
            Arrays.fill(score[i], -1);
        }

        score[1][0] = 1 - skill; // probability that score after match 1 is 0
        score[1][1] = skill; // probability that score after match 1 is 1
        for (int i = 2; i < score.length; i++) {
            for (int j = 0; j < i; j++) {
                if (score[i - 1][j] != -1) {
                    if (score[i][j] == -1)
                        score[i][j] = score[i - 1][j] * (1 - skill);
                    else
                        score[i][j] += score[i - 1][j] * (1 - skill);
                    if (score[i][j + 1] == -1)
                        score[i][j + 1] = score[i -1][j] * skill;
                    else
                        score[i][j + 1] += score[i -1][j] * skill;
                }
            }
        }

        double result = 0;
        for (int i = 0; i < 19; i++) {
            if (primes.indexOf((double) i) != -1) {
                result += score[18][i];
            }
        }
        return result;
    }
    public static void main(String[] args) {
        System.out.println(getProbability(50,50));
    }
}
