// Time complexity: O(n^2)
// Space complexity: O(n)

public class UnderscoreJustification {
    public static String justifyLine(String[] words, int width) {
        int numOfWords = words.length;

        int numOfChars = 0;
        for (int i = 0; i < numOfWords; i++) {
            numOfChars += words[i].length();
        }
        int numOfSpaces = width - numOfChars;
        StringBuilder resp = new StringBuilder();

        int max = numOfSpaces / (numOfWords - 1) + 1;
        int min = max - 1;
        int followedByMax = numOfSpaces % (numOfWords - 1);
        int i;
        for (i = 0; i < followedByMax; i++) {
            resp.append(words[i]);
            for (int j = 0; j < max; j++) {
                resp.append("_");
            }
        }

        for (int j = i; j < numOfWords - 1; j++) {
            resp.append(words[j]);
            for (int k = 0; k < min; k++) {
                resp.append("_");
            }
        }
        resp.append(words[numOfWords-1]);
        return resp.toString();
    }
}
