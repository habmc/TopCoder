// Time complexity: O(n^2)
// Space complexity: O(n)

public class LargestSubsequence {
    public static String getLargest(String s) {
        StringBuilder response = new StringBuilder();;
        int max = 0; // index of current maximum char

        for (int i = 0; i < s.length(); i++) {
            max = i;
            for (int j = i + 1; j < s.length(); j++) {
                if (s.charAt(max) < s.charAt(j)) {
                    max = j;
                }
            }
            i = max; // continues the search for the next largest char from index max
            response.append(s.charAt(max));
        }
        return response.toString();
    }
}
