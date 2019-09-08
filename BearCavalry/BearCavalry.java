import java.util.*;

public class BearCavalry {
    private static final int MOD = 1000000007;

    public static void reverse(int[] arr) {
        for (int i = 0; i < arr.length/2; i++) {
            int temp = arr[arr.length-i-1];
            arr[arr.length-1-i] = arr[i];
            arr[i] = temp;
        }
    }
    public static int countAssignments(int[] warriors, int[] horses) {
        Arrays.sort(horses);
        reverse(horses);

        int cap = warriors[0];
        int[] arr = new int[warriors.length - 1];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = warriors[i + 1];
        }
        Arrays.sort(arr);
        reverse(arr);

        long ans = 0;
        for (int i = 0; i < warriors.length; i++) {
            int capStrength = cap * horses[i];

            ArrayList<Integer> list = new ArrayList<>();
            for (int j = 0; j < horses.length; j++) {
                if (j != i)
                    list.add(horses[j]);
            }
            long count = 1;
            int cur = 0;
            for (int j = 0; j < arr.length; j++) {
                while (cur < arr.length && arr[j] * list.get(cur) < capStrength)
                    cur++;
                count = count * Math.max(0, cur - j) % MOD;

            }
            ans = (ans + count) % MOD;
        }
        return Math.toIntExact(ans);
    }
}
