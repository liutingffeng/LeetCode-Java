package LC200;

import java.util.*;

/**
 * 
 *
 */
public class LC247 {

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
        new LC247().findStrobogrammatic(2);
    }
}
