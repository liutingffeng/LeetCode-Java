package LCJZSolution;

import java.util.HashMap;
import java.util.Map;

public class LCJz060 {

    class Solution {
        public double[] twoSum(int n) {
            double[] pre = new double[6*n-n+1];
            double[] cur = new double[6*n-n+1];
            for (int i=0;i<6;i++){
                pre[i] = 1.0/6.0;
            }

            //有几个骰子
            for (int i=2;i<=n;i++){
                //有几种组合
                for (int j=i;j<=6*i;j++){
                    double count = 0;
                    //当前的点数
                    // 之前的点数在 i-1 , 6*(i-1)
                    for (int k=1;k<=j && k<=6;k++){
                        if (j-k<=6*(i-1) && j-k>=i-1){
                            count += pre[j-k-i+1]*(1.0/6.0);
                        }
                    }
                    cur[j-i] = count;
                }
                double[] temp = pre;
                pre = cur;
                cur = temp;
            }
            return pre;
        }
    }


    public static void main(String[] args) {
        new LCJz060().new Solution().twoSum(2);
    }
}
