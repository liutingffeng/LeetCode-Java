package LC200;

/**
 * 
 *
 */
public class LC256 {

    public int minCost(int[][] costs) {

        for (int i = 1; i < costs.length; i++) {
            costs[i][0] = costs[i][0] + Math.min(costs[i-1][1], costs[i-1][2]);
            costs[i][1] = costs[i][1] + Math.min(costs[i-1][0], costs[i-1][2]);
            costs[i][2] = costs[i][2] + Math.min(costs[i-1][0], costs[i-1][1]);
        }

        return Math.min(costs[costs.length - 1][0],
                Math.min(costs[costs.length - 1][1], costs[costs.length - 1][2]));
    }

    public static void main(String[] args) {
    }
}
