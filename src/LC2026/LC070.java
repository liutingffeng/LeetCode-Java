package LC2026;

public class LC070 {

    public int climbStairs(int n) {
        if (n == 1)
            return 1;
        if (n == 2) {
            return 2;
        }
        int fn_1 = 2, fn_2 = 1;
        int k = 3;
        int fn = 0;
        while (k <= n) {
            fn = fn_1 + fn_2;
            fn_2 = fn_1;
            fn_1 = fn;
            k++;
        }
        return fn;
    }


}
