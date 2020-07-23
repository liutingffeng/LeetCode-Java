package LCSolution;

import java.util.HashMap;
import java.util.Map;

public class LC091 {

    class Solution {
        /*
        爬楼梯的升级版
        如果连续的两位数符合条件，就相当于一个上楼梯的题目，可以有两种选法：
        1.一位数决定一个字母
        2.两位数决定一个字母
        就相当于dp(i) = dp[i-1] + dp[i-2];
    如果不符合条件，又有两种情况
        1.当前数字是0：
            不好意思，这阶楼梯不能单独走，
            dp[i] = dp[i-2]
        2.当前数字不是0
            不好意思，这阶楼梯太宽，走两步容易扯着步子，只能一个一个走
            dp[i] = dp[i-1];
         */
        public int numDecodings(String s) {
            if (s.charAt(0) == '0')
                return 0;
            int[] dp = new int[s.length()+1];
            dp[0] = 1;
            for (int i=0;i<s.length();i++){
                dp[i+1] = s.charAt(i)=='0'? 0:dp[i];
                if (i>0 && (s.charAt(i-1) == '1' || (s.charAt(i-1) == '2' && s.charAt(i)<='6')))
                    dp[i+1] +=dp[i-1];
            }
            return dp[s.length()];
        }
    }
}
