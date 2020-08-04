package LCSolution;

import java.util.HashMap;
import java.util.Map;

public class LC174 {

    /*
         dp  7  5  2
             6  11 5
             1  1  6
     */
    class Solution {
        public int calculateMinimumHP(int[][] dungeon) {
            int m = dungeon.length;
            int n = dungeon[0].length;

            int[] blood = new int[n];
            for (int i = n-1; i >=0; i--) {
                if (i==n-1) {
                    blood[i] = Math.max(1, 1-dungeon[m-1][i]);
                    continue;
                }
                blood[i] = Math.max(1, blood[i+1]-dungeon[m-1][i]);
            }

            for (int i = m-2; i >=0; i--) {
                for (int j = n-1; j >=0; j--) {
                    if (j==n-1){
                        blood[j] = Math.max(1, blood[j]-dungeon[i][j]);
                    }
                    else {
                        blood[j] = Math.max(1, Math.min(blood[j],blood[j+1])-dungeon[i][j]);
                    }
                }
            }

            return blood[0];
        }
    }
}
