package LCSolution;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class LC084 {

    class Solution {
//        public int largestRectangleArea(int[] heights) {
//            if (heights == null || heights.length == 0)
//                return 0;
//            int res = 0;
//            int len = heights.length;
//            //当前柱子左边小于当前柱子的位置
//            int[] memoL = new int[len];
//            memoL[0] = -1;
//            for (int i=1;i<len;i++){
//                if (heights[i]>heights[i-1])
//                    memoL[i] = i-1;
//                else {
//                    int index = memoL[i-1];
//                    while (index != -1 && heights[index]>=heights[i]){
//                        index = memoL[index];
//                    }
//                    memoL[i] = index;
//                }
//            }
//
//            int[] memoR = new int[len];
//            memoR[len-1] = len;
//            for (int i=len-2;i>=0;i--){
//                if (heights[i]>heights[i+1])
//                    memoR[i] = i+1;
//                else {
//                    int index = memoR[i+1];
//                    while (index != len && heights[index]>=heights[i]){
//                        index = memoR[index];
//                    }
//                    memoR[i] = index;
//                }
//            }
//
//            for (int i=0;i<len;i++){
//                int temp = heights[i]*(memoR[i]-memoL[i]-1);
//                res = Math.max(res, temp);
//            }
//            return res;
//        }

        //单调递增栈
        public int largestRectangleArea(int[] heights){
            if (heights == null || heights.length == 0)
                return 0;
            int res = 0;
            Deque<Integer> stack = new ArrayDeque<>();
            int[] new_heights = new int[heights.length+1];
            for (int i=0;i<heights.length;i++)
                new_heights[i] = heights[i];
            new_heights[heights.length] = 0;
            for (int i=0;i<new_heights.length;i++){
                while (!stack.isEmpty() && new_heights[i] < new_heights[stack.peek()] ){
                    int temp = stack.pop();
                    int left = stack.isEmpty()? -1:stack.peek();
                    res = Math.max(res, new_heights[temp]*(i-left-1));
                }
                stack.push(i);
            }
            return res;
        }
    }
}
