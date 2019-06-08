// Time complexity: O(k*n^2)
// Space complexity: O(n*k)

import java.util.Arrays;
import java.util.Comparator;

class Compare implements Comparator {
    public int compare(Object o1, Object o2) {
        String s1 = (String) o1;
        String s2 = (String) o2;

        String[] arr1 = s1.split(" "); // O(k1)
        String[] arr2 = s2.split(" "); // O(k2)

        int diff = arr1[1].compareTo(arr2[1]);
        if (diff != 0) return diff;
        return arr1[0].compareTo(arr2[0]);

    }
}

public class ClientList {
    public static String[] dataCleanup(String[] names) {
        String[] modified = new String[names.length];
        for (int i = 0; i < names.length; i++) {
            if (names[i].indexOf(',') != -1) {
                String[] temp = names[i].split(",");
                modified[i] = temp[1].trim() + " " + temp[0].trim();
            }
            else {
                modified[i] = names[i];
            }
        }
        Arrays.sort(modified, new Compare()); // O(n*logn*k)
        return modified;
    }
}
