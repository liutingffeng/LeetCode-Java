package LC2022;


import java.util.ArrayList;
import java.util.List;

public class LC022 {

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        deep(n, n, "", res);
        return res;
    }

    private void deep (int l, int r, String cur,List<String> res) {
        if (l > r || r == 0)
            return;
        if (l == 0) {
            String s = "";
            while (r-- > 0) {
                s += ')';
            }
            res.add(cur + s);
            return;
        }

        if (l == r) {
            deep(l - 1, r, cur + '(', res);
            return;
        }
        deep(l - 1, r, cur + '(', res);
        deep(l, r - 1, cur + ')', res);
        return;
    }

    public static void main(String[] args) {

    }
}
