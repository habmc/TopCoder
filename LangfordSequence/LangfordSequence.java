import java.util.*;

public class LangfordSequence {
    static int[] data;
    static int sz;
    static int result[], best[];

    static boolean gen(int index) {
        if (index == sz) {
            for (int i = 0; i < 2 * sz; i++) {
                if (result[i] != -1)
                    best[i] = result[i];
            }
            return true;
        }
        for (int i = 0; i < result.length - data[index] - 1; i++) {
            if (result[i] == -1 && result[i + data[index] + 1] == -1) {
                result[i] = data[index];
                result[i + data[index] + 1] = data[index];
                if (gen(index + 1)) {
                    return true;
                }
                result[i] = -1;
                result[i + data[index] + 1] = -1;
            }
        }
        return false;
    }

    public static int[] getFirst(int[] aa) {
        sz = aa.length;
        data = aa;
        Arrays.sort(data);
        result = new int[2 * sz];
        best = new int[2 * sz];
        Arrays.fill(result, -1);
        Arrays.fill(best, 1000000);
        gen(0);
        if (best[0] != 1000000) {
            for (int i = 0; i < best.length; i++)
                System.out.print(best[i] + " ");
            return best;
        } else {
            return new int[0];
        }
    }

    public static void main(String[] args) {
        int[] x = {3, 4, 5, 6, 7, 9, 10, 12}	;
        getFirst(x);
    }
}
