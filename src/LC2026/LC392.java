package LC2026;

public class LC392 {

    public boolean isSubsequence(String s, String t) {
        if (s == null)
            return true;
        if (t == null)
            return false;

        int x = 0, y = t.length() - 1;
        int i = 0, j = s.length() - 1;
        while (i <= j) {
            char sc = s.charAt(i);
            boolean find = false;
            while (x <= y) {
                char tc = t.charAt(x);
                if (sc == tc) {
                    x ++;
                    i ++;
                    find = true;
                    break;
                }
                x ++;
            }
            if (!find) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "abc";
        String t = "ahbgdc";

        new LC392().isSubsequence(s, t);
    }

}
