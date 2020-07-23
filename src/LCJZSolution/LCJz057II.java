package LCJZSolution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LCJz057II {

    class Solution {
        public int[][] findContinuousSequence(int target) {
            List<int[]> res = new ArrayList<>();
            int sum = 0;
            int l = 1,r = 1;
            while (l<=target/2){
                //加入窗口
                sum +=r;
                r++;
                //
                while (sum>=target){
                    //找到可行解
                    if (sum == target){
                        int[] temp = new int[r-l];
                        for (int i=l;i<r;i++){
                            temp[i-l] = i;
                        }
                        res.add(temp);
                    }
                    sum -=l;
                    l++;
                }
            }

            return res.toArray(new int[][]{});
        }
    }
}
