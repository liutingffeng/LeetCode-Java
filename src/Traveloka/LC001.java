package Traveloka;

/**
 * @Author liutingfeng
 * @Date 2026/7/31 16:40
 */
public class LC001 {

    /**
     * 给定整数 amount 和整数数组 coins。每种面值的硬币可以使用任意次，求组成 amount 的组合数量。
     * 同一组硬币采用不同排列顺序时，仍然属于同一种组合。
     * 输入：
     * amount = 5
     * coins = [1, 2, 5]
     *
     * 输出：
     * 4
     * @param amount
     * @param coins
     * @return
     */
    public static int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;

        for (int coin : coins) {
            for (int money = coin; money <= amount ; money++) {
                dp[money] += dp[money - coin];
            }
        }
        return dp[amount];
    }

    public static void main(String[] args) {
        int result = change(5, new int[]{1, 2, 5});
        System.out.println(result);
    }
}
