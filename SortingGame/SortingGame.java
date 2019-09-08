import java.util.*;

public class SortingGame {
    public int fewestMoves(int[] board, int k) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < board.length; i++) {
            sb.append(board[i]);
        }

        String original = sb.toString();
        HashMap<String, Integer> map = new HashMap<>();
        ArrayList<String> list = new ArrayList<>();
        list.add(original);
        map.put(original, 0);

        for (int i = 0; i < list.size(); i++) {
            String temp = list.get(i);
            if (isSorted(temp))
                return map.get(temp);
            int value = map.get(temp);

            for (int j = 0; j <= temp.length() - k; j++) {
                StringBuilder s = new StringBuilder(temp.substring(j, j + k));
                String newString = temp.substring(0, j) + s.reverse().toString() + temp.substring(j + k);
                if (!map.containsKey(newString)) {
                    list.add(newString);
                    map.put(newString, value + 1);
                }
            }
        }
        return -1;
    }

    // helper methods
    private boolean isSorted(String s) {
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) > s.charAt(i + 1))
                return false;
        }
        return true;
    }
}
