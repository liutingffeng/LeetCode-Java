package LCSolution;

import java.util.HashMap;
import java.util.Map;

public class LC011 {

    class Solution {
        public int maxArea(int[] height) {
            int l = 0;
            int r = height.length-1;
            int maxArea = 0;
            while (l<r){
                maxArea = Math.max(maxArea, (r-l)*Math.min(height[l],height[r]));
                //为甚要短柱子移动，因为这一次比较过程中，是以短柱子为基准的，如果长柱子移动肯定要这次结果小
//                所以隐形的列举了短柱子以及其他柱子的结果，同时选取了最大的面积
//                下一轮移动短柱子
                if (height[l]>height[r]){
                    r--;
                } else {
                    l++;
                }
            }
            return maxArea;
        }
    }
}
