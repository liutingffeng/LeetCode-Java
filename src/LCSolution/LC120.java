package LCSolution;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC120 {

    class Solution {
        //可以自底向上，用一维数组即可
        public int minimumTotal(List<List<Integer>> triangle) {

            int minValue = Integer.MAX_VALUE;
            int[][] dp = new int[2][triangle.size()];
            dp[0][0] = triangle.get(0).get(0);
            for (int i=1;i<triangle.size();i++){
                List<Integer> curlevel = triangle.get(i);
                int size = curlevel.size();
                dp[i%2][0] = dp[(i-1)%2][0] + curlevel.get(0);
                dp[i%2][size-1] = dp[(i-1)%2][size-2]+curlevel.get(size-1);
                for (int j=1;j<curlevel.size()-1;j++){
                    int curvalue = curlevel.get(j)+Math.min(dp[(i-1)%2][j-1],dp[(i-1)%2][j]);
                    dp[i%2][j] = curvalue;
                }
            }
            int index = (triangle.size()-1)%2;
            for (int i=0;i<triangle.size();i++)
                minValue = Math.min(minValue, dp[index][i]);
            return minValue;
        }
    }
}
