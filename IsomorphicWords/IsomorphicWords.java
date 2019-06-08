// Time complexity: O(n^2)
// Space complexity: O(n)

import java.util.HashMap;
import java.util.Map;

public class IsomorphicWords {
    public static String getPattern(String s) {
        int[] idx = new int[26];
        for (int i = 0; i < idx.length; i++) {
            idx[i] = -1;
        }
        int distinct = 0;
        StringBuilder pattern = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            int j = idx[s.charAt(i) - 'a'];
            if (j == -1) {
                idx[s.charAt(i) - 'a'] = ++distinct;
                pattern.append(distinct);
            }
            else {
                pattern.append(j);
            }
        }
        return pattern.toString();
    }


    public static int countPairs(String[] words) {
        String[] patterns = new String[words.length];
        for (int i = 0; i < patterns.length; i++) {
            patterns[i] = getPattern(words[i]);
        }


        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < patterns.length; i++) {
            if (map.containsKey(patterns[i]))
                map.put(patterns[i], map.get(patterns[i]) + 1);
            else
                map.put(patterns[i], 1);
        }

        int count = 0;
        for (Map.Entry<String, Integer> i: map.entrySet()) {
            if (i.getValue() != null ) {
                int frequency = i.getValue();
                count += (frequency * (frequency - 1)) / 2;
            }
        }
        return count;
    }
}
