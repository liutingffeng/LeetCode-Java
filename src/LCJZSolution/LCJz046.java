package LCJZSolution;

import java.util.HashMap;
import java.util.Map;

public class LCJz046 {

    class Solution {
        //动态规划
        public int translateNum(int num) {
            if (num<=9)
                return 1;
            String str = String.valueOf(num);
            int prei_2 = 1;
            int prei_1 = 1;
            int cur = 0;
            for (int i=1;i<str.length();i++){
                if (str.charAt(i-1)!='0' && str.substring(i-1, i+1).compareTo("26")<0){
                    cur = prei_1+prei_2;
                }
                else {
                    cur = prei_1;
                }
                prei_2 = prei_1;
                prei_1 = cur;
            }
            return cur;
        }
    }
}
