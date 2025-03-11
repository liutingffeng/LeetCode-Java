package LC200;

import javax.swing.plaf.TreeUI;

/**
 * 
 *
 */
public class LC276 {

    private int res;
    public int numWays(int n, int k) {
        if (n == 1)
            return k;
        // 动态规划
        // k, k, k * k-1
        // k, k * k-1, k * k-1 * k
        int[] limit = new int[n+1];
        int[] noLimitEqual = new int[n+1];
        int[] noLimitNoEqual = new int[n+1];
        limit[1] = k;
        noLimitEqual[1] = k;
        noLimitNoEqual[1] = k;
        limit[2] = 0;
        noLimitEqual[2] = k;
        noLimitNoEqual[2] = k * (k-1);
        for (int i = 3; i <= n; i++) {
            if (i == 3) {
                limit[i] = k * (k-1);
                noLimitEqual[i] =  k * (k - 1);
                noLimitNoEqual[i] = k * (k-1) * (k -1);
            } else {
                limit[i] = noLimitEqual[i-1] * (k-1);
                noLimitEqual[i] = (limit[i-1] + noLimitNoEqual[i-1]);
                noLimitNoEqual[i] = (limit[i-1] + noLimitNoEqual[i-1]) * (k-1);
            }
        }
        return limit[n] + noLimitEqual[n] + noLimitNoEqual[n];
    }

    private void dfs(int index, int k, int n, boolean limit, int last) {
        if (index > n){
            res += last;
            return;
        }
        // 2 k , k * k-1
        // 3 k * k-1  k * k-1 * k-1

        if (index == 1) {
            dfs(index + 1, k, n, false, last * k);
        } else {
            if (!limit) {
                //
                dfs(index + 1, k, n, true, last);
                //
                dfs(index + 1, k, n, false, last * (k-1));
            } else {
                dfs(index + 1, k, n, false, last * (k-1));
            }
        }

    }

    public static void main(String[] args) {
        new LC276().numWays(3, 2);
    }
}
