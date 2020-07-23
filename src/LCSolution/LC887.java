package LCSolution;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LC887 {

    class Solution {

        /*
       设指定的楼层为 k，k >= 1 且 k <= i：

如果鸡蛋破碎，测试 F 值的实验就得在 k 层以下做（不包括 k 层），这里已经使用了一个鸡蛋，因此测出 F 值的最少实验次数是：dp[k - 1][j - 1]；
如果鸡蛋完好，测试 F 值的实验就得在 k 层以上做（不包括 k 层），这里这个鸡蛋还能使用，因此测出 F 值的最少实验次数是：dp[i - k][j]，例如总共 8 层，在第 5 层扔下去没有破碎，则需要在 [6, 7, 8] 层继续做实验，因此区间的大小就是 8 - 5 = 3。
最坏情况下，是这两个子问题的较大者，由于在第 k 层扔下鸡蛋算作一次实验，k 的值在 1 \le k \le i1≤k≤i，对于每一个 k 都对应了一组值的最大值，取这些 k 下的最小值（最优子结构），因此：

dp[i][j] = \min_{1 \le k \le i} \left(\max(dp[k - 1][j - 1], dp[i - k][j]) + 1 \right)
dp[i][j]=
1≤k≤i
min
​
 (max(dp[k−1][j−1],dp[i−k][j])+1)

作者：liweiwei1419
链接：https://leetcode-cn.com/problems/super-egg-drop/solution/dong-tai-gui-hua-zhi-jie-shi-guan-fang-ti-jie-fang/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
         */
        public int superEggDrop(int K, int N) {
            // [k,N]  [k,N-i]  [k-1,i-1]

            // dp[i][j]：一共有 i 层楼梯的情况下，使用 j 个鸡蛋的最少实验的次数
            // 注意：
            // 1、i 表示的是楼层的大小，不是第几层的意思，例如楼层区间 [8, 9, 10] 的大小为 3，这一点是在状态转移的过程中调整的定义
            // 2、j 表示可以使用的鸡蛋的个数，它是约束条件，我个人习惯放在后面的维度，表示消除后效性的意思
// 0 个楼层和 0 个鸡蛋的情况都需要算上去，虽然没有实际的意义，但是作为递推的起点，被其它状态值所参考
            int[][] dp = new int[N + 1][K + 1];

            // 由于求的是最小值，因此初始化的时候赋值为一个较大的数，9999 或者 i 都可以
            for (int i = 0; i <= N; i++)
                Arrays.fill(dp[i], i);

            // 初始化：填写下标为 0、1 的行和下标为 0、1 的列
            // 第 0 行：楼层为 0 的时候，不管鸡蛋个数多少，都测试不出鸡蛋的 F 值，故全为 0

            Arrays.fill(dp[0], 0);

            // 第 1 行：楼层为 1 的时候，0 个鸡蛋的时候，扔 0 次，1 个以及 1 个鸡蛋以上只需要扔 1 次
            dp[1][0] = 0;
            for (int j = 1; j <= K; j++) {
                dp[1][j] = 1;
            }

            // 第 0 列：鸡蛋个数为 0 的时候，不管楼层为多少，也测试不出鸡蛋的 F 值，故全为 0
            // 第 1 列：鸡蛋个数为 1 的时候，这是一种极端情况，要试出 F 值，最少次数就等于楼层高度（想想复杂度的定义）

            for (int i = 0; i <= N; i++) {
                dp[i][0] = 0;
                dp[i][1] = i;
            }

            //第二行开始
            //第二列
            for (int i=2;i<=N;i++){
                for (int j=2;j<=K;j++){
                    for (int k = 1; k <= i; k++) {
                        // 碎了，就需要往低层继续扔：层数少 1 ，鸡蛋也少 1
                        // 不碎，就需要往高层继续扔：层数是当前层到最高层的距离差，鸡蛋数量不少
                        // 两种情况都做了一次尝试，所以加 1

                        dp[i][j] =Math.min(dp[i][j], Math.max(dp[k-1][j-1],dp[i-k][j])+1);
                    }
                }
            }

            return dp[N][K];

        }
    }
}
