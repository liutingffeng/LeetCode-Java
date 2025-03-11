package LC200;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 
 *
 */
public class LC248 {

    public int strobogrammaticInRange(String low, String high) {
        int res = 0;

        int l = low.length();
        int r = high.length();

        if (l == r) {
            List<String> t = findStrobogrammatic(l);
            for (String s: t) {
                if (Long.valueOf(s) >= Long.valueOf(low) && Long.valueOf(s) <= Long.valueOf(high)) {
                    res ++;
                }
            }
            return res;
        }

        for (int i = l; i <= r; i++) {
            List<String> t = findStrobogrammatic(i);
            int cur = 0;
            if (i == l) {
                for (String s: t) {
                    if (Long.valueOf(s) >= Long.valueOf(low))
                        cur++;
                }
            } else if (i == r) {
                for (String s: t) {
                    if (Long.valueOf(s) <= Long.valueOf(high))
                        cur++;
                }
            } else {
                cur = t.size();
            }
            res += cur;
        }
        return res;
    }

    static class Pair {
        char key;
        char value;

        public Pair(char key, char value) {
            this.key = key;
            this.value = value;
        }

        public char getValue() {
            return value;
        }
    }
    private static final List<Pair> valids =new ArrayList<>(5);
    static {
        valids.add(new Pair('0', '0'));
        valids.add(new Pair('1', '1'));
        valids.add(new Pair('8', '8'));
        valids.add(new Pair('6', '9'));
        valids.add(new Pair('9', '6'));
    }

    public List<String> findStrobogrammatic(int n) {
        List<String> res = new ArrayList<>();
        if (n == 1) {
            return Arrays.asList(new String[] {"0","1","8"});
        }
        char[] data = new char[n];
        dfs(0, n - 1, res, data);
        return res;
    }

    private void dfs(int l, int r, List<String> res, char[] data) {
        if (l > r) {
            res.add(String.copyValueOf(data));
            return;
        }
        if (l == r) {
            data[l] = '0';
            res.add(String.copyValueOf(data));
            data[l] = '1';
            res.add(String.copyValueOf(data));
            data[l] = '8';
            res.add(String.copyValueOf(data));
            return;
        }
        for (int i = 0; i < valids.size(); i++) {
            if (l == 0 && i == 0)
                continue;
            Pair pair = valids.get(i);
            data[l] = pair.key;
            data[r] = pair.value;
            dfs(++l, --r, res, data);
            l--;
            r++;
        }
    }

    public static void main(String[] args) {
    }
}
