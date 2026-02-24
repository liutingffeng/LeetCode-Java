package LC2026;

public class LC009 {

    public boolean isPalindrome(int x) {
        if (x < 0)
            return false;
        if (x == 0)
            return true;
        int cur = 0;
        int res = x;
        while (res > 0) {
            // 余数
            int a = res % 10;
            res /= 10;
            cur = cur * 10 + a;
        }
        return cur == x;
    }


}
