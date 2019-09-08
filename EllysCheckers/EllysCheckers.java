public class EllysCheckers
{
    public static String getWinner(String board)
    {
        int parity = 0;
        for (int i = 0; i < board.length(); i++)
            if (board.charAt(i) == 'o') parity += (board.length() - i - 1);
        return (parity % 2 == 0) ? "NO" : "YES";
    }

    private static void m (boolean[] x) {
        x[2] = true;
    }

    public static void main(String[] args) {
        System.out.println(getWinner("...o.o...."));
        boolean[] a = new boolean[5];
        m(a);
        System.out.println(a[2]);
    }
}