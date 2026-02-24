package LC2026;

public class LC125 {

    public boolean isPalindrome(String s) {
        if (s == null || s.length() <= 1)
            return true;

        int l = 0, r = s.length() - 1;
        char lc, rc;
        while (l < r) {
            lc = s.charAt(l);
            int lv = getTransValue(lc);
            if (lv == -100) {
                l++;
                continue;
            }
            rc = s.charAt(r);
            int rv = getTransValue(rc);
            if (rv == -100) {
                r--;
                continue;
            }
            if (lv != rv)
                return false;
            l++;
            r--;
        }

        return true;
    }

    private int getTransValue(char c) {
        int v = -100;
        if (validIsNumber(c)) {
            v = -(c - '0') - 1;
        }
        if (validIsSmallZimu(c)) {
            v = c - 'a';
        }
        if (validIsBigZimu(c)) {
            v = c - 'A';
        }
        return v;
    }

    private boolean validIsNumber(char c) {
        int v = c - '0';
        return v >= 0 && v <= 9;
    }

    private boolean validIsSmallZimu(char c) {
        int v = c - 'a';
        return v >= 0 && v <= ('z' - 'a');
    }

    private boolean validIsBigZimu(char c) {
        int v = c - 'A';
        return v >= 0 && v <= ('Z' - 'A');
    }


    public static void main(String[] args) {
        char a = 'a';
        char b = 'b';
        char c = 'C';
        System.out.println(b - a);
        System.out.println(c - 'A');
        System.out.println(0 == -0);
        char d = '0';
    }
}
