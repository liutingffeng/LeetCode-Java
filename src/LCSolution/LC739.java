package LCSolution;

import java.util.HashMap;
import java.util.Map;

public class LC739 {

    class Solution {
        public int[] dailyTemperatures(int[] T) {
            int n = T.length;
            int[] res = new int[n];

            for (int i=n-2;i>=0;i--){

                int addNum = 1;
                int index = i;
                while (addNum!=0){
                    index +=addNum;
                    if (T[index]>T[i]){
                        res[i] = index-i;
                        break;
                    }
                    addNum = res[index];
                }
            }
            return res;
        }
    }
}
